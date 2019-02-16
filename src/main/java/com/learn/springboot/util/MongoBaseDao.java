package com.learn.springboot.util;

import java.util.Collection;
import java.util.List;

import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.WriteResult;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.util.StringUtils;

@Repository
public class MongoBaseDao {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 单条查询mongo
     *
     * @param query          <必填> 查询对象，自行包含对条件的引入
     * @param entityClass    <必填> 返回的对象类型
     * @param collectionName <非必填> 被操作的集合/表，建议放在实体中
     * @return
     */
    public <T> T getRecordOne(Query query, Class<T> entityClass, String collectionName) {
        if (StringUtils.isEmpty(collectionName)) {
            return mongoTemplate.findOne(query, entityClass);
        } else {
            return mongoTemplate.findOne(query, entityClass, collectionName);
        }
    }


    /**
     * 多条查询mongo
     *
     * @param query          <必填> 查询对象，自行包含对条件的引入，比如分页、排序等
     * @param entityClass    <必填> 返回的集合对象类型
     * @param collectionName <非必填> 被操作的集合/表，建议放在实体中
     * @return
     */
    public <T> List<T> getRecords(Query query, Class<T> entityClass, String collectionName) {
        List<T> list = null;
        if (StringUtils.isEmpty(collectionName)) {
            list = mongoTemplate.find(query, entityClass);
        } else {
            list = mongoTemplate.find(query, entityClass, collectionName);
        }
        return list;
    }


    /**
     * 批量更新mongo
     *
     * @param query          <必填> 查询对象，自行包含对条件的引入
     * @param update         <必填> 更新对象，自行包含对条件的引入
     * @param entityClass    <必填> 文档类型
     * @param collectionName <非必填> 被操作的集合/表，建议放在实体中
     * @return
     */
    public int updateBatch(Query query, Update update, Class<?> entityClass, String collectionName) {
        if (StringUtils.isEmpty(collectionName)) {
            WriteResult wr = mongoTemplate.updateMulti(query, update, entityClass);
            return wr.getN();
        } else {
            WriteResult wr = mongoTemplate.updateMulti(query, update, entityClass, collectionName);
            return wr.getN();
        }
    }

    /**
     * 根据表名/集合名与文件id获取文件
     *
     * @param collectionName
     * @param fileId
     * @return
     */
    public GridFSDBFile getGridFSDBFileByParam(String collectionName, String fileId) throws Exception {
        DB db = mongoTemplate.getDb();
        // 存储fs的根节点
        GridFS gridFS = new GridFS(db, collectionName);
        GridFSDBFile dbfile = gridFS.findOne(fileId);
        return dbfile;
    }


    /**
     * 往表中插数据
     *
     * @param objectToSave   <必填>带插入数据
     * @param collectionName <非必填>表或集合
     */
    public void addRecord(Object objectToSave, String collectionName) {

        try {
            if (StringUtils.isEmpty(collectionName)) {
                mongoTemplate.insert(objectToSave);
    //			mongoTemplate.save(objectToSave);
            } else {
                mongoTemplate.insert(objectToSave, collectionName);
    //			mongoTemplate.save(objectToSave , collectionName);
            }
        } catch (DuplicateKeyException e) {
            //插入主键冲突，执行更新操作。
            e.printStackTrace();
        }
    }

    /**
     * 往表中插数据
     *
     * @param objectsToSave  <必填>带插入数据
     * @param collectionName <非必填>表或集合
     */
    public int addMongDataByList(Collection<? extends Object> objectsToSave, String collectionName) {
        if (StringUtils.isEmpty(collectionName)) {

            mongoTemplate.insertAll(objectsToSave);
        } else {
            mongoTemplate.insert(objectsToSave, collectionName);
        }
        return 0;
    }

    public void delMongDbData(Query query, String name) {
        mongoTemplate.remove(query, name);
    }

    public int selectMongDbData(Query query, String name) {
        return (int) mongoTemplate.count(query, name);
    }

}
