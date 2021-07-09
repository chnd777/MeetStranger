package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.List;

public class PhraseDefault {
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
         var1.add(Word.getNewWord("Cheer up", "To encourage", "Seato was having a bad day, so his wife cheered him up."));
         var1.add(Word.getNewWord("clam up", "To refuse to say", "When the police started asking questions, John clammed up."));
         var1.add(Word.getNewWord("brush up on", "To improve, refresh one’s knowledge of something", "I must brush up on someone special before going to New York next month."));
         var1.add(Word.getNewWord("bump into", "To meet by chance", "I bumped into Deahlia at the grocery store."));
         var1.add(Word.getNewWord("call back", "To return a phone call", "Could please call back in fifteen minutes?"));
         var1.add(Word.getNewWord("count on", "To rely on ", "You can count on me to keep the things happened today."));
         var1.add(Word.getNewWord("cut down on", "To reduce", "I’ve decided to cut down on the amount of meat I eat."));
         var1.add(Word.getNewWord("Cut in ", "To interrup", "I was about to ask that lady on a date, but her sister cut in and I lost the chance."));
         var1.add(Word.getNewWord("Cut off", "Make ito piecse", "That blue motorcycle just cut me off and I almost crashed into it."));
         var1.add(Word.getNewWord("deal with", "To handle", "Catherine is not good at dealing with people."));
      }

      if (var0 == 11) {
         var1.add(Word.getNewWord("die down", "To calm down", "After the snow died down, we went outside to see the damage it had caused."));
         var1.add(Word.getNewWord("do over", "To repeat", "Do this task over."));
         var1.add(Word.getNewWord("do without", "To manage without", "Nica didn’t get a salary this month, so she’ll have to do without extra treats."));
         var1.add(Word.getNewWord("drag on", "To last more than expected", "The suspect’s trial dragged on a very critical situation."));
         var1.add(Word.getNewWord("draw up", "To write", "They drew up an appoinment and had me sign it."));
         var1.add(Word.getNewWord("dress up", "To wear good clothes", "Their party gave us a chance to dress up and get out of the house."));
         var1.add(Word.getNewWord("drop in", "To pay a visit, usually on the way somewhere", "Why don’t you drop in to see us on your way to London?"));
         var1.add(Word.getNewWord("drop out", "To leave school without finishing course", "Ryan dropped out of college and joined the army."));
         var1.add(Word.getNewWord("Zoom in", "Focus more", "The phone's camera zoomed in to show people's faces."));
         var1.add(Word.getNewWord("Zoom off", "Go somewhere fast", "Ricky rushed out of the building and zoomed off in his motorbike."));
      }

      if (var0 == 12) {
         var1.add(Word.getNewWord("Zoom out", "Concentrate less closely", "The camera zoomed out to show all the the audience."));
         var1.add(Word.getNewWord("hurry up", "To act speedily", "Hurry up and finish your breakfast or we’ll miss the train."));
         var1.add(Word.getNewWord("iron out", "To resolve by talk", "The two leaders met at the conference to iron out their differences."));
         var1.add(Word.getNewWord("join in", "To participate", "Yes Luis, you can join in the discussion any time you like."));
         var1.add(Word.getNewWord("keep on", "To continue", "If you keep on making that scratch I will get annoyed."));
         var1.add(Word.getNewWord("keep up with", "Try to be at the same level", "I read the newspaper every day to keep up with the news."));
         var1.add(Word.getNewWord("Pay back", "To give back money", "I’ll pay you back later."));
         var1.add(Word.getNewWord("Pay for", "Pay for a particular purpose", "You’ll pay for all the problems you caused me!"));
         var1.add(Word.getNewWord("pick out", "choose", "She picked out the guy she thought had stolen her bag."));
         var1.add(Word.getNewWord("pick up", "lift something", "The crane picked up the car."));
      }

      if (var0 == 13) {
         var1.add(Word.getNewWord("point out", "call attention to", "Francis pointed out the major sceneries."));
         var1.add(Word.getNewWord("point out", "To indicate", "As I already pointed out, there was a mistake in your computation."));
         var1.add(Word.getNewWord("put away", "save or store", "We put away some funds for our retirement. "));
         var1.add(Word.getNewWord("put off", "postpone", "We asked the owner to put off the meeting until next week. "));
         var1.add(Word.getNewWord("Put on", "To get your clothes on", "Everyday Monica puts on her dress, lipstick, shoes and hat—in that order."));
         var1.add(Word.getNewWord("put out", "extinguish", "The firefighters put out the house fire before it could spread."));
         var1.add(Word.getNewWord("read over", "peruse", "I read over the task, but couldn't make any sense of it."));
         var1.add(Word.getNewWord("rely on", "To depend on, trust", "You can rely on me on any job."));
         var1.add(Word.getNewWord("figure out", "To understand", "He’s trying to figure out how to earn enough to go on the trip to Paris."));
         var1.add(Word.getNewWord("fill out", "complete a form", "Fill out this application form and deliver it as soon as possible."));
      }

      if (var0 == 14) {
         var1.add(Word.getNewWord("fill up", "fill upto the limit", "Jenna filled up the grocery cart with free food."));
         var1.add(Word.getNewWord("find out", "discover", "My sister found out that her fiance had been planning a surprise wedding proposal for her."));
         var1.add(Word.getNewWord("Get around", "Find a way(shortcut) to avoid something", "Some students know all the different ways to get around tax laws."));
         var1.add(Word.getNewWord("get at", "To imply", "What are you getting at on doing these bad things? "));
         var1.add(Word.getNewWord("Get away", "To escape", "Carmen managed to get away from her bully classmates."));
         var1.add(Word.getNewWord("Get back at", "To get revenge", "Her ex-husband took her bank account so she got back at him by taking his company."));
         var1.add(Word.getNewWord("wipe off", "To clean ", "I’ll wash up if you wipe off the bed."));
         var1.add(Word.getNewWord("Work out", "To exercise", "I try to work out everyday, by repeatedly lifting a heavy donut to my mouth."));
         var1.add(Word.getNewWord("Wriggle out of", "Avoid doing something", "Noel always manages to wriggle out of any extra work we get."));
         var1.add(Word.getNewWord("Yack on", "Talk continuously(annoying)", "Joshua yacked on for an hour."));
      }

      return var1;
   }

   static List getWordListFromLevelOneToFive(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 0) {
         var1.add(Word.getNewWord("Take out", "To open something", "The children sat at their seats and took out their drawing book."));
         var1.add(Word.getNewWord("talk over", "discussion", "Let's talk over like professionals."));
         var1.add(Word.getNewWord("kick off", "To begin", "The basketball match kicked off at 3 o’clock."));
         var1.add(Word.getNewWord("leave out", "omit", "You left out the part about the police chase down the bandits."));
         var1.add(Word.getNewWord("Grow apart ", "not is touch, keep in distance", "When my friend moved to a different city I tried to stay close with him, but we slowly grew apart."));
         var1.add(Word.getNewWord("let down", "To disappoint", "I feel so let down because they promised me a dress but all I got was a doll."));
         var1.add(Word.getNewWord("look after", "To take care of", "Lea can you look after your brother until I get back?"));
         var1.add(Word.getNewWord("look down on", "To consider as below standard", "Lecille always looks down on anyone who is poor."));
         var1.add(Word.getNewWord("look for", "To find", "Ingram went to the shop to look for a new computer."));
         var1.add(Word.getNewWord("look forward to", "To wait for something", "I’m looking forward to my debut."));
      }

      if (var0 == 1) {
         var1.add(Word.getNewWord("leave out", "Check if anything left", "Please check your payments again and make sure nothing is left out."));
         var1.add(Word.getNewWord("grow up", "become an adult", "He’s like character of the movie. He never really grew up at all."));
         var1.add(Word.getNewWord("hand in", "submit", "The students handed in their researchworks and left the room."));
         var1.add(Word.getNewWord("Hang on", "To keep something", "When everyone else was getting fired, Joshua managed to hang on to his work."));
         var1.add(Word.getNewWord("Hang out", "To spend time casually", "My friends and I used to hang out in the playground after school."));
         var1.add(Word.getNewWord("make fun of", "make jokes", "It’s not nice watch the Gag Show making fun of peoples."));
         var1.add(Word.getNewWord("make out", "understand", "JP was so far away, we really couldn't make out what he was saying."));
         var1.add(Word.getNewWord("make up", "invent something new or lie", "Glenda knew she was in trouble, so she made up a story about going to the movies with her friends."));
         var1.add(Word.getNewWord("mix up", "To get confused between", "Melissa had so many pets that she kept mixing up their names."));
         var1.add(Word.getNewWord("nod off", "To fall asleep", "You were so tired after the party that you nodded off on the bed."));
      }

      if (var0 == 2) {
         var1.add(Word.getNewWord("hang up", "put something on hook", "He hung up the telephone before she hung up his clothes."));
         var1.add(Word.getNewWord("Hold back", "To stop from doing something", "Drew has a great move but whenever she’s dancing in public she feels shy and holds back."));
         var1.add(Word.getNewWord("Hold on", "To hold tightly", "You’d better hold on to your hair, it’s windy out there!"));
         var1.add(Word.getNewWord("hold up", "delay", "I hate to hold up the date, but I have to go to the bathroom."));
         var1.add(Word.getNewWord("tell off", "To criticize badly", "The principal told her off for hurting her classmate."));
         var1.add(Word.getNewWord("look on", "To be a spectator", "If you don’t want to take part in the event you can look on for now."));
         var1.add(Word.getNewWord("Look out", "To watch out", "Look out, there’s a car coming your way!"));
         var1.add(Word.getNewWord("look over", "check something", "The investigators looked over the papers carefully before questioning the witness."));
         var1.add(Word.getNewWord("Look up ", "To check the meaning", "If you don’t know the meaning of your assignment, you should look it up in the website."));
         var1.add(Word.getNewWord("look up to", "To praise", "I always looked up to my boss."));
      }

      if (var0 == 3) {
         var1.add(Word.getNewWord("own up", "To admit", "Don't be shy. Own up. We know you have done something!"));
         var1.add(Word.getNewWord("pass away", "To die", "Your grandmother passed away peacefully in her sleep."));
         var1.add(Word.getNewWord("pass out", "To faint", "Louie didn’t drink enough water so he passed out at the end of the race."));
         var1.add(Word.getNewWord("Come across", "To meet by chance", "I was cleaning the garage and I came across my high school pictures."));
         var1.add(Word.getNewWord("come forward", "To present oneself", "Has the owner of the winning ticket come forward?"));
         var1.add(Word.getNewWord("Come in", "To enter", "Come in, the door is open!"));
         var1.add(Word.getNewWord("back down", "To withdraw", "National authorities backed down on their threats to build on that part of the village."));
         var1.add(Word.getNewWord("Bag out", "Criticize", "Don't bag out American English."));
         var1.add(Word.getNewWord("bank on", "To base your hopes on anything", "I’m banking on the organization to help with the charity event."));
         var1.add(Word.getNewWord("black out", "To lose consciousness", "Jenna fell in the stairs and blacked out."));
      }

      if (var0 == 4) {
         var1.add(Word.getNewWord("block off", "To separate", "The military blocked off the street after the explosion."));
         var1.add(Word.getNewWord("blow up", "explode", "The terrorists tried to blow up the airport."));
         var1.add(Word.getNewWord("boil down to", "To make summery", "It all boils down to the most powerful person."));
         var1.add(Word.getNewWord("boot up", "To start a computer", "You need to boot up your system before you begin to work."));
         var1.add(Word.getNewWord("Bring on", "To cause something negative to happen", "Nick's lung cancer was brought on by years of smoking."));
         var1.add(Word.getNewWord("Bring up", "To mention", "Mark had to miss the party, so please don’t bring it up."));
         var1.add(Word.getNewWord("ease off", "To make less severe", "Traffic usually eases off about 9pm."));
         var1.add(Word.getNewWord("end in", "To finish in a particular way", "Her marriage ended in separation."));
         var1.add(Word.getNewWord("end up", "To reach a position finally", "If you don’t improve your duties and responsibilities, you’ll end up being fired."));
         var1.add(Word.getNewWord("Fall apart", "to break into parts", "They tried to save their marriage by going to seminars but in the end if fell apart anyway."));
      }

      return var1;
   }

   static List getWordListFromLevelSixToTen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 5) {
         var1.add(Word.getNewWord("Fall down", "Usually drop or fall by accident", "My friend slipped on a rag and fell down."));
         var1.add(Word.getNewWord("fall through", "To fail", "His plans to trek through a nearby city fell through when he got sick."));
         var1.add(Word.getNewWord("Turn on/off", "To switch off", "Turn off the light, I’m trying to relax!"));
         var1.add(Word.getNewWord("turn up", "increase the volume", "Grandma couldn't hear, so he turned up her hearing aid."));
         var1.add(Word.getNewWord("use up", "use completely", "The gang members used up all the money gor gambling."));
         var1.add(Word.getNewWord("Zone in", "give attention after not doing so", "I zoned in on what she was saying when she started gossiping."));
         var1.add(Word.getNewWord("Zone out", "Not giving attention", "Rica zoned out during the lecture because it was so boring."));
         var1.add(Word.getNewWord("Zonk out", "Fall asleep", "I zonked out during the show and missed most of it."));
         var1.add(Word.getNewWord("Zip up", "Keep silent", "Michael was being stupid in the meeting, so we told him to zip up."));
         var1.add(Word.getNewWord("abide by", "To follow a decision or order", "If you want to keep your work here, you must abide the rules."));
      }

      if (var0 == 6) {
         var1.add(Word.getNewWord("account for", "To explain a reason", "Sheila hopes he can account for the time he was out!"));
         var1.add(Word.getNewWord("advise against", "Not to recommend", "I advise against walking alone in this street."));
         var1.add(Word.getNewWord("allow for", "To consider", "We need to allow for some changes about the policies along the way."));
         var1.add(Word.getNewWord("apply for", "To create a formal request", "John applied for a scholarship for next school year."));
         var1.add(Word.getNewWord("back away", "To move back in fear or other reason", "When Mathew saw the bear, he backed away in fright."));
         var1.add(Word.getNewWord("Yammer on", "Talk continuously(annoying)", "Mitzi yammered on for ages."));
         var1.add(Word.getNewWord("Yield to", "Surrender", "I yielded to temptation but still made a mistake."));
         var1.add(Word.getNewWord("Zero in on", "pay attention", "The police have zeroed in on the woman they believe to be responsible for the murder."));
         var1.add(Word.getNewWord("Zero out", "Cut off funding", "The debt was zeroed out by the group."));
         var1.add(Word.getNewWord("Zip around", "Walk or run quickly", "We zipped around the mall to get the shopping done."));
      }

      if (var0 == 7) {
         var1.add(Word.getNewWord("Zip by", "Pass quickly", "The carzipped by the cars stuck in the traffic jam."));
         var1.add(Word.getNewWord("Zip it", "Keep silent", "Mike told me to zip it, so I said nothing."));
         var1.add(Word.getNewWord("give away", "give something for free", "The gasoline station was giving away free gas and some freebies."));
         var1.add(Word.getNewWord("give back", "return", "My brother borrowed my car. I have a feeling that the money he borrowed will not about to given back."));
         var1.add(Word.getNewWord("Give in", "To surrender", "Ben’s mother gave in and let him stay out late with his cousins."));
         var1.add(Word.getNewWord("Give out", "to break down or stop working", "The city had to rebuild the building completely, because it was about to give out and fall down."));
         var1.add(Word.getNewWord("Give up", "To stop trying", "After three weeks of trying to build my own cabinet, I gave up and just bought one."));
         var1.add(Word.getNewWord("Go ahead", "To inspire to do something", "Go ahead, explain to me why there is a bunch of poo on my roof."));
         var1.add(Word.getNewWord("Get back to", "To return;start doing on a pending work", "Mark’s coworker wasn’t sure what time the event was, so he said he’d get back to him with the time."));
         var1.add(Word.getNewWord("get by", "To manage to adopt", "Students without part-jobs have a hard time getting by."));
      }

      if (var0 == 8) {
         var1.add(Word.getNewWord("Get up", "To stand up,To wake up from sleep", "I have so much trouble getting up that I have to set two alarms in order not to be late."));
         var1.add(Word.getNewWord("go through", "To experience", "Andy went through a lot of struggles after his father died."));
         var1.add(Word.getNewWord("throw away", "discard", "Don't just throw away the gifts."));
         var1.add(Word.getNewWord("set up", "to arrange, starting", "My girlfriend set up the bedroom exactly the way she wanted it."));
         var1.add(Word.getNewWord("Warm up", "To start liking someone, Prepare to do something", "The new kitten was scared of my husband when we first got him, but he warmed up to him pretty quickly."));
         var1.add(Word.getNewWord("shop around", "To check prices", "Let’s shop around and see if we can find something valuable."));
         var1.add(Word.getNewWord("sit down", "To take a seat", "I think you should sit down before the presentation."));
         var1.add(Word.getNewWord("stick up for", "To defend", "My big sister always stuck up for me when I got into a fight."));
         var1.add(Word.getNewWord("take down", "create a written note", "Take down notes before you forget."));
         var1.add(Word.getNewWord("try on", "Check again and again for proper adjustment", "Monique tried on fifteen dresses before she found one she liked."));
      }

      if (var0 == 9) {
         var1.add(Word.getNewWord("try out", "test or check", "I tried out five pair of shoes before I could find one that pleased me."));
         var1.add(Word.getNewWord("Turn around ", "To move opposite direction", "Sally turned around when someone called her name."));
         var1.add(Word.getNewWord("turn down", "lower volume", "Your radio is driving me crazy! Please turn it down."));
         var1.add(Word.getNewWord("rule out", "To eliminate", "Since Marco had a sound alibi, the police ruled him out as a main suspect."));
         var1.add(Word.getNewWord("run away", "To escape", "John ran away from home and joined the party."));
         var1.add(Word.getNewWord("run into", "To meet unexpectedly", "I’m so glad I ran into a friend."));
         var1.add(Word.getNewWord("set off", "To start", " Let’s set off early to miss the rush hour of annoying activities on the street."));
         var1.add(Word.getNewWord("take off", "remove clothing", "It was so hot that I had to take off my sweater."));
         var1.add(Word.getNewWord("Call off ", "To cancel", "The picnic was called off because of the sand storm."));
         var1.add(Word.getNewWord("die for", "To die for country or some good reason", "Many freedom fighters died for their country"));
      }

      return var1;
   }
}
