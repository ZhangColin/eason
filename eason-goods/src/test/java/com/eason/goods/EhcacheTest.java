package com.eason.goods;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;

public class EhcacheTest {
    @Test
    public void test() {
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
        Cache cache = cacheManager.getCache("HelloWorldCache");

        Element element = new Element("key1", "value1");
        cache.put(element);

        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        cache.remove("key1");
    }
}