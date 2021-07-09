package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.List;

public class IdiomsDefault {
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
         var1.add(Word.getNewWord("In the nick of time", "when something happens at the very last moment", "The policemen saved the hostage from the bandit."));
         var1.add(Word.getNewWord("In the pink of health", "in very nice condition", "Noree is in the pink of health."));
         var1.add(Word.getNewWord("In the same boat", "to be in the same condition like as other people", "May's always complaining that she doesn't have enough money, but we're all in the same boat."));
         var1.add(Word.getNewWord("Inside scoop", "the details", "Hey give me the inside scoop on how you met Jemar."));
         var1.add(Word.getNewWord("It’s all flooding back to me", "remembering forgotten things", "When I saw my childhood doll, memories all came flooding back to me."));
         var1.add(Word.getNewWord("Keep an eye on", "To watch with concentration", "You need to keep an eye on your new teacher."));
         var1.add(Word.getNewWord("Keep your fingers on the pulse", "Being constantly aware", "An employee must keep his fingers on the pulse of the market to be successful."));
         var1.add(Word.getNewWord("Kick the bucket", "no longer working", "I just got my phone kicked the bucket."));
         var1.add(Word.getNewWord("Kill two birds with one stone", "Finish two things at once", "You can kill two birds with one stone by doing laundry and study."));
         var1.add(Word.getNewWord("How’s it going?", "How are you?", "How’s it going today Jay?"));
      }

      if (var0 == 11) {
         var1.add(Word.getNewWord("I made a key decision", "make a big decision", "I made a key decision to finish my graduate studies."));
         var1.add(Word.getNewWord("I was knocked on my heels", "I was astonished", " I was knocked on my heels when I realized I won the lottery."));
         var1.add(Word.getNewWord("be full of beans", "fresh and energetic", "Clint's always full of beans when he goes to work. "));
         var1.add(Word.getNewWord("be in somebody's shoes", "Taking similar responsibility from another person", "I wouldn't like to be in Julia's shoes. She'll have a lot of problems with her boss. "));
         var1.add(Word.getNewWord("be no oil painting", "ugly looking", "Kate is very intelligent, but she's no oil painting. "));
         var1.add(Word.getNewWord("Stay on track", "concentrate on the goal", "I shouldn’t watch movies right now. I need to stay on track and study."));
         var1.add(Word.getNewWord("Stick with your goal/stick with it", "to continue", "You should really stick with dancing because you are very good at it."));
         var1.add(Word.getNewWord("Out of nowhere", "not expected", "That surprise game came out of nowhere."));
         var1.add(Word.getNewWord("Black sheep of the family", "describe an odd member of a group", "They usually describe middle child as black sheep of the family."));
         var1.add(Word.getNewWord("Break a leg", "wishing someone to win or acheive something", "You will do fine on your presentation. Go break a leg out there."));
      }

      if (var0 == 12) {
         var1.add(Word.getNewWord("Bring home the bacon", "to bring money earned from work", "I've got to do my best if I'm going to bring home the bacon."));
         var1.add(Word.getNewWord("call it a day", "No work for the rest of the day", "Why don't we call it a day? I'm really not feeling well. "));
         var1.add(Word.getNewWord("Fast track something ", "increase priority", "In view of the crime, the investigators is pressing up on a fast track decision from the court."));
         var1.add(Word.getNewWord("Fill in the blanks", "make things completed", "We have only 4 people in the team. We need 10. We need to fill in the blanks"));
         var1.add(Word.getNewWord("Fine-tooth comb", "Examining something carefully", "The manager examined my report with a fine tooth comb before submitting it to the senior management."));
         var1.add(Word.getNewWord("Get ducks in a row", "Making things well organized", "To ensure a successful advertisement, we must get our ducks in a row."));
         var1.add(Word.getNewWord("Put a sock in it", "be quiet", "My loud friends really need to put a sock in it."));
         var1.add(Word.getNewWord("quote a price", "state in advanced price", "The mason quoted a price of 1000$ to fix the interior of my house."));
         var1.add(Word.getNewWord("Take a chill pill", "telling someone to calm down and emnjoy", "I don't think the inetrview will be too hard, take a chill pill."));
         var1.add(Word.getNewWord("take a dim view of ", "not agreeing", "My grandmother takes a dim view of the new law."));
      }

      if (var0 == 13) {
         var1.add(Word.getNewWord("Take him out of the picture", "remove someone our from a group", "Roland isn't the best group partner, we should take him out of the picture."));
         var1.add(Word.getNewWord("Take it easy", "calm down", "You only failed inetrview.Take it easy."));
         var1.add(Word.getNewWord("talk a mile a minute", "to speak very quickly; to talk in a very quick or hurried manner", "I can never follow everything Jay tries to say. He talks a mile a minute. "));
         var1.add(Word.getNewWord("that beats everything", "expressions of surprise", "You mean he came very late again last night? Well, that beats everything!"));
         var1.add(Word.getNewWord("That’s tight", "closed firmly", "This new dress is tight."));
         var1.add(Word.getNewWord("the chill wind of something", "problems, trouble", "We are facing the chill wind of the recession."));
         var1.add(Word.getNewWord("to stretch", "The last part of a hard work", "We are in the beach to stretch after a year of hard work."));
         var1.add(Word.getNewWord("The last straw", "the final thing that causes everything to fail", "My recent sprained knee was the last straw; I need to get surgery now."));
         var1.add(Word.getNewWord("be a cold fish", "be a person who is not comfortable to speak much", "Carwin rarely talks to his colleagues. He's a cold fish."));
         var1.add(Word.getNewWord("be dead in the water", "no progress at all", "Our outputs will be dead in the water if we don't have a good plan. "));
      }

      if (var0 == 14) {
         var1.add(Word.getNewWord("A blessing in disguise", "looks bad, but is actually good", "Accidently registering for the wrong organization was actually a blessing in disguise."));
         var1.add(Word.getNewWord("A feather in my cap", "Some recognition", "Kersy is so proud of his son for a feather in his cap."));
         var1.add(Word.getNewWord("A piece of cake", "very easy", "That test was a piece of cake."));
         var1.add(Word.getNewWord("as poor as a church mouse", "very poor", "MArlou is as poor as a church mouse; don't ask him to donate anything."));
         var1.add(Word.getNewWord("as ugly as sin", "very ugly", "The dress Ann is wearing is as ugly as sin. "));
         var1.add(Word.getNewWord("at death's door", "almost at the end of life", "Alyssa was so ill and was at death's door for more than a month. "));
         var1.add(Word.getNewWord("at hand", "nearby", "I don't have the her phone number at hand at the moment."));
         var1.add(Word.getNewWord("zero hour", "the to begin", "This is the zero hour for the incident."));
         var1.add(Word.getNewWord("The stars have aligned", "very good moment by luck", "The stars have aligned because it’s Jecyl's birthday and she won the lottery."));
         var1.add(Word.getNewWord("Think on your feet", "fast decisions to adopt quickly", "A good agent man must be able to think on his feet to close the deal."));
      }

      return var1;
   }

   static List getWordListFromLevelOneToFive(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 0) {
         var1.add(Word.getNewWord("at sixes and sevens", "not organized", "Jerry is at sixes and sevens after the death of his wife. "));
         var1.add(Word.getNewWord("at the drop of a hat", "they do it without delay or good reason", "So many years of struggles and then you can leave me at the drop of a hat."));
         var1.add(Word.getNewWord("at the wheel", "in driving", "You know Janoel fell asleep at the wheel."));
         var1.add(Word.getNewWord("Something’s fishy", "strange", "All the lights are off in the room and gate is open, something’s fishy."));
         var1.add(Word.getNewWord("Speak of the Devil", "see someone/something unexpectedly ", "Speak of the devil Noree! We were just looking for you."));
         var1.add(Word.getNewWord("Spill the beans", "to tell the hidden", "I told Leah my biggest secret, she then spilled the beans to the whole class."));
         var1.add(Word.getNewWord("Out of the blue", "not expected", "We were walking to the mall when Naysa appeared out of the blue."));
         var1.add(Word.getNewWord("Plum job", "comfortable or relatively easy", "This looks like a plum job but we need to consider the rules."));
         var1.add(Word.getNewWord("Pull the plug", "put an end", "After Rico quit, we may just have to pull the plug on the whole operation."));
         var1.add(Word.getNewWord("Throw an idea around", "propose an idea", "I want to throw an idea around for next week’s event."));
      }

      if (var0 == 1) {
         var1.add(Word.getNewWord("Beating around the bush", "not discussing main idea", "I needed to work things out, but I kept beating around the bush."));
         var1.add(Word.getNewWord("beef up", "make something more productive", "The students beefed up their offer with another million dollar."));
         var1.add(Word.getNewWord("behind one's back", "In one's absence", "Marko was talking nonsense on my back when I arrived. "));
         var1.add(Word.getNewWord("Big task on your hand", "something important to do", "My professor gave me a new assignment, so I have a big task on my hands."));
         var1.add(Word.getNewWord("Shape up or ship out", "threaten to fire if work is not done perfectly", "When Lawrence started neglecting the customers, he was told to shape up or ship out."));
         var1.add(Word.getNewWord("Since day one", "long time", "I've been playing boxing since day one"));
         var1.add(Word.getNewWord("Time flies", "time passes quickly", "I can't believe the summer is already over, time flies!"));
         var1.add(Word.getNewWord("To touch base ", "to contact", "I need to touch base with Joseph about the new office reports."));
         var1.add(Word.getNewWord("Tricks of the trade", "Cunning way to do something", "Being into the construction business for last 15 years, I know all tricks of the trade."));
         var1.add(Word.getNewWord("Spur of the moment", "to take a sudden decision", "I decided to drive to Florida on the spur of the moment."));
      }

      if (var0 == 2) {
         var1.add(Word.getNewWord("Tight", "close score in sports", "80 to 80 with two minutes left! This is a really tight game."));
         var1.add(Word.getNewWord("Have stumbled upon", "to accidentally find something", "I stumbled upon a new coffee shop while walking around downtown."));
         var1.add(Word.getNewWord("Heart of gold", "a caring attitude", "Underneath Ada's grumpy disposition beats a heart of gold."));
         var1.add(Word.getNewWord("Hit the books", "to study", "I can't go to the event tonight, I have to hit the books"));
         var1.add(Word.getNewWord("Hold your horses", "calm down", "Hold your horses. I am still eating my lunch."));
         var1.add(Word.getNewWord("Acid Test", "A task that will show the skills or proof", "I practiced hard at the music sessions but the acid test will come when the master will assess our solo performances."));
         var1.add(Word.getNewWord("Actions speak louder than words", "give importance on practical works", "You say you love her but actions speak louder than words."));
         var1.add(Word.getNewWord("Almost hit the ceiling", "to be very angry", "When my momd found out I had failed the exams, she just hit the door."));
         var1.add(Word.getNewWord("Apple of my eye", "person you admire or love", "Michael's apple of the eye is the president of the Math Club."));
         var1.add(Word.getNewWord("as one man", "in agreement", "They all rose as one man, supporting the oppressed family."));
      }

      if (var0 == 3) {
         var1.add(Word.getNewWord("at your mother's knee", "in childhood", "Melrose learned to sing at her mother's knee. "));
         var1.add(Word.getNewWord("back the wrong horse", "defend the wrong person", "Why you are not firing this stupid guy. Don't back the wrong horse!"));
         var1.add(Word.getNewWord("Back-room boys", "People who perform not in front", "Our back room girls deserve an applause for the success of this advertisement."));
         var1.add(Word.getNewWord("bad blood", "bad relation", "There is bad blood between Christina and Andrea."));
         var1.add(Word.getNewWord("bag of tricks", "a set of techniques", "Why don't you use your bag of tricks to solve this mystery?"));
         var1.add(Word.getNewWord("bank on", "rely on", "Can I bank on your brother's predictions about the stock market?"));
         var1.add(Word.getNewWord("be a barrel of laughs", "be entertaining", "This theater show is a real barrel of laughs."));
         var1.add(Word.getNewWord("get in someone's hair", "Annoy someone", "I know that the girls get in your hair, but you should try not to let it upset you so much."));
         var1.add(Word.getNewWord("Get on the ball", "to put focus on the goal ", "If you haven’t started your work yet, you need to get on the ball."));
         var1.add(Word.getNewWord("Get out of town", "Go from here(showing anger)", "Get out of town!I dont like to see your face"));
      }

      if (var0 == 4) {
         var1.add(Word.getNewWord("Get over it", "forget past incident", "Antonio broke up with his girlfriend but he needs to get over it."));
         var1.add(Word.getNewWord("Get the axe", "lose the job", "Recruitment agencies were the first to get the axe."));
         var1.add(Word.getNewWord("Get the show on the road", "Put idea in action", "Now that they have compeleted all the legal formalities, let's get them show on the road."));
         var1.add(Word.getNewWord("give me five", "slap your open hand to express happiness", "\"Give me five!\" shouted Raffy after he passed the exam."));
         var1.add(Word.getNewWord("go home in a box", "to die or killed", "Those soldiers are too young to go home in a box."));
         var1.add(Word.getNewWord("go with the flow", "accept the reality and not trying to change things", "Don't think of it! Take it easy and go with the flow!"));
         var1.add(Word.getNewWord("Golden handshake ", "Retirement offer in exchange of cash", "They offered a golden hand shake to many of their retirees."));
         var1.add(Word.getNewWord("Gone off track", "Not focusing on the main idea", "My friend really got off track because she failed all classes this semester."));
         var1.add(Word.getNewWord("grouse about someone or something", "To complain", "Justin was grousing about his son's laziness."));
         var1.add(Word.getNewWord("Hands down", "certainly", "Harvard is hands down the best place to study abroad."));
      }

      return var1;
   }

   static List getWordListFromLevelSixToTen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 5) {
         var1.add(Word.getNewWord("call the shots", "Decide something", "This is my birthday party; I will call the shots. You have to sing now."));
         var1.add(Word.getNewWord("Can’t stand", "to dislike something", "I can’t stand having to do homework on a Tuesday."));
         var1.add(Word.getNewWord("carry a tune", "sing a melody perfectly", "I can't carry a tune, but my twin brother sings very well. "));
         var1.add(Word.getNewWord("Chase your tail", "Too much work to get little", "Greg's been chasing his tail all week collecting data but the report is still not ready."));
         var1.add(Word.getNewWord("Check out that", "Try something", " Check out that very cool looking car."));
         var1.add(Word.getNewWord("Close but no cigar", "close but failed", "You got a 79% on the test. Almost a C…close but no cigar."));
         var1.add(Word.getNewWord("Cut the ground from under feet", "Creating a worse scenario for someone", "When team India hit more than 200 runs in the T20, they cut the ground from under the opponent's feet."));
         var1.add(Word.getNewWord("Dead wood", "People or things which are no longer useful", "They no longer want the dead trees."));
         var1.add(Word.getNewWord("Deliver the goods", "Do what is expected", "I have given my bicycle to a new mechanic for repair, hope he delivers the goods."));
         var1.add(Word.getNewWord("Don't sweat it", "don’t worry", "You accidently scratched my work but I don't care. Don’t sweat it."));
      }

      if (var0 == 6) {
         var1.add(Word.getNewWord("Draw the line", "put limitation", "I draw the line at $30 for a pasta."));
         var1.add(Word.getNewWord("Driving me bananas", "making me feel good", "My very loud friends are driving me bananas."));
         var1.add(Word.getNewWord("Easier said than done", "easy to say, but difficult to do", "Changing the text is easier said than done."));
         var1.add(Word.getNewWord("Explore all avenues", "Trying out every possibility to get a result", "It is a difficult thing to do but if we rwant the best, we must explore all avenues."));
         var1.add(Word.getNewWord("Hang on a second", "wait for a moment", "Hang on a second…I am waiting for my works to finish."));
         var1.add(Word.getNewWord("Hang out", "spend time with a friend", "Leander and I hang out after class every Saturday."));
         var1.add(Word.getNewWord("Lend a hand", "help someone out", "I see those books are very heavy, can I lend you a hand?"));
         var1.add(Word.getNewWord("Let it ride", "to allow something to remain as it is", "I don't like my schedule for this semester, but I'm going to let it ride."));
         var1.add(Word.getNewWord("Let’s boogie on out", "let’s all leave", "The moviehouse is closing, let’s boogie on out."));
         var1.add(Word.getNewWord("Let’s bounce ", "to leave", "The marathon is over, let’s bounce."));
      }

      if (var0 == 7) {
         var1.add(Word.getNewWord("Locked in", "to give complete concentration too", "I'm really locked in to this new movie."));
         var1.add(Word.getNewWord("Low down", "to receive the complete story", "Hey give me the low down on what happened last Friday night."));
         var1.add(Word.getNewWord("Mean business", "Being serious on what you announce", "Now that all our policies about work are put up we can make some changes."));
         var1.add(Word.getNewWord("next to nothing", "almost; hardly", "Although they paid Ronel next to nothing, he liked the job."));
         var1.add(Word.getNewWord("No big deal", "very easy", "If you can't make it to my welcome party it’s no big deal."));
         var1.add(Word.getNewWord("not half bad", "Pretty nice", "It was my first attempt at driving, but I tried it and it was not half bad."));
         var1.add(Word.getNewWord("Not let grass grow under feet", "Don't be late in getting something done", "Jeff doesn't let the grass grow under his feet."));
         var1.add(Word.getNewWord("On the same page", "having similar ideas", "I'm glad we are on the same page with our ideas for this assignment."));
         var1.add(Word.getNewWord("Laid back", "feeling easy", "Justine is not very excited, he is laid back."));
         var1.add(Word.getNewWord("Last shot", "Last opportunity", "The final exam is my last shot to graduate."));
      }

      if (var0 == 8) {
         var1.add(Word.getNewWord("Leading someone on ", "having someone believe something that is false", "Why do you keep telling Robielyn you like her, you are just leading her on."));
         var1.add(Word.getNewWord("Raining cats and dogs", "something that you say when it is raining strong", "I wasn't able to attend the meeting because it was raining cats and dogs."));
         var1.add(Word.getNewWord("Rally the troops", "to meet up friends together", "We're going to rally the troops then head to the badminton game."));
         var1.add(Word.getNewWord("Sail through something", "Being successful in doing something in ease", "The presentation at the local conference was extremely important for the company. We sailed through it."));
         var1.add(Word.getNewWord("Save his face", "Maintaining the status or honour", "Angelo tried to make reparations to those he had injured, partly to save face."));
         var1.add(Word.getNewWord("Separate sheep from goats", "Selecting one from a group", "Audition test was conducted by the recruiter to separate sheep from goats."));
         var1.add(Word.getNewWord("Up a creek without a paddle", "in a worse situation", "Yesterday my car heated up and then my phone ran out of battery, I was up a creek without a paddle."));
         var1.add(Word.getNewWord("vanish into the air", "disappear", "The jewelries just vanished into the air. I can't find it anywhere."));
         var1.add(Word.getNewWord("Waiting in the wings", "Waiting for the scope to take action, mostly to replace someone else in their job", "Two of her seniors who are waiting in the wings will have a fierce competition."));
         var1.add(Word.getNewWord("What’s up?", "How are you?", "Hey John what’s up?"));
      }

      if (var0 == 9) {
         var1.add(Word.getNewWord("Whole bag of tricks", "Trying many techniques to achieve something", "It was really difficult to do the task even after applying the whole bag of tricks."));
         var1.add(Word.getNewWord("With flying colours", "If you do something such as pass an exam ", "She passed the licensure exam with flying colours."));
         var1.add(Word.getNewWord("Work like a charm", "Works very well", "I had some new installed softwares and they worked like a charm."));
         var1.add(Word.getNewWord("you got me there", "Understanding by expression or other way", "I don't kow what to say about the situation. You got me there! "));
         var1.add(Word.getNewWord("You pulled a fast one", "to trick someone", "You pretended you knew her name when you did not, you pulled a fast one."));
         var1.add(Word.getNewWord("young at heart", "to have a fresh spirit for an older person", "Although he is over 90, he still feels young at heart."));
         var1.add(Word.getNewWord("I’ll toss it around", "casually suggest", "I am tossing around the idea of having a party on my birthday."));
         var1.add(Word.getNewWord("I’m feeling blue", "to feel bad", "I failed the interview, I'm really feeling blue."));
         var1.add(Word.getNewWord("I’m out", "I'm leaving", "I have to go to an event, I'm out!"));
         var1.add(Word.getNewWord("In the bag", "will definitely happen, good confident", "My basketball team will win the game. It is in the bag."));
      }

      return var1;
   }
}
