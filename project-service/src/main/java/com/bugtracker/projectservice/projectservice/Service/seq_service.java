package com.bugtracker.projectservice.projectservice.Service;

import com.bugtracker.projectservice.projectservice.Entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class seq_service {
    @Autowired
    private MongoOperations mongoOperations;

    public int getseq(String sqname){
        Query query = new Query(Criteria.where("id").is(sqname));
        Update update = new Update().inc("seq",1);
        Sequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), Sequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
