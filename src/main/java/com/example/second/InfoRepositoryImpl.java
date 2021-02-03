package com.example.second;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InfoRepositoryImpl implements InfoRepositoryCustom{

//    @Autowired
//    @Qualifier("infoJPAQueryFactory")
//    private JPAQueryFactory queryFactory;

    @Override
    public Info findById(Long id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);




        QInfo info = QInfo.info;
        return queryFactory.select(info)
                .where(info.id.eq(id))
                .orderBy(info.createdDate.desc())
                .fetchFirst();

    }

}
