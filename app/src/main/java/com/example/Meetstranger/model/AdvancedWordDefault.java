package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.List;

public class AdvancedWordDefault {
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
         var1.add(Word.getNewWord("torpor", "lethargy; dormancy", "Non-existence of torpor will be meaningless."));
         var1.add(Word.getNewWord("truculence", "aggressiveness; ferocity ", "Raven was a truculent bully."));
         var1.add(Word.getNewWord("vacillate ", "to waver; oscillate ", "The congress continues to vacillate over foreign policy."));
         var1.add(Word.getNewWord("venerate", "honor; respect", "The writer has been venerated for almost a decade."));
         var1.add(Word.getNewWord("reticent", "not speaking freely; reserved; reluctant", "At first Whena was reticent, but later she relaxed and was more forthcoming."));
         var1.add(Word.getNewWord("sage ", "wise", "It was a sage comment."));
         var1.add(Word.getNewWord("complaisant", "trying to please; overly polite; obliging; willing to please ", "Benjamin has been very complaisant to the management."));
         var1.add(Word.getNewWord("conciliatory ", "overcoming distrust or hostility", "He struck a conciliatory tone, saying he didn’t think anybody was to be blamed."));
         var1.add(Word.getNewWord("contrite", "very sorrowful for a wrong ", "Chynna seemed genuinely contrite when she apologized."));
         var1.add(Word.getNewWord("contumacious ", "disobedient; rebellious", "The had the power to apply sanctions for contumacious conduct."));
      }

      if (var0 == 11) {
         var1.add(Word.getNewWord("impeccable", "no fault or error", "Tricia speaks impeccable language."));
         var1.add(Word.getNewWord("impertinent", "improper behavior or bold", "Mark was scolded by the teacher because of being impertinent."));
         var1.add(Word.getNewWord("inchoate", "imperfectly formed", "Rea had a child's inchoate awareness of language."));
         var1.add(Word.getNewWord("incongruity", "state of not fitting", "No matter what you do, it is still incongruity to be part of the group."));
         var1.add(Word.getNewWord("indolent", "disinclined to work or exertion", "We lolled over the papers in the afternoon, hung over and indolent."));
         var1.add(Word.getNewWord("inept", "generally incompetent", "Once you're inept, you just can't get it done."));
         var1.add(Word.getNewWord("infamy", "a case of extreme dishonor", "Everything will be nothing if  will live in infamy."));
         var1.add(Word.getNewWord("inhibit", "put down by force", "Police inhibit the uprising very early."));
         var1.add(Word.getNewWord("innate", "Being talented through inherited qualities", "Grecia is preaching the innate goodness of humans and handing long book lists to colleagues."));
         var1.add(Word.getNewWord("insatiable", "not possible to satisfy", "This is an insatiable demand for old stores to restore."));
      }

      if (var0 == 12) {
         var1.add(Word.getNewWord("precarious", "not sure", "She climbed onto a precarious platform to get a better view."));
         var1.add(Word.getNewWord("prevaricate ", "false or lie", "Morrie accused the minister of prevaricating."));
         var1.add(Word.getNewWord("pungent", "not tasty or good", "The group hate the pungent odors when I entered the comfort room."));
         var1.add(Word.getNewWord("quibble ", "to argue or irrelevant things", "The problem is too important to quibble over."));
         var1.add(Word.getNewWord("quiescent ", "not active", "The situation was now relatively quiescent."));
         var1.add(Word.getNewWord("optimum", "most conducive; best", "He is trying to find an optimum solution for this problem"));
         var1.add(Word.getNewWord("recalcitrant ", "resisting authority or control", "People petitioned the recalcitrant manager to finish repairs to their building."));
         var1.add(Word.getNewWord("recondite", "secret ", "The students had to work from material that was both complex and recondite."));
         var1.add(Word.getNewWord("repudiate", "to reject as having no authority", "The proofs presented at the trial has since been repudiated."));
         var1.add(Word.getNewWord("soporific", "sleep producing", "I am already tired,it might be because of the soporific heat today."));
         var1.add(Word.getNewWord("tangential ", "not very clear, or nearly clear, close to something", "I hate you for giving me a tangential issue."));
      }

      if (var0 == 13) {
         var1.add(Word.getNewWord("conundrum", "A difficult problem or puzzle", "The best movies pose moral conundrums that are hard to solve."));
         var1.add(Word.getNewWord("convoluted ", "twisted; complicated", "I made Brenda's convoluted speech."));
         var1.add(Word.getNewWord("craven ", "cowardly ", "It is a craven act of terrorism."));
         var1.add(Word.getNewWord("debase", "corrupt morally or by intemperance or sensuality", "Her actions will always be a reminder of the degree to which it was debased ."));
         var1.add(Word.getNewWord("decry", "express strong disapproval of", "We decry the racism in South Asia"));
         var1.add(Word.getNewWord("deride", "treat or speak with no respect", "Michael derided his student's attempt to solve the biggest problem in Algorithm."));
         var1.add(Word.getNewWord("despot", "a cruel and oppressive dictator", "It is not easy to live in a town whose leader is a despot."));
         var1.add(Word.getNewWord("desultory", "random", "Bea made a desultory attempt at conversation."));
         var1.add(Word.getNewWord("diatribe", "bitter verbal attack", "Michael launched into a long diatribe against the lack of action in Senate."));
      }

      if (var0 == 14) {
         var1.add(Word.getNewWord("abhor", "hate", "The family said in a statement Thursday that they abhor violence, racism and bigotry, and can’t begin to understand the senseless act."));
         var1.add(Word.getNewWord("abscond", "depart secretly and hide ", "This might be the last meeting because we need to abscond."));
         var1.add(Word.getNewWord("abstemious ", "moderate in appetite", "Sheena is very abstemious in his food to keep her healthy."));
         var1.add(Word.getNewWord("acquiesce", "express agreement(unwillingly)", "he acquiesced in our plan, even though its a bit costly"));
         var1.add(Word.getNewWord("grandiloquent ", "pompous; bombastic", "Lea's speech was full of grandiloquent language, but it contained no new ideas."));
         var1.add(Word.getNewWord("gratuitous", "unnecessary and unwarranted", "A gratuitous insult over his poverty , make him sad."));
         var1.add(Word.getNewWord("gregarious", "sociable", "Leo was an open, gregarious, kind individual, who loved children."));
         var1.add(Word.getNewWord("haughty", "having or showing arrogant superiority to and disdain of those one views as unworthy", "James is haughty, that is why he is  arrogant and full of pride."));
         var1.add(Word.getNewWord("hypocrisy", "pretending to have qualities or beliefs that you do not have", "There was a contrast and hypocrisy on both sides of the current debate."));
         var1.add(Word.getNewWord("erudite", "learned; scholarly ", "Bea is a scholarly and erudite person."));
      }

      return var1;
   }

   static List getWordListFromLevelOneToFive(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 0) {
         var1.add(Word.getNewWord("dichotomy", "division into two opposed parts", "The dichotomy between what people think they are and what they do is critical act."));
         var1.add(Word.getNewWord("dirge", "funeral song", "It is so sad to hear dirge from our neighborhood."));
         var1.add(Word.getNewWord("ebullient ", "showing great excitement", "Jed was openly ebullient after the election."));
         var1.add(Word.getNewWord("effrontery", "arrogant or shameless or boldness", "Gem was silent all through the meal and then had the effrontery to complain that I looked bored!"));
         var1.add(Word.getNewWord("elated", "in high spirits", "The elated winner of the beauty contest is my friend."));
         var1.add(Word.getNewWord("salubrious", "healthful", "Gideon doesn't live in a very salubrious part of town."));
         var1.add(Word.getNewWord("perfidious", "faithless; disloyal", "Irva described the new criminal bill as a perfidious attack on democracy."));
         var1.add(Word.getNewWord("perfunctory ", "not detail or only for asking", "Mely asked a few perfunctory questions about my family and then ended the conversation."));
         var1.add(Word.getNewWord("phlegmatic ", "no emotion ", "Ryan is a retired lawyer with a solid, phlegmatic manner."));
         var1.add(Word.getNewWord("placate", "to reduce another's anger", "Ericka easily placated the angry customer."));
      }

      if (var0 == 1) {
         var1.add(Word.getNewWord("plummet", "fall sharply", "Temperatures plummeted last weekend."));
         var1.add(Word.getNewWord("verbose", "using to many words", "Christian was a notoriously verbose after-dinner speaker."));
         var1.add(Word.getNewWord("viscous", "tending to stick", "Please give me the viscous oil for my task."));
         var1.add(Word.getNewWord("vituperative ", "harshly abusive", "Miss Irving yesterday launched a vituperative attack on her ex-boss and former lover."));
         var1.add(Word.getNewWord("welter", "confusion on many things", "The news was issued amid a welter of conflicting evidence."));
         var1.add(Word.getNewWord("whimsical ", "capricious; fanciful ", "The music she gave me have a whimsical charm."));
         var1.add(Word.getNewWord("zealot ", "one who is fanatically devoted to a cause ", "I heard the comment of the religious zealot."));
         var1.add(Word.getNewWord("mollify ", "to soothe, to get convinced", "Andrea was not mollified by his apology."));
         var1.add(Word.getNewWord("obdurate", "stubborn", "The senator remains obdurate on immigration."));
         var1.add(Word.getNewWord("obsequious", "attemp to win by flattery", "Rica is embarrassingly obsequious to anyone in authority."));
      }

      if (var0 == 2) {
         var1.add(Word.getNewWord("onerous ", "burdensome", "The bill was aimed at lifting the onerous tax burden."));
         var1.add(Word.getNewWord("opprobrium", "A state of dishonour or dislike", "National opprobrium has been heaped on the country following its attack on its neighbours."));
         var1.add(Word.getNewWord("paucity", "scarcity", "The authorities had to cope with the paucity of information about the effects of the earthquake."));
         var1.add(Word.getNewWord("pedantic ", "showing off learning", "Professor Harris had a narrow, pedantic approach to history that put us to sleep."));
         var1.add(Word.getNewWord("penury", "extreme poverty", "There was a list of cities given to me realetd to penury."));
         var1.add(Word.getNewWord("attenuate", "to reduce", "Radiation is attenuated by the earth's atmosphere."));
         var1.add(Word.getNewWord("austere ", "unadorned, plain", "Angel depicts the austere beauty of the desert."));
         var1.add(Word.getNewWord("avarice", "insatiable(never satisified) desire for something", "an insatiable demand for old homes to restore"));
         var1.add(Word.getNewWord("aver", "to affirm; declare to be true", "Lawyer averred her client's innocence."));
         var1.add(Word.getNewWord("banal", "repeated", "Mike just sat there making banal remarks all evening."));
      }

      if (var0 == 3) {
         var1.add(Word.getNewWord("belie ", "give a false impression", "Her statement belies my intentions. I never wanted to hurt her."));
         var1.add(Word.getNewWord("boorish ", "rude", "I’m sick of my husband's boorish behavior."));
         var1.add(Word.getNewWord("admonish ", "express disapproval", "Sheila needs to be admonish for hurting her classmate."));
         var1.add(Word.getNewWord("alacrity ", "cheerful willingness", "Marc invited us all to visit, and we agreed with alacrity."));
         var1.add(Word.getNewWord("alacrity", "liveliness and eagerness", "Their alacrity  instilled them with confidence."));
         var1.add(Word.getNewWord("amalgamate", "Joined together into one", "The two towns amalgamated for their protection."));
         var1.add(Word.getNewWord("fabricate", "make up something artificial or untrue", "The factory fabricates plastic utensils."));
         var1.add(Word.getNewWord("facetious", "humurous", "I make so much money that we never have to worry – She is being facetious."));
         var1.add(Word.getNewWord("fatuous", "foolishly self satisfied ", "It was very fatous remark I've ever heard."));
         var1.add(Word.getNewWord("flabbergasted", "speechless out of surprise", "The flabbergasted ladies were speechless."));
      }

      if (var0 == 4) {
         var1.add(Word.getNewWord("flout ", "to treat without respect", "They think he can flout the law and get away with it."));
         var1.add(Word.getNewWord("abate", "to decrease", "Bea needs to abate the price."));
         var1.add(Word.getNewWord("aberration", "different from the standard", "Parexit was a temporary aberration."));
         var1.add(Word.getNewWord("forsake", "leave someone who needs you", "I forsake her for doing this to me."));
         var1.add(Word.getNewWord("furtive", "secret and deceptive", "He has a furtive behavior towards what happened yesterday."));
         var1.add(Word.getNewWord("gainsay", "oppose", "Certainly there's no gainsaying."));
         var1.add(Word.getNewWord("garrulous", "Talk to much", "They had talked too much and felt like a garrulous old fool."));
         var1.add(Word.getNewWord("gluttony", "habitual eating to excess", "The size him into a wrestling match."));
         var1.add(Word.getNewWord("ameliorate ", "to improve ", "What do we need to ameliorate the effects of the drought?"));
         var1.add(Word.getNewWord("amiable", "friendliness", "We celebrated an amiable gathering."));
      }

      return var1;
   }

   static List getWordListFromLevelSixToTen(int var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == 5) {
         var1.add(Word.getNewWord("anachronism", "something out of proper time", "The movie was filled with anachronisms."));
         var1.add(Word.getNewWord("appease", "to make someone happy", "Joshua's goal is leading a company to appease shareholders."));
         var1.add(Word.getNewWord("arcane", "requiring mysterious knowledge", "The arcane about dowsing was the topic today."));
         var1.add(Word.getNewWord("ascetic ", "one who practices self denial", "Whena is ascetic."));
         var1.add(Word.getNewWord("assiduous ", "with extra care", "The government has been assiduous in the fight against inflation."));
         var1.add(Word.getNewWord("assuage", "make less severe", "The administration has tried to assuage the public's fears."));
         var1.add(Word.getNewWord("brazen", "unrestrained by convention or propriety", "Each of these stuffs now appears to be a brazen lie."));
         var1.add(Word.getNewWord("brusque", "marked by rude or peremptory shortness", "Bella should try to cultivate a less brusque manner."));
         var1.add(Word.getNewWord("buttress ", "support", "Paulo looked for things that would buttress the prosecution case and win a conviction."));
         var1.add(Word.getNewWord("cajole", "influence or urge", "Earlier, Mike cajoled her into playing a stronger role in the theatre show."));
      }

      if (var0 == 6) {
         var1.add(Word.getNewWord("callous", "emotionally hardened/indifference", "A callous attitude towards study, will make you fail in the exam."));
         var1.add(Word.getNewWord("candor", "the quality of being honest", "I'm not sure he appreciated my candor"));
         var1.add(Word.getNewWord("capricious", "fickle/Changable ", "We have had very capricious weather lately."));
         var1.add(Word.getNewWord("castigation", "severe punishment or scolding ", "The castigation were done by the fire inspectors."));
         var1.add(Word.getNewWord("chicanery", "trickery ; fraud", "The investigation has revealed chicanery at the highest levels."));
         var1.add(Word.getNewWord("chide", "criticize severely or angrily", "Lea chided Brix for attempting to calm the public by assuring that there was “no need to be alarmed."));
         var1.add(Word.getNewWord("circumspect", "Knowing about potential outcome", "Pediatricians are now more circumspect about recommending medicines."));
         var1.add(Word.getNewWord("coagulate", "thicken", "We need some enzymes in order to mak the milk coagulate."));
         var1.add(Word.getNewWord("compendium", "brief, comprehensive summary ", "Joanna put together a compendium of early Italian furniture."));
         var1.add(Word.getNewWord("complacency", "the feeling you have when you are satisfied with yourself", "Maria complacency was absolutely disgusting."));
      }

      if (var0 == 7) {
         var1.add(Word.getNewWord("elegy ", "poem or song expressing sadness ", "Jema made an elegy for her love."));
         var1.add(Word.getNewWord("eloquent", "expressing yourself clearly", "I listened to a speech as extraordinary and eloquent."));
         var1.add(Word.getNewWord("embezzle", "appropriate fraudulently to one's own use", "The accountant embezzled millions of dollars while working for the company"));
         var1.add(Word.getNewWord("empathy", "a state or condition markedly different from the norm", "I have taken my dinner with my lover."));
         var1.add(Word.getNewWord("enervate ", "to weaken ", "You need to enervate your team in order to win."));
         var1.add(Word.getNewWord("insipid", "lacking in flavor; dull ", "Lea was already tired watching insipid drama."));
         var1.add(Word.getNewWord("insular", "narrowly restricted in outlook or scope", "They have different insular attitudes toward foreigners."));
         var1.add(Word.getNewWord("intrepid", "invulnerable to fear or intimidation", " Bell is the real thing, intrepid, fierce and smart."));
         var1.add(Word.getNewWord("inundate", "too much; overwhelm ", "After appearing on a movie they were inundated with telephone calls for a week."));
         var1.add(Word.getNewWord("irascible", "irritable; easily angered ", "They saw the irascible painter in the event."));
      }

      if (var0 == 8) {
         var1.add(Word.getNewWord("irresolute ", "unsure how to act; weak ", "Stop giving me irresoloute answers of the investigation."));
         var1.add(Word.getNewWord("laconic ", "using few words", "“It will be done,” was the laconic reply."));
         var1.add(Word.getNewWord("lassitude ", "lethargy; sluggishness ", "Stockholders are blaming the school's problems on the lassitude of the admission."));
         var1.add(Word.getNewWord("laud ", "to praise", "The vice preseident lauded the rise of market economies around the country."));
         var1.add(Word.getNewWord("malingerer", "to feign(fake) illness to escape duty", "The article gives advice to employess on how to deal successfully with malingerers."));
         var1.add(Word.getNewWord("maverick", "Independent in behaviour", "Michael is considered a political maverick."));
         var1.add(Word.getNewWord("mendacious", "dishonest", "Some of their statements are misleading and some are downright mendacious."));
         var1.add(Word.getNewWord("misanthrope", "some one who hates humanity", "Nicko is a misanthrope-like person."));
         var1.add(Word.getNewWord("rescind ", "to cancel ", "The vote rescinds zoning decisions made earlier in the previous years."));
         var1.add(Word.getNewWord("enmity", "hostile", "The attack appeared to be inflaming the enmity between of the two countries."));
      }

      if (var0 == 9) {
         var1.add(Word.getNewWord("ephemeral", "short-time", "That was just an ephemeral fame."));
         var1.add(Word.getNewWord("equanimity", "calmness in critical condition", "In spite of Joan's financial troubles, she faced the future with equanimity."));
         var1.add(Word.getNewWord("erudite", "having or showing good knowledge", "I really looked-up to my erudite teacher."));
         var1.add(Word.getNewWord("esoteric ", "hard to understand; known only to a chosen few ", "Novels can sometimes seem esoteric, but we are trying to make them more attractive to more people."));
         var1.add(Word.getNewWord("abeyance", "temporary suspension", "John will be given an abeyance because of what he did."));
         var1.add(Word.getNewWord("exacerbate", "to aggravate; make worse", "Her sickness was exacerbated by the dust."));
         var1.add(Word.getNewWord("exigency", "urgent requirement ", "Economic exigency obliged the Congress to act."));
         var1.add(Word.getNewWord("extol", "praise, glorify, honor", "They should always extol the virtues of one's student."));
         var1.add(Word.getNewWord("extrapolation", "the act of estimation of future using known information ", "The company expects inflation to overshoot target in two years, but this is only an extrapolation of past trends."));
         var1.add(Word.getNewWord("gouge ", "to make a hole in something", "The equipment had gouged a huge hole in the roadway."));
      }

      return var1;
   }
}
