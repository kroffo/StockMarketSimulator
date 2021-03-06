<%@ page import="com.simulator.User" %>
<%
  com.simulator.User user = (com.simulator.User)session.getAttribute("user");
  if(user == null) { %>
<html>
  <body>
    <script>
      window.location.replace(location.origin + "/StockMarketSimulator/restTimeout");
    </script>
  </body>
</html>
<% } else { %>
<html>
  <head>
    <title>Dashboard</title>
  </head>
  <body>
    <h2>Welcome to your Dashboard, <% out.println(" " + user.getName() + "!"); %></h2>
    <h4>Balance: $ <% out.println(String.format("%.2f", user.getMoney())); %> </h4>
    <button OnClick="enterStockMarket()">Stock Market</button>
    <button OnClick="enterLeaderboard()">Leaderboard</button>
    <script>
      function enterStockMarket() {
        var url = location.origin + "/StockMarketSimulator/restStockMarket";
        window.location.replace(url);
      }

      function enterLeaderboard() {
      	var url = location.origin + "/StockMarketSimulator/restLeaderboard";
	window.location.replace(url);
      }
    </script>
  </body>
</html>
<% } %>
