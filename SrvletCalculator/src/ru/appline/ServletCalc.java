package ru.appline;

import com.google.gson.JsonObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/math")
public class ServletCalc extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null){
                jb.append(line);
            }
        } catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        double a = jobj.get("a").getAsDouble();
        double b = jobj.get("b").getAsDouble();
        String math = jobj.get("math").getAsString();
        Map<String, Double> result = new HashMap<String, Double>();
        Map<String, String> error = new HashMap<String, String>();
        String err = " ";
        double res = 0;
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        switch (math){
            case ("+"):
                res = a + b;
                result.put("result", res);
                pw.print(gson.toJson(result));
            break;
            case ("-"):
                res = a - b;
                result.put("result", res);
                pw.print(gson.toJson(result));
            break;
            case ("*"):
                res = a * b;
                result.put("result", res);
                pw.print(gson.toJson(result));
            break;
            case ("/"):
                if (b != 0){
                    res = a / b;
                    result.put("result", res);
                    pw.print(gson.toJson(result));
                } else {
                    err = "Делить на ноль нельзя!";
                    error.put("error", err);
                    pw.print(gson.toJson(error));
                }
            break;
        }
    }
}
