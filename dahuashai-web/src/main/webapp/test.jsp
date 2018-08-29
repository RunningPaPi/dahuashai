<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Java API for WebSocket (JSR-356)</title>
</head>
<body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<script type="text/javascript">
    var websocket = null;
    document.cookie = "WEBSOCKET_USERNAME=user12; WEBSOCKET_GROUP=1_20180523_01; JSESSIONID=F899C760A50FCCED45994ACA631BBD60;domain=ws://jijiatmatm.3322.org:49080/websocket/socketServer"
    if ('WebSocket' in window) {
        //Websocket的连接
        websocket = new WebSocket("ws://192.168.2.93:8080/websocket/socketServer");//WebSocket对应的地址
    }
    else if ('MozWebSocket' in window) {
        //Websocket的连接
        websocket = new MozWebSocket("ws://192.168.93:8080/websocket/socketServer");//SockJS对应的地址
    }
    else {
        alert("socketjs")
        //SockJS的连接
        websocket = new SockJS("http://192.168.2.93:8080/sockjs/socketServer");    //SockJS对应的地址
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;

    function onOpen(openEvt) {
        //alert(openEvt.Data);
        alert("连接建立成功!");
    }

    function onMessage(evt) {
        alert(evt.data);
    }
    function onError() {
    }
    function onClose() {
    }

    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = document.getElementById("inputMsg").value;
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");
        } else {
            alert("连接失败!");
        }
    }

    window.close = function () {
        websocket.onclose();
    }
</script>
请输入：<textarea rows="3" cols="100" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend();">发送</button>
</body>
</html>