const mongoose = require ('mongoose');

const answerSchema = mongoose.Schema ({
    _id: Number,
    student_id: {
        type: Number,
        ref:'StudentModel'
    },
    question_id:{
        type: Number,
        ref:'QuestionModel'
    },
    trueFalseAnswer: Boolean,
    multipleChoiceAnswer: Number,
},{collection:'answers'});

module.exports = answerSchema