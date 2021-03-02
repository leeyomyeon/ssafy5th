package com.ssafy.weather;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WeatherMain {
    JFrame f = new JFrame("Weather Info");
    JButton b = new JButton("call Weather");
    JList<Object> li = new JList<>();
    WeatherSAX dao;

    public WeatherMain() {
        dao = new WeatherSAX();
        createGUI();
        addEvent();
    }

    private void addEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
    }

    protected void showList() {
        java.util.List<Weather> datas = dao
                .getWeathersList("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
        li.removeAll();
        li.setListData(datas.toArray());
    }

    private void createGUI() {
        f.add(b, "North");
        f.add(li);
        f.setSize(400, 500);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new WeatherMain();
    }

}
