package com.titaniume.springboot;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.titaniume.springboot.bean.UserLog;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo18ApplicationTests {


	/*@Autowired
	private UserLogDao userLogDao;
	
	//JpaRepository 接口自带的查询
	@Test
	public void insert() {
		UserLog user = new UserLog();
		user.setUserName("titaniume2");
		user.setUserIp("127.0.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void delete() {
		userLogDao.delete(2);
	}

	@Test
	public void update() {
		UserLog user = new UserLog();
		user.setId(3);
		user.setUserName("titaniume2");
		user.setUserIp("192.168.0.1");
		user.setCreateTime(new Date());
		userLogDao.save(user);
	}

	@Test
	public void select1() {
		UserLog result = userLogDao.findOne(1);
		System.out.println(result);
	}
	*/
	
	
	//////////////////测试REST服务-使用代理///////////////////////////
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	@Test
	public void getForObject() {
		UserLog bean = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}", UserLog.class, 1);
		System.out.println(bean);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 7);
		bean = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, UserLog.class);
		System.out.println(bean);
	}
	
	
	/**
	 * 代理测试
	 */
	@Test
	public void getProxy() {
		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("http://www.jd.com", String.class);
		System.out.println(result);
	}
	
	/**
	 * 代理实现
	 * @author titaniume
	 * 2017年12月11日下午11:30:29
	 *
	 */
	static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "210.13.77.66";
			int proxyPort = 8080;
			
			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
					System.out.println(target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			//连接超时
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			//读取超时 这两个参数必须要设置
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}
	
	
	
}
