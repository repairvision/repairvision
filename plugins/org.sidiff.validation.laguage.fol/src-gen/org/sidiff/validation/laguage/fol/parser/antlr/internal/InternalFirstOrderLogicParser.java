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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_INT", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not'", "'('", "')'", "'isEqual'", "','", "'isGreater'", "'isGreaterEqual'", "'isSmaller'", "'isSmallerEqual'", "'isEmpty'", "'isInstanceOf'", "'isValueLiteralOf'", "'forAll'", "'in'", "'exists'", "'.'", "'::'", "'getContainer'", "'getContainments'", "'getClosure'", "'size'", "'indexOf'", "'concatenate'", "'capitalize'", "'asClassifier'", "'asDataType'"
    };
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_SIGNED_INT=6;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
        	return "ConstraintLibrary";
       	}

       	@Override
       	protected FirstOrderLogicGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConstraintLibrary"
    // InternalFirstOrderLogic.g:64:1: entryRuleConstraintLibrary returns [EObject current=null] : iv_ruleConstraintLibrary= ruleConstraintLibrary EOF ;
    public final EObject entryRuleConstraintLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintLibrary = null;


        try {
            // InternalFirstOrderLogic.g:64:58: (iv_ruleConstraintLibrary= ruleConstraintLibrary EOF )
            // InternalFirstOrderLogic.g:65:2: iv_ruleConstraintLibrary= ruleConstraintLibrary EOF
            {
             newCompositeNode(grammarAccess.getConstraintLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintLibrary=ruleConstraintLibrary();

            state._fsp--;

             current =iv_ruleConstraintLibrary; 
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
    // $ANTLR end "entryRuleConstraintLibrary"


    // $ANTLR start "ruleConstraintLibrary"
    // InternalFirstOrderLogic.g:71:1: ruleConstraintLibrary returns [EObject current=null] : ( ( (lv_domains_0_0= ruleDomain ) )* ( (lv_constraints_1_0= ruleConstraint ) )* ) ;
    public final EObject ruleConstraintLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_domains_0_0 = null;

        EObject lv_constraints_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( ( ( (lv_domains_0_0= ruleDomain ) )* ( (lv_constraints_1_0= ruleConstraint ) )* ) )
            // InternalFirstOrderLogic.g:78:2: ( ( (lv_domains_0_0= ruleDomain ) )* ( (lv_constraints_1_0= ruleConstraint ) )* )
            {
            // InternalFirstOrderLogic.g:78:2: ( ( (lv_domains_0_0= ruleDomain ) )* ( (lv_constraints_1_0= ruleConstraint ) )* )
            // InternalFirstOrderLogic.g:79:3: ( (lv_domains_0_0= ruleDomain ) )* ( (lv_constraints_1_0= ruleConstraint ) )*
            {
            // InternalFirstOrderLogic.g:79:3: ( (lv_domains_0_0= ruleDomain ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:80:4: (lv_domains_0_0= ruleDomain )
            	    {
            	    // InternalFirstOrderLogic.g:80:4: (lv_domains_0_0= ruleDomain )
            	    // InternalFirstOrderLogic.g:81:5: lv_domains_0_0= ruleDomain
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintLibraryAccess().getDomainsDomainParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_domains_0_0=ruleDomain();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"domains",
            	    						lv_domains_0_0,
            	    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Domain");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalFirstOrderLogic.g:98:3: ( (lv_constraints_1_0= ruleConstraint ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:99:4: (lv_constraints_1_0= ruleConstraint )
            	    {
            	    // InternalFirstOrderLogic.g:99:4: (lv_constraints_1_0= ruleConstraint )
            	    // InternalFirstOrderLogic.g:100:5: lv_constraints_1_0= ruleConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_constraints_1_0=ruleConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_1_0,
            	    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constraint");
            	    					afterParserOrEnumRuleCall();
            	    				

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
    // $ANTLR end "ruleConstraintLibrary"


    // $ANTLR start "entryRuleDomain"
    // InternalFirstOrderLogic.g:121:1: entryRuleDomain returns [EObject current=null] : iv_ruleDomain= ruleDomain EOF ;
    public final EObject entryRuleDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomain = null;


        try {
            // InternalFirstOrderLogic.g:121:47: (iv_ruleDomain= ruleDomain EOF )
            // InternalFirstOrderLogic.g:122:2: iv_ruleDomain= ruleDomain EOF
            {
             newCompositeNode(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomain=ruleDomain();

            state._fsp--;

             current =iv_ruleDomain; 
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
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // InternalFirstOrderLogic.g:128:1: ruleDomain returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domain_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:134:2: ( (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ) )
            // InternalFirstOrderLogic.g:135:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) )
            {
            // InternalFirstOrderLogic.g:135:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) )
            // InternalFirstOrderLogic.g:136:3: otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDomainAccess().getDomainKeyword_0());
            		
            // InternalFirstOrderLogic.g:140:3: ( (lv_domain_1_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:141:4: (lv_domain_1_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:141:4: (lv_domain_1_0= RULE_STRING )
            // InternalFirstOrderLogic.g:142:5: lv_domain_1_0= RULE_STRING
            {
            lv_domain_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_domain_1_0, grammarAccess.getDomainAccess().getDomainSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDomainRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domain",
            						lv_domain_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:162:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalFirstOrderLogic.g:162:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalFirstOrderLogic.g:163:2: iv_ruleConstraint= ruleConstraint EOF
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
    // InternalFirstOrderLogic.g:169:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) ;
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
            // InternalFirstOrderLogic.g:175:2: ( (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:176:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:176:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:177:3: otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getConstraintKeyword_0());
            		
            // InternalFirstOrderLogic.g:181:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:182:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:182:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:183:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getMessageKeyword_2());
            		
            // InternalFirstOrderLogic.g:203:3: ( (lv_message_3_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:204:4: (lv_message_3_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:204:4: (lv_message_3_0= RULE_STRING )
            // InternalFirstOrderLogic.g:205:5: lv_message_3_0= RULE_STRING
            {
            lv_message_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

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

            otherlv_4=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getContextKeyword_4());
            		
            // InternalFirstOrderLogic.g:225:3: ( (lv_variable_5_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:226:4: (lv_variable_5_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:226:4: (lv_variable_5_0= ruleVariable )
            // InternalFirstOrderLogic.g:227:5: lv_variable_5_0= ruleVariable
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

            otherlv_6=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:248:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:249:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:249:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:250:5: lv_formula_7_0= ruleFormula
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
    // InternalFirstOrderLogic.g:271:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:271:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:272:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalFirstOrderLogic.g:278:1: ruleVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:284:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFirstOrderLogic.g:285:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFirstOrderLogic.g:285:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:286:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:286:3: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:287:4: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:287:4: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:288:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:300:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:301:5: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:321:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:321:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:322:2: iv_ruleFormula= ruleFormula EOF
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
    // InternalFirstOrderLogic.g:328:1: ruleFormula returns [EObject current=null] : this_BinaryFormula_0= ruleBinaryFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryFormula_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:334:2: (this_BinaryFormula_0= ruleBinaryFormula )
            // InternalFirstOrderLogic.g:335:2: this_BinaryFormula_0= ruleBinaryFormula
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
    // InternalFirstOrderLogic.g:346:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:346:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:347:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:353:1: ruleBinaryFormula returns [EObject current=null] : this_Iff_0= ruleIff ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Iff_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:359:2: (this_Iff_0= ruleIff )
            // InternalFirstOrderLogic.g:360:2: this_Iff_0= ruleIff
            {

            		newCompositeNode(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall());
            	
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
    // $ANTLR end "ruleBinaryFormula"


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:371:1: entryRuleIff returns [EObject current=null] : iv_ruleIff= ruleIff EOF ;
    public final EObject entryRuleIff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIff = null;


        try {
            // InternalFirstOrderLogic.g:371:44: (iv_ruleIff= ruleIff EOF )
            // InternalFirstOrderLogic.g:372:2: iv_ruleIff= ruleIff EOF
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
    // InternalFirstOrderLogic.g:378:1: ruleIff returns [EObject current=null] : (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) ;
    public final EObject ruleIff() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_If_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:384:2: ( (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) )
            // InternalFirstOrderLogic.g:385:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            {
            // InternalFirstOrderLogic.g:385:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            // InternalFirstOrderLogic.g:386:3: this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            {

            			newCompositeNode(grammarAccess.getIffAccess().getIfParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_If_0=ruleIf();

            state._fsp--;


            			current = this_If_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:394:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:395:4: () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) )
            	    {
            	    // InternalFirstOrderLogic.g:395:4: ()
            	    // InternalFirstOrderLogic.g:396:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIffAccess().getIffLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIffAccess().getEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:406:4: ( (lv_right_3_0= ruleIf ) )
            	    // InternalFirstOrderLogic.g:407:5: (lv_right_3_0= ruleIf )
            	    {
            	    // InternalFirstOrderLogic.g:407:5: (lv_right_3_0= ruleIf )
            	    // InternalFirstOrderLogic.g:408:6: lv_right_3_0= ruleIf
            	    {

            	    						newCompositeNode(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=ruleIf();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIffRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.If");
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
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:430:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:430:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:431:2: iv_ruleIf= ruleIf EOF
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
    // InternalFirstOrderLogic.g:437:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:443:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:444:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:444:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:445:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:453:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:454:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:454:4: ()
            	    // InternalFirstOrderLogic.g:455:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:465:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:466:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:466:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:467:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
    // InternalFirstOrderLogic.g:489:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:489:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:490:2: iv_ruleXor= ruleXor EOF
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
    // InternalFirstOrderLogic.g:496:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:502:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:503:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:503:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:504:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:512:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:513:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:513:4: ()
            	    // InternalFirstOrderLogic.g:514:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:524:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:525:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:525:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:526:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
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
    // InternalFirstOrderLogic.g:548:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:548:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:549:2: iv_ruleOr= ruleOr EOF
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
    // InternalFirstOrderLogic.g:555:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:561:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:562:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:562:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:563:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:571:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:572:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:572:4: ()
            	    // InternalFirstOrderLogic.g:573:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:583:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:584:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:584:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:585:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:607:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:607:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:608:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalFirstOrderLogic.g:614:1: ruleAnd returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:620:2: ( (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) )
            // InternalFirstOrderLogic.g:621:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            {
            // InternalFirstOrderLogic.g:621:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            // InternalFirstOrderLogic.g:622:3: this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;


            			current = this_BooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:630:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:631:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) )
            	    {
            	    // InternalFirstOrderLogic.g:631:4: ()
            	    // InternalFirstOrderLogic.g:632:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:642:4: ( (lv_right_3_0= ruleBooleanExpression ) )
            	    // InternalFirstOrderLogic.g:643:5: (lv_right_3_0= ruleBooleanExpression )
            	    {
            	    // InternalFirstOrderLogic.g:643:5: (lv_right_3_0= ruleBooleanExpression )
            	    // InternalFirstOrderLogic.g:644:6: lv_right_3_0= ruleBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleBooleanExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.BooleanExpression");
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
    // InternalFirstOrderLogic.g:666:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:666:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:667:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:673:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:679:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:680:2: this_Not_0= ruleNot
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
    // InternalFirstOrderLogic.g:691:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:691:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:692:2: iv_ruleNot= ruleNot EOF
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
    // InternalFirstOrderLogic.g:698:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_not_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:704:2: ( ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:705:2: ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:705:2: ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:706:3: () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')'
            {
            // InternalFirstOrderLogic.g:706:3: ()
            // InternalFirstOrderLogic.g:707:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getNotAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:721:3: ( (lv_not_3_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:722:4: (lv_not_3_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:722:4: (lv_not_3_0= ruleFormula )
            // InternalFirstOrderLogic.g:723:5: lv_not_3_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_17);
            lv_not_3_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotRule());
            					}
            					set(
            						current,
            						"not",
            						lv_not_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getNotAccess().getRightParenthesisKeyword_4());
            		

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
    // InternalFirstOrderLogic.g:748:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalFirstOrderLogic.g:748:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalFirstOrderLogic.g:749:2: iv_rulePredicate= rulePredicate EOF
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
    // InternalFirstOrderLogic.g:755:1: rulePredicate returns [EObject current=null] : (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        EObject this_Equals_0 = null;

        EObject this_Inequality_1 = null;

        EObject this_IsEmpty_2 = null;

        EObject this_IsInstanceOf_3 = null;

        EObject this_IsValueLiteralOf_4 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:761:2: ( (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf ) )
            // InternalFirstOrderLogic.g:762:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf )
            {
            // InternalFirstOrderLogic.g:762:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt8=1;
                }
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt8=2;
                }
                break;
            case 32:
                {
                alt8=3;
                }
                break;
            case 33:
                {
                alt8=4;
                }
                break;
            case 34:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:763:3: this_Equals_0= ruleEquals
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
                    // InternalFirstOrderLogic.g:772:3: this_Inequality_1= ruleInequality
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Inequality_1=ruleInequality();

                    state._fsp--;


                    			current = this_Inequality_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:781:3: this_IsEmpty_2= ruleIsEmpty
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsEmpty_2=ruleIsEmpty();

                    state._fsp--;


                    			current = this_IsEmpty_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:790:3: this_IsInstanceOf_3= ruleIsInstanceOf
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsInstanceOf_3=ruleIsInstanceOf();

                    state._fsp--;


                    			current = this_IsInstanceOf_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:799:3: this_IsValueLiteralOf_4= ruleIsValueLiteralOf
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsValueLiteralOfParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsValueLiteralOf_4=ruleIsValueLiteralOf();

                    state._fsp--;


                    			current = this_IsValueLiteralOf_4;
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
    // InternalFirstOrderLogic.g:811:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalFirstOrderLogic.g:811:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalFirstOrderLogic.g:812:2: iv_ruleEquals= ruleEquals EOF
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
    // InternalFirstOrderLogic.g:818:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:824:2: ( (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:825:2: (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:825:2: (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:826:3: otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getIsEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getEqualsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:834:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:835:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:835:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:836:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEqualsRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getEqualsAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:857:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:858:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:858:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:859:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEqualsRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getEqualsAccess().getRightParenthesisKeyword_5());
            		

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


    // $ANTLR start "entryRuleInequality"
    // InternalFirstOrderLogic.g:884:1: entryRuleInequality returns [EObject current=null] : iv_ruleInequality= ruleInequality EOF ;
    public final EObject entryRuleInequality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInequality = null;


        try {
            // InternalFirstOrderLogic.g:884:51: (iv_ruleInequality= ruleInequality EOF )
            // InternalFirstOrderLogic.g:885:2: iv_ruleInequality= ruleInequality EOF
            {
             newCompositeNode(grammarAccess.getInequalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInequality=ruleInequality();

            state._fsp--;

             current =iv_ruleInequality; 
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
    // $ANTLR end "entryRuleInequality"


    // $ANTLR start "ruleInequality"
    // InternalFirstOrderLogic.g:891:1: ruleInequality returns [EObject current=null] : (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) ;
    public final EObject ruleInequality() throws RecognitionException {
        EObject current = null;

        EObject this_Greater_0 = null;

        EObject this_GreaterEqual_1 = null;

        EObject this_Smaller_2 = null;

        EObject this_SmallerEqual_3 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:897:2: ( (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) )
            // InternalFirstOrderLogic.g:898:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            {
            // InternalFirstOrderLogic.g:898:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt9=1;
                }
                break;
            case 29:
                {
                alt9=2;
                }
                break;
            case 30:
                {
                alt9=3;
                }
                break;
            case 31:
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
                    // InternalFirstOrderLogic.g:899:3: this_Greater_0= ruleGreater
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Greater_0=ruleGreater();

                    state._fsp--;


                    			current = this_Greater_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:908:3: this_GreaterEqual_1= ruleGreaterEqual
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_GreaterEqual_1=ruleGreaterEqual();

                    state._fsp--;


                    			current = this_GreaterEqual_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:917:3: this_Smaller_2= ruleSmaller
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Smaller_2=ruleSmaller();

                    state._fsp--;


                    			current = this_Smaller_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:926:3: this_SmallerEqual_3= ruleSmallerEqual
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SmallerEqual_3=ruleSmallerEqual();

                    state._fsp--;


                    			current = this_SmallerEqual_3;
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
    // $ANTLR end "ruleInequality"


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:938:1: entryRuleGreater returns [EObject current=null] : iv_ruleGreater= ruleGreater EOF ;
    public final EObject entryRuleGreater() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreater = null;


        try {
            // InternalFirstOrderLogic.g:938:48: (iv_ruleGreater= ruleGreater EOF )
            // InternalFirstOrderLogic.g:939:2: iv_ruleGreater= ruleGreater EOF
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
    // InternalFirstOrderLogic.g:945:1: ruleGreater returns [EObject current=null] : (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleGreater() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:951:2: ( (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:952:2: (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:952:2: (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:953:3: otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterAccess().getIsGreaterKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getGreaterAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:961:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:962:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:962:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:963:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getGreaterAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:984:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:985:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:985:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:986:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getGreaterAccess().getRightParenthesisKeyword_5());
            		

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
    // InternalFirstOrderLogic.g:1011:1: entryRuleGreaterEqual returns [EObject current=null] : iv_ruleGreaterEqual= ruleGreaterEqual EOF ;
    public final EObject entryRuleGreaterEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterEqual = null;


        try {
            // InternalFirstOrderLogic.g:1011:53: (iv_ruleGreaterEqual= ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:1012:2: iv_ruleGreaterEqual= ruleGreaterEqual EOF
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
    // InternalFirstOrderLogic.g:1018:1: ruleGreaterEqual returns [EObject current=null] : (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleGreaterEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1024:2: ( (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1025:2: (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1025:2: (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1026:3: otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getGreaterEqualAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1034:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1035:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1035:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1036:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getGreaterEqualAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1057:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1058:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1058:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1059:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_5());
            		

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
    // InternalFirstOrderLogic.g:1084:1: entryRuleSmaller returns [EObject current=null] : iv_ruleSmaller= ruleSmaller EOF ;
    public final EObject entryRuleSmaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmaller = null;


        try {
            // InternalFirstOrderLogic.g:1084:48: (iv_ruleSmaller= ruleSmaller EOF )
            // InternalFirstOrderLogic.g:1085:2: iv_ruleSmaller= ruleSmaller EOF
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
    // InternalFirstOrderLogic.g:1091:1: ruleSmaller returns [EObject current=null] : (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleSmaller() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1097:2: ( (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1098:2: (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1098:2: (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1099:3: otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerAccess().getIsSmallerKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getSmallerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1107:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1108:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1108:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1109:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getSmallerAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1130:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1131:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1131:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1132:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSmallerAccess().getRightParenthesisKeyword_5());
            		

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
    // InternalFirstOrderLogic.g:1157:1: entryRuleSmallerEqual returns [EObject current=null] : iv_ruleSmallerEqual= ruleSmallerEqual EOF ;
    public final EObject entryRuleSmallerEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmallerEqual = null;


        try {
            // InternalFirstOrderLogic.g:1157:53: (iv_ruleSmallerEqual= ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:1158:2: iv_ruleSmallerEqual= ruleSmallerEqual EOF
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
    // InternalFirstOrderLogic.g:1164:1: ruleSmallerEqual returns [EObject current=null] : (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleSmallerEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1170:2: ( (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1171:2: (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1171:2: (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1172:3: otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getSmallerEqualAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1180:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1181:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1181:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1182:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getSmallerEqualAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1203:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1204:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1204:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1205:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_5());
            		

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


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:1230:1: entryRuleIsEmpty returns [EObject current=null] : iv_ruleIsEmpty= ruleIsEmpty EOF ;
    public final EObject entryRuleIsEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsEmpty = null;


        try {
            // InternalFirstOrderLogic.g:1230:48: (iv_ruleIsEmpty= ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:1231:2: iv_ruleIsEmpty= ruleIsEmpty EOF
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
    // InternalFirstOrderLogic.g:1237:1: ruleIsEmpty returns [EObject current=null] : (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleIsEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1243:2: ( (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:1244:2: (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:1244:2: (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:1245:3: otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getIsEmptyAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1253:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1254:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1254:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1255:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_term_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsEmptyRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_3());
            		

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


    // $ANTLR start "entryRuleIsInstanceOf"
    // InternalFirstOrderLogic.g:1280:1: entryRuleIsInstanceOf returns [EObject current=null] : iv_ruleIsInstanceOf= ruleIsInstanceOf EOF ;
    public final EObject entryRuleIsInstanceOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsInstanceOf = null;


        try {
            // InternalFirstOrderLogic.g:1280:53: (iv_ruleIsInstanceOf= ruleIsInstanceOf EOF )
            // InternalFirstOrderLogic.g:1281:2: iv_ruleIsInstanceOf= ruleIsInstanceOf EOF
            {
             newCompositeNode(grammarAccess.getIsInstanceOfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsInstanceOf=ruleIsInstanceOf();

            state._fsp--;

             current =iv_ruleIsInstanceOf; 
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
    // $ANTLR end "entryRuleIsInstanceOf"


    // $ANTLR start "ruleIsInstanceOf"
    // InternalFirstOrderLogic.g:1287:1: ruleIsInstanceOf returns [EObject current=null] : (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleClassifier ) ) otherlv_5= ')' ) ;
    public final EObject ruleIsInstanceOf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_term_2_0 = null;

        EObject lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1293:2: ( (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleClassifier ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1294:2: (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleClassifier ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1294:2: (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleClassifier ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1295:3: otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleClassifier ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getIsInstanceOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1303:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1304:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1304:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1305:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_term_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsInstanceOfRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getIsInstanceOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1326:3: ( (lv_type_4_0= ruleClassifier ) )
            // InternalFirstOrderLogic.g:1327:4: (lv_type_4_0= ruleClassifier )
            {
            // InternalFirstOrderLogic.g:1327:4: (lv_type_4_0= ruleClassifier )
            // InternalFirstOrderLogic.g:1328:5: lv_type_4_0= ruleClassifier
            {

            					newCompositeNode(grammarAccess.getIsInstanceOfAccess().getTypeClassifierParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_type_4_0=ruleClassifier();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsInstanceOfRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Classifier");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleIsInstanceOf"


    // $ANTLR start "entryRuleIsValueLiteralOf"
    // InternalFirstOrderLogic.g:1353:1: entryRuleIsValueLiteralOf returns [EObject current=null] : iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF ;
    public final EObject entryRuleIsValueLiteralOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsValueLiteralOf = null;


        try {
            // InternalFirstOrderLogic.g:1353:57: (iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF )
            // InternalFirstOrderLogic.g:1354:2: iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF
            {
             newCompositeNode(grammarAccess.getIsValueLiteralOfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsValueLiteralOf=ruleIsValueLiteralOf();

            state._fsp--;

             current =iv_ruleIsValueLiteralOf; 
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
    // $ANTLR end "entryRuleIsValueLiteralOf"


    // $ANTLR start "ruleIsValueLiteralOf"
    // InternalFirstOrderLogic.g:1360:1: ruleIsValueLiteralOf returns [EObject current=null] : (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleDataType ) ) otherlv_5= ')' ) ;
    public final EObject ruleIsValueLiteralOf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_term_2_0 = null;

        EObject lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1366:2: ( (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleDataType ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1367:2: (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleDataType ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1367:2: (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleDataType ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1368:3: otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleDataType ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getIsValueLiteralOfAccess().getIsValueLiteralOfKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getIsValueLiteralOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1376:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1377:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1377:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1378:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsValueLiteralOfAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_term_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsValueLiteralOfRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getIsValueLiteralOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1399:3: ( (lv_type_4_0= ruleDataType ) )
            // InternalFirstOrderLogic.g:1400:4: (lv_type_4_0= ruleDataType )
            {
            // InternalFirstOrderLogic.g:1400:4: (lv_type_4_0= ruleDataType )
            // InternalFirstOrderLogic.g:1401:5: lv_type_4_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getIsValueLiteralOfAccess().getTypeDataTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_type_4_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsValueLiteralOfRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getIsValueLiteralOfAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleIsValueLiteralOf"


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:1426:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:1426:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:1427:2: iv_ruleQuantifier= ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:1433:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1439:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:1440:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:1440:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==35) ) {
                alt10=1;
            }
            else if ( (LA10_0==37) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalFirstOrderLogic.g:1441:3: this_ForAll_0= ruleForAll
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
                    // InternalFirstOrderLogic.g:1450:3: this_Exists_1= ruleExists
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
    // InternalFirstOrderLogic.g:1462:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:1462:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:1463:2: iv_ruleForAll= ruleForAll EOF
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
    // InternalFirstOrderLogic.g:1469:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) ;
    public final EObject ruleForAll() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_name_3_0 = null;

        EObject lv_iteration_5_0 = null;

        EObject lv_formula_7_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1475:2: ( ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) )
            // InternalFirstOrderLogic.g:1476:2: ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            {
            // InternalFirstOrderLogic.g:1476:2: ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            // InternalFirstOrderLogic.g:1477:3: () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')'
            {
            // InternalFirstOrderLogic.g:1477:3: ()
            // InternalFirstOrderLogic.g:1478:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getForAllAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:1492:3: ( (lv_name_3_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1493:4: (lv_name_3_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1493:4: (lv_name_3_0= ruleVariable )
            // InternalFirstOrderLogic.g:1494:5: lv_name_3_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_22);
            lv_name_3_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getForAllAccess().getInKeyword_4());
            		
            // InternalFirstOrderLogic.g:1515:3: ( (lv_iteration_5_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1516:4: (lv_iteration_5_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1516:4: (lv_iteration_5_0= ruleTerm )
            // InternalFirstOrderLogic.g:1517:5: lv_iteration_5_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_5_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_5_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getForAllAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:1538:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1539:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1539:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:1540:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_17);
            lv_formula_7_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_7_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getForAllAccess().getRightParenthesisKeyword_8());
            		

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
    // InternalFirstOrderLogic.g:1565:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:1565:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:1566:2: iv_ruleExists= ruleExists EOF
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
    // InternalFirstOrderLogic.g:1572:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) ;
    public final EObject ruleExists() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_name_3_0 = null;

        EObject lv_iteration_5_0 = null;

        EObject lv_formula_7_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1578:2: ( ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) )
            // InternalFirstOrderLogic.g:1579:2: ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            {
            // InternalFirstOrderLogic.g:1579:2: ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            // InternalFirstOrderLogic.g:1580:3: () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')'
            {
            // InternalFirstOrderLogic.g:1580:3: ()
            // InternalFirstOrderLogic.g:1581:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getExistsAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:1595:3: ( (lv_name_3_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1596:4: (lv_name_3_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1596:4: (lv_name_3_0= ruleVariable )
            // InternalFirstOrderLogic.g:1597:5: lv_name_3_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_22);
            lv_name_3_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getExistsAccess().getInKeyword_4());
            		
            // InternalFirstOrderLogic.g:1618:3: ( (lv_iteration_5_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1619:4: (lv_iteration_5_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1619:4: (lv_iteration_5_0= ruleTerm )
            // InternalFirstOrderLogic.g:1620:5: lv_iteration_5_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_5_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_5_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getExistsAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:1641:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1642:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1642:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:1643:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_17);
            lv_formula_7_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_7_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getExistsAccess().getRightParenthesisKeyword_8());
            		

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


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalFirstOrderLogic.g:1668:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalFirstOrderLogic.g:1668:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:1669:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;

             current =iv_ruleBooleanExpression; 
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
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalFirstOrderLogic.g:1675:1: ruleBooleanExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Formula_1 = null;

        EObject this_UnaryFormula_3 = null;

        EObject this_Quantifier_4 = null;

        EObject this_Predicate_5 = null;

        EObject this_BoolConstant_6 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1681:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) )
            // InternalFirstOrderLogic.g:1682:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            {
            // InternalFirstOrderLogic.g:1682:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt11=1;
                }
                break;
            case 23:
                {
                alt11=2;
                }
                break;
            case 35:
            case 37:
                {
                alt11=3;
                }
                break;
            case 26:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt11=4;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalFirstOrderLogic.g:1683:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:1683:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:1684:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_10); 

                    				newLeafNode(otherlv_0, grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_17);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1702:3: this_UnaryFormula_3= ruleUnaryFormula
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryFormula_3=ruleUnaryFormula();

                    state._fsp--;


                    			current = this_UnaryFormula_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1711:3: this_Quantifier_4= ruleQuantifier
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Quantifier_4=ruleQuantifier();

                    state._fsp--;


                    			current = this_Quantifier_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1720:3: this_Predicate_5= rulePredicate
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Predicate_5=rulePredicate();

                    state._fsp--;


                    			current = this_Predicate_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1729:3: this_BoolConstant_6= ruleBoolConstant
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_6=ruleBoolConstant();

                    state._fsp--;


                    			current = this_BoolConstant_6;
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
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:1741:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:1741:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:1742:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalFirstOrderLogic.g:1748:1: ruleTerm returns [EObject current=null] : (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_IndexOf_6= ruleIndexOf | this_Concatenate_7= ruleConcatenate | this_Capitalize_8= ruleCapitalize ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_VariableRef_1 = null;

        EObject this_GetContainments_2 = null;

        EObject this_GetContainer_3 = null;

        EObject this_GetClosure_4 = null;

        EObject this_Size_5 = null;

        EObject this_IndexOf_6 = null;

        EObject this_Concatenate_7 = null;

        EObject this_Capitalize_8 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1754:2: ( (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_IndexOf_6= ruleIndexOf | this_Concatenate_7= ruleConcatenate | this_Capitalize_8= ruleCapitalize ) )
            // InternalFirstOrderLogic.g:1755:2: (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_IndexOf_6= ruleIndexOf | this_Concatenate_7= ruleConcatenate | this_Capitalize_8= ruleCapitalize )
            {
            // InternalFirstOrderLogic.g:1755:2: (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_IndexOf_6= ruleIndexOf | this_Concatenate_7= ruleConcatenate | this_Capitalize_8= ruleCapitalize )
            int alt12=9;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_SIGNED_INT:
            case RULE_BOOLEAN:
                {
                alt12=1;
                }
                break;
            case RULE_ID:
                {
                alt12=2;
                }
                break;
            case 41:
                {
                alt12=3;
                }
                break;
            case 40:
                {
                alt12=4;
                }
                break;
            case 42:
                {
                alt12=5;
                }
                break;
            case 43:
                {
                alt12=6;
                }
                break;
            case 44:
                {
                alt12=7;
                }
                break;
            case 45:
                {
                alt12=8;
                }
                break;
            case 46:
                {
                alt12=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalFirstOrderLogic.g:1756:3: this_Constant_0= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_0=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1765:3: this_VariableRef_1= ruleVariableRef
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableRef_1=ruleVariableRef();

                    state._fsp--;


                    			current = this_VariableRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1774:3: this_GetContainments_2= ruleGetContainments
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetContainments_2=ruleGetContainments();

                    state._fsp--;


                    			current = this_GetContainments_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1783:3: this_GetContainer_3= ruleGetContainer
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetContainer_3=ruleGetContainer();

                    state._fsp--;


                    			current = this_GetContainer_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1792:3: this_GetClosure_4= ruleGetClosure
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetClosure_4=ruleGetClosure();

                    state._fsp--;


                    			current = this_GetClosure_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1801:3: this_Size_5= ruleSize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getSizeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Size_5=ruleSize();

                    state._fsp--;


                    			current = this_Size_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalFirstOrderLogic.g:1810:3: this_IndexOf_6= ruleIndexOf
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getIndexOfParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_IndexOf_6=ruleIndexOf();

                    state._fsp--;


                    			current = this_IndexOf_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalFirstOrderLogic.g:1819:3: this_Concatenate_7= ruleConcatenate
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConcatenateParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concatenate_7=ruleConcatenate();

                    state._fsp--;


                    			current = this_Concatenate_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalFirstOrderLogic.g:1828:3: this_Capitalize_8= ruleCapitalize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Capitalize_8=ruleCapitalize();

                    state._fsp--;


                    			current = this_Capitalize_8;
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:1840:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalFirstOrderLogic.g:1840:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:1841:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
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
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalFirstOrderLogic.g:1847:1: ruleVariableRef returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_get_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1853:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:1854:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:1854:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:1855:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )?
            {
            // InternalFirstOrderLogic.g:1855:3: ()
            // InternalFirstOrderLogic.g:1856:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            // InternalFirstOrderLogic.g:1862:3: ( (otherlv_1= RULE_ID ) )
            // InternalFirstOrderLogic.g:1863:4: (otherlv_1= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1863:4: (otherlv_1= RULE_ID )
            // InternalFirstOrderLogic.g:1864:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_1, grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:1875:3: ( (lv_get_2_0= ruleGet ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalFirstOrderLogic.g:1876:4: (lv_get_2_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:1876:4: (lv_get_2_0= ruleGet )
                    // InternalFirstOrderLogic.g:1877:5: lv_get_2_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_get_2_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVariableRefRule());
                    					}
                    					set(
                    						current,
                    						"get",
                    						lv_get_2_0,
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
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:1898:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:1898:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:1899:2: iv_ruleGet= ruleGet EOF
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
    // InternalFirstOrderLogic.g:1905:1: ruleGet returns [EObject current=null] : (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_next_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1911:2: ( (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:1912:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:1912:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:1913:3: otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
            		
            // InternalFirstOrderLogic.g:1917:3: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==39) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:1918:4: ( (otherlv_1= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalFirstOrderLogic.g:1918:4: ( (otherlv_1= RULE_ID ) )
                    // InternalFirstOrderLogic.g:1919:5: (otherlv_1= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:1919:5: (otherlv_1= RULE_ID )
                    // InternalFirstOrderLogic.g:1920:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGetRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_24); 

                    						newLeafNode(otherlv_1, grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:1936:3: ( (otherlv_3= RULE_ID ) )
            // InternalFirstOrderLogic.g:1937:4: (otherlv_3= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1937:4: (otherlv_3= RULE_ID )
            // InternalFirstOrderLogic.g:1938:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_3, grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:1949:3: ( (lv_next_4_0= ruleGet ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFirstOrderLogic.g:1950:4: (lv_next_4_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:1950:4: (lv_next_4_0= ruleGet )
                    // InternalFirstOrderLogic.g:1951:5: lv_next_4_0= ruleGet
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


    // $ANTLR start "entryRuleGetContainer"
    // InternalFirstOrderLogic.g:1972:1: entryRuleGetContainer returns [EObject current=null] : iv_ruleGetContainer= ruleGetContainer EOF ;
    public final EObject entryRuleGetContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainer = null;


        try {
            // InternalFirstOrderLogic.g:1972:53: (iv_ruleGetContainer= ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:1973:2: iv_ruleGetContainer= ruleGetContainer EOF
            {
             newCompositeNode(grammarAccess.getGetContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetContainer=ruleGetContainer();

            state._fsp--;

             current =iv_ruleGetContainer; 
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
    // $ANTLR end "entryRuleGetContainer"


    // $ANTLR start "ruleGetContainer"
    // InternalFirstOrderLogic.g:1979:1: ruleGetContainer returns [EObject current=null] : (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleGetContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_element_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1985:2: ( (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:1986:2: (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:1986:2: (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:1987:3: otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainerAccess().getGetContainerKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getGetContainerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1995:3: ( (lv_element_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1996:4: (lv_element_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1996:4: (lv_element_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1997:5: lv_element_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_element_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetContainerRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleGetContainer"


    // $ANTLR start "entryRuleGetContainments"
    // InternalFirstOrderLogic.g:2022:1: entryRuleGetContainments returns [EObject current=null] : iv_ruleGetContainments= ruleGetContainments EOF ;
    public final EObject entryRuleGetContainments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainments = null;


        try {
            // InternalFirstOrderLogic.g:2022:56: (iv_ruleGetContainments= ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:2023:2: iv_ruleGetContainments= ruleGetContainments EOF
            {
             newCompositeNode(grammarAccess.getGetContainmentsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetContainments=ruleGetContainments();

            state._fsp--;

             current =iv_ruleGetContainments; 
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
    // $ANTLR end "entryRuleGetContainments"


    // $ANTLR start "ruleGetContainments"
    // InternalFirstOrderLogic.g:2029:1: ruleGetContainments returns [EObject current=null] : (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleGetContainments() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_element_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2035:2: ( (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2036:2: (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2036:2: (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2037:3: otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getGetContainmentsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2045:3: ( (lv_element_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2046:4: (lv_element_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2046:4: (lv_element_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2047:5: lv_element_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_element_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetContainmentsRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleGetContainments"


    // $ANTLR start "entryRuleGetClosure"
    // InternalFirstOrderLogic.g:2072:1: entryRuleGetClosure returns [EObject current=null] : iv_ruleGetClosure= ruleGetClosure EOF ;
    public final EObject entryRuleGetClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetClosure = null;


        try {
            // InternalFirstOrderLogic.g:2072:51: (iv_ruleGetClosure= ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:2073:2: iv_ruleGetClosure= ruleGetClosure EOF
            {
             newCompositeNode(grammarAccess.getGetClosureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetClosure=ruleGetClosure();

            state._fsp--;

             current =iv_ruleGetClosure; 
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
    // $ANTLR end "entryRuleGetClosure"


    // $ANTLR start "ruleGetClosure"
    // InternalFirstOrderLogic.g:2079:1: ruleGetClosure returns [EObject current=null] : (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ')' ) ;
    public final EObject ruleGetClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_element_2_0 = null;

        EObject lv_feature_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2085:2: ( (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:2086:2: (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:2086:2: (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:2087:3: otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getGetClosureAccess().getGetClosureKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getGetClosureAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2095:3: ( (lv_element_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2096:4: (lv_element_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2096:4: (lv_element_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2097:5: lv_element_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_element_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getGetClosureAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2118:3: ( (lv_feature_4_0= ruleFeatureConstant ) )
            // InternalFirstOrderLogic.g:2119:4: (lv_feature_4_0= ruleFeatureConstant )
            {
            // InternalFirstOrderLogic.g:2119:4: (lv_feature_4_0= ruleFeatureConstant )
            // InternalFirstOrderLogic.g:2120:5: lv_feature_4_0= ruleFeatureConstant
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getFeatureFeatureConstantParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_feature_4_0=ruleFeatureConstant();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"feature",
            						lv_feature_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.FeatureConstant");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleGetClosure"


    // $ANTLR start "entryRuleSize"
    // InternalFirstOrderLogic.g:2145:1: entryRuleSize returns [EObject current=null] : iv_ruleSize= ruleSize EOF ;
    public final EObject entryRuleSize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSize = null;


        try {
            // InternalFirstOrderLogic.g:2145:45: (iv_ruleSize= ruleSize EOF )
            // InternalFirstOrderLogic.g:2146:2: iv_ruleSize= ruleSize EOF
            {
             newCompositeNode(grammarAccess.getSizeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSize=ruleSize();

            state._fsp--;

             current =iv_ruleSize; 
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
    // $ANTLR end "entryRuleSize"


    // $ANTLR start "ruleSize"
    // InternalFirstOrderLogic.g:2152:1: ruleSize returns [EObject current=null] : (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleSize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2158:2: ( (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2159:2: (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2159:2: (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2160:3: otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getSizeAccess().getSizeKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getSizeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2168:3: ( (lv_elements_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2169:4: (lv_elements_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2169:4: (lv_elements_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2170:5: lv_elements_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_elements_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSizeRule());
            					}
            					set(
            						current,
            						"elements",
            						lv_elements_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSizeAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleSize"


    // $ANTLR start "entryRuleIndexOf"
    // InternalFirstOrderLogic.g:2195:1: entryRuleIndexOf returns [EObject current=null] : iv_ruleIndexOf= ruleIndexOf EOF ;
    public final EObject entryRuleIndexOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexOf = null;


        try {
            // InternalFirstOrderLogic.g:2195:48: (iv_ruleIndexOf= ruleIndexOf EOF )
            // InternalFirstOrderLogic.g:2196:2: iv_ruleIndexOf= ruleIndexOf EOF
            {
             newCompositeNode(grammarAccess.getIndexOfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndexOf=ruleIndexOf();

            state._fsp--;

             current =iv_ruleIndexOf; 
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
    // $ANTLR end "entryRuleIndexOf"


    // $ANTLR start "ruleIndexOf"
    // InternalFirstOrderLogic.g:2202:1: ruleIndexOf returns [EObject current=null] : (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ',' ( (lv_element_6_0= ruleTerm ) ) otherlv_7= ')' ) ;
    public final EObject ruleIndexOf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_container_2_0 = null;

        EObject lv_feature_4_0 = null;

        EObject lv_element_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2208:2: ( (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ',' ( (lv_element_6_0= ruleTerm ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:2209:2: (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ',' ( (lv_element_6_0= ruleTerm ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:2209:2: (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ',' ( (lv_element_6_0= ruleTerm ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:2210:3: otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_feature_4_0= ruleFeatureConstant ) ) otherlv_5= ',' ( (lv_element_6_0= ruleTerm ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getIndexOfAccess().getIndexOfKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getIndexOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2218:3: ( (lv_container_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2219:4: (lv_container_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2219:4: (lv_container_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2220:5: lv_container_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIndexOfAccess().getContainerTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_container_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIndexOfRule());
            					}
            					set(
            						current,
            						"container",
            						lv_container_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getIndexOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2241:3: ( (lv_feature_4_0= ruleFeatureConstant ) )
            // InternalFirstOrderLogic.g:2242:4: (lv_feature_4_0= ruleFeatureConstant )
            {
            // InternalFirstOrderLogic.g:2242:4: (lv_feature_4_0= ruleFeatureConstant )
            // InternalFirstOrderLogic.g:2243:5: lv_feature_4_0= ruleFeatureConstant
            {

            					newCompositeNode(grammarAccess.getIndexOfAccess().getFeatureFeatureConstantParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_feature_4_0=ruleFeatureConstant();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIndexOfRule());
            					}
            					set(
            						current,
            						"feature",
            						lv_feature_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.FeatureConstant");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getIndexOfAccess().getCommaKeyword_5());
            		
            // InternalFirstOrderLogic.g:2264:3: ( (lv_element_6_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2265:4: (lv_element_6_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2265:4: (lv_element_6_0= ruleTerm )
            // InternalFirstOrderLogic.g:2266:5: lv_element_6_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_17);
            lv_element_6_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIndexOfRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleIndexOf"


    // $ANTLR start "entryRuleConcatenate"
    // InternalFirstOrderLogic.g:2291:1: entryRuleConcatenate returns [EObject current=null] : iv_ruleConcatenate= ruleConcatenate EOF ;
    public final EObject entryRuleConcatenate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenate = null;


        try {
            // InternalFirstOrderLogic.g:2291:52: (iv_ruleConcatenate= ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:2292:2: iv_ruleConcatenate= ruleConcatenate EOF
            {
             newCompositeNode(grammarAccess.getConcatenateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcatenate=ruleConcatenate();

            state._fsp--;

             current =iv_ruleConcatenate; 
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
    // $ANTLR end "entryRuleConcatenate"


    // $ANTLR start "ruleConcatenate"
    // InternalFirstOrderLogic.g:2298:1: ruleConcatenate returns [EObject current=null] : (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleConcatenate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2304:2: ( (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:2305:2: (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:2305:2: (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:2306:3: otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatenateAccess().getConcatenateKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getConcatenateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2314:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2315:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2315:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2316:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcatenateRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getConcatenateAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2337:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2338:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2338:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:2339:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_right_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcatenateRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleConcatenate"


    // $ANTLR start "entryRuleCapitalize"
    // InternalFirstOrderLogic.g:2364:1: entryRuleCapitalize returns [EObject current=null] : iv_ruleCapitalize= ruleCapitalize EOF ;
    public final EObject entryRuleCapitalize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapitalize = null;


        try {
            // InternalFirstOrderLogic.g:2364:51: (iv_ruleCapitalize= ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:2365:2: iv_ruleCapitalize= ruleCapitalize EOF
            {
             newCompositeNode(grammarAccess.getCapitalizeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCapitalize=ruleCapitalize();

            state._fsp--;

             current =iv_ruleCapitalize; 
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
    // $ANTLR end "entryRuleCapitalize"


    // $ANTLR start "ruleCapitalize"
    // InternalFirstOrderLogic.g:2371:1: ruleCapitalize returns [EObject current=null] : (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleCapitalize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_string_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2377:2: ( (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2378:2: (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2378:2: (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2379:3: otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getCapitalizeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2387:3: ( (lv_string_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2388:4: (lv_string_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2388:4: (lv_string_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2389:5: lv_string_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_string_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCapitalizeRule());
            					}
            					set(
            						current,
            						"string",
            						lv_string_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleCapitalize"


    // $ANTLR start "entryRuleFeatureConstant"
    // InternalFirstOrderLogic.g:2414:1: entryRuleFeatureConstant returns [EObject current=null] : iv_ruleFeatureConstant= ruleFeatureConstant EOF ;
    public final EObject entryRuleFeatureConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureConstant = null;


        try {
            // InternalFirstOrderLogic.g:2414:56: (iv_ruleFeatureConstant= ruleFeatureConstant EOF )
            // InternalFirstOrderLogic.g:2415:2: iv_ruleFeatureConstant= ruleFeatureConstant EOF
            {
             newCompositeNode(grammarAccess.getFeatureConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureConstant=ruleFeatureConstant();

            state._fsp--;

             current =iv_ruleFeatureConstant; 
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
    // $ANTLR end "entryRuleFeatureConstant"


    // $ANTLR start "ruleFeatureConstant"
    // InternalFirstOrderLogic.g:2421:1: ruleFeatureConstant returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFeatureConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2427:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:2428:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:2428:2: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:2429:3: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2429:3: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:2430:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFeatureConstantRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getFeatureConstantAccess().getConstantEStructuralFeatureCrossReference_0());
            			

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
    // $ANTLR end "ruleFeatureConstant"


    // $ANTLR start "entryRuleClassifier"
    // InternalFirstOrderLogic.g:2444:1: entryRuleClassifier returns [EObject current=null] : iv_ruleClassifier= ruleClassifier EOF ;
    public final EObject entryRuleClassifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifier = null;


        try {
            // InternalFirstOrderLogic.g:2444:51: (iv_ruleClassifier= ruleClassifier EOF )
            // InternalFirstOrderLogic.g:2445:2: iv_ruleClassifier= ruleClassifier EOF
            {
             newCompositeNode(grammarAccess.getClassifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassifier=ruleClassifier();

            state._fsp--;

             current =iv_ruleClassifier; 
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
    // $ANTLR end "entryRuleClassifier"


    // $ANTLR start "ruleClassifier"
    // InternalFirstOrderLogic.g:2451:1: ruleClassifier returns [EObject current=null] : (this_ClassifierConstant_0= ruleClassifierConstant | this_AsClassifier_1= ruleAsClassifier ) ;
    public final EObject ruleClassifier() throws RecognitionException {
        EObject current = null;

        EObject this_ClassifierConstant_0 = null;

        EObject this_AsClassifier_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2457:2: ( (this_ClassifierConstant_0= ruleClassifierConstant | this_AsClassifier_1= ruleAsClassifier ) )
            // InternalFirstOrderLogic.g:2458:2: (this_ClassifierConstant_0= ruleClassifierConstant | this_AsClassifier_1= ruleAsClassifier )
            {
            // InternalFirstOrderLogic.g:2458:2: (this_ClassifierConstant_0= ruleClassifierConstant | this_AsClassifier_1= ruleAsClassifier )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            else if ( (LA16_0==47) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:2459:3: this_ClassifierConstant_0= ruleClassifierConstant
                    {

                    			newCompositeNode(grammarAccess.getClassifierAccess().getClassifierConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ClassifierConstant_0=ruleClassifierConstant();

                    state._fsp--;


                    			current = this_ClassifierConstant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:2468:3: this_AsClassifier_1= ruleAsClassifier
                    {

                    			newCompositeNode(grammarAccess.getClassifierAccess().getAsClassifierParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AsClassifier_1=ruleAsClassifier();

                    state._fsp--;


                    			current = this_AsClassifier_1;
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
    // $ANTLR end "ruleClassifier"


    // $ANTLR start "entryRuleClassifierConstant"
    // InternalFirstOrderLogic.g:2480:1: entryRuleClassifierConstant returns [EObject current=null] : iv_ruleClassifierConstant= ruleClassifierConstant EOF ;
    public final EObject entryRuleClassifierConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierConstant = null;


        try {
            // InternalFirstOrderLogic.g:2480:59: (iv_ruleClassifierConstant= ruleClassifierConstant EOF )
            // InternalFirstOrderLogic.g:2481:2: iv_ruleClassifierConstant= ruleClassifierConstant EOF
            {
             newCompositeNode(grammarAccess.getClassifierConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassifierConstant=ruleClassifierConstant();

            state._fsp--;

             current =iv_ruleClassifierConstant; 
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
    // $ANTLR end "entryRuleClassifierConstant"


    // $ANTLR start "ruleClassifierConstant"
    // InternalFirstOrderLogic.g:2487:1: ruleClassifierConstant returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleClassifierConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2493:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:2494:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:2494:2: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:2495:3: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2495:3: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:2496:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getClassifierConstantRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getClassifierConstantAccess().getConstantEClassifierCrossReference_0());
            			

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
    // $ANTLR end "ruleClassifierConstant"


    // $ANTLR start "entryRuleAsClassifier"
    // InternalFirstOrderLogic.g:2510:1: entryRuleAsClassifier returns [EObject current=null] : iv_ruleAsClassifier= ruleAsClassifier EOF ;
    public final EObject entryRuleAsClassifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsClassifier = null;


        try {
            // InternalFirstOrderLogic.g:2510:53: (iv_ruleAsClassifier= ruleAsClassifier EOF )
            // InternalFirstOrderLogic.g:2511:2: iv_ruleAsClassifier= ruleAsClassifier EOF
            {
             newCompositeNode(grammarAccess.getAsClassifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAsClassifier=ruleAsClassifier();

            state._fsp--;

             current =iv_ruleAsClassifier; 
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
    // $ANTLR end "entryRuleAsClassifier"


    // $ANTLR start "ruleAsClassifier"
    // InternalFirstOrderLogic.g:2517:1: ruleAsClassifier returns [EObject current=null] : (otherlv_0= 'asClassifier' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleAsClassifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2523:2: ( (otherlv_0= 'asClassifier' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2524:2: (otherlv_0= 'asClassifier' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2524:2: (otherlv_0= 'asClassifier' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2525:3: otherlv_0= 'asClassifier' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getAsClassifierAccess().getAsClassifierKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getAsClassifierAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2533:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2534:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2534:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2535:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getAsClassifierAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_term_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAsClassifierRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getAsClassifierAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleAsClassifier"


    // $ANTLR start "entryRuleDataType"
    // InternalFirstOrderLogic.g:2560:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalFirstOrderLogic.g:2560:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalFirstOrderLogic.g:2561:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalFirstOrderLogic.g:2567:1: ruleDataType returns [EObject current=null] : (this_DataTypeConstant_0= ruleDataTypeConstant | this_AsDataType_1= ruleAsDataType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeConstant_0 = null;

        EObject this_AsDataType_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2573:2: ( (this_DataTypeConstant_0= ruleDataTypeConstant | this_AsDataType_1= ruleAsDataType ) )
            // InternalFirstOrderLogic.g:2574:2: (this_DataTypeConstant_0= ruleDataTypeConstant | this_AsDataType_1= ruleAsDataType )
            {
            // InternalFirstOrderLogic.g:2574:2: (this_DataTypeConstant_0= ruleDataTypeConstant | this_AsDataType_1= ruleAsDataType )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==48) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalFirstOrderLogic.g:2575:3: this_DataTypeConstant_0= ruleDataTypeConstant
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getDataTypeConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataTypeConstant_0=ruleDataTypeConstant();

                    state._fsp--;


                    			current = this_DataTypeConstant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:2584:3: this_AsDataType_1= ruleAsDataType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getAsDataTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AsDataType_1=ruleAsDataType();

                    state._fsp--;


                    			current = this_AsDataType_1;
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleDataTypeConstant"
    // InternalFirstOrderLogic.g:2596:1: entryRuleDataTypeConstant returns [EObject current=null] : iv_ruleDataTypeConstant= ruleDataTypeConstant EOF ;
    public final EObject entryRuleDataTypeConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeConstant = null;


        try {
            // InternalFirstOrderLogic.g:2596:57: (iv_ruleDataTypeConstant= ruleDataTypeConstant EOF )
            // InternalFirstOrderLogic.g:2597:2: iv_ruleDataTypeConstant= ruleDataTypeConstant EOF
            {
             newCompositeNode(grammarAccess.getDataTypeConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeConstant=ruleDataTypeConstant();

            state._fsp--;

             current =iv_ruleDataTypeConstant; 
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
    // $ANTLR end "entryRuleDataTypeConstant"


    // $ANTLR start "ruleDataTypeConstant"
    // InternalFirstOrderLogic.g:2603:1: ruleDataTypeConstant returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleDataTypeConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2609:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:2610:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:2610:2: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:2611:3: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2611:3: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:2612:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDataTypeConstantRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getDataTypeConstantAccess().getConstantEDataTypeCrossReference_0());
            			

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
    // $ANTLR end "ruleDataTypeConstant"


    // $ANTLR start "entryRuleAsDataType"
    // InternalFirstOrderLogic.g:2626:1: entryRuleAsDataType returns [EObject current=null] : iv_ruleAsDataType= ruleAsDataType EOF ;
    public final EObject entryRuleAsDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAsDataType = null;


        try {
            // InternalFirstOrderLogic.g:2626:51: (iv_ruleAsDataType= ruleAsDataType EOF )
            // InternalFirstOrderLogic.g:2627:2: iv_ruleAsDataType= ruleAsDataType EOF
            {
             newCompositeNode(grammarAccess.getAsDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAsDataType=ruleAsDataType();

            state._fsp--;

             current =iv_ruleAsDataType; 
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
    // $ANTLR end "entryRuleAsDataType"


    // $ANTLR start "ruleAsDataType"
    // InternalFirstOrderLogic.g:2633:1: ruleAsDataType returns [EObject current=null] : (otherlv_0= 'asDataType' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleAsDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2639:2: ( (otherlv_0= 'asDataType' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2640:2: (otherlv_0= 'asDataType' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2640:2: (otherlv_0= 'asDataType' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2641:3: otherlv_0= 'asDataType' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getAsDataTypeAccess().getAsDataTypeKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getAsDataTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2649:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2650:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2650:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2651:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getAsDataTypeAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_term_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAsDataTypeRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getAsDataTypeAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleAsDataType"


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:2676:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalFirstOrderLogic.g:2676:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalFirstOrderLogic.g:2677:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalFirstOrderLogic.g:2683:1: ruleConstant returns [EObject current=null] : (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntConstant_0 = null;

        EObject this_StringConstant_1 = null;

        EObject this_BoolConstant_2 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2689:2: ( (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant ) )
            // InternalFirstOrderLogic.g:2690:2: (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant )
            {
            // InternalFirstOrderLogic.g:2690:2: (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_SIGNED_INT:
                {
                alt18=1;
                }
                break;
            case RULE_STRING:
                {
                alt18=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalFirstOrderLogic.g:2691:3: this_IntConstant_0= ruleIntConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntConstant_0=ruleIntConstant();

                    state._fsp--;


                    			current = this_IntConstant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:2700:3: this_StringConstant_1= ruleStringConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringConstant_1=ruleStringConstant();

                    state._fsp--;


                    			current = this_StringConstant_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:2709:3: this_BoolConstant_2= ruleBoolConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_2=ruleBoolConstant();

                    state._fsp--;


                    			current = this_BoolConstant_2;
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleIntConstant"
    // InternalFirstOrderLogic.g:2721:1: entryRuleIntConstant returns [EObject current=null] : iv_ruleIntConstant= ruleIntConstant EOF ;
    public final EObject entryRuleIntConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConstant = null;


        try {
            // InternalFirstOrderLogic.g:2721:52: (iv_ruleIntConstant= ruleIntConstant EOF )
            // InternalFirstOrderLogic.g:2722:2: iv_ruleIntConstant= ruleIntConstant EOF
            {
             newCompositeNode(grammarAccess.getIntConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntConstant=ruleIntConstant();

            state._fsp--;

             current =iv_ruleIntConstant; 
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
    // $ANTLR end "entryRuleIntConstant"


    // $ANTLR start "ruleIntConstant"
    // InternalFirstOrderLogic.g:2728:1: ruleIntConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_SIGNED_INT ) ) ;
    public final EObject ruleIntConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2734:2: ( ( (lv_value_0_0= RULE_SIGNED_INT ) ) )
            // InternalFirstOrderLogic.g:2735:2: ( (lv_value_0_0= RULE_SIGNED_INT ) )
            {
            // InternalFirstOrderLogic.g:2735:2: ( (lv_value_0_0= RULE_SIGNED_INT ) )
            // InternalFirstOrderLogic.g:2736:3: (lv_value_0_0= RULE_SIGNED_INT )
            {
            // InternalFirstOrderLogic.g:2736:3: (lv_value_0_0= RULE_SIGNED_INT )
            // InternalFirstOrderLogic.g:2737:4: lv_value_0_0= RULE_SIGNED_INT
            {
            lv_value_0_0=(Token)match(input,RULE_SIGNED_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIntConstantAccess().getValueSIGNED_INTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntConstantRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.sidiff.validation.laguage.fol.FirstOrderLogic.SIGNED_INT");
            			

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
    // $ANTLR end "ruleIntConstant"


    // $ANTLR start "entryRuleStringConstant"
    // InternalFirstOrderLogic.g:2756:1: entryRuleStringConstant returns [EObject current=null] : iv_ruleStringConstant= ruleStringConstant EOF ;
    public final EObject entryRuleStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringConstant = null;


        try {
            // InternalFirstOrderLogic.g:2756:55: (iv_ruleStringConstant= ruleStringConstant EOF )
            // InternalFirstOrderLogic.g:2757:2: iv_ruleStringConstant= ruleStringConstant EOF
            {
             newCompositeNode(grammarAccess.getStringConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringConstant=ruleStringConstant();

            state._fsp--;

             current =iv_ruleStringConstant; 
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
    // $ANTLR end "entryRuleStringConstant"


    // $ANTLR start "ruleStringConstant"
    // InternalFirstOrderLogic.g:2763:1: ruleStringConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2769:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalFirstOrderLogic.g:2770:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalFirstOrderLogic.g:2770:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:2771:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:2771:3: (lv_value_0_0= RULE_STRING )
            // InternalFirstOrderLogic.g:2772:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringConstantAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringConstantRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleStringConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalFirstOrderLogic.g:2791:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalFirstOrderLogic.g:2791:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:2792:2: iv_ruleBoolConstant= ruleBoolConstant EOF
            {
             newCompositeNode(grammarAccess.getBoolConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolConstant=ruleBoolConstant();

            state._fsp--;

             current =iv_ruleBoolConstant; 
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
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // InternalFirstOrderLogic.g:2798:1: ruleBoolConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2804:2: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalFirstOrderLogic.g:2805:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalFirstOrderLogic.g:2805:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalFirstOrderLogic.g:2806:3: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalFirstOrderLogic.g:2806:3: (lv_value_0_0= RULE_BOOLEAN )
            // InternalFirstOrderLogic.g:2807:4: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getBoolConstantAccess().getValueBOOLEANTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoolConstantRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.sidiff.validation.laguage.fol.FirstOrderLogic.BOOLEAN");
            			

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
    // $ANTLR end "ruleBoolConstant"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002FF5800080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00007F2FF58000F0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000800000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000008000000000L});

}