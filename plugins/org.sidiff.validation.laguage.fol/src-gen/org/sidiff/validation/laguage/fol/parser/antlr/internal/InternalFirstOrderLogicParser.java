package org.sidiff.validation.laguage.fol.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFirstOrderLogicParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'import'", "'name'", "'message'", "'context'", "':'", "'.'", "'::'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'equals('", "'['", "']'", "','", "'isEmpty('", "'>'", "'>='", "'<'", "'<='", "'forAll('", "'in'", "'exists('", "'('", "'true'", "'false'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalFirstOrderLogicParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFirstOrderLogicParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFirstOrderLogicParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFirstOrderLogic.g"; }



     	private FirstOrderLogicGrammarAccess grammarAccess;

        public InternalFirstOrderLogicParser(TokenStream input, FirstOrderLogicGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ConstraintRuleBase";
       	}

       	@Override
       	protected FirstOrderLogicGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConstraintRuleBase"
    // InternalFirstOrderLogic.g:64:1: entryRuleConstraintRuleBase returns [EObject current=null] : iv_ruleConstraintRuleBase= ruleConstraintRuleBase EOF ;
    public final EObject entryRuleConstraintRuleBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRuleBase = null;


        try {
            // InternalFirstOrderLogic.g:64:59: (iv_ruleConstraintRuleBase= ruleConstraintRuleBase EOF )
            // InternalFirstOrderLogic.g:65:2: iv_ruleConstraintRuleBase= ruleConstraintRuleBase EOF
            {
             newCompositeNode(grammarAccess.getConstraintRuleBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintRuleBase=ruleConstraintRuleBase();

            state._fsp--;

             current =iv_ruleConstraintRuleBase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintRuleBase"


    // $ANTLR start "ruleConstraintRuleBase"
    // InternalFirstOrderLogic.g:71:1: ruleConstraintRuleBase returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* ) ;
    public final EObject ruleConstraintRuleBase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domain_1_0=null;
        Token otherlv_2=null;
        Token lv_packageImport_3_0=null;
        EObject lv_constraints_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* ) )
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* )
            {
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* )
            // InternalFirstOrderLogic.g:79:3: otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintRuleBaseAccess().getDomainKeyword_0());
            		
            // InternalFirstOrderLogic.g:83:3: ( (lv_domain_1_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:84:4: (lv_domain_1_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:84:4: (lv_domain_1_0= RULE_STRING )
            // InternalFirstOrderLogic.g:85:5: lv_domain_1_0= RULE_STRING
            {
            lv_domain_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_domain_1_0, grammarAccess.getConstraintRuleBaseAccess().getDomainSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRuleBaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domain",
            						lv_domain_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintRuleBaseAccess().getImportKeyword_2());
            		
            // InternalFirstOrderLogic.g:105:3: ( (lv_packageImport_3_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:106:4: (lv_packageImport_3_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:106:4: (lv_packageImport_3_0= RULE_STRING )
            // InternalFirstOrderLogic.g:107:5: lv_packageImport_3_0= RULE_STRING
            {
            lv_packageImport_3_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            					newLeafNode(lv_packageImport_3_0, grammarAccess.getConstraintRuleBaseAccess().getPackageImportSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRuleBaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"packageImport",
            						lv_packageImport_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalFirstOrderLogic.g:123:3: ( (lv_constraints_4_0= ruleConstraint ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:124:4: (lv_constraints_4_0= ruleConstraint )
            	    {
            	    // InternalFirstOrderLogic.g:124:4: (lv_constraints_4_0= ruleConstraint )
            	    // InternalFirstOrderLogic.g:125:5: lv_constraints_4_0= ruleConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_constraints_4_0=ruleConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintRuleBaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_4_0,
            	    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintRuleBase"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:146:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalFirstOrderLogic.g:146:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalFirstOrderLogic.g:147:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalFirstOrderLogic.g:153:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'name' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_message_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_variable_5_0 = null;

        EObject lv_formula_7_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:159:2: ( (otherlv_0= 'name' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:160:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:160:2: (otherlv_0= 'name' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:161:3: otherlv_0= 'name' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getNameKeyword_0());
            		
            // InternalFirstOrderLogic.g:165:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:166:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:166:4: (lv_name_1_0= RULE_STRING )
            // InternalFirstOrderLogic.g:167:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstraintAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getMessageKeyword_2());
            		
            // InternalFirstOrderLogic.g:187:3: ( (lv_message_3_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:188:4: (lv_message_3_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:188:4: (lv_message_3_0= RULE_STRING )
            // InternalFirstOrderLogic.g:189:5: lv_message_3_0= RULE_STRING
            {
            lv_message_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_message_3_0, grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"message",
            						lv_message_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getContextKeyword_4());
            		
            // InternalFirstOrderLogic.g:209:3: ( (lv_variable_5_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:210:4: (lv_variable_5_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:210:4: (lv_variable_5_0= ruleVariable )
            // InternalFirstOrderLogic.g:211:5: lv_variable_5_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_variable_5_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_5_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:232:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:233:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:233:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:234:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_formula_7_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_7_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:255:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:255:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:256:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalFirstOrderLogic.g:262:1: ruleVariable returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:268:2: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFirstOrderLogic.g:269:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFirstOrderLogic.g:269:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:270:3: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:270:3: ( (lv_type_0_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:271:4: (lv_type_0_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:271:4: (lv_type_0_0= RULE_ID )
            // InternalFirstOrderLogic.g:272:5: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_type_0_0, grammarAccess.getVariableAccess().getTypeIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFirstOrderLogic.g:288:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:289:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:289:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:290:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:310:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:310:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:311:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalFirstOrderLogic.g:317:1: ruleTerm returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:323:2: (this_Function_0= ruleFunction )
            // InternalFirstOrderLogic.g:324:2: this_Function_0= ruleFunction
            {

            		newCompositeNode(grammarAccess.getTermAccess().getFunctionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Function_0=ruleFunction();

            state._fsp--;


            		current = this_Function_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleFunction"
    // InternalFirstOrderLogic.g:335:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalFirstOrderLogic.g:335:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalFirstOrderLogic.g:336:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalFirstOrderLogic.g:342:1: ruleFunction returns [EObject current=null] : this_GetTerm_0= ruleGetTerm ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_GetTerm_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:348:2: (this_GetTerm_0= ruleGetTerm )
            // InternalFirstOrderLogic.g:349:2: this_GetTerm_0= ruleGetTerm
            {

            		newCompositeNode(grammarAccess.getFunctionAccess().getGetTermParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_GetTerm_0=ruleGetTerm();

            state._fsp--;


            		current = this_GetTerm_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGetTerm"
    // InternalFirstOrderLogic.g:360:1: entryRuleGetTerm returns [EObject current=null] : iv_ruleGetTerm= ruleGetTerm EOF ;
    public final EObject entryRuleGetTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetTerm = null;


        try {
            // InternalFirstOrderLogic.g:360:48: (iv_ruleGetTerm= ruleGetTerm EOF )
            // InternalFirstOrderLogic.g:361:2: iv_ruleGetTerm= ruleGetTerm EOF
            {
             newCompositeNode(grammarAccess.getGetTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetTerm=ruleGetTerm();

            state._fsp--;

             current =iv_ruleGetTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetTerm"


    // $ANTLR start "ruleGetTerm"
    // InternalFirstOrderLogic.g:367:1: ruleGetTerm returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? ) ;
    public final EObject ruleGetTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_feature_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:373:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:374:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:374:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:375:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )?
            {
            // InternalFirstOrderLogic.g:375:3: ()
            // InternalFirstOrderLogic.g:376:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGetTermAccess().getGetTermAction_0(),
            					current);
            			

            }

            // InternalFirstOrderLogic.g:382:3: ( (otherlv_1= RULE_ID ) )
            // InternalFirstOrderLogic.g:383:4: (otherlv_1= RULE_ID )
            {
            // InternalFirstOrderLogic.g:383:4: (otherlv_1= RULE_ID )
            // InternalFirstOrderLogic.g:384:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetTermRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:395:3: ( (lv_feature_2_0= ruleGet ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:396:4: (lv_feature_2_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:396:4: (lv_feature_2_0= ruleGet )
                    // InternalFirstOrderLogic.g:397:5: lv_feature_2_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getGetTermAccess().getFeatureGetParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_feature_2_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGetTermRule());
                    					}
                    					set(
                    						current,
                    						"feature",
                    						lv_feature_2_0,
                    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetTerm"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:418:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:418:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:419:2: iv_ruleGet= ruleGet EOF
            {
             newCompositeNode(grammarAccess.getGetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGet=ruleGet();

            state._fsp--;

             current =iv_ruleGet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGet"


    // $ANTLR start "ruleGet"
    // InternalFirstOrderLogic.g:425:1: ruleGet returns [EObject current=null] : (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token otherlv_2=null;
        EObject lv_next_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:431:2: ( (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:432:2: (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:432:2: (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:433:3: otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
            		
            // InternalFirstOrderLogic.g:437:3: ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==18) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:438:4: ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalFirstOrderLogic.g:438:4: ( (lv_type_1_0= RULE_ID ) )
                    // InternalFirstOrderLogic.g:439:5: (lv_type_1_0= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:439:5: (lv_type_1_0= RULE_ID )
                    // InternalFirstOrderLogic.g:440:6: lv_type_1_0= RULE_ID
                    {
                    lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_type_1_0, grammarAccess.getGetAccess().getTypeIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGetRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"type",
                    							lv_type_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,18,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:461:3: ( ( ruleFeature ) )
            // InternalFirstOrderLogic.g:462:4: ( ruleFeature )
            {
            // InternalFirstOrderLogic.g:462:4: ( ruleFeature )
            // InternalFirstOrderLogic.g:463:5: ruleFeature
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
            				
            pushFollow(FOLLOW_11);
            ruleFeature();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFirstOrderLogic.g:477:3: ( (lv_next_4_0= ruleGet ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFirstOrderLogic.g:478:4: (lv_next_4_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:478:4: (lv_next_4_0= ruleGet )
                    // InternalFirstOrderLogic.g:479:5: lv_next_4_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_next_4_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGetRule());
                    					}
                    					set(
                    						current,
                    						"next",
                    						lv_next_4_0,
                    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGet"


    // $ANTLR start "entryRuleFeature"
    // InternalFirstOrderLogic.g:500:1: entryRuleFeature returns [String current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final String entryRuleFeature() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeature = null;


        try {
            // InternalFirstOrderLogic.g:500:47: (iv_ruleFeature= ruleFeature EOF )
            // InternalFirstOrderLogic.g:501:2: iv_ruleFeature= ruleFeature EOF
            {
             newCompositeNode(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;

             current =iv_ruleFeature.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalFirstOrderLogic.g:507:1: ruleFeature returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleFeature() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:513:2: (this_ID_0= RULE_ID )
            // InternalFirstOrderLogic.g:514:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getFeatureAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:524:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:524:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:525:2: iv_ruleFormula= ruleFormula EOF
            {
             newCompositeNode(grammarAccess.getFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFormula=ruleFormula();

            state._fsp--;

             current =iv_ruleFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalFirstOrderLogic.g:531:1: ruleFormula returns [EObject current=null] : this_Iff_0= ruleIff ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Iff_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:537:2: (this_Iff_0= ruleIff )
            // InternalFirstOrderLogic.g:538:2: this_Iff_0= ruleIff
            {

            		newCompositeNode(grammarAccess.getFormulaAccess().getIffParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Iff_0=ruleIff();

            state._fsp--;


            		current = this_Iff_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:549:1: entryRuleIff returns [EObject current=null] : iv_ruleIff= ruleIff EOF ;
    public final EObject entryRuleIff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIff = null;


        try {
            // InternalFirstOrderLogic.g:549:44: (iv_ruleIff= ruleIff EOF )
            // InternalFirstOrderLogic.g:550:2: iv_ruleIff= ruleIff EOF
            {
             newCompositeNode(grammarAccess.getIffRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIff=ruleIff();

            state._fsp--;

             current =iv_ruleIff; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIff"


    // $ANTLR start "ruleIff"
    // InternalFirstOrderLogic.g:556:1: ruleIff returns [EObject current=null] : (this_BinaryFormula_0= ruleBinaryFormula ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )* ) ;
    public final EObject ruleIff() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BinaryFormula_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:562:2: ( (this_BinaryFormula_0= ruleBinaryFormula ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )* ) )
            // InternalFirstOrderLogic.g:563:2: (this_BinaryFormula_0= ruleBinaryFormula ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )* )
            {
            // InternalFirstOrderLogic.g:563:2: (this_BinaryFormula_0= ruleBinaryFormula ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )* )
            // InternalFirstOrderLogic.g:564:3: this_BinaryFormula_0= ruleBinaryFormula ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )*
            {

            			newCompositeNode(grammarAccess.getIffAccess().getBinaryFormulaParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_BinaryFormula_0=ruleBinaryFormula();

            state._fsp--;


            			current = this_BinaryFormula_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:572:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:573:4: () otherlv_2= '=' ( (lv_right_3_0= ruleBinaryFormula ) )
            	    {
            	    // InternalFirstOrderLogic.g:573:4: ()
            	    // InternalFirstOrderLogic.g:574:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIffAccess().getIffLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIffAccess().getEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:584:4: ( (lv_right_3_0= ruleBinaryFormula ) )
            	    // InternalFirstOrderLogic.g:585:5: (lv_right_3_0= ruleBinaryFormula )
            	    {
            	    // InternalFirstOrderLogic.g:585:5: (lv_right_3_0= ruleBinaryFormula )
            	    // InternalFirstOrderLogic.g:586:6: lv_right_3_0= ruleBinaryFormula
            	    {

            	    						newCompositeNode(grammarAccess.getIffAccess().getRightBinaryFormulaParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleBinaryFormula();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIffRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.BinaryFormula");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:608:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:608:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:609:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
            {
             newCompositeNode(grammarAccess.getBinaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryFormula=ruleBinaryFormula();

            state._fsp--;

             current =iv_ruleBinaryFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryFormula"


    // $ANTLR start "ruleBinaryFormula"
    // InternalFirstOrderLogic.g:615:1: ruleBinaryFormula returns [EObject current=null] : this_If_0= ruleIf ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_If_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:621:2: (this_If_0= ruleIf )
            // InternalFirstOrderLogic.g:622:2: this_If_0= ruleIf
            {

            		newCompositeNode(grammarAccess.getBinaryFormulaAccess().getIfParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_If_0=ruleIf();

            state._fsp--;


            		current = this_If_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryFormula"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:633:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:633:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:634:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalFirstOrderLogic.g:640:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:646:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:647:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:647:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:648:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:656:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:657:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:657:4: ()
            	    // InternalFirstOrderLogic.g:658:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:668:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:669:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:669:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:670:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleXor();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIfRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Xor");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleXor"
    // InternalFirstOrderLogic.g:692:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:692:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:693:2: iv_ruleXor= ruleXor EOF
            {
             newCompositeNode(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXor=ruleXor();

            state._fsp--;

             current =iv_ruleXor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalFirstOrderLogic.g:699:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:705:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:706:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:706:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:707:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:715:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:716:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:716:4: ()
            	    // InternalFirstOrderLogic.g:717:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:727:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:728:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:728:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:729:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleOr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Or");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:751:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:751:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:752:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalFirstOrderLogic.g:758:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:764:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:765:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:765:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:766:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:774:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:775:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:775:4: ()
            	    // InternalFirstOrderLogic.g:776:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:786:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:787:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:787:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:788:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:810:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:810:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:811:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalFirstOrderLogic.g:817:1: ruleAnd returns [EObject current=null] : (this_Greater_0= ruleGreater ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Greater_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:823:2: ( (this_Greater_0= ruleGreater ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )* ) )
            // InternalFirstOrderLogic.g:824:2: (this_Greater_0= ruleGreater ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )* )
            {
            // InternalFirstOrderLogic.g:824:2: (this_Greater_0= ruleGreater ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )* )
            // InternalFirstOrderLogic.g:825:3: this_Greater_0= ruleGreater ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getGreaterParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_Greater_0=ruleGreater();

            state._fsp--;


            			current = this_Greater_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:833:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:834:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleGreater ) )
            	    {
            	    // InternalFirstOrderLogic.g:834:4: ()
            	    // InternalFirstOrderLogic.g:835:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,23,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:845:4: ( (lv_right_3_0= ruleGreater ) )
            	    // InternalFirstOrderLogic.g:846:5: (lv_right_3_0= ruleGreater )
            	    {
            	    // InternalFirstOrderLogic.g:846:5: (lv_right_3_0= ruleGreater )
            	    // InternalFirstOrderLogic.g:847:6: lv_right_3_0= ruleGreater
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightGreaterParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_17);
            	    lv_right_3_0=ruleGreater();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Greater");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:869:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:869:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:870:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
            {
             newCompositeNode(grammarAccess.getUnaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryFormula=ruleUnaryFormula();

            state._fsp--;

             current =iv_ruleUnaryFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryFormula"


    // $ANTLR start "ruleUnaryFormula"
    // InternalFirstOrderLogic.g:876:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:882:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:883:2: this_Not_0= ruleNot
            {

            		newCompositeNode(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Not_0=ruleNot();

            state._fsp--;


            		current = this_Not_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryFormula"


    // $ANTLR start "entryRuleNot"
    // InternalFirstOrderLogic.g:894:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:894:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:895:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalFirstOrderLogic.g:901:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_not_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:907:2: ( ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:908:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:908:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:909:3: () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')'
            {
            // InternalFirstOrderLogic.g:909:3: ()
            // InternalFirstOrderLogic.g:910:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            // InternalFirstOrderLogic.g:920:3: ( (lv_not_2_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:921:4: (lv_not_2_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:921:4: (lv_not_2_0= ruleFormula )
            // InternalFirstOrderLogic.g:922:5: lv_not_2_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_18);
            lv_not_2_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotRule());
            					}
            					set(
            						current,
            						"not",
            						lv_not_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNotAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRulePredicate"
    // InternalFirstOrderLogic.g:947:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalFirstOrderLogic.g:947:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalFirstOrderLogic.g:948:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalFirstOrderLogic.g:954:1: rulePredicate returns [EObject current=null] : (this_Equals_0= ruleEquals | this_IsEmpty_1= ruleIsEmpty ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        EObject this_Equals_0 = null;

        EObject this_IsEmpty_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:960:2: ( (this_Equals_0= ruleEquals | this_IsEmpty_1= ruleIsEmpty ) )
            // InternalFirstOrderLogic.g:961:2: (this_Equals_0= ruleEquals | this_IsEmpty_1= ruleIsEmpty )
            {
            // InternalFirstOrderLogic.g:961:2: (this_Equals_0= ruleEquals | this_IsEmpty_1= ruleIsEmpty )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            else if ( (LA10_0==30) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalFirstOrderLogic.g:962:3: this_Equals_0= ruleEquals
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Equals_0=ruleEquals();

                    state._fsp--;


                    			current = this_Equals_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:971:3: this_IsEmpty_1= ruleIsEmpty
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsEmpty_1=ruleIsEmpty();

                    state._fsp--;


                    			current = this_IsEmpty_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleEquals"
    // InternalFirstOrderLogic.g:983:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalFirstOrderLogic.g:983:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalFirstOrderLogic.g:984:2: iv_ruleEquals= ruleEquals EOF
            {
             newCompositeNode(grammarAccess.getEqualsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquals=ruleEquals();

            state._fsp--;

             current =iv_ruleEquals; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalFirstOrderLogic.g:990:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'equals(' ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) ) otherlv_5= ',' ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) ) otherlv_10= ')' ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_left_1_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_8_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:996:2: ( (otherlv_0= 'equals(' ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) ) otherlv_5= ',' ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) ) otherlv_10= ')' ) )
            // InternalFirstOrderLogic.g:997:2: (otherlv_0= 'equals(' ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) ) otherlv_5= ',' ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) ) otherlv_10= ')' )
            {
            // InternalFirstOrderLogic.g:997:2: (otherlv_0= 'equals(' ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) ) otherlv_5= ',' ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) ) otherlv_10= ')' )
            // InternalFirstOrderLogic.g:998:3: otherlv_0= 'equals(' ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) ) otherlv_5= ',' ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) ) otherlv_10= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getEqualsKeyword_0());
            		
            // InternalFirstOrderLogic.g:1002:3: ( ( (lv_left_1_0= ruleTerm ) ) | (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==27) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalFirstOrderLogic.g:1003:4: ( (lv_left_1_0= ruleTerm ) )
                    {
                    // InternalFirstOrderLogic.g:1003:4: ( (lv_left_1_0= ruleTerm ) )
                    // InternalFirstOrderLogic.g:1004:5: (lv_left_1_0= ruleTerm )
                    {
                    // InternalFirstOrderLogic.g:1004:5: (lv_left_1_0= ruleTerm )
                    // InternalFirstOrderLogic.g:1005:6: lv_left_1_0= ruleTerm
                    {

                    						newCompositeNode(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_left_1_0=ruleTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEqualsRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_1_0,
                    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1023:4: (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' )
                    {
                    // InternalFirstOrderLogic.g:1023:4: (otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']' )
                    // InternalFirstOrderLogic.g:1024:5: otherlv_2= '[' ( (lv_left_3_0= ruleConstant ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_10); 

                    					newLeafNode(otherlv_2, grammarAccess.getEqualsAccess().getLeftSquareBracketKeyword_1_1_0());
                    				
                    // InternalFirstOrderLogic.g:1028:5: ( (lv_left_3_0= ruleConstant ) )
                    // InternalFirstOrderLogic.g:1029:6: (lv_left_3_0= ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1029:6: (lv_left_3_0= ruleConstant )
                    // InternalFirstOrderLogic.g:1030:7: lv_left_3_0= ruleConstant
                    {

                    							newCompositeNode(grammarAccess.getEqualsAccess().getLeftConstantParserRuleCall_1_1_1_0());
                    						
                    pushFollow(FOLLOW_21);
                    lv_left_3_0=ruleConstant();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEqualsRule());
                    							}
                    							set(
                    								current,
                    								"left",
                    								lv_left_3_0,
                    								"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constant");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,28,FOLLOW_20); 

                    					newLeafNode(otherlv_4, grammarAccess.getEqualsAccess().getRightSquareBracketKeyword_1_1_2());
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getEqualsAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:1057:3: ( ( (lv_right_6_0= ruleTerm ) ) | (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==27) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalFirstOrderLogic.g:1058:4: ( (lv_right_6_0= ruleTerm ) )
                    {
                    // InternalFirstOrderLogic.g:1058:4: ( (lv_right_6_0= ruleTerm ) )
                    // InternalFirstOrderLogic.g:1059:5: (lv_right_6_0= ruleTerm )
                    {
                    // InternalFirstOrderLogic.g:1059:5: (lv_right_6_0= ruleTerm )
                    // InternalFirstOrderLogic.g:1060:6: lv_right_6_0= ruleTerm
                    {

                    						newCompositeNode(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_right_6_0=ruleTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEqualsRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_6_0,
                    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1078:4: (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' )
                    {
                    // InternalFirstOrderLogic.g:1078:4: (otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']' )
                    // InternalFirstOrderLogic.g:1079:5: otherlv_7= '[' ( (lv_right_8_0= ruleConstant ) ) otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,27,FOLLOW_10); 

                    					newLeafNode(otherlv_7, grammarAccess.getEqualsAccess().getLeftSquareBracketKeyword_3_1_0());
                    				
                    // InternalFirstOrderLogic.g:1083:5: ( (lv_right_8_0= ruleConstant ) )
                    // InternalFirstOrderLogic.g:1084:6: (lv_right_8_0= ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1084:6: (lv_right_8_0= ruleConstant )
                    // InternalFirstOrderLogic.g:1085:7: lv_right_8_0= ruleConstant
                    {

                    							newCompositeNode(grammarAccess.getEqualsAccess().getRightConstantParserRuleCall_3_1_1_0());
                    						
                    pushFollow(FOLLOW_21);
                    lv_right_8_0=ruleConstant();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEqualsRule());
                    							}
                    							set(
                    								current,
                    								"right",
                    								lv_right_8_0,
                    								"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constant");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_9=(Token)match(input,28,FOLLOW_18); 

                    					newLeafNode(otherlv_9, grammarAccess.getEqualsAccess().getRightSquareBracketKeyword_3_1_2());
                    				

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEqualsAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:1116:1: entryRuleIsEmpty returns [EObject current=null] : iv_ruleIsEmpty= ruleIsEmpty EOF ;
    public final EObject entryRuleIsEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsEmpty = null;


        try {
            // InternalFirstOrderLogic.g:1116:48: (iv_ruleIsEmpty= ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:1117:2: iv_ruleIsEmpty= ruleIsEmpty EOF
            {
             newCompositeNode(grammarAccess.getIsEmptyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsEmpty=ruleIsEmpty();

            state._fsp--;

             current =iv_ruleIsEmpty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsEmpty"


    // $ANTLR start "ruleIsEmpty"
    // InternalFirstOrderLogic.g:1123:1: ruleIsEmpty returns [EObject current=null] : (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleIsEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1129:2: ( (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:1130:2: (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:1130:2: (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:1131:3: otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0());
            		
            // InternalFirstOrderLogic.g:1135:3: ( (lv_term_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1136:4: (lv_term_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1136:4: (lv_term_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1137:5: lv_term_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_term_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsEmptyRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsEmpty"


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:1162:1: entryRuleGreater returns [EObject current=null] : iv_ruleGreater= ruleGreater EOF ;
    public final EObject entryRuleGreater() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreater = null;


        try {
            // InternalFirstOrderLogic.g:1162:48: (iv_ruleGreater= ruleGreater EOF )
            // InternalFirstOrderLogic.g:1163:2: iv_ruleGreater= ruleGreater EOF
            {
             newCompositeNode(grammarAccess.getGreaterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreater=ruleGreater();

            state._fsp--;

             current =iv_ruleGreater; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGreater"


    // $ANTLR start "ruleGreater"
    // InternalFirstOrderLogic.g:1169:1: ruleGreater returns [EObject current=null] : (this_GreaterEqual_0= ruleGreaterEqual ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )* ) ;
    public final EObject ruleGreater() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_GreaterEqual_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1175:2: ( (this_GreaterEqual_0= ruleGreaterEqual ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )* ) )
            // InternalFirstOrderLogic.g:1176:2: (this_GreaterEqual_0= ruleGreaterEqual ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )* )
            {
            // InternalFirstOrderLogic.g:1176:2: (this_GreaterEqual_0= ruleGreaterEqual ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )* )
            // InternalFirstOrderLogic.g:1177:3: this_GreaterEqual_0= ruleGreaterEqual ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )*
            {

            			newCompositeNode(grammarAccess.getGreaterAccess().getGreaterEqualParserRuleCall_0());
            		
            pushFollow(FOLLOW_22);
            this_GreaterEqual_0=ruleGreaterEqual();

            state._fsp--;


            			current = this_GreaterEqual_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:1185:3: ( () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==31) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1186:4: () otherlv_2= '>' ( (lv_right_3_0= ruleGreaterEqual ) )
            	    {
            	    // InternalFirstOrderLogic.g:1186:4: ()
            	    // InternalFirstOrderLogic.g:1187:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getGreaterAccess().getGreaterLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getGreaterAccess().getGreaterThanSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:1197:4: ( (lv_right_3_0= ruleGreaterEqual ) )
            	    // InternalFirstOrderLogic.g:1198:5: (lv_right_3_0= ruleGreaterEqual )
            	    {
            	    // InternalFirstOrderLogic.g:1198:5: (lv_right_3_0= ruleGreaterEqual )
            	    // InternalFirstOrderLogic.g:1199:6: lv_right_3_0= ruleGreaterEqual
            	    {

            	    						newCompositeNode(grammarAccess.getGreaterAccess().getRightGreaterEqualParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_right_3_0=ruleGreaterEqual();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGreaterRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.GreaterEqual");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGreater"


    // $ANTLR start "entryRuleGreaterEqual"
    // InternalFirstOrderLogic.g:1221:1: entryRuleGreaterEqual returns [EObject current=null] : iv_ruleGreaterEqual= ruleGreaterEqual EOF ;
    public final EObject entryRuleGreaterEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterEqual = null;


        try {
            // InternalFirstOrderLogic.g:1221:53: (iv_ruleGreaterEqual= ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:1222:2: iv_ruleGreaterEqual= ruleGreaterEqual EOF
            {
             newCompositeNode(grammarAccess.getGreaterEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreaterEqual=ruleGreaterEqual();

            state._fsp--;

             current =iv_ruleGreaterEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGreaterEqual"


    // $ANTLR start "ruleGreaterEqual"
    // InternalFirstOrderLogic.g:1228:1: ruleGreaterEqual returns [EObject current=null] : (this_Smaller_0= ruleSmaller ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )* ) ;
    public final EObject ruleGreaterEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Smaller_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1234:2: ( (this_Smaller_0= ruleSmaller ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )* ) )
            // InternalFirstOrderLogic.g:1235:2: (this_Smaller_0= ruleSmaller ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )* )
            {
            // InternalFirstOrderLogic.g:1235:2: (this_Smaller_0= ruleSmaller ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )* )
            // InternalFirstOrderLogic.g:1236:3: this_Smaller_0= ruleSmaller ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )*
            {

            			newCompositeNode(grammarAccess.getGreaterEqualAccess().getSmallerParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_Smaller_0=ruleSmaller();

            state._fsp--;


            			current = this_Smaller_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:1244:3: ( () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==32) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1245:4: () otherlv_2= '>=' ( (lv_right_3_0= ruleSmaller ) )
            	    {
            	    // InternalFirstOrderLogic.g:1245:4: ()
            	    // InternalFirstOrderLogic.g:1246:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getGreaterEqualAccess().getGreaterEqualLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getGreaterEqualAccess().getGreaterThanSignEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:1256:4: ( (lv_right_3_0= ruleSmaller ) )
            	    // InternalFirstOrderLogic.g:1257:5: (lv_right_3_0= ruleSmaller )
            	    {
            	    // InternalFirstOrderLogic.g:1257:5: (lv_right_3_0= ruleSmaller )
            	    // InternalFirstOrderLogic.g:1258:6: lv_right_3_0= ruleSmaller
            	    {

            	    						newCompositeNode(grammarAccess.getGreaterEqualAccess().getRightSmallerParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_right_3_0=ruleSmaller();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Smaller");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGreaterEqual"


    // $ANTLR start "entryRuleSmaller"
    // InternalFirstOrderLogic.g:1280:1: entryRuleSmaller returns [EObject current=null] : iv_ruleSmaller= ruleSmaller EOF ;
    public final EObject entryRuleSmaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmaller = null;


        try {
            // InternalFirstOrderLogic.g:1280:48: (iv_ruleSmaller= ruleSmaller EOF )
            // InternalFirstOrderLogic.g:1281:2: iv_ruleSmaller= ruleSmaller EOF
            {
             newCompositeNode(grammarAccess.getSmallerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSmaller=ruleSmaller();

            state._fsp--;

             current =iv_ruleSmaller; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSmaller"


    // $ANTLR start "ruleSmaller"
    // InternalFirstOrderLogic.g:1287:1: ruleSmaller returns [EObject current=null] : (this_SmallerEqual_0= ruleSmallerEqual ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )* ) ;
    public final EObject ruleSmaller() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_SmallerEqual_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1293:2: ( (this_SmallerEqual_0= ruleSmallerEqual ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )* ) )
            // InternalFirstOrderLogic.g:1294:2: (this_SmallerEqual_0= ruleSmallerEqual ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )* )
            {
            // InternalFirstOrderLogic.g:1294:2: (this_SmallerEqual_0= ruleSmallerEqual ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )* )
            // InternalFirstOrderLogic.g:1295:3: this_SmallerEqual_0= ruleSmallerEqual ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )*
            {

            			newCompositeNode(grammarAccess.getSmallerAccess().getSmallerEqualParserRuleCall_0());
            		
            pushFollow(FOLLOW_24);
            this_SmallerEqual_0=ruleSmallerEqual();

            state._fsp--;


            			current = this_SmallerEqual_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:1303:3: ( () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1304:4: () otherlv_2= '<' ( (lv_right_3_0= ruleSmallerEqual ) )
            	    {
            	    // InternalFirstOrderLogic.g:1304:4: ()
            	    // InternalFirstOrderLogic.g:1305:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSmallerAccess().getSmallerLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,33,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSmallerAccess().getLessThanSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:1315:4: ( (lv_right_3_0= ruleSmallerEqual ) )
            	    // InternalFirstOrderLogic.g:1316:5: (lv_right_3_0= ruleSmallerEqual )
            	    {
            	    // InternalFirstOrderLogic.g:1316:5: (lv_right_3_0= ruleSmallerEqual )
            	    // InternalFirstOrderLogic.g:1317:6: lv_right_3_0= ruleSmallerEqual
            	    {

            	    						newCompositeNode(grammarAccess.getSmallerAccess().getRightSmallerEqualParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_right_3_0=ruleSmallerEqual();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSmallerRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.SmallerEqual");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSmaller"


    // $ANTLR start "entryRuleSmallerEqual"
    // InternalFirstOrderLogic.g:1339:1: entryRuleSmallerEqual returns [EObject current=null] : iv_ruleSmallerEqual= ruleSmallerEqual EOF ;
    public final EObject entryRuleSmallerEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmallerEqual = null;


        try {
            // InternalFirstOrderLogic.g:1339:53: (iv_ruleSmallerEqual= ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:1340:2: iv_ruleSmallerEqual= ruleSmallerEqual EOF
            {
             newCompositeNode(grammarAccess.getSmallerEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSmallerEqual=ruleSmallerEqual();

            state._fsp--;

             current =iv_ruleSmallerEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSmallerEqual"


    // $ANTLR start "ruleSmallerEqual"
    // InternalFirstOrderLogic.g:1346:1: ruleSmallerEqual returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleSmallerEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1352:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalFirstOrderLogic.g:1353:2: (this_Primary_0= rulePrimary ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalFirstOrderLogic.g:1353:2: (this_Primary_0= rulePrimary ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalFirstOrderLogic.g:1354:3: this_Primary_0= rulePrimary ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getSmallerEqualAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_25);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:1362:3: ( () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1363:4: () otherlv_2= '<=' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalFirstOrderLogic.g:1363:4: ()
            	    // InternalFirstOrderLogic.g:1364:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSmallerEqualAccess().getSmallerEqualLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,34,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSmallerEqualAccess().getLessThanSignEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:1374:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalFirstOrderLogic.g:1375:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalFirstOrderLogic.g:1375:5: (lv_right_3_0= rulePrimary )
            	    // InternalFirstOrderLogic.g:1376:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getSmallerEqualAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSmallerEqual"


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:1398:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:1398:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:1399:2: iv_ruleQuantifier= ruleQuantifier EOF
            {
             newCompositeNode(grammarAccess.getQuantifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantifier=ruleQuantifier();

            state._fsp--;

             current =iv_ruleQuantifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantifier"


    // $ANTLR start "ruleQuantifier"
    // InternalFirstOrderLogic.g:1405:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1411:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:1412:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:1412:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            else if ( (LA17_0==37) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalFirstOrderLogic.g:1413:3: this_ForAll_0= ruleForAll
                    {

                    			newCompositeNode(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForAll_0=ruleForAll();

                    state._fsp--;


                    			current = this_ForAll_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1422:3: this_Exists_1= ruleExists
                    {

                    			newCompositeNode(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Exists_1=ruleExists();

                    state._fsp--;


                    			current = this_Exists_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantifier"


    // $ANTLR start "entryRuleForAll"
    // InternalFirstOrderLogic.g:1434:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:1434:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:1435:2: iv_ruleForAll= ruleForAll EOF
            {
             newCompositeNode(grammarAccess.getForAllRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForAll=ruleForAll();

            state._fsp--;

             current =iv_ruleForAll; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForAll"


    // $ANTLR start "ruleForAll"
    // InternalFirstOrderLogic.g:1441:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleForAll() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_name_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1447:2: ( ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:1448:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:1448:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:1449:3: () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:1449:3: ()
            // InternalFirstOrderLogic.g:1450:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            // InternalFirstOrderLogic.g:1460:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1461:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1461:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:1462:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_name_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getForAllAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:1483:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1484:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1484:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1485:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getForAllAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:1506:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1507:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1507:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:1508:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_18);
            lv_formula_6_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getForAllAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAll"


    // $ANTLR start "entryRuleExists"
    // InternalFirstOrderLogic.g:1533:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:1533:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:1534:2: iv_ruleExists= ruleExists EOF
            {
             newCompositeNode(grammarAccess.getExistsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExists=ruleExists();

            state._fsp--;

             current =iv_ruleExists; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExists"


    // $ANTLR start "ruleExists"
    // InternalFirstOrderLogic.g:1540:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleExists() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_name_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1546:2: ( ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:1547:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:1547:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:1548:3: () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:1548:3: ()
            // InternalFirstOrderLogic.g:1549:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            // InternalFirstOrderLogic.g:1559:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1560:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1560:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:1561:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_name_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getExistsAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:1582:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1583:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1583:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1584:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getExistsAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:1605:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1606:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1606:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:1607:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_18);
            lv_formula_6_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getExistsAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExists"


    // $ANTLR start "entryRulePrimary"
    // InternalFirstOrderLogic.g:1632:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalFirstOrderLogic.g:1632:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalFirstOrderLogic.g:1633:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalFirstOrderLogic.g:1639:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_Constant_6= ruleConstant ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Formula_1 = null;

        EObject this_UnaryFormula_3 = null;

        EObject this_Quantifier_4 = null;

        EObject this_Predicate_5 = null;

        EObject this_Constant_6 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1645:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_Constant_6= ruleConstant ) )
            // InternalFirstOrderLogic.g:1646:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_Constant_6= ruleConstant )
            {
            // InternalFirstOrderLogic.g:1646:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_Constant_6= ruleConstant )
            int alt18=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt18=1;
                }
                break;
            case 24:
                {
                alt18=2;
                }
                break;
            case 35:
            case 37:
                {
                alt18=3;
                }
                break;
            case 26:
            case 30:
                {
                alt18=4;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 39:
            case 40:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalFirstOrderLogic.g:1647:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:1647:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:1648:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,38,FOLLOW_10); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_18);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1666:3: this_UnaryFormula_3= ruleUnaryFormula
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getUnaryFormulaParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryFormula_3=ruleUnaryFormula();

                    state._fsp--;


                    			current = this_UnaryFormula_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1675:3: this_Quantifier_4= ruleQuantifier
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getQuantifierParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Quantifier_4=ruleQuantifier();

                    state._fsp--;


                    			current = this_Quantifier_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1684:3: this_Predicate_5= rulePredicate
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getPredicateParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Predicate_5=rulePredicate();

                    state._fsp--;


                    			current = this_Predicate_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1693:3: this_Constant_6= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getConstantParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_6=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:1705:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalFirstOrderLogic.g:1705:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalFirstOrderLogic.g:1706:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalFirstOrderLogic.g:1712:1: ruleConstant returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1718:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalFirstOrderLogic.g:1719:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalFirstOrderLogic.g:1719:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt20=1;
                }
                break;
            case RULE_STRING:
                {
                alt20=2;
                }
                break;
            case 39:
            case 40:
                {
                alt20=3;
                }
                break;
            case RULE_ID:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalFirstOrderLogic.g:1720:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalFirstOrderLogic.g:1720:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalFirstOrderLogic.g:1721:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalFirstOrderLogic.g:1721:4: ()
                    // InternalFirstOrderLogic.g:1722:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getIntConstantAction_0_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1728:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalFirstOrderLogic.g:1729:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalFirstOrderLogic.g:1729:5: (lv_value_1_0= RULE_INT )
                    // InternalFirstOrderLogic.g:1730:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1748:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalFirstOrderLogic.g:1748:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalFirstOrderLogic.g:1749:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalFirstOrderLogic.g:1749:4: ()
                    // InternalFirstOrderLogic.g:1750:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1756:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalFirstOrderLogic.g:1757:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalFirstOrderLogic.g:1757:5: (lv_value_3_0= RULE_STRING )
                    // InternalFirstOrderLogic.g:1758:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1776:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalFirstOrderLogic.g:1776:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalFirstOrderLogic.g:1777:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalFirstOrderLogic.g:1777:4: ()
                    // InternalFirstOrderLogic.g:1778:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getBoolConstantAction_2_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1784:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalFirstOrderLogic.g:1785:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalFirstOrderLogic.g:1785:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalFirstOrderLogic.g:1786:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalFirstOrderLogic.g:1786:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==39) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==40) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalFirstOrderLogic.g:1787:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,39,FOLLOW_2); 

                            							newLeafNode(lv_value_5_1, grammarAccess.getConstantAccess().getValueTrueKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getConstantRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalFirstOrderLogic.g:1798:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,40,FOLLOW_2); 

                            							newLeafNode(lv_value_5_2, grammarAccess.getConstantAccess().getValueFalseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getConstantRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1813:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalFirstOrderLogic.g:1813:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalFirstOrderLogic.g:1814:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalFirstOrderLogic.g:1814:4: ()
                    // InternalFirstOrderLogic.g:1815:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getVariableRefAction_3_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1821:4: ( (otherlv_7= RULE_ID ) )
                    // InternalFirstOrderLogic.g:1822:5: (otherlv_7= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:1822:5: (otherlv_7= RULE_ID )
                    // InternalFirstOrderLogic.g:1823:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getConstantAccess().getVariableVariableCrossReference_3_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000001E845000070L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000000L});

}