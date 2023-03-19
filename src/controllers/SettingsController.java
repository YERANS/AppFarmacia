package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.SystemView;


public class SettingsController implements MouseListener{
    
    private SystemView views;

    public SettingsController(SystemView views) {
        this.views = views;
        this.views.jLabelProducts.addMouseListener(this);
        this.views.jLabelPurchises.addMouseListener(this);
        this.views.jLabelCustomers.addMouseListener(this);
        this.views.jLabelEmploys.addMouseListener(this);
        this.views.jLabelSupplagers.addMouseListener(this);
        this.views.jLabelCategorias.addMouseListener(this);
        this.views.jLabelReports.addMouseListener(this);
        this.views.jLabelSettings.addMouseListener(this);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == views.jLabelProducts){
            views.jPanelProducts.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelPurchises) {
            views.jPanelPurchises.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelCustomers) {
            views.jPanelCustomers.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelEmploys) {
            views.jPanelEmploys.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelSupplagers) {
            views.jPanelSupplagers.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelCategorias) {
            views.jPanelCategorias.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelReports) {
            views.jPanelReports.setBackground(new Color(152, 202, 63));
        }else if (e.getSource() == views.jLabelSettings) {
            views.jPanelSettings.setBackground(new Color(152, 202, 63));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == views.jLabelProducts){
            views.jPanelProducts.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelPurchises) {
            views.jPanelPurchises.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelCustomers) {
            views.jPanelCustomers.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelEmploys) {
            views.jPanelEmploys.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelSupplagers) {
            views.jPanelSupplagers.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelCategorias) {
            views.jPanelCategorias.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelReports) {
            views.jPanelReports.setBackground(new Color(18,45,61));
        }else if (e.getSource() == views.jLabelSettings) {
            views.jPanelSettings.setBackground(new Color(18,45,61));
        }
    }
    
}
