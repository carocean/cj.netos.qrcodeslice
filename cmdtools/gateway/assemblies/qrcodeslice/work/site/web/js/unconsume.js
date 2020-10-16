function parseTime17(time) {
    var myDate = new Date();
    myDate.setFullYear(parseInt(time.substring(0, 4)), parseInt(time.substring(4, 6)), parseInt(time.substring(6, 8)));
    myDate.setHours(parseInt(time.substring(8, 10)), parseInt(time.substring(10, 12)), parseInt(time.substring(12, 14)), parseInt(time.substring(14, 17)));
    return myDate;
}

/**************************************时间格式化处理************************************/
function dateFtt(fmt, date) { //author: meizz
    var o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds(),                 //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(document).on("pagecreate", "#balance-details", function () {
    var qrslice = $('.publisher ul li[label]').html();
    $.get('./recipients/balances.json', {
        'qrslice': qrslice.trim(),
        'limit': 10,
        'offset': 0,
    }, function (data, status) {
        var list = eval(data);
        var balanceAmount = $('.balance-amount').html();
        $('#balance-details div[data-role="pannel"] span').html(balanceAmount);
        var ul = $('#balance-details ul[rbalance-ul]');
        var li = ul.find('>li').first().clone();
        ul.empty();
        for (var i = 0; i < list.length; i++) {
            var obj = list[i];
            var cli = li.clone();
            cli.find('li[name]').html(obj.abTitle);
            cli.find('li[time]').html(dateFtt('yyyy-MM-dd hh:mm:ss', parseTime17(obj.ctime)));
            cli.find('li[amount] span').html('¥' + (obj.amount / 100.00).toFixed(14));

            ul.append(cli);
        }
    });
});

$(document).on("pagecreate", "#cat-page", function () {
    var qrslice = $('.publisher ul li[label]').html();
    $.get('./cats.json', {
        'qrslice': qrslice.trim(),
    }, function (data, status) {
        var obj = eval(data);
        var ul = $('#cat-page ul[cat-ul]');
        var li = ul.find('>li[cat]').first().clone();
        ul.empty();
        for (var i = 0; i < obj.length; i++) {
            var cat = obj[i];
            var cli = li.clone();
            cli.find('span').html(cat.title);
            ul.append(cli);
        }
    });
});

$(document).on("pagecreate", "#unconsumes-page", function () {
    var qrslice = $('.publisher ul li[label]').html();
    $.get('./unconsumes.json', {
        'qrslice': qrslice.trim(),
    }, function (data, status) {
        var list = eval(data);
        var ul = $('#unconsumes-page ul[unconsume-ul]');
        var li = ul.find('>li').first().clone();
        ul.empty();
        for (var i = 0; i < list.length; i++) {
            var slice = list[i];
            var cli = li.clone();
            var qrcode = cli.find('.qrcode');
            qrcode.qrcode({width: 100, height: 100, text: slice.href + '?id=' + slice.id});
            cli.on('click', function () {
                window.location.href = './?id=' + slice.id;
            });
            ul.append(cli);
        }
    });
});

$(document).on("pagecreate", "#doConsume-page", function () {
    var the = $(this);
    var phone = the.find('#phone');
    the.find('a.ui-input-clear').on('click', function () {
        phone.removeAttr('readonly');
        phone.attr('placeholder', '输入手机号');
        the.find('#verifycode').hide();
    });
    phone.keyup(function (e) {
        if (phone.attr('readonly') == 'readonly') {
            return;
        }
        the.find('#verifycode').hide();
        the.find('p[tips]').hide();
        var v = phone.val();
        if (typeof v == 'undefined' || v == '') {
            return;
        }
        if (isNaN(v)) {
            alert('手机号必须是数字');
            phone.val('');
            return;
        }
        if (v.length != 11) {
            return;
        }
        phone.attr('placeholder', '开始检测账号...');
        phone.val('');
        phone.attr('readonly', 'readonly');
        $.get('./existsAccount.service', {
            'phone': v,
        }, function (data, status) {
            var exists = eval(data);
            phone.val(v);
            if (!exists) {
                the.find('#verifycode').hide();
                the.find('p[tips]').show();
                phone.attr('placeholder', '输入手机号');
                phone.removeAttr('readonly');
                return;
            }
            phone.attr('placeholder', '正在发送验证码...');
            phone.val('');
            phone.attr('readonly', 'readonly');
            $.get('./sendVerifycode.service', {
                'phone': v,
            }, function (data, status) {
                phone.val(v);
                phone.attr('placeholder', '输入手机号');
                the.find('#verifycode').show();
            }).error(function (e,f) {
                phone.removeAttr('readonly');
                phone.val(e.responseText);
                phone.attr('placeholder', '输入手机号');
                the.find('#verifycode').hide();
            });
        }).error(function () {
            phone.removeAttr('readonly');
            phone.val(v);
        });
    });

    the.find('#verifycode').keyup(function (e) {
        var input = $(this);
        var v = input.val();
        if (typeof v == 'undefined' || v == '') {
            return;
        }
        if (isNaN(v)) {
            alert('验证码必须是数字');
            phone.val('');
            return;
        }
        if (v.length != 6) {
            return;
        }
        input.val('');
        input.attr('placeholder', '正在消费本码片...');
        $.getJSON('./doConsume.service', {
            'verifyCode': v,
        }, function (data, status) {
            var map = data;
            if (map.status=='1001') {
                input.val('');
                input.attr('placeholder', '验证码不正确，请重试...');
                return;
            }
            if (map.status=='1002') {
                $('body').empty();
                $('body').html('<p style="text-align: center;">'+map.message+'</p>');
                return;
            }
            if(map.status!="200"){
                input.val('');
                input.attr('placeholder', '失败，请重试...');
                return;
            }
            $('body').empty();
            $('body').html('<p style="text-align: center;">消费成功，请退出！</p>');
        });
    });
});