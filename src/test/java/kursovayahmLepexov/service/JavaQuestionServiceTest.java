package kursovayahmLepexov.service;

import kursovayahmLepexov.dto.Question;
import kursovayahmLepexov.exception.NotEnoughQuestionException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private Question question = new Question("question","answer");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());

        assertTrue(underTest.getAll().contains(question));
        assertEquals(question,result);

    }


    @Test
    void remove_shouldRemoveQuestionOfSetAndReturnQuestion() {
        underTest.add(question);
        Question result = underTest.remove(question);
        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void getAll_shouldReturnQuestionsCollection() {
        Question question1 = new Question("question1","answer1");
        underTest.add(question);
        underTest.add(question1);

        Collection<Question> result = underTest.getAll();

        assertEquals(Set.of(question,question1),result);

    }

    @Test
    void getRandomQuestion_shouldThrowExceptionWhenCollectionIsEmpty() {
        assertThrows(NotEnoughQuestionException.class, () ->underTest.getRandomQuestion());
    }
    @Test
    void getRandomQuestion_shouldReturnQuestionWhenCollectionIsNotEmpty(){
        underTest.add(question);


        Question result = underTest.getRandomQuestion();

        assertEquals(question,result);

    }
}