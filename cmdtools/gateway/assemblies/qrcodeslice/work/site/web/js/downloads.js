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
    $.getJSON('./market.json', {}, function (data, status) {
        var obj = eval(data);
        var defaultMarket=obj.default;
        var markets=obj.markets;
        var box =$('.dl-market-box');
        var ul =$('.dl-markets');
        var li=ul.find('>li').first();
        ul.empty();
        for(var i=0;i<markets.length;i++){
            var market=markets[i];
            var cli=li.clone();
            cli.find('a').html(market.title);
            cli.find('a').attr('href',market.href);
            ul.append(cli);
        }

        var md = new MobileDetect(window.navigator.userAgent);
        var installer=$('.dl-install >a');
        var currentMarket=$('.dl-brand');
        var os =md.os();
        if (os == "iOS") {//ios系统的处理
            var current=null;
            for(var i=0;i<markets.length;i++){
                var market=markets[i];
                if(market.grand=='iphone'||market.grand=='ipad'){
                    current=market;
                    break;
                }
            }
            if (current == null) {
                box.remove();
                $('.dl-deliver').remove();
                $('.dl-m-label').remove();
                return;
            }
            currentMarket.html('苹果');
            installer.attr('href',current.href);
            return;
        }
        //是android
        var current=null;
        var agent=window.navigator.userAgent.toLowerCase();
        for(var i=0;i<markets.length;i++){
            var market=markets[i];
            var grand=market.grand;
            if(grand=='oppo'){
                grand='heytap';
            }
            if(agent.indexOf(grand)>-1){
                current=market;
                break;
            }
        }
        if (current == null) {
            if(defaultMarket==null||typeof defaultMarket=='undefined'||defaultMarket==''){
                box.remove();
                $('.dl-deliver').remove();
                $('.dl-m-label').remove();
                return;
            }
            currentMarket.html('默认');
            installer.attr('href',defaultMarket);
            return;
        }
        currentMarket.html(current.title);
        installer.attr('href',current.href);
        return;
    });
});