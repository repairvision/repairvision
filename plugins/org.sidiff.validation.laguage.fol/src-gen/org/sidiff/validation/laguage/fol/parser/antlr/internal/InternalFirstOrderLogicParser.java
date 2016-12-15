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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'context'", "':'", "'.'", "'::'", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'forAll('", "'in'", "'exists('", "'('", "'true'", "'false'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
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
    // InternalFirstOrderLogic.g:71:1: ruleConstraintRuleBase returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ( (lv_constraints_2_0= ruleConstraint ) ) ) ;
    public final EObject ruleConstraintRuleBase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domain_1_0=null;
        EObject lv_constraints_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ( (lv_constraints_2_0= ruleConstraint ) ) ) )
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ( (lv_constraints_2_0= ruleConstraint ) ) )
            {
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ( (lv_constraints_2_0= ruleConstraint ) ) )
            // InternalFirstOrderLogic.g:79:3: otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ( (lv_constraints_2_0= ruleConstraint ) )
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

            // InternalFirstOrderLogic.g:101:3: ( (lv_constraints_2_0= ruleConstraint ) )
            // InternalFirstOrderLogic.g:102:4: (lv_constraints_2_0= ruleConstraint )
            {
            // InternalFirstOrderLogic.g:102:4: (lv_constraints_2_0= ruleConstraint )
            // InternalFirstOrderLogic.g:103:5: lv_constraints_2_0= ruleConstraint
            {

            					newCompositeNode(grammarAccess.getConstraintRuleBaseAccess().getConstraintsConstraintParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_constraints_2_0=ruleConstraint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRuleBaseRule());
            					}
            					add(
            						current,
            						"constraints",
            						lv_constraints_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constraint");
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
    // $ANTLR end "ruleConstraintRuleBase"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:124:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalFirstOrderLogic.g:124:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalFirstOrderLogic.g:125:2: iv_ruleConstraint= ruleConstraint EOF
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
    // InternalFirstOrderLogic.g:131:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'context' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_formula_3_0= ruleFormula ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_variable_1_0 = null;

        EObject lv_formula_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:137:2: ( (otherlv_0= 'context' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_formula_3_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:138:2: (otherlv_0= 'context' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_formula_3_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:138:2: (otherlv_0= 'context' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_formula_3_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:139:3: otherlv_0= 'context' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ':' ( (lv_formula_3_0= ruleFormula ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getContextKeyword_0());
            		
            // InternalFirstOrderLogic.g:143:3: ( (lv_variable_1_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:144:4: (lv_variable_1_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:144:4: (lv_variable_1_0= ruleVariable )
            // InternalFirstOrderLogic.g:145:5: lv_variable_1_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_variable_1_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getColonKeyword_2());
            		
            // InternalFirstOrderLogic.g:166:3: ( (lv_formula_3_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:167:4: (lv_formula_3_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:167:4: (lv_formula_3_0= ruleFormula )
            // InternalFirstOrderLogic.g:168:5: lv_formula_3_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_formula_3_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_3_0,
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
    // InternalFirstOrderLogic.g:189:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:189:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:190:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalFirstOrderLogic.g:196:1: ruleVariable returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:202:2: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFirstOrderLogic.g:203:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFirstOrderLogic.g:203:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:204:3: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:204:3: ( (lv_type_0_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:205:4: (lv_type_0_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:205:4: (lv_type_0_0= RULE_ID )
            // InternalFirstOrderLogic.g:206:5: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

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

            // InternalFirstOrderLogic.g:222:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:223:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:223:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:224:5: lv_name_1_0= RULE_ID
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
    // InternalFirstOrderLogic.g:244:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:244:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:245:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalFirstOrderLogic.g:251:1: ruleTerm returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:257:2: (this_Function_0= ruleFunction )
            // InternalFirstOrderLogic.g:258:2: this_Function_0= ruleFunction
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
    // InternalFirstOrderLogic.g:269:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalFirstOrderLogic.g:269:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalFirstOrderLogic.g:270:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalFirstOrderLogic.g:276:1: ruleFunction returns [EObject current=null] : this_GetTerm_0= ruleGetTerm ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_GetTerm_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:282:2: (this_GetTerm_0= ruleGetTerm )
            // InternalFirstOrderLogic.g:283:2: this_GetTerm_0= ruleGetTerm
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
    // InternalFirstOrderLogic.g:294:1: entryRuleGetTerm returns [EObject current=null] : iv_ruleGetTerm= ruleGetTerm EOF ;
    public final EObject entryRuleGetTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetTerm = null;


        try {
            // InternalFirstOrderLogic.g:294:48: (iv_ruleGetTerm= ruleGetTerm EOF )
            // InternalFirstOrderLogic.g:295:2: iv_ruleGetTerm= ruleGetTerm EOF
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
    // InternalFirstOrderLogic.g:301:1: ruleGetTerm returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? ) ;
    public final EObject ruleGetTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_feature_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:307:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:308:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:308:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:309:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_feature_2_0= ruleGet ) )?
            {
            // InternalFirstOrderLogic.g:309:3: ()
            // InternalFirstOrderLogic.g:310:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGetTermAccess().getGetTermAction_0(),
            					current);
            			

            }

            // InternalFirstOrderLogic.g:316:3: ( (otherlv_1= RULE_ID ) )
            // InternalFirstOrderLogic.g:317:4: (otherlv_1= RULE_ID )
            {
            // InternalFirstOrderLogic.g:317:4: (otherlv_1= RULE_ID )
            // InternalFirstOrderLogic.g:318:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetTermRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_1, grammarAccess.getGetTermAccess().getNameVariableCrossReference_1_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:329:3: ( (lv_feature_2_0= ruleGet ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:330:4: (lv_feature_2_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:330:4: (lv_feature_2_0= ruleGet )
                    // InternalFirstOrderLogic.g:331:5: lv_feature_2_0= ruleGet
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
    // InternalFirstOrderLogic.g:352:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:352:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:353:2: iv_ruleGet= ruleGet EOF
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
    // InternalFirstOrderLogic.g:359:1: ruleGet returns [EObject current=null] : (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token otherlv_2=null;
        EObject lv_next_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:365:2: ( (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:366:2: (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:366:2: (otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:367:3: otherlv_0= '.' ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )? ( ( ruleFeature ) ) ( (lv_next_4_0= ruleGet ) )?
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
            		
            // InternalFirstOrderLogic.g:371:3: ( ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==15) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:372:4: ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalFirstOrderLogic.g:372:4: ( (lv_type_1_0= RULE_ID ) )
                    // InternalFirstOrderLogic.g:373:5: (lv_type_1_0= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:373:5: (lv_type_1_0= RULE_ID )
                    // InternalFirstOrderLogic.g:374:6: lv_type_1_0= RULE_ID
                    {
                    lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

                    otherlv_2=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:395:3: ( ( ruleFeature ) )
            // InternalFirstOrderLogic.g:396:4: ( ruleFeature )
            {
            // InternalFirstOrderLogic.g:396:4: ( ruleFeature )
            // InternalFirstOrderLogic.g:397:5: ruleFeature
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
            				
            pushFollow(FOLLOW_8);
            ruleFeature();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFirstOrderLogic.g:411:3: ( (lv_next_4_0= ruleGet ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:412:4: (lv_next_4_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:412:4: (lv_next_4_0= ruleGet )
                    // InternalFirstOrderLogic.g:413:5: lv_next_4_0= ruleGet
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
    // InternalFirstOrderLogic.g:434:1: entryRuleFeature returns [String current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final String entryRuleFeature() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeature = null;


        try {
            // InternalFirstOrderLogic.g:434:47: (iv_ruleFeature= ruleFeature EOF )
            // InternalFirstOrderLogic.g:435:2: iv_ruleFeature= ruleFeature EOF
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
    // InternalFirstOrderLogic.g:441:1: ruleFeature returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleFeature() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:447:2: (this_ID_0= RULE_ID )
            // InternalFirstOrderLogic.g:448:2: this_ID_0= RULE_ID
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
    // InternalFirstOrderLogic.g:458:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:458:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:459:2: iv_ruleFormula= ruleFormula EOF
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
    // InternalFirstOrderLogic.g:465:1: ruleFormula returns [EObject current=null] : this_BinaryFormula_0= ruleBinaryFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryFormula_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:471:2: (this_BinaryFormula_0= ruleBinaryFormula )
            // InternalFirstOrderLogic.g:472:2: this_BinaryFormula_0= ruleBinaryFormula
            {

            		newCompositeNode(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BinaryFormula_0=ruleBinaryFormula();

            state._fsp--;


            		current = this_BinaryFormula_0;
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


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:483:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:483:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:484:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:490:1: ruleBinaryFormula returns [EObject current=null] : this_If_0= ruleIf ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_If_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:496:2: (this_If_0= ruleIf )
            // InternalFirstOrderLogic.g:497:2: this_If_0= ruleIf
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
    // InternalFirstOrderLogic.g:508:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:508:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:509:2: iv_ruleIf= ruleIf EOF
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
    // InternalFirstOrderLogic.g:515:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:521:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:522:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:522:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:523:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_10);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:531:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:532:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:532:4: ()
            	    // InternalFirstOrderLogic.g:533:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:543:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:544:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:544:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:545:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_10);
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
            	    break loop4;
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
    // InternalFirstOrderLogic.g:567:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:567:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:568:2: iv_ruleXor= ruleXor EOF
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
    // InternalFirstOrderLogic.g:574:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:580:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:581:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:581:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:582:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:590:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:591:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:591:4: ()
            	    // InternalFirstOrderLogic.g:592:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:602:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:603:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:603:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:604:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
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
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:626:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:626:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:627:2: iv_ruleOr= ruleOr EOF
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
    // InternalFirstOrderLogic.g:633:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:639:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:640:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:640:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:641:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:649:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:650:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:650:4: ()
            	    // InternalFirstOrderLogic.g:651:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,18,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:661:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:662:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:662:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:663:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:685:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:685:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:686:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalFirstOrderLogic.g:692:1: ruleAnd returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:698:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalFirstOrderLogic.g:699:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalFirstOrderLogic.g:699:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalFirstOrderLogic.g:700:3: this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:708:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:709:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalFirstOrderLogic.g:709:4: ()
            	    // InternalFirstOrderLogic.g:710:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:720:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalFirstOrderLogic.g:721:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalFirstOrderLogic.g:721:5: (lv_right_3_0= rulePrimary )
            	    // InternalFirstOrderLogic.g:722:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:744:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:744:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:745:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:751:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:757:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:758:2: this_Not_0= ruleNot
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
    // InternalFirstOrderLogic.g:769:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:769:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:770:2: iv_ruleNot= ruleNot EOF
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
    // InternalFirstOrderLogic.g:776:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_not_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:782:2: ( ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:783:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:783:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:784:3: () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')'
            {
            // InternalFirstOrderLogic.g:784:3: ()
            // InternalFirstOrderLogic.g:785:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            // InternalFirstOrderLogic.g:795:3: ( (lv_not_2_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:796:4: (lv_not_2_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:796:4: (lv_not_2_0= ruleFormula )
            // InternalFirstOrderLogic.g:797:5: lv_not_2_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_3=(Token)match(input,21,FOLLOW_2); 

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


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:822:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:822:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:823:2: iv_ruleQuantifier= ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:829:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:835:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:836:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:836:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==24) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:837:3: this_ForAll_0= ruleForAll
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
                    // InternalFirstOrderLogic.g:846:3: this_Exists_1= ruleExists
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
    // InternalFirstOrderLogic.g:858:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:858:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:859:2: iv_ruleForAll= ruleForAll EOF
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
    // InternalFirstOrderLogic.g:865:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
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
            // InternalFirstOrderLogic.g:871:2: ( ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:872:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:872:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:873:3: () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:873:3: ()
            // InternalFirstOrderLogic.g:874:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            // InternalFirstOrderLogic.g:884:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:885:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:885:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:886:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
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

            otherlv_3=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getForAllAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:907:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:908:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:908:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:909:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
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

            otherlv_5=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getForAllAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:930:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:931:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:931:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:932:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_7=(Token)match(input,21,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:957:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:957:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:958:2: iv_ruleExists= ruleExists EOF
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
    // InternalFirstOrderLogic.g:964:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
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
            // InternalFirstOrderLogic.g:970:2: ( ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:971:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:971:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:972:3: () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:972:3: ()
            // InternalFirstOrderLogic.g:973:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            // InternalFirstOrderLogic.g:983:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:984:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:984:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:985:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
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

            otherlv_3=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getExistsAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:1006:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1007:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1007:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1008:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
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

            otherlv_5=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getExistsAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:1029:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1030:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1030:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:1031:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_7=(Token)match(input,21,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1056:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalFirstOrderLogic.g:1056:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalFirstOrderLogic.g:1057:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalFirstOrderLogic.g:1063:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Formula_1 = null;

        EObject this_UnaryFormula_3 = null;

        EObject this_Quantifier_4 = null;

        EObject this_TerminalExpression_5 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1069:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression ) )
            // InternalFirstOrderLogic.g:1070:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression )
            {
            // InternalFirstOrderLogic.g:1070:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt9=1;
                }
                break;
            case 20:
                {
                alt9=2;
                }
                break;
            case 22:
            case 24:
                {
                alt9=3;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 26:
            case 27:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalFirstOrderLogic.g:1071:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:1071:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:1072:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_14);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1090:3: this_UnaryFormula_3= ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:1099:3: this_Quantifier_4= ruleQuantifier
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
                    // InternalFirstOrderLogic.g:1108:3: this_TerminalExpression_5= ruleTerminalExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getTerminalExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminalExpression_5=ruleTerminalExpression();

                    state._fsp--;


                    			current = this_TerminalExpression_5;
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


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalFirstOrderLogic.g:1120:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalFirstOrderLogic.g:1120:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalFirstOrderLogic.g:1121:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;

             current =iv_ruleTerminalExpression; 
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
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalFirstOrderLogic.g:1127:1: ruleTerminalExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1133:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalFirstOrderLogic.g:1134:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalFirstOrderLogic.g:1134:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt11=1;
                }
                break;
            case RULE_STRING:
                {
                alt11=2;
                }
                break;
            case 26:
            case 27:
                {
                alt11=3;
                }
                break;
            case RULE_ID:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalFirstOrderLogic.g:1135:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalFirstOrderLogic.g:1135:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalFirstOrderLogic.g:1136:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalFirstOrderLogic.g:1136:4: ()
                    // InternalFirstOrderLogic.g:1137:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getIntConstantAction_0_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1143:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalFirstOrderLogic.g:1144:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalFirstOrderLogic.g:1144:5: (lv_value_1_0= RULE_INT )
                    // InternalFirstOrderLogic.g:1145:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getTerminalExpressionAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
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
                    // InternalFirstOrderLogic.g:1163:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalFirstOrderLogic.g:1163:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalFirstOrderLogic.g:1164:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalFirstOrderLogic.g:1164:4: ()
                    // InternalFirstOrderLogic.g:1165:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1171:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalFirstOrderLogic.g:1172:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalFirstOrderLogic.g:1172:5: (lv_value_3_0= RULE_STRING )
                    // InternalFirstOrderLogic.g:1173:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
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
                    // InternalFirstOrderLogic.g:1191:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalFirstOrderLogic.g:1191:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalFirstOrderLogic.g:1192:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalFirstOrderLogic.g:1192:4: ()
                    // InternalFirstOrderLogic.g:1193:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1199:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalFirstOrderLogic.g:1200:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalFirstOrderLogic.g:1200:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalFirstOrderLogic.g:1201:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalFirstOrderLogic.g:1201:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==26) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==27) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalFirstOrderLogic.g:1202:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,26,FOLLOW_2); 

                            							newLeafNode(lv_value_5_1, grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTerminalExpressionRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalFirstOrderLogic.g:1213:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,27,FOLLOW_2); 

                            							newLeafNode(lv_value_5_2, grammarAccess.getTerminalExpressionAccess().getValueFalseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTerminalExpressionRule());
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
                    // InternalFirstOrderLogic.g:1228:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalFirstOrderLogic.g:1228:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalFirstOrderLogic.g:1229:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalFirstOrderLogic.g:1229:4: ()
                    // InternalFirstOrderLogic.g:1230:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getVariableRefAction_3_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1236:4: ( (otherlv_7= RULE_ID ) )
                    // InternalFirstOrderLogic.g:1237:5: (otherlv_7= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:1237:5: (otherlv_7= RULE_ID )
                    // InternalFirstOrderLogic.g:1238:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getTerminalExpressionAccess().getVariableVariableCrossReference_3_1_0());
                    					

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
    // $ANTLR end "ruleTerminalExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000F500070L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});

}