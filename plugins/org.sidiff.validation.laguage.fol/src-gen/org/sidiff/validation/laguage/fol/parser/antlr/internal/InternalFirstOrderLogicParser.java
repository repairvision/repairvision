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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "':'", "'.'", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'forAll('", "'in'", "'exists('", "'('", "'true'", "'false'"
    };
    public static final int RULE_STRING=6;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
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
        	return "ConsistencyRule";
       	}

       	@Override
       	protected FirstOrderLogicGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConsistencyRule"
    // InternalFirstOrderLogic.g:64:1: entryRuleConsistencyRule returns [EObject current=null] : iv_ruleConsistencyRule= ruleConsistencyRule EOF ;
    public final EObject entryRuleConsistencyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsistencyRule = null;


        try {
            // InternalFirstOrderLogic.g:64:56: (iv_ruleConsistencyRule= ruleConsistencyRule EOF )
            // InternalFirstOrderLogic.g:65:2: iv_ruleConsistencyRule= ruleConsistencyRule EOF
            {
             newCompositeNode(grammarAccess.getConsistencyRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConsistencyRule=ruleConsistencyRule();

            state._fsp--;

             current =iv_ruleConsistencyRule; 
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
    // $ANTLR end "entryRuleConsistencyRule"


    // $ANTLR start "ruleConsistencyRule"
    // InternalFirstOrderLogic.g:71:1: ruleConsistencyRule returns [EObject current=null] : (otherlv_0= 'context' ( (lv_type_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariable ) ) otherlv_3= ':' ( (lv_formula_4_0= ruleFormula ) ) ) ;
    public final EObject ruleConsistencyRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token otherlv_3=null;
        EObject lv_variable_2_0 = null;

        EObject lv_formula_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( (otherlv_0= 'context' ( (lv_type_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariable ) ) otherlv_3= ':' ( (lv_formula_4_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'context' ( (lv_type_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariable ) ) otherlv_3= ':' ( (lv_formula_4_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'context' ( (lv_type_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariable ) ) otherlv_3= ':' ( (lv_formula_4_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:79:3: otherlv_0= 'context' ( (lv_type_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariable ) ) otherlv_3= ':' ( (lv_formula_4_0= ruleFormula ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConsistencyRuleAccess().getContextKeyword_0());
            		
            // InternalFirstOrderLogic.g:83:3: ( (lv_type_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:84:4: (lv_type_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:84:4: (lv_type_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:85:5: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_type_1_0, grammarAccess.getConsistencyRuleAccess().getTypeIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConsistencyRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFirstOrderLogic.g:101:3: ( (lv_variable_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:102:4: (lv_variable_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:102:4: (lv_variable_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:103:5: lv_variable_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getConsistencyRuleAccess().getVariableVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_variable_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConsistencyRuleRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getConsistencyRuleAccess().getColonKeyword_3());
            		
            // InternalFirstOrderLogic.g:124:3: ( (lv_formula_4_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:125:4: (lv_formula_4_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:125:4: (lv_formula_4_0= ruleFormula )
            // InternalFirstOrderLogic.g:126:5: lv_formula_4_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getConsistencyRuleAccess().getFormulaFormulaParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_formula_4_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConsistencyRuleRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_4_0,
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
    // $ANTLR end "ruleConsistencyRule"


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:147:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:147:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:148:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalFirstOrderLogic.g:154:1: ruleVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:160:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:161:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:161:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:162:3: (lv_name_0_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:162:3: (lv_name_0_0= RULE_ID )
            // InternalFirstOrderLogic.g:163:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // InternalFirstOrderLogic.g:182:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:182:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:183:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalFirstOrderLogic.g:189:1: ruleTerm returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:195:2: (this_Function_0= ruleFunction )
            // InternalFirstOrderLogic.g:196:2: this_Function_0= ruleFunction
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
    // InternalFirstOrderLogic.g:207:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalFirstOrderLogic.g:207:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalFirstOrderLogic.g:208:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalFirstOrderLogic.g:214:1: ruleFunction returns [EObject current=null] : this_Get_0= ruleGet ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_Get_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:220:2: (this_Get_0= ruleGet )
            // InternalFirstOrderLogic.g:221:2: this_Get_0= ruleGet
            {

            		newCompositeNode(grammarAccess.getFunctionAccess().getGetParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Get_0=ruleGet();

            state._fsp--;


            		current = this_Get_0;
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


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:232:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:232:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:233:2: iv_ruleGet= ruleGet EOF
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
    // InternalFirstOrderLogic.g:239:1: ruleGet returns [EObject current=null] : (this_Variable_0= ruleVariable ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_feature_3_0=null;
        EObject this_Variable_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:245:2: ( (this_Variable_0= ruleVariable ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )* ) )
            // InternalFirstOrderLogic.g:246:2: (this_Variable_0= ruleVariable ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )* )
            {
            // InternalFirstOrderLogic.g:246:2: (this_Variable_0= ruleVariable ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )* )
            // InternalFirstOrderLogic.g:247:3: this_Variable_0= ruleVariable ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )*
            {

            			newCompositeNode(grammarAccess.getGetAccess().getVariableParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_Variable_0=ruleVariable();

            state._fsp--;


            			current = this_Variable_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:255:3: ( () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:256:4: () otherlv_2= '.' ( (lv_feature_3_0= RULE_ID ) )
            	    {
            	    // InternalFirstOrderLogic.g:256:4: ()
            	    // InternalFirstOrderLogic.g:257:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getGetAccess().getGetContextAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:267:4: ( (lv_feature_3_0= RULE_ID ) )
            	    // InternalFirstOrderLogic.g:268:5: (lv_feature_3_0= RULE_ID )
            	    {
            	    // InternalFirstOrderLogic.g:268:5: (lv_feature_3_0= RULE_ID )
            	    // InternalFirstOrderLogic.g:269:6: lv_feature_3_0= RULE_ID
            	    {
            	    lv_feature_3_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    						newLeafNode(lv_feature_3_0, grammarAccess.getGetAccess().getFeatureIDTerminalRuleCall_1_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGetRule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"feature",
            	    							lv_feature_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


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
    // $ANTLR end "ruleGet"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:290:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:290:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:291:2: iv_ruleFormula= ruleFormula EOF
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
    // InternalFirstOrderLogic.g:297:1: ruleFormula returns [EObject current=null] : this_BinaryFormula_0= ruleBinaryFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryFormula_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:303:2: (this_BinaryFormula_0= ruleBinaryFormula )
            // InternalFirstOrderLogic.g:304:2: this_BinaryFormula_0= ruleBinaryFormula
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
    // InternalFirstOrderLogic.g:315:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:315:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:316:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:322:1: ruleBinaryFormula returns [EObject current=null] : this_If_0= ruleIf ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_If_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:328:2: (this_If_0= ruleIf )
            // InternalFirstOrderLogic.g:329:2: this_If_0= ruleIf
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
    // InternalFirstOrderLogic.g:340:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:340:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:341:2: iv_ruleIf= ruleIf EOF
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
    // InternalFirstOrderLogic.g:347:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:353:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:354:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:354:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:355:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_7);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:363:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:364:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:364:4: ()
            	    // InternalFirstOrderLogic.g:365:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:375:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:376:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:376:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:377:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_7);
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
            	    break loop2;
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
    // InternalFirstOrderLogic.g:399:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:399:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:400:2: iv_ruleXor= ruleXor EOF
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
    // InternalFirstOrderLogic.g:406:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:412:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:413:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:413:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:414:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_8);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:422:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:423:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:423:4: ()
            	    // InternalFirstOrderLogic.g:424:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,15,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:434:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:435:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:435:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:436:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_8);
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
            	    break loop3;
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
    // InternalFirstOrderLogic.g:458:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:458:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:459:2: iv_ruleOr= ruleOr EOF
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
    // InternalFirstOrderLogic.g:465:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:471:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:472:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:472:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:473:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_9);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:481:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:482:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:482:4: ()
            	    // InternalFirstOrderLogic.g:483:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:493:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:494:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:494:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:495:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_9);
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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:517:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:517:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:518:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalFirstOrderLogic.g:524:1: ruleAnd returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:530:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalFirstOrderLogic.g:531:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalFirstOrderLogic.g:531:2: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalFirstOrderLogic.g:532:3: this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_10);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:540:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:541:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalFirstOrderLogic.g:541:4: ()
            	    // InternalFirstOrderLogic.g:542:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:552:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalFirstOrderLogic.g:553:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalFirstOrderLogic.g:553:5: (lv_right_3_0= rulePrimary )
            	    // InternalFirstOrderLogic.g:554:6: lv_right_3_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightPrimaryParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_10);
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:576:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:576:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:577:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:583:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:589:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:590:2: this_Not_0= ruleNot
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
    // InternalFirstOrderLogic.g:601:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:601:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:602:2: iv_ruleNot= ruleNot EOF
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
    // InternalFirstOrderLogic.g:608:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_not_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:614:2: ( ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:615:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:615:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:616:3: () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')'
            {
            // InternalFirstOrderLogic.g:616:3: ()
            // InternalFirstOrderLogic.g:617:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            // InternalFirstOrderLogic.g:627:3: ( (lv_not_2_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:628:4: (lv_not_2_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:628:4: (lv_not_2_0= ruleFormula )
            // InternalFirstOrderLogic.g:629:5: lv_not_2_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,19,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:654:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:654:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:655:2: iv_ruleQuantifier= ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:661:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:667:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:668:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:668:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:669:3: this_ForAll_0= ruleForAll
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
                    // InternalFirstOrderLogic.g:678:3: this_Exists_1= ruleExists
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
    // InternalFirstOrderLogic.g:690:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:690:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:691:2: iv_ruleForAll= ruleForAll EOF
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
    // InternalFirstOrderLogic.g:697:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleForAll() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_bounded_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:703:2: ( ( () otherlv_1= 'forAll(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:704:2: ( () otherlv_1= 'forAll(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:704:2: ( () otherlv_1= 'forAll(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:705:3: () otherlv_1= 'forAll(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:705:3: ()
            // InternalFirstOrderLogic.g:706:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            // InternalFirstOrderLogic.g:716:3: ( (lv_bounded_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:717:4: (lv_bounded_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:717:4: (lv_bounded_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:718:5: lv_bounded_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getBoundedVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_bounded_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"bounded",
            						lv_bounded_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getForAllAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:739:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:740:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:740:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:741:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_5=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getForAllAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:762:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:763:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:763:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:764:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_7=(Token)match(input,19,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:789:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:789:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:790:2: iv_ruleExists= ruleExists EOF
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
    // InternalFirstOrderLogic.g:796:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleExists() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_bounded_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:802:2: ( ( () otherlv_1= 'exists(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:803:2: ( () otherlv_1= 'exists(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:803:2: ( () otherlv_1= 'exists(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:804:3: () otherlv_1= 'exists(' ( (lv_bounded_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:804:3: ()
            // InternalFirstOrderLogic.g:805:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            // InternalFirstOrderLogic.g:815:3: ( (lv_bounded_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:816:4: (lv_bounded_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:816:4: (lv_bounded_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:817:5: lv_bounded_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getBoundedVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_bounded_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"bounded",
            						lv_bounded_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getExistsAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:838:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:839:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:839:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:840:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_5=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getExistsAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:861:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:862:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:862:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:863:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_7=(Token)match(input,19,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:888:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalFirstOrderLogic.g:888:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalFirstOrderLogic.g:889:2: iv_rulePrimary= rulePrimary EOF
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
    // InternalFirstOrderLogic.g:895:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression ) ;
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
            // InternalFirstOrderLogic.g:901:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression ) )
            // InternalFirstOrderLogic.g:902:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression )
            {
            // InternalFirstOrderLogic.g:902:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_TerminalExpression_5= ruleTerminalExpression )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 18:
                {
                alt7=2;
                }
                break;
            case 20:
            case 22:
                {
                alt7=3;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 24:
            case 25:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:903:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:903:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:904:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_5); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_11);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:922:3: this_UnaryFormula_3= ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:931:3: this_Quantifier_4= ruleQuantifier
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
                    // InternalFirstOrderLogic.g:940:3: this_TerminalExpression_5= ruleTerminalExpression
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
    // InternalFirstOrderLogic.g:952:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalFirstOrderLogic.g:952:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalFirstOrderLogic.g:953:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
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
    // InternalFirstOrderLogic.g:959:1: ruleTerminalExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:965:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalFirstOrderLogic.g:966:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalFirstOrderLogic.g:966:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt9=1;
                }
                break;
            case RULE_STRING:
                {
                alt9=2;
                }
                break;
            case 24:
            case 25:
                {
                alt9=3;
                }
                break;
            case RULE_ID:
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
                    // InternalFirstOrderLogic.g:967:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalFirstOrderLogic.g:967:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalFirstOrderLogic.g:968:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalFirstOrderLogic.g:968:4: ()
                    // InternalFirstOrderLogic.g:969:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getIntConstantAction_0_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:975:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalFirstOrderLogic.g:976:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalFirstOrderLogic.g:976:5: (lv_value_1_0= RULE_INT )
                    // InternalFirstOrderLogic.g:977:6: lv_value_1_0= RULE_INT
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
                    // InternalFirstOrderLogic.g:995:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalFirstOrderLogic.g:995:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalFirstOrderLogic.g:996:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalFirstOrderLogic.g:996:4: ()
                    // InternalFirstOrderLogic.g:997:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1003:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalFirstOrderLogic.g:1004:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalFirstOrderLogic.g:1004:5: (lv_value_3_0= RULE_STRING )
                    // InternalFirstOrderLogic.g:1005:6: lv_value_3_0= RULE_STRING
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
                    // InternalFirstOrderLogic.g:1023:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalFirstOrderLogic.g:1023:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalFirstOrderLogic.g:1024:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalFirstOrderLogic.g:1024:4: ()
                    // InternalFirstOrderLogic.g:1025:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getBoolConstantAction_2_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1031:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalFirstOrderLogic.g:1032:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalFirstOrderLogic.g:1032:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalFirstOrderLogic.g:1033:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalFirstOrderLogic.g:1033:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==24) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==25) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalFirstOrderLogic.g:1034:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,24,FOLLOW_2); 

                            							newLeafNode(lv_value_5_1, grammarAccess.getTerminalExpressionAccess().getValueTrueKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTerminalExpressionRule());
                            							}
                            							setWithLastConsumed(current, "value", lv_value_5_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalFirstOrderLogic.g:1045:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,25,FOLLOW_2); 

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
                    // InternalFirstOrderLogic.g:1060:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalFirstOrderLogic.g:1060:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalFirstOrderLogic.g:1061:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalFirstOrderLogic.g:1061:4: ()
                    // InternalFirstOrderLogic.g:1062:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTerminalExpressionAccess().getVariableRefAction_3_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:1068:4: ( (otherlv_7= RULE_ID ) )
                    // InternalFirstOrderLogic.g:1069:5: (otherlv_7= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:1069:5: (otherlv_7= RULE_ID )
                    // InternalFirstOrderLogic.g:1070:6: otherlv_7= RULE_ID
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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003D40070L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});

}