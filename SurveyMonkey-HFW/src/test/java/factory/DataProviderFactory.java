package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ProvidesData;

public class DataProviderFactory 
{
	
	public static ConfigDataProvider getConfig() 
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;

	}
	
	public static ProvidesData getExcel() 
	{
		ProvidesData excel = new ProvidesData();
		return excel;

	}

}
