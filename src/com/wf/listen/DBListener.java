package com.wf.listen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wf.common.DBConnection;

/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
public class DBListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBListener() {
        // TODO Auto-generated constructor stub
    }

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		Properties properties = new Properties();
		try
		{
			String realPath = arg0.getServletContext().getRealPath("/");
			realPath = realPath + "persist\\jdbc.properties";
			properties.load(new FileInputStream(realPath));
			System.out.println("DBListener.contextInitialized()");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = properties.getProperty("DRIVER");
		String url = properties.getProperty("URL");

		DBConnection.init(driver, url);
		
	}
	
}
