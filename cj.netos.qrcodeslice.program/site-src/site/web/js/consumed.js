$(document).on("pagecreate", "#main-page", function () {
    var the=$(this);
    the.find('a[gotoPage]').on('tap',function (){
        $.mobile.changePage('#unconsumes-page','slideup');
    });
});

$(document).on("pagecreate", "#unconsumes-page", function () {
    var qrslice = $('a[qrslice]').attr('qrslice');
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