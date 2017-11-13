<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Welcome</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script type="text/javascript">
        options={"hoc":"CCCCCC","hbw":5,"hfc":"FFFFFF","hnc":"e1ead6","fin":"_sans","fan":"_sans","fas":17,"fac":"000000","fdi":86,"fnu":1,"mqv":1,"mqc":"84a558","mqs":3,"mql":3,"mqw":1,"mqd":96,"mhv":1,"mhc":"84a558","mhs":3,"mhl":3,"mhw":1,"mhd":96,"mmv":1,"mmc":"84a558","mms":3,"mml":1,"mmw":0,"mmd":96,"hhv":1,"hhc":"000000","hhs":0,"hhl":45,"hhb":0,"hhw":5,"hhr":5,"hhm":3,"hmv":1,"hmc":"000000","hms":0,"hml":70,"hmb":0,"hmw":5,"hmr":5,"hmm":3,"hsv":1,"hsc":"ff0000","hss":0,"hsl":75,"hsb":15,"hsw":1,"hsr":3,"hsm":3,"szw":110};
        et=1510762837;function f0(d){return ((d.getUTCHours()+11)%12+1)+':'+p2(d.getUTCMinutes())+':'+p2(d.getUTCSeconds())+' '+_ap(d);}
        cks={t1:{t:[{"o":19800,"a":"IST"}],f:f0}};
        function _ap(d){var t=Math.floor(d.getTime()/1E3+8640000000)%86400;if(t===0){return 'midnight';}if(t==43200){return 'noon';}if(t<43200){return 'am';}return 'pm';}
        //Copyright timeanddate.com 2005-2015, do not use without permission
        var ltn=0,lt0=0,sa=0,flsh=0;Mf=Math.floor;function gf(b){var d=document;return d.getElementById?d.getElementById(b):null}function ih(b,d){b&&(b.innerHTML=d)}function rf(b,d){ih(gf("c1"),"refresh...");setTimeout("location.reload()",Mf(1E3*(b+Math.random()*d)))}function pf(b,d){for(;(b="0000"+b)&&b.length<d;);return b.substring(b.length-d)}function p2(b){return 10>b?"0"+b:b}function gtr(b,d){var h=b.t,e=null,l;for(l=0;l<h.length;l++){var a=h[l];if(a.t>d)break;e=a;l&&(e.C=l)}return e?e:{}}
        function dt(){return+new Date}function locDate(){var b=(dt()+sa)/1E3,d=gtr(cks.t1,b).o;return void 0!==d?1E3*(b+d):1E3*b}function upd(){var b=dt()+sa;if(ltn>b)rf(7,0);else{ltn=b;var d=Mf(b/1E3);if(d>et)rf(10,0);else{if(d!=lt0){lt0=d;var b=cks.t1,h=gtr(b,d),e=h.o,h=h.a;void 0!==e&&b.d1&&(ih(b.d1,b.f(new Date(1E3*(d+e)))),b.pa!=h&&b.d2&&(b.pa=h,ih(b.d2,h)));b=dt()+sa}setTimeout(upd,1E3-b%1E3)}}}
        function sync(b){function d(a,k,b){sa=a;sae=k;if(flsh){if(flO=gf("count"))try{flO.setSync(a);return}catch(c){}2E3>b&&(b+=100,setTimeout(function(){d(sa,sae,b)},b))}}var h=document.cookie;if(h){var e=h.match(/tads\=(\d+)_(\d+)/);if(e){var l=dt();if(-1E4<e[1]-l){d(e[2]-0,e[3]-0,0);upd();return}}if(1E3>b&&0<=h.indexOf("tads=c")){b=2*b+10;setTimeout("sync("+b+")",b);return}}document.cookie="tads=c; path=/";var a=null;b=window;try{b.XMLHttpRequest&&(a=new XMLHttpRequest)}catch(k){}if(!a&&b.ActiveXObject){try{a=
            new ActiveXObject("Msxml2.XMLHTTP")}catch(r){}if(!a)try{a=new ActiveXObject("Microsoft.XMLHTTP")}catch(g){}}if(a)try{var n=dt(),q=document.URL.replace(/clock.*/,"ts.php?t="+n);a.open("GET",q,!0);a.onreadystatechange=function(){var k=dt();if(a&&4==a.readyState&&200==a.status){var b=(n+k)/2,c=1E3*parseFloat(a.responseText);0<c&&(c=Mf(c-b),d(c,k-b,0),document.cookie="tads="+(k+"_"+c)+"; path=/",a=null,upd())}};n=dt();a.send("")}catch(c){}}
        (function(){function b(a,k){for(var b in k)try{a[b]=k[b]}catch(g){}return a}var d=[[1,2,3,4,5,6,7,8,9,10,11,12],"I II III IV V VI VII VIII IX X XI XII".split(" "),"\u4e00 \u4e8c \u4e09 \u56db \u4e94 \u516d \u4e03 \u516b \u4e5d \u5341 \u5341\u4e00 \u5341\u4e8c".split(" ")],h={hoc:"CCCCCC",hbw:5,hfc:"FFFFFF",hnc:-1,fiv:1,fin:"_sans",fav:1,fan:"_sans",fas:16,fac:"000000",fdi:86,fnu:1,mqv:1,mqs:0,mqd:96,mql:10,mqw:1,mqc:"000",mhv:1,mhs:0,mhd:96,mhl:7,mhw:1,mhc:"000",mmv:1,mms:0,mmd:96,mml:2,mmw:1,mmc:"000",
            hhv:1,hhs:0,hhm:0,hhl:45,hhb:4,hhw:5,hhr:5,hhc:"000000",hmv:1,hms:0,hmm:0,hml:70,hmb:4,hmw:5,hmr:5,hmc:"000000",hsv:1,hss:0,hsm:0,hsl:75,hsb:14,hsw:1,hsr:3,hsc:"FF0000",hcw:0,hcd:70,hcc:"000000",szw:500},e=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.oRequestAnimationFrame||window.msRequestAnimationFrame||function(a){window.setTimeout(function(){a(locDate())},20)}}(),l=function(a,k,d,g){this.b=a;this.F=k;this.h=d;void 0!==
        this.b.getContext&&(this.o=b(h,g),this.s=this.o.szw,this.c=this.s/2,this.r=this.s/2,this.S=200/this.s,this.t=locDate(),this.setup())};l.prototype={setup:function(){this.b.width=this.b.height=this.F.width=this.F.height=2*this.s;this.b.style.width=this.b.style.height=this.F.style.width=this.F.style.height=this.s+"px";this.h.style.width=this.h.style.height=this.s+"px";this.B=this.b.getContext("2d");this.frontCtx=this.F.getContext("2d");this.B.setTransform(2,0,0,2,0,0);this.frontCtx.setTransform(2,0,
            0,2,0,0);this.B.clearRect(0,0,this.s,this.s);this.G();this.update()},setOptions:function(a){b(options,a);this.setup()},G:function(){this.B.clearRect(0,0,this.s,this.s);this.A();this.E();this.T();this.C()},A:function(){var a=this.o,k=this.B;if(-1!==a.hnc){var b=k.createRadialGradient(this.c,this.c,0,this.c,this.c,this.r);b.addColorStop(0,"#"+a.hfc);b.addColorStop(1,"#"+a.hnc)}else b="#"+a.hfc;k.save();k.fillStyle=b;k.strokeStyle="#"+a.hoc;k.lineWidth=a.hbw/100*this.r*2;k.arc(this.c,this.c,a.hwc?0.9*
            this.r:this.r,0,2*Math.PI,!1);a.hwc&&(k.shadowBlur=20/this.S,k.shadowColor="#"+a.hwc);k.fill();k.clip();k.shadowColor="transparent black";k.shadowBlur=0;0<a.hbw&&k.stroke();k.restore()},E:function(){var a=this.B,b=this.o;1<=b.hcw&&(a.save(),a.beginPath(),a.strokeStyle="#"+b.hcc,a.lineWidth=b.hcw/100*this.r/2,a.arc(this.c,this.c,b.hcd/this.S,0,2*Math.PI,!1),a.closePath(),a.stroke(),a.restore())},I:function(a,b,d,g,n,h){var c=this.B,e=this.r/100;c.save();c.translate(this.c,this.c);c.rotate(b);c.translate(d*
            e,0);c.strokeStyle="#"+h;c.fillStyle="#"+h;switch(a){case 1:c.beginPath();c.arc(0,0,g*e,0,2*Math.PI);c.stroke();break;case 2:c.beginPath();c.arc(0,0,g*e,0,2*Math.PI);c.fill();break;case 4:c.beginPath();c.arc(0,0,n*e/2,0,2*Math.PI);c.moveTo(0,n*e/2);c.lineTo(-(g*e),0);c.lineTo(0,-(n*e/2));c.fill();break;default:c.beginPath(),c.moveTo(0,0),c.lineWidth=n/this.S,c.lineTo(-g*e,0),c.stroke()}this.B.restore()},T:function(){for(var a=this.o,b=0;360>=b;b+=6)0!=b%90||1!==a.mqv&&void 0!==a.mqv?0!=b%30||0===
        b%90||1!==a.mhv&&void 0!==a.mhv?1!==a.mmv&&void 0!==a.mmv||this.I(a.mms,b*Math.PI/180,a.mmd,a.mml,a.mmw,a.mmc):this.I(a.mhs,b*Math.PI/180,a.mhd,a.mhl,a.mhw,a.mhc):this.I(a.mqs,b*Math.PI/180,a.mqd,a.mql,a.mqw,a.mqc)},C:function(){var a=[],b=this,e=b.B,g=b.o;if(void 0===g.fiv||1===g.fiv)a=a.concat([1,2,4,5,7,8,10,11]);if(void 0===g.fav||1===g.fav)a=a.concat([3,6,9,12]);a.sort();e.save();e.textAlign="center";e.textBaseline="middle";a.forEach(function(a){if(0==a%3)var h=g.fas/b.S,c="_sans"===g.fan?"sans-serif":
            "_serif"===g.fan?"serif":"_typewriter"===g.fan?"monospace":"",l=g.fac;else h=g.fas/b.S,c="_sans"===g.fin?"sans-serif":"_serif"===g.fan?"serif":"_typewriter"===g.fan?"monospace":"",l=g.fac;e.fillStyle="#"+l;e.font=h+"px "+c;c=2*Math.PI/12*-a;h=Math.sin(c+Math.PI)*(g.fdi/100)*b.r+b.c;c=Math.cos(c+Math.PI)*(g.fdi/100)*b.r+b.c;e.fillText(d[g.fnu-1][a-1],h,c)},b);e.restore()},drawHand:function(a,b,e,g,d,h,c,l,p){var m=0,f=this.frontCtx,m=this.t/a%b;b=360/b;switch(g){case 1:m=Mf(m)*b;break;case 2:g=Mf(m)*
            b;m=0<this.t%a&&250>this.t%a?g+0.55*b*Math.sin(this.t%a/25)/Math.exp(this.t%a/100):g;break;default:m*=b}f.save();f.strokeStyle="#"+p;f.fillStyle="#"+p;f.shadowBlur=2/this.S;f.shadowColor="rgba(0,0,0,0.6)";f.translate(this.c,this.c);f.rotate(m*Math.PI/180);a=this.r/100;switch(e){case 1:f.beginPath();f.lineWidth=c*a/2*2;f.moveTo(0,h*a);f.lineTo(0,-d*a/3);f.stroke();f.lineWidth=c*a/2;f.lineTo(0,-d*a);f.stroke();break;case 2:f.beginPath();f.moveTo(c*a/2,0);f.lineTo(0,-d*a);f.lineTo(-c*a/2,0);f.lineTo(0,
            h*a);f.lineTo(c*a/2,0);f.fill();break;default:f.beginPath(),f.moveTo(0,h*a),f.lineWidth=Math.max(c/this.S/2,0.5),f.lineTo(0,-d*a),f.stroke()}f.shadowBlur=0;f.beginPath();f.arc(0,0,l*a,0,2*Math.PI);f.fill();f.restore()},drawHands:function(){var a=this.o;this.frontCtx.clearRect(0,0,this.s,this.s);1===a.hhv&&this.drawHand(36E5,12,a.hhs,a.hhm,a.hhl,a.hhb,a.hhw,a.hhr,a.hhc);1===a.hmv&&this.drawHand(6E4,60,a.hms,a.hmm,a.hml,a.hmb,a.hmw,a.hmr,a.hmc);1===a.hsv&&this.drawHand(1E3,60,a.hss,a.hsm,a.hsl,a.hsb,
            a.hsw,a.hsr,a.hsc)},update:function(){this.t=locDate();this.drawHands();e(this.update.bind(this))}};window.onload=function(){if(void 0!==document.createElement("canvas").getContext)window.clock=new l(gf("back"),gf("front"),gf("hov"),options);else{var a=gf("fc");a.className+=" no";ih(a,flash_html+a.innerHTML+"</object>");flsh=1}var b;if("undefined"!==typeof cks){for(b in cks)a=cks[b],a.d1=gf(b),a.d2=gf(b+"a"),a.pa="";sync(0)}}})();

    </script>
    <style>#fc canvas{position:absolute;top:0;left:0}#fc #back{position:relative}#fc{display:inline-block;position:relative}#t1c{display:block;text-align:center}#hov{position:absolute;top:0;left:0;background:url('/gfx/free-logo.png') rgba(255,255,255,0.8);background:url('/gfx/free-logo.svg'),linear-gradient(rgba(255,255,255,0.8),rgba(255,255,255,0.8));background-size:cover;background-repeat:no-repeat;display:none}#fc:hover #hov{display:block}.no #hov{display:none}
    </style>

