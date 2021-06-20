package com.eason.goods.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Slf4j
public class ElasticSearchService {
    protected static final RequestOptions COMMON_OPTIONS;

    static {
        final RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // 默认缓冲限制为100MB，此处修改为30MB。
        builder.setHttpAsyncResponseConsumerFactory(new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

    @Autowired
    private RestHighLevelClient client;

//    public ElasticSearchService(RestHighLevelClient client) {
//        this.client = client;
//    }

    protected void createIndexRequest(String index) {
        final CreateIndexRequest createIndexRequest = new CreateIndexRequest(index)
                .settings(Settings.builder().put("index.number_of_shards", 3)
                        .put("index.number_of_replicas", 0));

        final GetIndexRequest getIndexRequest = new GetIndexRequest(index);

        try {
            if (!client.indices().exists(getIndexRequest, COMMON_OPTIONS)) {
                final CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, COMMON_OPTIONS);
                log.info("所有节点确认响应：[{}]", createIndexResponse.isAcknowledged());
                log.info("所有分片的复制未超时：[{}]", createIndexResponse.isShardsAcknowledged());
            }
        } catch (IOException e) {
            log.error("创建索引库 [{}] 失败", index, e);
        }
    }

    protected void deleteIndexRequest(String index) {
        final DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);

        try {
            final AcknowledgedResponse response = client.indices().delete(deleteIndexRequest, COMMON_OPTIONS);
            log.info("所有节点确认响应：[{}]", response.isAcknowledged());
        } catch (IOException e) {
            log.error("删除索引库 [{}] 失败", index, e);
        }
    }

    protected List<String> search(String index, String keyword) {
        final SearchRequest searchRequest = new SearchRequest();
        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        final BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder()
                .filter(QueryBuilders.matchQuery("title", keyword))
                .filter(QueryBuilders.matchQuery("description", keyword));

        searchSourceBuilder.query(boolQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        try {
            final SearchResponse searchResponse = client.search(searchRequest, COMMON_OPTIONS);
            return Arrays.stream(searchResponse.getHits().getHits()).map(SearchHit::getId).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    protected void insertRequest(String index, String id, Object object) {
        final IndexRequest indexRequest = new IndexRequest(index).id(id).source(object, XContentType.JSON);
        try {
            client.index(indexRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error("创建索引文档 [{}] 数据 [{}] 失败", index, object, e);
        }
    }

    protected void updateRequest(String index, String id, Object object) {
        final UpdateRequest updateRequest = new UpdateRequest(index, id);
        updateRequest.doc(object, XContentType.JSON);
        try {
            client.update(updateRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error("更新索引文档 [{}] 数据 [{}] 失败", index, object, e);
        }
    }

    protected void deleteRequest(String index, String id) {
        final DeleteRequest deleteRequest = new DeleteRequest(index, id);
        try {
            client.delete(deleteRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error("删除索引文档 [{}] 数据id [{}] 失败", index, id, e);
        }
    }
}
