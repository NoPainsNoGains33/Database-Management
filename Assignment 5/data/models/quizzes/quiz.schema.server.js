const mongoose = require ('mongoose');

const quizSchema = mongoose.Schema ({
    _id: Number,
    width: Number,
    height: Number
},{collection:'quizzes'});

module.exports = quizSchema