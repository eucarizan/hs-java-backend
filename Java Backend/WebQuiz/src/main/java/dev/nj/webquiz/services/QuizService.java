package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.NotOwnerException;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService {

    /**
     * find and retrieve quiz with given id
     *
     * @param id quiz id
     * @return the found quiz
     * @throws QuizNotFoundException if no quiz with id is found
     */
    Quiz getById(long id) throws QuizNotFoundException;

    /**
     * find a quiz with the given id and solve with the given answer
     *
     * @param id     quiz id
     * @param answer answer/s to the quiz
     * @return the result if answer is correct or not
     * @throws QuizNotFoundException if no quiz with id is found
     */
    Result answer(long id, AnswerDto answer) throws QuizNotFoundException;

    /**
     * save a given quiz to the repository
     *
     * @param quizDto quiz details
     * @param user    creator of the quiz
     * @return the quiz with its id
     */
    Quiz create(QuizDto quizDto, User user);

    /**
     * delete the quiz with the given id only when logged-in user is the quiz's creator
     *
     * @param id       quiz id
     * @param username logged-in User
     * @throws QuizNotFoundException if no quiz with id is found
     * @throws NotOwnerException     if the authenticated session user is not the owner of the quiz
     */
    void delete(long id, String username) throws QuizNotFoundException, NotOwnerException;


    /**
     * find quizzes with the given page, default size of page is 10
     *
     * @param pageable page
     * @return paginated list of quizzes
     */
    Page<QuizDto> findAll(Pageable pageable);
}
