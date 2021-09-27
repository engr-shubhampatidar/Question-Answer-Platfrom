package com.platform.QuestionAnswer.DAO;

import org.springframework.stereotype.Service;

@Service
public class QuestionDetail {
        private String questionText;
        private boolean questionLikes;
        private String  company;
        private String tag;
        private String topics;


        public QuestionDetail() {
        }

        public QuestionDetail(String questionText,
                              boolean questionLikes,
                              String company,
                              String tag,
                              String topics) {
            this.questionText = questionText;
            this.questionLikes = questionLikes;
            this.company = company;
            this.tag = tag;
            this.topics = topics;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public boolean isQuestionLikes() {
            return questionLikes;
        }

        public void setQuestionLikes(boolean questionLikes) {
            this.questionLikes = questionLikes;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTopics() {
            return topics;
        }

        public void setTopics(String topics) {
            this.topics = topics;
        }

    @Override
    public String toString() {
        return "QuestionDetail{" +
                "questionText='" + questionText + '\'' +
                ", questionLikes=" + questionLikes +
                ", company='" + company + '\'' +
                ", tag='" + tag + '\'' +
                ", topics='" + topics + '\'' +
                '}';
    }
}
