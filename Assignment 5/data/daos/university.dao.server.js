const answerModel = require('../models/answers/answer.model.server')
const studentModel = require('../models/students/student.model.server')
const questionModel = require('../models/questions/question.model.server')
const quizModel = require ('../models/quizzes/quiz.model.server')

const studentDao = require ('./student.dao.server')
const questionDao = require ('./question.dao.server')
const answerDao = require ('./answer.dao.server')


truncateDatabase = () => {
    return answerModel.remove({})
        .then (() => studentModel.remove({}))
        .then (() => questionModel.remove({}))
        .then (() => quizModel.remove({}))
}

populateDatabase = () => {
    let alice = {_id: 123, firstName: 'Alice', lastName: 'WonderLand', username: 'alice', password: 'alice', gradYear: 2020, scholarship: 15000}
    let bob = {_id: 234, firstName: 'Bob', lastName: 'Hope', username: 'bob', password: 'bob', gradYear: 2021, scholarship: 12000}

    let question1 = {
        _id: 321,
        question: 'Is the following schema valid?',
        points: 10,
        questionType: 'TRUE_FALSE',
        trueFalse: {
            _id: 321,
            isTrue: false
        }}
    let question2 = {
        _id: 432,
        question: 'DAO stands for Dynamic Access Object.',
        points: 10,
        questionType: 'TRUE_FALSE',
        trueFalse: {
            _id: 432,
            isTrue: false
        }
    }
    let question3 = {
        _id: 543,
        question: 'What does JPA stand for?',
        points: 10,
        questionType: 'MULTIPLE_CHOICE',
        multipleChoice: {
            _id: 543,
            choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
            correct: 1
        }
    }
    let question4 = {
        _id: 654,
        question: 'What does ORM stand for?',
        points: 10,
        questionType: 'MULTIPLE_CHOICE',
        multipleChoice: {
            _id: 654,
            choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
            correct: 4
        }
    }

    let ans1 = {
        _id: 123,
        trueFalseAnswer: true,
        student_id: 123,
        question_id: 321
    }
    let ans2 = {
        _id: 234,
        trueFalseAnswer: false,
        student_id: 123,
        question_id: 432
    }
    let ans3 = {
        _id: 345,
        multipleChoiceAnswer: 1,
        student_id: 123,
        question_id: 543
    }
    let ans4 = {
        _id: 456,
        multipleChoiceAnswer: 2,
        student_id: 123,
        question_id: 654
    }
    let ans5 = {
        _id: 567,
        trueFalseAnswer: false,
        student_id: 234,
        question_id: 321
    }
    let ans6 = {
        _id: 678,
        trueFalseAnswer: true,
        student_id: 234,
        question_id: 432
    }
    let ans7 = {
        _id: 789,
        multipleChoiceAnswer: 3,
        student_id: 234,
        question_id: 543
    }
    let ans8 = {
        _id: 890,
        multipleChoiceAnswer: 4,
        student_id: 234,
        question_id: 654
    }

    return studentDao.createStudent(alice)
        .then (() => {
            return studentDao.createStudent(bob)
        })
        .then (() => {
            return questionDao.createQuestion(question1)
        })
        .then (() => {
            return questionDao.createQuestion(question2)
        })
        .then (() => {
            return questionDao.createQuestion(question3)
        })
        .then (() => {
            return questionDao.createQuestion(question4)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans1)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans2)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans3)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans4)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans5)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans6)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans7)
        })
        .then (() => {
            return answerDao.answerQuestionWithoutId(ans8)
        })
}

testStudentsInitialCount = () => {
    return studentDao.findAllStudents()
        .then(docs => console.log('Total number of students: ' + docs.length))
}

testQuestionsInitialCount = () => {
    return questionDao.findAllQuestions()
        .then(docs => console.log('Total number of questions: ' + docs.length))
}

testAnswersInitialCount = () => {
    return answerDao.findAllAnswers()
        .then(docs => console.log('Total number of answers: ' + docs.length))
}

testDeleteAnswer = () => {
    return answerDao.deleteAnswer(890)
        .then (() => {
            answerDao.findAllAnswers()
                .then (docs => {
                    console.log ('After delete the answer, current number of answers: ', docs.length)
                    return answerDao.findAnswersByStudent(234)
                })
                .then (docs => console.log ("Bob's total number of answers is: ", docs.length))
        })
}

testDeleteQuestion = () => {
    return questionDao.deleteQuestion(321)
        .then(() => {
            return questionDao.findAllQuestions()
        })
        .then(docs =>
            console.log('After delete the question, curren number of questions: ' + docs.length)
        )
}

testDeleteStudent = () => {
    return studentDao.deleteStudent(234)
        .then(() => {
            return studentDao.findAllStudents()
        })
        .then(docs =>
            console.log('After delete the student, current number of students: ' + docs.length)
        )
}
module.exports = {
    truncateDatabase,
    populateDatabase,
    testStudentsInitialCount,
    testQuestionsInitialCount,
    testAnswersInitialCount,
    testDeleteAnswer,
    testDeleteQuestion,
    testDeleteStudent
}


// What I have tried:
// return studentDao.createStudent(alice)
//     .then (() => studentDao.createStudent(bob)
//         .then (() => questionDao.createQuestion(question1)
//             .then (() => questionDao.createQuestion(question2)
//                 .then (() => questionDao.createQuestion(question3)
//                     .then (() => questionDao.createQuestion(question4)
//                         .then (() => answerDao.answerQuestionWithoutId(ans1)
//                             .then (() => answerDao.answerQuestionWithoutId(ans2)
//                                 .then (() => answerDao.answerQuestionWithoutId(ans3)
//                                     .then (() => answerDao.answerQuestionWithoutId(ans4)
//                                         .then (() => answerDao.answerQuestionWithoutId(ans5)
//                                             .then (() => answerDao.answerQuestionWithoutId(ans6)
//                                                 .then (() => answerDao.answerQuestionWithoutId(ans7)
//                                                     .then (() => answerDao.answerQuestionWithoutId(ans8))))))))))))))

// return studentDao.createStudent(alice)
//     .then (() => studentDao.createStudent(bob))
//     .then (() => questionDao.createQuestion(question1))
//     .then (() => questionDao.createQuestion(question2))
//     .then (() => questionDao.createQuestion(question3))
//     .then (() => questionDao.createQuestion(question4))
//     .then (() => {
//         answerDao.answerQuestionWithoutId(ans1)
//         answerDao.answerQuestionWithoutId(ans2)
//         answerDao.answerQuestionWithoutId(ans3)
//         answerDao.answerQuestionWithoutId(ans4)
//         answerDao.answerQuestionWithoutId(ans5)
//         answerDao.answerQuestionWithoutId(ans6)
//         answerDao.answerQuestionWithoutId(ans7)
//         answerDao.answerQuestionWithoutId(ans8)
//     })