</head>
<body class="index">
<div id="page-wrapper">
    ${nav}
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
    <section id="banner">
        <script type="text/javascript">
            flash_html="<object width=\"110\" height=\"110\" id=count data=\"/fl/fc_c_v3.swf\" type=\"application/x-shockwave-flash\"><param name=movie value=\"/fl/fc_c_v3.swf\"><param name=quality value=high><param name=flashvars value=\"hoc=CCCCCC&amp;hbw=20&amp;hfc=FFFFFF&amp;hnc=e1ead6&amp;fdi=173&amp;fan=_sans&amp;fin=_sans&amp;fas=34&amp;fis=34&amp;fac=000000&amp;fic=000000&amp;mqc=84a558&amp;mhc=84a558&amp;mmc=84a558&amp;hhc=000000&amp;hmc=000000&amp;hsc=ff0000&amp;n=1925&amp;dst=19800\"><param name=swliveconnect value=true><param name=wmode value=transparent><param name=allowFullScreen value=true><param name=allowScriptAccess value=sameDomain>";
        </script>

        ${message}
    <br><br><br>
    </section>
        <footer id="footer">
            <ul class="copyright">
                <li><strong>Grade One Evaluating System - Ministry Of Education</strong></li>
            </ul>
            <img width="130px" height="auto" src="${contextPath}/resources/images/Aurora-logo.png" alt="">
        </footer>

</div>

<script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrollgress.min.js"></script>
<script src="${contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${contextPath}/resources/assets/js/util.js"></script>
<script src="${contextPath}/resources/assets/js/main.js"></script>

</body>
</html>



