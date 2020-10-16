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
    var doc = ctx.html("/consumed.html", "utf-8");

    doc.select('a[gotoPage]').attr('qrslice',qrslice.id);

    circuit.content().writeBytes(doc.toString().getBytes());
}
