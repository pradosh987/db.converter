<%-- 
    Document   : index
    Created on : Jun 25, 2015, 3:15:35 PM
    Author     : AION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>
   <form method="post" action="database_converter">
      <label for="name">Database Converter</label><br/><br/>
      Source: 
      <select name="source">
          <option value="CSV">CSV</option>
          <option value="Excel">Excel</option>
          <option value="MySQL">MySQL</option>
      </select>
      <br/><br/>
      Source Parameter 1: <input type="text" name="sourceParam1" />
      <br/>
      Source Parameter 2: <input type="text" name="sourceParam2" />
      <br/>
      Source Parameter 3: <input type="text" name="sourceParam3" />
      <br/>
      Source Parameter 4: <input type="text" name="sourceParam4" />
      <br/>
      Source Parameter 5: <input type="text" name="sourceParam5" />
      <br />
      Source File:
      <input type="file"  name="sourceFile" />
      </br><br/><br/>
      Destination:
      <select name="destination">
          <option value="CSV">CSV</option>
          <option value="Excel">Excel</option>
          <option value="MySQL">MySQL</option>
      </select>
      <br/><br/>
      Destination Parameter 1: <input type="text" name="destinationParam1" />
      <br/>
      Destination Parameter 2: <input type="text" name="destinationParam2" />
      <br/>
      Destination Parameter 3: <input type="text" name="destinationParam3" />
      <br/>
      Destination Parameter 4: <input type="text" name="destinationParam4" />
      <br/>
      Destination Parameter 5: <input type="text" name="destinationParam5" />
      </br><br/><br/>
      <input type="submit" value="Convert"/>
   </form>
</body>
</html>
