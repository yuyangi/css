package com.css.cloudkitchens.orders.impl;

import com.alibaba.fastjson.JSON;
import com.css.cloudkitchens.OrderConfigration;
import com.css.cloudkitchens.orders.OrderList;
import com.css.cloudkitchens.orders.service.OrderLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Loader order info from  http://bit.ly/css_dto_orders.
 * Using Spring's RestTemplate.
 */
@Component
public class OrderLoaderImpl implements OrderLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderLoaderImpl.class);

    private static RestTemplate template = new RestTemplate();

    @Autowired
    private OrderConfigration orderConfigration;

    public OrderList loadOrder() {
        File file = loadFile();
        try {
            if (file != null) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder jsonBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                return JSON.parseObject(jsonBuilder.toString(), OrderList.class);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Read order file failed!", e);
        } catch (IOException e) {
            LOGGER.error("Read order file failed!", e);
        }
        return null;
    }

    public File loadFile() {
        try {
            HttpHeaders headers = new HttpHeaders();
            List<MediaType> list = new ArrayList<MediaType>();
            list.add(MediaType.valueOf(APPLICATION_JSON_VALUE));
            headers.setAccept(list);
            ResponseEntity<byte[]> response = template.exchange(orderConfigration.getOrderAddress(), HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);

            byte[] result = response.getBody();
            if (result != null) {
                InputStream inputStream = new ByteArrayInputStream(result);

                File file = new File(OrderLoader.class.getResource("").getPath());
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        return null;
                    }
                }

                OutputStream outputStream = new FileOutputStream(file);
                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                    outputStream.write(buf, 0, len);
                }
                return file;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
