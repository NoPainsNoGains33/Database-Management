const answerModel = require('../models/answers/answer.model.server')

answerQuestion = (studentId, questionId, answer) => {
    answer.student_id = studentId
    answer.questionId = questionId
    answerModel.create(answer)
}

answerQuestionWithoutId = answer => answerModel.create(answer)


deleteAnswer = answerId => answerModel.remove({_id: answerId})

deleteAllAnswers = () => answerModel.remove({})

findAllAnswers = () => answerModel.find()

findAnswerById = answerId => answerModel.findById(answerId)

findAnswersByStudent = (studentId) =>
    answerModel.find({student_id: studentId})
        .populate ('question_id', 'question')
        .exec()

findAnswersByQuestion = (questionId) =>
    answerModel.find({question_id: questionId})
        .populate ('student_id', 'firstName, lastName')
        .exec()

module.exports = {
    answerQuestion,
    answerQuestionWithoutId,
    deleteAnswer,
    deleteAllAnswers,
    findAllAnswers,
    findAnswerById,
    findAnswersByStudent,
    findAnswersByQuestion
}