$(document).ready(function () {
    $.getJSON('./ProductDownloadUrl.json', {}, function (data, status) {
        var obj = eval(data);
        var ul = $('.dl-ul');
        var li = ul.find('>.dl-li').first().clone();
        ul.empty();
        for (var key in obj) {
            var v = obj[key];
            var cli = li.clone();
            var a=cli.find('>a');
            a.attr('href', v);
            a.attr('os', key);
            // ca.attr('download',);
            var label = '';
            switch (key) {
                case 'android':
                    label = '安卓版';
                    break;
                case 'ios':
                    label = '苹果版';
                    break;
                default:
                    label = '其它版';
                    break;
            }
            a.html(label);
            ul.append(cli);
        }
    });

});