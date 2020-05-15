const questionModel = require('../models/questions/question.model.server')

createQuestion = question => questionModel.create(question)

deleteQuestion = questionId => questionModel.remove({_id: questionId})

deleteAllQuestions = () => questionModel.remove({})

findAllQuestions = () => questionModel.find()

findQuestionById = questionId => questionModel.findById(questionId)

module.exports = {
    createQuestion,
    deleteQuestion,
    deleteAllQuestions,
    findAllQuestions,
    findQuestionById
}