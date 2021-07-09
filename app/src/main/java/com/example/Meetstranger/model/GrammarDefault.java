package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.List;

public class GrammarDefault {
   public static List getWordListByLevel(int var0) {
      if (var0 < 5) {
         return getWordListFromLevelOneToFive(var0);
      } else {
         return var0 < 10 ? getWordListFromLevelSixToTen(var0) : getWordListFromLevelElevenToFifteen(var0);
      }
   }

   static List getWordListFromLevelElevenToFifteen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 10) {
         var1.add(Word.getNewWord("Imperative mood", "request", "Please stop following me!"));
         var1.add(Word.getNewWord("Subjunctive mood", "contrary to fact", "I wish you were more educated."));
         var1.add(Word.getNewWord("Infinitives", "It is+___+infinitive", "It is time to do my homework in Algebra."));
         var1.add(Word.getNewWord("Comparative adjectives", "compare two things", "I love to dance than sing."));
         var1.add(Word.getNewWord("Superlative adjectives", "compare more than two things", "Leaana is the oldest woman in town."));
         var1.add(Word.getNewWord("Abstract noun", "not concrete", "I want to see justice served among the people."));
         var1.add(Word.getNewWord("Uncountable nouns", "SV=UN", "Children are prone to making wrongdoing if they are not doing anything."));
         var1.add(Word.getNewWord("Objective pronoun", "Pre+OP", "She depends on them."));
         var1.add(Word.getNewWord("Nominative pronoun", "after than", "She is better than you."));
         var1.add(Word.getNewWord("Positive degree", "described quality of a noun", "She is a good boy."));
      }

      if (var0 == 11) {
         var1.add(Word.getNewWord("Comparative degree", "than+nouns/pronouns", "I am better than her."));
         var1.add(Word.getNewWord("If clause in Present tense", "If + Simple present, simple future", "If you come to London, you will meet me."));
         var1.add(Word.getNewWord("If clause in Past tense", "If + Simple Past, Subject + would + V1", "If I had money, I would give it to you."));
         var1.add(Word.getNewWord("If clause in Past Perfect tense", "If + Past Perfect, Sub + would + have +V3", "If I had seen him, I would have stopped the bus."));
         var1.add(Word.getNewWord("Imaginative sentences", "If + subject + were, subject + would + V1", "If I were a fish, I would swim in the deep blue sea."));
         var1.add(Word.getNewWord("Quantifiers", "CN/UN=some/any/more/few", "Some students were happy of the examination result in English language."));
         var1.add(Word.getNewWord("Present Participle Verb", "base form+ing", "I am falling in love with him."));
         var1.add(Word.getNewWord("Troublesome Prepositions", "beside/besides", "She sits besides me in the classroom. Besides enjoying dancing, I love travelling when I'm free."));
         var1.add(Word.getNewWord("Adverbs of manner", "verb+adverb", "The boys cheered enthusiastically when they watched the cricket game."));
         var1.add(Word.getNewWord("Adverbs of Time", "verb+time", "Dinner will be ready soon."));
      }

      if (var0 == 12) {
         var1.add(Word.getNewWord("Semicolon to Join two Ideas", "CJ+;+CJ", "Vena's dog is hyperactive;it won't stop barking."));
         var1.add(Word.getNewWord("Subject verb agreement", "SS+SV/V1+s/es", "She plays the piano."));
         var1.add(Word.getNewWord("Plurals Ending in S", "s+apostrophe", "Joy, who dated all his friends' girlfriends."));
         var1.add(Word.getNewWord("Irregular pronouns", "apostrophe+s", "If all of the men have fancy bikes, you should write the men's fancy bikes."));
         var1.add(Word.getNewWord("Aberrant Apostrophe", "P-possessives=no apostrophe", "Odyssesus travels a long mile to reach his love."));
         var1.add(Word.getNewWord("Singular subjects", "SS+either/or", "Either choccolate ice cream or vanilla ice cream is fine."));
         var1.add(Word.getNewWord("Phrase-Complex", "phrase1+phrase2", "She moved in silence and without hesitation."));
         var1.add(Word.getNewWord("Verb-group complex", "V1+V2+V3+...", "The aim of higher education is to enrich and empower its graduates by developing their skills that will enable them to aprticipate in and contribute more effectively to society in the coming years."));
         var1.add(Word.getNewWord("Descriptive adjectives", "qualities and attributes+nouns", "She is beautiful."));
         var1.add(Word.getNewWord("Demonstrative adjectives", "S/P+neasr/far", "Those books are huge."));
      }

      if (var0 == 13) {
         var1.add(Word.getNewWord("Adverbs of degree", "adv+adv", "The ballerinas put up a totally entertaining performance ."));
         var1.add(Word.getNewWord("Compound Possessive Nouns", "noun+noun+'s", "Mark and Michael's business was booming."));
         var1.add(Word.getNewWord("Open compound word", "MA+noun", "The full moon is very beautiful today."));
         var1.add(Word.getNewWord("Parallelism", "Phrases/Clauses=Phrases/Clauses", "Athletes usually like practicing,competing,and to eat ice cream sandwiches."));
         var1.add(Word.getNewWord("Slashes", "separate lines/indicate or/form abbreviations/", "College seniors should bring a mattress and/or cot to sleep on during orientation."));
         var1.add(Word.getNewWord("Standalone interjections", "inj+sen/sen+inj", "Yikes!There is a snake in the kitchen!"));
         var1.add(Word.getNewWord("Root form of the verb", "base form", "I am going to market."));
         var1.add(Word.getNewWord("The Ellipsis", "...", "Tamlet asked whether it was nobler . . . to suffer the slings and arrows of outrageous fortune or to take arms against a sea of troubles."));
         var1.add(Word.getNewWord("The subjunctive", "if/wish+to were", "If I were a pretty girl."));
         var1.add(Word.getNewWord("Hyphens", "word+hyphen+word", "I am up-to-date when it comes to work."));
      }

      if (var0 == 14) {
         var1.add(Word.getNewWord("Inspite of + verb+ing", "doing something at inverse condition", "Inspite of being sick, he passed the exam."));
         var1.add(Word.getNewWord("Although..", "some act against the condition", "Although he is very poor, he is doing good in study."));
         var1.add(Word.getNewWord("So as to", "for a purpose", "He is studying hard so as to pass the exam."));
         var1.add(Word.getNewWord("inorder to", "for a purpose, goal", "He is studying hard inorder to pass the exam."));
         var1.add(Word.getNewWord("Neither.. nor", "none of the two", "Neither he nor his brother could pass the exam."));
         var1.add(Word.getNewWord("Either.. or", "one of the two", "Either he or his brother should look afther the ailing father."));
         var1.add(Word.getNewWord("Not only .. but also", "both", "Not only he but also his brother failed in the exam."));
         var1.add(Word.getNewWord("Whether or", "doubt between two", "I am not sure whether there will be rain or not."));
         var1.add(Word.getNewWord("had better", "a strong feeling to do something", "I had better quit smoking ->If I had quited smoke, it would be better."));
         var1.add(Word.getNewWord("used to", "habit in past", "I used to smoke a lot in past"));
      }

      return var1;
   }

   static List getWordListFromLevelOneToFive(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 0) {
         var1.add(Word.getNewWord("Tense - Present simple", "subject+verb present form , simple task in present", "He lives in India."));
         var1.add(Word.getNewWord("Tense - Present progressive", "subject+be(am,is,are)+verb+ing , any running task in present.", "He is playing football."));
         var1.add(Word.getNewWord("Tense - Present perfect", "subject+has/have+verb past participle, Any work of recent time", "He has just finished his lunch."));
         var1.add(Word.getNewWord("Tense - Present perfect progressive", "subject+has/have+been+verb+ing, any running task on present with a specific time or period", "He has been working for 4 hours."));
         var1.add(Word.getNewWord("Tense - Past simple", "subject+verb past form , simple task in past", "He played yesterdy."));
         var1.add(Word.getNewWord("Tense - Past progressive", "subject+(was/were)+verb+ing , any running task on past ", "He was playing football."));
         var1.add(Word.getNewWord("Tense - Past perfect", "subject+had+verb past participle, an action completed prior to some past point of time", "He had completed his lunch before the teacher came"));
         var1.add(Word.getNewWord("Tense - Future simple", "subject+shall/will+verb present form , simple task in Future", "He will go there monday."));
         var1.add(Word.getNewWord("Tense - Future progressive", "subject+ will/shall+be+verb+ing , any running task on Future ", "Ariyana will be enjoying world tour from next month."));
         var1.add(Word.getNewWord("Tense - Future perfect", "subject+will have+verb past participle, Any work that is expected to be finished", "He will have reached by this time."));
      }

      if (var0 == 1) {
         var1.add(Word.getNewWord("Parts of speech - Noun", "name of people, things, ideas or place", "Jimi is a good person. Jimi = noun"));
         var1.add(Word.getNewWord("Parts of speech - Pronoun", "Take the place of noun", "Karim is a good person. He is an honest person. He = pronoun"));
         var1.add(Word.getNewWord("Parts of speech - Adjective", "modify or describe noun or pronoun", "He is a good boy. Good = pronoun"));
         var1.add(Word.getNewWord("Parts of speech - Verb", "action or state", "Jimi plays football. Play = verb"));
         var1.add(Word.getNewWord("Parts of speech - Adverb", "Modifier of verb, adjective or adverb", "He is a very good person. Very = adverb"));
         var1.add(Word.getNewWord("Parts of speech - Preposition", "stands before noun to relate noun with other words", "Keep the cup on the table. On = preposition"));
         var1.add(Word.getNewWord("Parts of speech - Conjunction", "connector of two words, sentences or clauses", "He is poor but honest. But = conjunction"));
         var1.add(Word.getNewWord("Parts of speech - Interjection", "express excitement or emotion", "Hurrah! We have won the match. Hurrah = Interjection"));
         var1.add(Word.getNewWord("Clause - Independent Clause", "a simple sentence", "He is full."));
         var1.add(Word.getNewWord("Clause - Dependent Clause", "cannot stand on its own", "Although she is hungry..."));
      }

      if (var0 == 2) {
         var1.add(Word.getNewWord("Sentence - Assertive", "state or declare something", "Jimi is a good boy."));
         var1.add(Word.getNewWord("Sentence - Interrogative", "asks a question", "What is your name?"));
         var1.add(Word.getNewWord("Sentence - Imperative", "express command, order, request or wish", "Please , Lend me your book."));
         var1.add(Word.getNewWord("Sentence - Exclamatory", "express emotion, surprise,excitement", "Oh! we lost the game."));
         var1.add(Word.getNewWord("Voice - Active to passive - simple", "object in subject form+be+vpp+by+subject in object form", "He does the work.-> The work is done by him."));
         var1.add(Word.getNewWord("Voice - Active to passive - progressive", "be+being+vpp", "He is eating an apple.-> An apple is being eaten by him."));
         var1.add(Word.getNewWord("Voice - Active to passive - perfect", "has/have/had been+vpp", "He has done the job. -> The job has been done by him."));
         var1.add(Word.getNewWord("Voice - Active to passive - who?", "By whom should be used", "Who wrote this poem? -> By whom was this poem written?"));
         var1.add(Word.getNewWord("too+adjective+to", "express a negative act with a reason", "He is too sick to walk. -> He is very sick. He cant walk."));
         var1.add(Word.getNewWord("so+adjective+that", "cause and effect", "He is so polite that everyone loves him."));
      }

      if (var0 == 3) {
         var1.add(Word.getNewWord("would - the future in past", "the future in past", "In India she see the person that she would one day meet in person."));
         var1.add(Word.getNewWord("would - conditionals", "conditionals", "If he lost his job he would have no car."));
         var1.add(Word.getNewWord("would - desire", "desire", "I'd love to visit Spain."));
         var1.add(Word.getNewWord("would - requests", "polite requests", "Would you go with him?."));
         var1.add(Word.getNewWord("would - opinion", "opinion", "I suppose some people would call it murder."));
         var1.add(Word.getNewWord("would - presumption", "presumption", "Police would have been looking for those goons."));
         var1.add(Word.getNewWord("would - wish", "wish", "They don't like her. I'm sure they wish she'd leve the place."));
         var1.add(Word.getNewWord("would - uncertainty", "uncertainty", "He would seem to be getting cured."));
         var1.add(Word.getNewWord("would - derogatory comment", "derogatory comment", "They would do that, wouldn't they?."));
         var1.add(Word.getNewWord("would - regret", "regret", "Would that his father had lived to see him being successful."));
      }

      if (var0 == 4) {
         var1.add(Word.getNewWord("Narration- Direct speech", "Original words in qoute", "Bella said,\"I am sick.\""));
         var1.add(Word.getNewWord("Narration- Indirect speech", "Qoute is transformed in simple form", "Bella said that she was sick."));
         var1.add(Word.getNewWord("Narration- Direct to Indirect - present", "Change in subject only", "Bella says,\"I eat rice\" -> Bella says that she eats rice."));
         var1.add(Word.getNewWord("Narration- Direct to Indirect - past", "present->past, past simple->past perfect, said to->told", "Bella said to me,\"I ate rice\" -> Bella told me that she had eaten rice"));
         var1.add(Word.getNewWord("could- past form of can", "past form of can", "I could do the work"));
         var1.add(Word.getNewWord("could- possibility", "possibility, heistation", "Pamela could be the one who murdered the old man"));
         var1.add(Word.getNewWord("could- conditional of can", "conditional in past", "If I had more money, I could travel around the country"));
         var1.add(Word.getNewWord("could- suggestion", "suggestion", "You could have spent your summer in Spain"));
         var1.add(Word.getNewWord("could- past ability", "ability in past, but not now", "I could read Arabic when I was in school."));
         var1.add(Word.getNewWord("could- polite request", "request", "Could I borrow your pen?"));
      }

      return var1;
   }

   static List getWordListFromLevelSixToTen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 5) {
         var1.add(Word.getNewWord("connect using conjunction", "S+V+O,CC+S+V+O", "She is rich but so much greedy."));
         var1.add(Word.getNewWord("Connect using comma", "use of comma", "Pary fed her pet, and I drank my frappe."));
         var1.add(Word.getNewWord("Subject verb agreement", "SS+SV/V1+s/es", "She plays the piano."));
         var1.add(Word.getNewWord("s+apostrophe", "Plurals Ending in S", "Joy, who dated all his friends' girlfriends."));
         var1.add(Word.getNewWord("Irregular pronouns", "apostrophe+s", "If all of the men have fancy bikes, you should write the men's fancy bikes."));
         var1.add(Word.getNewWord("Aberrant Apostrophe", "P-possessives=no apostrophe", "Odyssesus travels a long mile to reach his love."));
         var1.add(Word.getNewWord("Singular subjects", "either/or", "Either chocolate ice cream or vanilla ice cream is fine."));
         var1.add(Word.getNewWord("Capitalization", "capital letter", "I grew up in India."));
         var1.add(Word.getNewWord("Verbs in o or sibilant", "o/ch/sh/s/x+es", "She washes the dishes."));
         var1.add(Word.getNewWord("Wh-question structure", "Wh-question word+Aux+S+verb", "Whom are they playing with?"));
      }

      if (var0 == 6) {
         var1.add(Word.getNewWord("Denominal adjective", "derived from nouns", "A wooden car."));
         var1.add(Word.getNewWord("Subject-Verb agreement", "SS+SV", "Benning works in Austria."));
         var1.add(Word.getNewWord("Interrogative Simple Past Tense", "Did+subject+infinitive without to", "Did he arrive?"));
         var1.add(Word.getNewWord("Interrogative Paste Tense", "Did not+subject+infinitive without to", "Didn't you dance?"));
         var1.add(Word.getNewWord("Compound adjective", "adjective+adjective", "She adopted a one-year-old cat."));
         var1.add(Word.getNewWord("Direct objects ", "receive the action of the verb carried out by the subject", "I like chocolate."));
         var1.add(Word.getNewWord("Indirect objects ", "receive the direct object", "I gave Yissa the shoes."));
         var1.add(Word.getNewWord("Conditional statements", "If + Present Indefinite + Future Indefinite + Obj", "If I go to Malaysia, I will meet him."));
         var1.add(Word.getNewWord("Transitive verbs", "DO+verb", "Jonathon will send the price quote as soon as she can."));
         var1.add(Word.getNewWord("Intransitive verbs", "no need for direct objects", "They laughed through out the movie."));
      }

      if (var0 == 7) {
         var1.add(Word.getNewWord("Auxiliary verbs", "main verb+have/be/do", "Maria is writing an e-mail to a client at the moment."));
         var1.add(Word.getNewWord("Demonstrative determiners", "this,that,these, and those", "This my cellphone."));
         var1.add(Word.getNewWord("Possessive adjectives", "my/your/his/her/its/our/your/their", "My watch is expensive."));
         var1.add(Word.getNewWord("Possessive pronouns", "mine/his/hers/yours/ours/theirs", "This is yours."));
         var1.add(Word.getNewWord("Modifying nouns", "some/any/few/little/more/much/many/each", "Little information will create problem."));
         var1.add(Word.getNewWord("Restrictive/Defining Clauses", "gives essential information", "The person who is standing there just came from a war."));
         var1.add(Word.getNewWord("Present subjunctive", " SP+be+verb", "It is important to finish your studies."));
         var1.add(Word.getNewWord("Past subjunctive", " SP+be", "If I were you I would buy this shoe."));
         var1.add(Word.getNewWord("Relative Pronoun", " who/whom/which/that/those", "The man whom she loves got away."));
         var1.add(Word.getNewWord("Relative adverb", " where/why/when", "The beach where I have my birthday party is awesome."));
      }

      if (var0 == 8) {
         var1.add(Word.getNewWord("Restrictive appositives", " don't need be set off with pair of commas", "My friend Joan is very kind."));
         var1.add(Word.getNewWord("Expressing purpose", "use to, so as to, and in order to", "Bella wakes up early in order to be on time to be in school."));
         var1.add(Word.getNewWord("Paralellism", " balancing of words", "My wife loves cooking and cleaning."));
         var1.add(Word.getNewWord("Bare infinitive", "do/be", "I can do it."));
         var1.add(Word.getNewWord("Full infinitive", "to do/to be", "She was made to do it."));
         var1.add(Word.getNewWord("Gerund", "verb+ing", "Dancing is my favorite hobby."));
         var1.add(Word.getNewWord("Modal verbs", "express functions-can/could/may/might", "Can I use your pen please?"));
         var1.add(Word.getNewWord("Modals in the present and past", "modal+have+past participle", "You should see a doctor."));
         var1.add(Word.getNewWord("Adjectival participle", "PP+ing", "It was a very frightening experience to go alone in the jungle."));
         var1.add(Word.getNewWord("Coordinate adjectives", "modify a noun", "While Chang was strolling in the woods, he found a big,blue, and strange tree."));
      }

      if (var0 == 9) {
         var1.add(Word.getNewWord("Cumulative adjectives", "jointly describe the noun", "I bought a beautiful pink dress."));
         var1.add(Word.getNewWord("Adverbs of frequency", "often+doing something", "She often go out dating."));
         var1.add(Word.getNewWord("Grammatical gender", "masculine/feminine", "Daddy loves Mommy."));
         var1.add(Word.getNewWord("Dummy subject", "there+to be", "There is peace in the village"));
         var1.add(Word.getNewWord("Reflexive pronouns", "SP+RP", "You might hurt yourself."));
         var1.add(Word.getNewWord("Possessive pronouns", "SP+PP/PA", "What color is your sister's shoe?"));
         var1.add(Word.getNewWord("Subordinating Conjunctions", "although=in spite of the fact that", "Although it was raining, I ran to the gym."));
         var1.add(Word.getNewWord("Coordinating conjunctions", "and/but/so/far/or", "I am pretty so as my mother."));
         var1.add(Word.getNewWord("Correlative conjunctions", "both", "Both TV and radio can be source of fun."));
         var1.add(Word.getNewWord("Indicative mood", "fact", "I will eat the chocoloate now."));
      }

      return var1;
   }
}
