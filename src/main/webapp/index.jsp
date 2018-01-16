<%
    Cookie[] cookies = request.getCookies();
    String token = null;
    String cartInfo = null;
    if (cookies != null) {
        for(int i=0; i<cookies.length; i++) {
            // 获得具体的Cookie
            Cookie cookie = cookies[i];
            String cookieName = cookie.getName();
            if ("token".equals(cookieName)){
                token = cookie.getValue();
            }
            if (("cartInfo").equals(cookieName)){
                cartInfo = cookie.getValue();
            }
        }
    }
    String url = "user/homePage/" + token + "/" + cartInfo;
    request.getRequestDispatcher(url).forward(request,response);
%>
