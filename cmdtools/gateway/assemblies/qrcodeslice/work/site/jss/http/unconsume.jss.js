/*
 * 2016.0829
 * 作者：赵向彬
 * 说明：services是声明本jss要引用的服务
 * <![jss:{
		scope:'runtime',
		extends:'cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView',
		isStronglyJss:true,
		filter:{
	 	}
	},
	shit:{
	 		name:"test..."
	},
 	services:{
 		test:'testService'
 	}
 ]>
 <![desc:{
	ttt:'2323',
	obj:{
		name:'09skdkdk'
		}
* }]>
 */

var String = Java.type('java.lang.String');
var WebUtil = Java.type('cj.studio.ecm.net.util.WebUtil');
var RoundingMode=Java.type('java.math.RoundingMode');
var BigDecimal=Java.type('java.math.BigDecimal');
var CircuitException=Java.type('cj.studio.ecm.net.CircuitException');
var SimpleDateFormat = Java.type('java.text.SimpleDateFormat');
var Date = Java.type('java.util.Date');
var Long = Java.type('java.lang.Long');



exports.flow = function(frame,circuit,ctx) {
    var qrslice=frame.session().attribute('qrslice');
    var doc = ctx.html("/unconsume.html", "utf-8");
    var tokenInfo=frame.session().attribute('tokenInfo');

    var publisherE= doc.select('.publisher li[name]');
    publisherE.html(qrslice.cname);
    var sliceE= doc.select('.publisher li[label]');
    sliceE.html(qrslice.id);
    var pubimg= doc.select('.publisher img');
    var publisher=frame.session().attribute('publisher');
    var pbavatar=(publisher['avatar'])+'?accessToken='+tokenInfo['token']['accessToken']   ;
    pubimg.attr('src',pbavatar);
    var totalBalances=frame.session().attribute('totalBalances');
    var money=totalBalances.divide(new BigDecimal("100"),14, RoundingMode.DOWN);
    doc.select('.balance-amount').html('¥'+money.toPlainString()+'↑');
    var totalCats=frame.session().attribute('catCount');
    doc.select('.slice-info li[totalCats] span').html(totalCats+'个');

    var unconsumeCount=frame.session().attribute('unconsumeCount');
    doc.select('.slice-info li[unconsumeCount] span').html(unconsumeCount+'张');
    var ranks=frame.session().attribute('recipientsRank');


    var ul=doc.select('.rank-top ul[rank-ul]');
    var li=ul.select('>li').first().clone();
    ul.empty();
    for(var i=0;i<ranks.size();i++){
        var rank=ranks.get(i);
        if (rank.personInfo == null) {//有的用户被删除了跳过
            continue;
        }
        var cli=li.clone();
        var money=rank.total.divide(new BigDecimal("100"),14, RoundingMode.DOWN);
        cli.select('span').html('¥'+money);
        cli.attr('recipients',rank.recipient);
        cli.select('i').html(rank.personInfo==null?rank.recipient:rank.personInfo['nickName']);
        var avatar=(rank.personInfo['avatar'])+'?accessToken='+tokenInfo['token']['accessToken']   ;
        cli.select('img').attr('src',avatar);

        ul.append(cli);
    }
    circuit.content().writeBytes(doc.toString().getBytes());
}
