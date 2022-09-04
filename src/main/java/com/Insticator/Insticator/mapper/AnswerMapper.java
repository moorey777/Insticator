package com.Insticator.Insticator.mapper;

import com.Insticator.Insticator.model.Answer;
import com.Insticator.Insticator.model.Trivia;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface AnswerMapper {
    @Select("select * from answer")
    List<Answer> findAll();

    @Select("select typeName from questionType where typeId = #{typeId}")
    String findTypeName(@PathParam("typeId") final Integer typeId);

    @Select("select * from ${typeName} where id = #{questionId}")
    Trivia find(@PathParam("typeName") final String typeName, @PathParam("questionId") final Integer questionId);

    @Insert("insert into answer(typeId,questionId,userUid,answer,isCorrect) values(#{typeId},#{questionId},#{userUid},#{answer},#{isCorrect})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Answer answer);
}
