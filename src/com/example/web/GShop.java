package com.example.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.GGoods;

public class GShop extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<GGoods> goods = produceTesters();
        req.setAttribute("goods", goods);
        RequestDispatcher view = req.getRequestDispatcher("goods.jsp");
		view.forward(req, resp);
    }

    public ArrayList<GGoods> produceTesters(){
        ArrayList<GGoods> goods = new ArrayList<>();
        GGoods good;
        for(int i = 0; i < 15; i++){
            good = new GGoods();
            good.setGoods_id(i);
            good.setGoods_name("number" + i);
            goods.add(good);
        }
        return goods;
    }
}
