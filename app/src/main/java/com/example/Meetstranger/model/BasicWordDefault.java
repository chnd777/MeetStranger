package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.List;

public class BasicWordDefault {
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
         var1.add(Word.getNewWord("ground", "area of knowledge", "The teacher just keeps going over the same ground."));
         var1.add(Word.getNewWord("group", "a number of people", "These objects fall into ten distinct groups."));
         var1.add(Word.getNewWord("guerrilla ", "soldier specializing in surprise attacks ", "This small town fell to the guerrillas."));
         var1.add(Word.getNewWord("guess", "not certain with the answer", "I had to guess just to give an answer."));
         var1.add(Word.getNewWord("halt", "to stop something", "The administration need to do something to halt the rally."));
         var1.add(Word.getNewWord("herd ", "group of animals ", "Researchers hope to discover new ways that may help a herd of extinct animals."));
         var1.add(Word.getNewWord("how", "in what way", "How are you going to solve the word problem given by the teacher?"));
         var1.add(Word.getNewWord("however", "regardless of how", "However you look at the problem, just don't give up."));
         var1.add(Word.getNewWord("huge", "extremely large", "They made big profits in food industry."));
         var1.add(Word.getNewWord("humane ", "compassionate ", "The regulations ensuring the humane treatment of our pets."));
      }

      if (var0 == 11) {
         var1.add(Word.getNewWord("hunting", "chase", "I enjoyed hunting every summer."));
         var1.add(Word.getNewWord("icicle", "a pointed stick of ice that hangs down", "The icicle was too sharp."));
         var1.add(Word.getNewWord("idea", "knowledge", "Can you give an idea about Statistics?"));
         var1.add(Word.getNewWord("illicit ", "forbidden", "I need to investigate their involvement on illicit drugs."));
         var1.add(Word.getNewWord("include", "adding something or somebody", "Please include me in the list of volunteers this coming Saturday."));
         var1.add(Word.getNewWord("increase", "make something larger", "The increase of the number of students has been a problem because we do lack classrooms."));
         var1.add(Word.getNewWord("indicate", "point out", "A period will indicate that the sentence ended."));
         var1.add(Word.getNewWord("industry", "type of work", "Lucia is in computer industry."));
         var1.add(Word.getNewWord("moment", "instant", "Rocky was silent for a moment."));
         var1.add(Word.getNewWord("moral", "righteous", "We should make it sure we are doing what is moral."));
      }

      if (var0 == 12) {
         var1.add(Word.getNewWord("morale ", "attitude or outlook usually of a group ", "The university in the city was high when it comes to morale."));
         var1.add(Word.getNewWord("movement", "motion", "The movement of the tectonics caused the earthquake."));
         var1.add(Word.getNewWord("mystery", "puzzle", "There is always a mystery behind everything happening in this world."));
         var1.add(Word.getNewWord("nation", "country", "The elected president will lead the nation with fairness and loyalty."));
         var1.add(Word.getNewWord("natural", "existing in or caused by nature", "Natural calamities  are unpredictable nowadays."));
         var1.add(Word.getNewWord("necessary", "obligatory", "It is necessary to register first before you can join the marathon."));
         var1.add(Word.getNewWord("nesting", "fit an object or object inside a larger one", "The town is nesting inside a large crater on the flanks of a volcano."));
         var1.add(Word.getNewWord("notice", " to come to sb's attention", "I have noticed that you are trying to change something in your physical looks."));
         var1.add(Word.getNewWord("notice", "attention", "My preschooler's silence did not escape my notice."));
         var1.add(Word.getNewWord("occur", "happen", "The incident occurred last week."));
      }

      if (var0 == 13) {
         var1.add(Word.getNewWord("once", "formerly", "My dad was once a soldier and a hero."));
         var1.add(Word.getNewWord("operate", "run", "You need to operate the machine now."));
         var1.add(Word.getNewWord("order", "arrangement", "The secretary filed the cards in alphabetical order."));
         var1.add(Word.getNewWord("pattern", "design", "It was a beautiful pattern for the activity."));
         var1.add(Word.getNewWord("peddle ", "to sell", "Theo peddled art and printing materials around the country."));
         var1.add(Word.getNewWord("strait ", "narrow or confining; a waterway", "The road was so strait that a handful of men might have defended it."));
         var1.add(Word.getNewWord("strange", "unusual", "There was a strange noise coming from the attic."));
         var1.add(Word.getNewWord("texture", "feel,touch", "The paper he bought has a soft texture."));
         var1.add(Word.getNewWord("thorough ", "complete", "Planners need a thorough understanding of the event."));
         var1.add(Word.getNewWord("quickly", "rapidly", "As quickly as possible, give me the information I needed to solve the case."));
      }

      if (var0 == 14) {
         var1.add(Word.getNewWord("quite", "entirely", "It is quite an argument to the organization."));
         var1.add(Word.getNewWord("information", "facts provided or learned about something or someone", "A vital piece of information form the witness is what we needed to solve the case."));
         var1.add(Word.getNewWord("injure", "hurt", "Romeo was injured because of the game."));
         var1.add(Word.getNewWord("instead", "as an alternative", "Put on a clean dressing instead of  a lotion."));
         var1.add(Word.getNewWord("interest", "the state of wanting to know or learn more", "His interest towards Joanne is full of sincerity."));
         var1.add(Word.getNewWord("island", "a piece of land in a sea or river", "We had a vacation in a very beautiful island."));
         var1.add(Word.getNewWord("isle ", "a small island ", "Crusoe's fabled isle is a nice place to visit."));
         var1.add(Word.getNewWord("job", "employment", "I badly need a job to pay my debts."));
         var1.add(Word.getNewWord("join", "participate", "Do you want to join the party tonight?"));
         var1.add(Word.getNewWord("joke", "amusing", "The guests of the party bursted  into laughter because of the joke."));
      }

      return var1;
   }

   static List getWordListFromLevelOneToFive(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 0) {
         var1.add(Word.getNewWord("complicated", "not easy", "The school rules are rather complicated to follow."));
         var1.add(Word.getNewWord("conclude", "finish", "The speaker concluded the speech by reminding us of our responsibility."));
         var1.add(Word.getNewWord("conscience", "sense of morality ", "Emma had a guilty conscience about her desires."));
         var1.add(Word.getNewWord("conscious ", "awake or aware ", "Joshua  was already conscious."));
         var1.add(Word.getNewWord("corps", "regulated group ", "The teacher told us about the U.S. Army Medical Corps."));
         var1.add(Word.getNewWord("counsel ", "advice", "Rody was counseled by his supporters to return to Malaysia."));
         var1.add(Word.getNewWord("course ", "series of lectures", "The city along our way adopts a tortuous course along the coast."));
         var1.add(Word.getNewWord("decide", "Take a decision", "They decided to appoint Angie."));
         var1.add(Word.getNewWord("reverend ", "title given to clergy(Christianity); deserving respect ", "I spent an entire year serving the Reverend."));
         var1.add(Word.getNewWord("reverent ", "worshipful ", "Consider your father as reverent as GOD"));
      }

      if (var0 == 1) {
         var1.add(Word.getNewWord("jungle", "an area of land overgrown with dense forest", "They went into the jungle to conduct some studies."));
         var1.add(Word.getNewWord("just", "exactly", "I need exactly that medicine for my headache."));
         var1.add(Word.getNewWord("justice", "fairness", "Ernie demanded justice for the false arrest."));
         var1.add(Word.getNewWord("keep", "have possession of", "My sister would keep the best for herself."));
         var1.add(Word.getNewWord("kind", "sort", "I love all kinds of music."));
         var1.add(Word.getNewWord("know", "realize", "Most people know that there will be a storm."));
         var1.add(Word.getNewWord("latter", "second one of two things ", "The latter half of 1985 enjoyed the party."));
         var1.add(Word.getNewWord("learn", "grasp", "It will be easy for me to learn the steps in using the Microsoft Office."));
         var1.add(Word.getNewWord("length", "span", "It can reach over four meters in span."));
         var1.add(Word.getNewWord("mention", "refer to something", "Rea did not mention anything about the incident."));
      }

      if (var0 == 2) {
         var1.add(Word.getNewWord("scale", "measuring system", "Hotel ratings are on a scale of zero to five stars."));
         var1.add(Word.getNewWord("separate", "independent or different", "The elementary school and the high school are in two separate buildings."));
         var1.add(Word.getNewWord("settle", "make comfortable", "Carolina settled herself in front of a blazing fire.."));
         var1.add(Word.getNewWord("stationary", "no movement", "A car collided with a stationary vehicle."));
         var1.add(Word.getNewWord("argument", "disagreement", "Wally got into an argument with Brian in the pub last night."));
         var1.add(Word.getNewWord("assent", "agreement ", "The stdeunts had a loud murmur of assent."));
         var1.add(Word.getNewWord("ban", "to make something illegal", "Smoking is banned in all areas of the town."));
         var1.add(Word.getNewWord("bilingual", "able to speak two languages", "Marian works as a bilingual secretary for a law firm."));
         var1.add(Word.getNewWord("burst", "explode", "The cute boy hate it when balloons burst."));
         var1.add(Word.getNewWord("calculate", "to judge the number", "At some instance we need to calculate to solve the word problems."));
      }

      if (var0 == 3) {
         var1.add(Word.getNewWord("canvass ", "survey ", "In each ward, three workers canvassed some 5,000 voters."));
         var1.add(Word.getNewWord("century", "100 years", "Marcky's teaching career spanned half a century."));
         var1.add(Word.getNewWord("cite", "document or quote", "I will cite everything in my paper work."));
         var1.add(Word.getNewWord("coarse", "rough", "Kristine don't like the coarse woolen cloth."));
         var1.add(Word.getNewWord("abandon", "to leave alone or completely stop ", "The group have to abandon the offer because of rising costs."));
         var1.add(Word.getNewWord("access", "to enter a place", "Sheila can access the area through the back door."));
         var1.add(Word.getNewWord("accommodation", "a place to live", "In our country we had nice accommodation not far from the coast."));
         var1.add(Word.getNewWord("ache", "a continuous pain", "They say that you have all sorts of aches as you get older."));
         var1.add(Word.getNewWord("acknowledge", "to accept or recognise", "Leandro acknowledged that her schoolmate was a better chess player."));
         var1.add(Word.getNewWord("acquit", " to find not guilty", "Lucio was acquited of the crime."));
      }

      if (var0 == 4) {
         var1.add(Word.getNewWord("adapt", "being fit for new situation", "The family adapted the product's packaging to suit the Asian market."));
         var1.add(Word.getNewWord("corridor ", "space between rows", "There is no sitting allowed in the corridor."));
         var1.add(Word.getNewWord("allot ", "to divide", "Whena equal time was allotted to each student."));
         var1.add(Word.getNewWord("allude ", "make indirect reference to", "May had a way of alluding to Billy but never saying his name."));
         var1.add(Word.getNewWord("allusion", "indirect reference ", "It is an allusion to Shakespeare."));
         var1.add(Word.getNewWord("alter ", "change a lot", "Jeff was persuaded to alter the passage."));
         var1.add(Word.getNewWord("coherent", "able to speak clearly", "When Erick calmed down, he was more coherent ."));
         var1.add(Word.getNewWord("thread", "twisting cut", "The threads are worn already."));
         var1.add(Word.getNewWord("tiny", "very small", "I will get some tiny bit of your hair, please."));
         var1.add(Word.getNewWord("track ", "road ", "I will follow the track to the resort."));
      }

      return var1;
   }

   static List getWordListFromLevelSixToTen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 5) {
         var1.add(Word.getNewWord("tract", "pamphlet; plot of ground ", "The large tracts of natural place."));
         var1.add(Word.getNewWord("unbeatable", "invincible", "The giftshop sell products at unbeatable prices."));
         var1.add(Word.getNewWord("usage", "utilization", "A survey of water usage was done today."));
         var1.add(Word.getNewWord("usually", "normally", "Roy usually arrives home about three o'clock."));
         var1.add(Word.getNewWord("mettle ", "courage, spirit, energy", "The team showed their true mettle in the third quarter."));
         var1.add(Word.getNewWord("devise ", "to make or create", "A team-building activity should be devised to solve the problem of the company."));
         var1.add(Word.getNewWord("discreet ", "modest, prudent behavior", "The company of businessemen made some discreet inquiries."));
         var1.add(Word.getNewWord("discrete", "a separate thing, distinct ", "Sounds are produced as a continuous signal rather than discrete units."));
         var1.add(Word.getNewWord("dissent ", "disagreement ", "Three members dissented from the majority."));
         var1.add(Word.getNewWord("dominate", "to control", "The company dominates the IT section for operating system software."));
      }

      if (var0 == 6) {
         var1.add(Word.getNewWord("elicit", "to draw out", "The Johnson's family invariably elicit exclamations of approval from guests."));
         var1.add(Word.getNewWord("elude", "to avoid", "Rico managed to elude his pursuers by escaping into an alley."));
         var1.add(Word.getNewWord("equip", "provide", "We should equip some chairs for our classrooms."));
         var1.add(Word.getNewWord("extreme", "great", "Use extreme caution, as the floor is very slippery."));
         var1.add(Word.getNewWord("famous", "known by very many or most people", "Rain is the famous singer in their country."));
         var1.add(Word.getNewWord("favorite", "best liked or most enjoyed", "My favorite foods are exotic."));
         var1.add(Word.getNewWord("quote", "repeat", "Ricky quoted the news to us."));
         var1.add(Word.getNewWord("race", "contest", "Luie won the first 50-lap race."));
         var1.add(Word.getNewWord("rationale ", "principles, beliefs ", "Elmer explained the rationale behind the change."));
         var1.add(Word.getNewWord("raze", "to tear down ", "Villages were razed to the ground."));
      }

      if (var0 == 7) {
         var1.add(Word.getNewWord("reign ", "to rule ", "A king reigns over a land."));
         var1.add(Word.getNewWord("report", "announce", "Please report directly the incident to the family of the victim."));
         var1.add(Word.getNewWord("represent", "constitute", "This figure represents the income of the house loan Rebecca made."));
         var1.add(Word.getNewWord("represent", "to speak or act for another", "The son represented the Queen at the ceremony."));
         var1.add(Word.getNewWord("reschedule", "to change the timing", "We'll have to reschedule the presentation because Noah is ill."));
         var1.add(Word.getNewWord("value", "worth", "I value all the things you gave me."));
         var1.add(Word.getNewWord("victim", "sufferer", "I really pitied my friend for being a victim of hoax."));
         var1.add(Word.getNewWord("violent", "brutal", "A violent incident happened in the school yesterday."));
         var1.add(Word.getNewWord("waive ", "forgo, renounce ", "The prince will waive all rights to the money."));
         var1.add(Word.getNewWord("weigh", "show weight", "This locker donated by the Batch 1989 weighs a lot."));
      }

      if (var0 == 8) {
         var1.add(Word.getNewWord("whether ", "if", "Joshua seemed undecided whether to go or stay."));
         var1.add(Word.getNewWord("worse", "lower standard", "The accommodations of the resort were not in good quality and the food was worse."));
         var1.add(Word.getNewWord("yank", "to pull something forcefully with a quick movement", "We yanked open the front door to run into the libving room for cookies."));
         var1.add(Word.getNewWord("yore", "time long past", "Norkis will help you in your assignment about the great empire in days of yore."));
         var1.add(Word.getNewWord("pique", "A sudden outburst of anger", "his pique sparked like a sleeping volcano"));
         var1.add(Word.getNewWord("precious", "valuable", "My precious necklace was a gift to me by my husband."));
         var1.add(Word.getNewWord("prevent", "stop", "We need to have an action to prevent further accidents."));
         var1.add(Word.getNewWord("puzzle", "confuse", "It will sure be a puzzle for us."));
         var1.add(Word.getNewWord("fear", "to be frightened about someone or something unpleasant", "I fear that his driving might cause an accident."));
         var1.add(Word.getNewWord("feeling", "have opinion", "I have a feeling that Roxanne was part of the crime ."));
      }

      if (var0 == 9) {
         var1.add(Word.getNewWord("fig", "Mediterranean tree having sweet edible fruit", "I saw the Old World tree that bears the fig during our field trip."));
         var1.add(Word.getNewWord("fight", "to argue with", "Bea will fight for her right as a daughter no matter what it takes."));
         var1.add(Word.getNewWord("figure", "number", "I won the scratch lottery and it was totally in large figure."));
         var1.add(Word.getNewWord("flash", "visible for a very short period", "The image flashed on the screen for just a minute."));
         var1.add(Word.getNewWord("follow", "go or to come after", "I will follow my love wherever she will go because I love her."));
         var1.add(Word.getNewWord("formerly", "previously ", "Adam is a Mumbai, formerly Bombay."));
         var1.add(Word.getNewWord("gallery", "building", "Let us go tonight at the art gallery beside the mall."));
         var1.add(Word.getNewWord("glance", "casually look for a short time", "Rebecca glanced out of the window and saw that her car was gone."));
         var1.add(Word.getNewWord("great", "above the normal or average", "The scenery of the place we visited was one of the great interest."));
         var1.add(Word.getNewWord("Greek", "belonging to or relating to Greece, its people, or its language", "My classmate is a Greek."));
      }

      return var1;
   }
}
