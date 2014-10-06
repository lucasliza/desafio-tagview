package com.lucasliza.estagiotagview;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

//Responsável por fazer requisições http com API's 
//assim como retornar a resposta, se houver.
public class APICaller {
	static String response = "";
	
	public String sendRequest(String url, List<NameValuePair> params) {
		try {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpEntity httpEntity = null;
		HttpResponse httpResponse = null;
		//Adicionar parâmetros na url
		if (params != null) {
		    String paramString = URLEncodedUtils.format(params, "utf-8");
		    url += "?" + paramString;
		    Log.e("URL", url);
		}
		
		HttpGet httpGet = new HttpGet(url);
		httpResponse = httpClient.execute(httpGet);
		httpEntity = httpResponse.getEntity();
		response = EntityUtils.toString(httpEntity); 
		
		}  catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return response;
	}

}
