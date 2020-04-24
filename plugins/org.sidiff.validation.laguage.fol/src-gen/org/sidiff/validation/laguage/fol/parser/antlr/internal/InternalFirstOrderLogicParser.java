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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_INT", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'constraint'", "'message'", "'context'", "'<'", "'>'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not'", "'('", "')'", "'isEqual'", "','", "'isGreater'", "'isGreaterEqual'", "'isSmaller'", "'isSmallerEqual'", "'isEmpty'", "'isInstanceOf'", "'isValueLiteralOf'", "'forAll'", "'in'", "'exists'", "'select'", "'.'", "'::'", "'getContainer'", "'getContainments'", "'getClosure'", "'size'", "'indexOf'", "'concatenate'", "'capitalize'", "'$'"
    };
    public static final int T__50=50;
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
    public static final int T__49=49;
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
    // InternalFirstOrderLogic.g:71:1: ruleConstraintLibrary returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_constraints_1_0= ruleConstraint ) )* ) ;
    public final EObject ruleConstraintLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_constraints_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_constraints_1_0= ruleConstraint ) )* ) )
            // InternalFirstOrderLogic.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_constraints_1_0= ruleConstraint ) )* )
            {
            // InternalFirstOrderLogic.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_constraints_1_0= ruleConstraint ) )* )
            // InternalFirstOrderLogic.g:79:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_constraints_1_0= ruleConstraint ) )*
            {
            // InternalFirstOrderLogic.g:79:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:80:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalFirstOrderLogic.g:80:4: (lv_imports_0_0= ruleImport )
            	    // InternalFirstOrderLogic.g:81:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintLibraryAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Import");
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


    // $ANTLR start "entryRuleImport"
    // InternalFirstOrderLogic.g:121:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalFirstOrderLogic.g:121:47: (iv_ruleImport= ruleImport EOF )
            // InternalFirstOrderLogic.g:122:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalFirstOrderLogic.g:128:1: ruleImport returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
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

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getDomainKeyword_0());
            		
            // InternalFirstOrderLogic.g:140:3: ( (lv_domain_1_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:141:4: (lv_domain_1_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:141:4: (lv_domain_1_0= RULE_STRING )
            // InternalFirstOrderLogic.g:142:5: lv_domain_1_0= RULE_STRING
            {
            lv_domain_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_domain_1_0, grammarAccess.getImportAccess().getDomainSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
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
    // $ANTLR end "ruleImport"


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
    // InternalFirstOrderLogic.g:169:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )? otherlv_9= ':' ( (lv_formula_10_0= ruleFormula ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_message_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_variable_5_0 = null;

        EObject lv_formula_10_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:175:2: ( (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )? otherlv_9= ':' ( (lv_formula_10_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:176:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )? otherlv_9= ':' ( (lv_formula_10_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:176:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )? otherlv_9= ':' ( (lv_formula_10_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:177:3: otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )? otherlv_9= ':' ( (lv_formula_10_0= ruleFormula ) )
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

            // InternalFirstOrderLogic.g:244:3: (otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:245:4: otherlv_6= '<' ( (otherlv_7= RULE_ID ) ) otherlv_8= '>'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getLessThanSignKeyword_6_0());
                    			
                    // InternalFirstOrderLogic.g:249:4: ( (otherlv_7= RULE_ID ) )
                    // InternalFirstOrderLogic.g:250:5: (otherlv_7= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:250:5: (otherlv_7= RULE_ID )
                    // InternalFirstOrderLogic.g:251:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstraintRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_7, grammarAccess.getConstraintAccess().getTypeEClassifierCrossReference_6_1_0());
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getConstraintAccess().getGreaterThanSignKeyword_6_2());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_9, grammarAccess.getConstraintAccess().getColonKeyword_7());
            		
            // InternalFirstOrderLogic.g:271:3: ( (lv_formula_10_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:272:4: (lv_formula_10_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:272:4: (lv_formula_10_0= ruleFormula )
            // InternalFirstOrderLogic.g:273:5: lv_formula_10_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_2);
            lv_formula_10_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_10_0,
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
    // InternalFirstOrderLogic.g:294:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:294:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:295:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalFirstOrderLogic.g:301:1: ruleVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:307:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFirstOrderLogic.g:308:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFirstOrderLogic.g:308:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:309:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:309:3: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:310:4: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:310:4: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:311:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:322:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:323:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:323:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:324:5: lv_name_1_0= RULE_ID
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
    // InternalFirstOrderLogic.g:344:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:344:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:345:2: iv_ruleFormula= ruleFormula EOF
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
    // InternalFirstOrderLogic.g:351:1: ruleFormula returns [EObject current=null] : this_BinaryFormula_0= ruleBinaryFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryFormula_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:357:2: (this_BinaryFormula_0= ruleBinaryFormula )
            // InternalFirstOrderLogic.g:358:2: this_BinaryFormula_0= ruleBinaryFormula
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
    // InternalFirstOrderLogic.g:369:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:369:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:370:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
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
    // InternalFirstOrderLogic.g:376:1: ruleBinaryFormula returns [EObject current=null] : this_Iff_0= ruleIff ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Iff_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:382:2: (this_Iff_0= ruleIff )
            // InternalFirstOrderLogic.g:383:2: this_Iff_0= ruleIff
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
    // InternalFirstOrderLogic.g:394:1: entryRuleIff returns [EObject current=null] : iv_ruleIff= ruleIff EOF ;
    public final EObject entryRuleIff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIff = null;


        try {
            // InternalFirstOrderLogic.g:394:44: (iv_ruleIff= ruleIff EOF )
            // InternalFirstOrderLogic.g:395:2: iv_ruleIff= ruleIff EOF
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
    // InternalFirstOrderLogic.g:401:1: ruleIff returns [EObject current=null] : (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) ;
    public final EObject ruleIff() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_If_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:407:2: ( (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) )
            // InternalFirstOrderLogic.g:408:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            {
            // InternalFirstOrderLogic.g:408:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            // InternalFirstOrderLogic.g:409:3: this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            {

            			newCompositeNode(grammarAccess.getIffAccess().getIfParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_If_0=ruleIf();

            state._fsp--;


            			current = this_If_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:417:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:418:4: () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) )
            	    {
            	    // InternalFirstOrderLogic.g:418:4: ()
            	    // InternalFirstOrderLogic.g:419:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIffAccess().getIffLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIffAccess().getEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:429:4: ( (lv_right_3_0= ruleIf ) )
            	    // InternalFirstOrderLogic.g:430:5: (lv_right_3_0= ruleIf )
            	    {
            	    // InternalFirstOrderLogic.g:430:5: (lv_right_3_0= ruleIf )
            	    // InternalFirstOrderLogic.g:431:6: lv_right_3_0= ruleIf
            	    {

            	    						newCompositeNode(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
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
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:453:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:453:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:454:2: iv_ruleIf= ruleIf EOF
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
    // InternalFirstOrderLogic.g:460:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:466:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:467:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:467:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:468:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:476:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:477:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:477:4: ()
            	    // InternalFirstOrderLogic.g:478:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:488:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:489:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:489:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:490:6: lv_right_3_0= ruleXor
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
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleXor"
    // InternalFirstOrderLogic.g:512:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:512:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:513:2: iv_ruleXor= ruleXor EOF
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
    // InternalFirstOrderLogic.g:519:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:525:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:526:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:526:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:527:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:535:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:536:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:536:4: ()
            	    // InternalFirstOrderLogic.g:537:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:547:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:548:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:548:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:549:6: lv_right_3_0= ruleOr
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
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:571:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:571:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:572:2: iv_ruleOr= ruleOr EOF
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
    // InternalFirstOrderLogic.g:578:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:584:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:585:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:585:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:586:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:594:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:595:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:595:4: ()
            	    // InternalFirstOrderLogic.g:596:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,23,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:606:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:607:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:607:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:608:6: lv_right_3_0= ruleAnd
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
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:630:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:630:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:631:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalFirstOrderLogic.g:637:1: ruleAnd returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:643:2: ( (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) )
            // InternalFirstOrderLogic.g:644:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            {
            // InternalFirstOrderLogic.g:644:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            // InternalFirstOrderLogic.g:645:3: this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;


            			current = this_BooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:653:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:654:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) )
            	    {
            	    // InternalFirstOrderLogic.g:654:4: ()
            	    // InternalFirstOrderLogic.g:655:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,24,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:665:4: ( (lv_right_3_0= ruleBooleanExpression ) )
            	    // InternalFirstOrderLogic.g:666:5: (lv_right_3_0= ruleBooleanExpression )
            	    {
            	    // InternalFirstOrderLogic.g:666:5: (lv_right_3_0= ruleBooleanExpression )
            	    // InternalFirstOrderLogic.g:667:6: lv_right_3_0= ruleBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_17);
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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:689:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:689:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:690:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
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
    // InternalFirstOrderLogic.g:696:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:702:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:703:2: this_Not_0= ruleNot
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
    // InternalFirstOrderLogic.g:714:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:714:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:715:2: iv_ruleNot= ruleNot EOF
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
    // InternalFirstOrderLogic.g:721:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_not_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:727:2: ( ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:728:2: ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:728:2: ( () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:729:3: () otherlv_1= 'not' otherlv_2= '(' ( (lv_not_3_0= ruleFormula ) ) otherlv_4= ')'
            {
            // InternalFirstOrderLogic.g:729:3: ()
            // InternalFirstOrderLogic.g:730:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            otherlv_2=(Token)match(input,26,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getNotAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:744:3: ( (lv_not_3_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:745:4: (lv_not_3_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:745:4: (lv_not_3_0= ruleFormula )
            // InternalFirstOrderLogic.g:746:5: lv_not_3_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_4=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:771:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalFirstOrderLogic.g:771:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalFirstOrderLogic.g:772:2: iv_rulePredicate= rulePredicate EOF
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
    // InternalFirstOrderLogic.g:778:1: rulePredicate returns [EObject current=null] : (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        EObject this_Equals_0 = null;

        EObject this_Inequality_1 = null;

        EObject this_IsEmpty_2 = null;

        EObject this_IsInstanceOf_3 = null;

        EObject this_IsValueLiteralOf_4 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:784:2: ( (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf ) )
            // InternalFirstOrderLogic.g:785:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf )
            {
            // InternalFirstOrderLogic.g:785:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf | this_IsValueLiteralOf_4= ruleIsValueLiteralOf )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt9=1;
                }
                break;
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt9=2;
                }
                break;
            case 34:
                {
                alt9=3;
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            case 36:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalFirstOrderLogic.g:786:3: this_Equals_0= ruleEquals
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
                    // InternalFirstOrderLogic.g:795:3: this_Inequality_1= ruleInequality
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
                    // InternalFirstOrderLogic.g:804:3: this_IsEmpty_2= ruleIsEmpty
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
                    // InternalFirstOrderLogic.g:813:3: this_IsInstanceOf_3= ruleIsInstanceOf
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
                    // InternalFirstOrderLogic.g:822:3: this_IsValueLiteralOf_4= ruleIsValueLiteralOf
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
    // InternalFirstOrderLogic.g:834:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalFirstOrderLogic.g:834:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalFirstOrderLogic.g:835:2: iv_ruleEquals= ruleEquals EOF
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
    // InternalFirstOrderLogic.g:841:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:847:2: ( (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:848:2: (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:848:2: (otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:849:3: otherlv_0= 'isEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getIsEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getEqualsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:857:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:858:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:858:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:859:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getEqualsAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:880:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:881:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:881:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:882:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:907:1: entryRuleInequality returns [EObject current=null] : iv_ruleInequality= ruleInequality EOF ;
    public final EObject entryRuleInequality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInequality = null;


        try {
            // InternalFirstOrderLogic.g:907:51: (iv_ruleInequality= ruleInequality EOF )
            // InternalFirstOrderLogic.g:908:2: iv_ruleInequality= ruleInequality EOF
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
    // InternalFirstOrderLogic.g:914:1: ruleInequality returns [EObject current=null] : (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) ;
    public final EObject ruleInequality() throws RecognitionException {
        EObject current = null;

        EObject this_Greater_0 = null;

        EObject this_GreaterEqual_1 = null;

        EObject this_Smaller_2 = null;

        EObject this_SmallerEqual_3 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:920:2: ( (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) )
            // InternalFirstOrderLogic.g:921:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            {
            // InternalFirstOrderLogic.g:921:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt10=1;
                }
                break;
            case 31:
                {
                alt10=2;
                }
                break;
            case 32:
                {
                alt10=3;
                }
                break;
            case 33:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalFirstOrderLogic.g:922:3: this_Greater_0= ruleGreater
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
                    // InternalFirstOrderLogic.g:931:3: this_GreaterEqual_1= ruleGreaterEqual
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
                    // InternalFirstOrderLogic.g:940:3: this_Smaller_2= ruleSmaller
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
                    // InternalFirstOrderLogic.g:949:3: this_SmallerEqual_3= ruleSmallerEqual
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
    // InternalFirstOrderLogic.g:961:1: entryRuleGreater returns [EObject current=null] : iv_ruleGreater= ruleGreater EOF ;
    public final EObject entryRuleGreater() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreater = null;


        try {
            // InternalFirstOrderLogic.g:961:48: (iv_ruleGreater= ruleGreater EOF )
            // InternalFirstOrderLogic.g:962:2: iv_ruleGreater= ruleGreater EOF
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
    // InternalFirstOrderLogic.g:968:1: ruleGreater returns [EObject current=null] : (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:974:2: ( (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:975:2: (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:975:2: (otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:976:3: otherlv_0= 'isGreater' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterAccess().getIsGreaterKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getGreaterAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:984:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:985:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:985:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:986:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getGreaterAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1007:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1008:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1008:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1009:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1034:1: entryRuleGreaterEqual returns [EObject current=null] : iv_ruleGreaterEqual= ruleGreaterEqual EOF ;
    public final EObject entryRuleGreaterEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterEqual = null;


        try {
            // InternalFirstOrderLogic.g:1034:53: (iv_ruleGreaterEqual= ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:1035:2: iv_ruleGreaterEqual= ruleGreaterEqual EOF
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
    // InternalFirstOrderLogic.g:1041:1: ruleGreaterEqual returns [EObject current=null] : (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:1047:2: ( (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1048:2: (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1048:2: (otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1049:3: otherlv_0= 'isGreaterEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getGreaterEqualAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1057:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1058:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1058:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1059:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getGreaterEqualAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1080:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1081:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1081:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1082:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1107:1: entryRuleSmaller returns [EObject current=null] : iv_ruleSmaller= ruleSmaller EOF ;
    public final EObject entryRuleSmaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmaller = null;


        try {
            // InternalFirstOrderLogic.g:1107:48: (iv_ruleSmaller= ruleSmaller EOF )
            // InternalFirstOrderLogic.g:1108:2: iv_ruleSmaller= ruleSmaller EOF
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
    // InternalFirstOrderLogic.g:1114:1: ruleSmaller returns [EObject current=null] : (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:1120:2: ( (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1121:2: (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1121:2: (otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1122:3: otherlv_0= 'isSmaller' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerAccess().getIsSmallerKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSmallerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1130:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1131:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1131:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1132:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getSmallerAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1153:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1154:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1154:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1155:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1180:1: entryRuleSmallerEqual returns [EObject current=null] : iv_ruleSmallerEqual= ruleSmallerEqual EOF ;
    public final EObject entryRuleSmallerEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmallerEqual = null;


        try {
            // InternalFirstOrderLogic.g:1180:53: (iv_ruleSmallerEqual= ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:1181:2: iv_ruleSmallerEqual= ruleSmallerEqual EOF
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
    // InternalFirstOrderLogic.g:1187:1: ruleSmallerEqual returns [EObject current=null] : (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:1193:2: ( (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1194:2: (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1194:2: (otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1195:3: otherlv_0= 'isSmallerEqual' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSmallerEqualAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1203:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1204:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1204:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1205:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getSmallerEqualAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1226:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1227:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1227:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1228:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1253:1: entryRuleIsEmpty returns [EObject current=null] : iv_ruleIsEmpty= ruleIsEmpty EOF ;
    public final EObject entryRuleIsEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsEmpty = null;


        try {
            // InternalFirstOrderLogic.g:1253:48: (iv_ruleIsEmpty= ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:1254:2: iv_ruleIsEmpty= ruleIsEmpty EOF
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
    // InternalFirstOrderLogic.g:1260:1: ruleIsEmpty returns [EObject current=null] : (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleIsEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1266:2: ( (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:1267:2: (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:1267:2: (otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:1268:3: otherlv_0= 'isEmpty' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getIsEmptyAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1276:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1277:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1277:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1278:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1303:1: entryRuleIsInstanceOf returns [EObject current=null] : iv_ruleIsInstanceOf= ruleIsInstanceOf EOF ;
    public final EObject entryRuleIsInstanceOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsInstanceOf = null;


        try {
            // InternalFirstOrderLogic.g:1303:53: (iv_ruleIsInstanceOf= ruleIsInstanceOf EOF )
            // InternalFirstOrderLogic.g:1304:2: iv_ruleIsInstanceOf= ruleIsInstanceOf EOF
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
    // InternalFirstOrderLogic.g:1310:1: ruleIsInstanceOf returns [EObject current=null] : (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:1316:2: ( (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1317:2: (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1317:2: (otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1318:3: otherlv_0= 'isInstanceOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getIsInstanceOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1326:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1327:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1327:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1328:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getIsInstanceOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1349:3: ( (lv_type_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1350:4: (lv_type_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1350:4: (lv_type_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1351:5: lv_type_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsInstanceOfAccess().getTypeTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_type_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsInstanceOfRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1376:1: entryRuleIsValueLiteralOf returns [EObject current=null] : iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF ;
    public final EObject entryRuleIsValueLiteralOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsValueLiteralOf = null;


        try {
            // InternalFirstOrderLogic.g:1376:57: (iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF )
            // InternalFirstOrderLogic.g:1377:2: iv_ruleIsValueLiteralOf= ruleIsValueLiteralOf EOF
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
    // InternalFirstOrderLogic.g:1383:1: ruleIsValueLiteralOf returns [EObject current=null] : (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:1389:2: ( (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:1390:2: (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:1390:2: (otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:1391:3: otherlv_0= 'isValueLiteralOf' otherlv_1= '(' ( (lv_term_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_type_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getIsValueLiteralOfAccess().getIsValueLiteralOfKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getIsValueLiteralOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1399:3: ( (lv_term_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1400:4: (lv_term_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1400:4: (lv_term_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1401:5: lv_term_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsValueLiteralOfAccess().getTermTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getIsValueLiteralOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1422:3: ( (lv_type_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1423:4: (lv_type_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1423:4: (lv_type_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1424:5: lv_type_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsValueLiteralOfAccess().getTypeTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_type_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsValueLiteralOfRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1449:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:1449:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:1450:2: iv_ruleQuantifier= ruleQuantifier EOF
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
    // InternalFirstOrderLogic.g:1456:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1462:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:1463:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:1463:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            else if ( (LA11_0==39) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalFirstOrderLogic.g:1464:3: this_ForAll_0= ruleForAll
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
                    // InternalFirstOrderLogic.g:1473:3: this_Exists_1= ruleExists
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
    // InternalFirstOrderLogic.g:1485:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:1485:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:1486:2: iv_ruleForAll= ruleForAll EOF
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
    // InternalFirstOrderLogic.g:1492:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) ;
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
            // InternalFirstOrderLogic.g:1498:2: ( ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) )
            // InternalFirstOrderLogic.g:1499:2: ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            {
            // InternalFirstOrderLogic.g:1499:2: ( () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            // InternalFirstOrderLogic.g:1500:3: () otherlv_1= 'forAll' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')'
            {
            // InternalFirstOrderLogic.g:1500:3: ()
            // InternalFirstOrderLogic.g:1501:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            otherlv_2=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getForAllAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:1515:3: ( (lv_name_3_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1516:4: (lv_name_3_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1516:4: (lv_name_3_0= ruleVariable )
            // InternalFirstOrderLogic.g:1517:5: lv_name_3_0= ruleVariable
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

            otherlv_4=(Token)match(input,38,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getForAllAccess().getInKeyword_4());
            		
            // InternalFirstOrderLogic.g:1538:3: ( (lv_iteration_5_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1539:4: (lv_iteration_5_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1539:4: (lv_iteration_5_0= ruleTerm )
            // InternalFirstOrderLogic.g:1540:5: lv_iteration_5_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_6=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getForAllAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:1561:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1562:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1562:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:1563:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_8=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1588:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:1588:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:1589:2: iv_ruleExists= ruleExists EOF
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
    // InternalFirstOrderLogic.g:1595:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) ;
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
            // InternalFirstOrderLogic.g:1601:2: ( ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' ) )
            // InternalFirstOrderLogic.g:1602:2: ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            {
            // InternalFirstOrderLogic.g:1602:2: ( () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')' )
            // InternalFirstOrderLogic.g:1603:3: () otherlv_1= 'exists' otherlv_2= '(' ( (lv_name_3_0= ruleVariable ) ) otherlv_4= 'in' ( (lv_iteration_5_0= ruleTerm ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) otherlv_8= ')'
            {
            // InternalFirstOrderLogic.g:1603:3: ()
            // InternalFirstOrderLogic.g:1604:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            otherlv_2=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getExistsAccess().getLeftParenthesisKeyword_2());
            		
            // InternalFirstOrderLogic.g:1618:3: ( (lv_name_3_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1619:4: (lv_name_3_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1619:4: (lv_name_3_0= ruleVariable )
            // InternalFirstOrderLogic.g:1620:5: lv_name_3_0= ruleVariable
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

            otherlv_4=(Token)match(input,38,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getExistsAccess().getInKeyword_4());
            		
            // InternalFirstOrderLogic.g:1641:3: ( (lv_iteration_5_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1642:4: (lv_iteration_5_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1642:4: (lv_iteration_5_0= ruleTerm )
            // InternalFirstOrderLogic.g:1643:5: lv_iteration_5_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_6=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getExistsAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:1664:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1665:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1665:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:1666:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_8=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:1691:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalFirstOrderLogic.g:1691:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:1692:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalFirstOrderLogic.g:1698:1: ruleBooleanExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) ;
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
            // InternalFirstOrderLogic.g:1704:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) )
            // InternalFirstOrderLogic.g:1705:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            {
            // InternalFirstOrderLogic.g:1705:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 25:
                {
                alt12=2;
                }
                break;
            case 37:
            case 39:
                {
                alt12=3;
                }
                break;
            case 28:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                {
                alt12=4;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalFirstOrderLogic.g:1706:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:1706:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:1707:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,26,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_19);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1725:3: this_UnaryFormula_3= ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:1734:3: this_Quantifier_4= ruleQuantifier
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
                    // InternalFirstOrderLogic.g:1743:3: this_Predicate_5= rulePredicate
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
                    // InternalFirstOrderLogic.g:1752:3: this_BoolConstant_6= ruleBoolConstant
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
    // InternalFirstOrderLogic.g:1764:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:1764:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:1765:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalFirstOrderLogic.g:1771:1: ruleTerm returns [EObject current=null] : (this_ReferenceBase_0= ruleReferenceBase | this_Concatenate_1= ruleConcatenate | this_Size_2= ruleSize | this_IndexOf_3= ruleIndexOf | this_Capitalize_4= ruleCapitalize | this_Constant_5= ruleConstant ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceBase_0 = null;

        EObject this_Concatenate_1 = null;

        EObject this_Size_2 = null;

        EObject this_IndexOf_3 = null;

        EObject this_Capitalize_4 = null;

        EObject this_Constant_5 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1777:2: ( (this_ReferenceBase_0= ruleReferenceBase | this_Concatenate_1= ruleConcatenate | this_Size_2= ruleSize | this_IndexOf_3= ruleIndexOf | this_Capitalize_4= ruleCapitalize | this_Constant_5= ruleConstant ) )
            // InternalFirstOrderLogic.g:1778:2: (this_ReferenceBase_0= ruleReferenceBase | this_Concatenate_1= ruleConcatenate | this_Size_2= ruleSize | this_IndexOf_3= ruleIndexOf | this_Capitalize_4= ruleCapitalize | this_Constant_5= ruleConstant )
            {
            // InternalFirstOrderLogic.g:1778:2: (this_ReferenceBase_0= ruleReferenceBase | this_Concatenate_1= ruleConcatenate | this_Size_2= ruleSize | this_IndexOf_3= ruleIndexOf | this_Capitalize_4= ruleCapitalize | this_Constant_5= ruleConstant )
            int alt13=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 40:
            case 43:
            case 44:
            case 45:
                {
                alt13=1;
                }
                break;
            case 48:
                {
                alt13=2;
                }
                break;
            case 46:
                {
                alt13=3;
                }
                break;
            case 47:
                {
                alt13=4;
                }
                break;
            case 49:
                {
                alt13=5;
                }
                break;
            case RULE_STRING:
            case RULE_SIGNED_INT:
            case RULE_BOOLEAN:
            case 50:
                {
                alt13=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalFirstOrderLogic.g:1779:3: this_ReferenceBase_0= ruleReferenceBase
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getReferenceBaseParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferenceBase_0=ruleReferenceBase();

                    state._fsp--;


                    			current = this_ReferenceBase_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1788:3: this_Concatenate_1= ruleConcatenate
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConcatenateParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concatenate_1=ruleConcatenate();

                    state._fsp--;


                    			current = this_Concatenate_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1797:3: this_Size_2= ruleSize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getSizeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Size_2=ruleSize();

                    state._fsp--;


                    			current = this_Size_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1806:3: this_IndexOf_3= ruleIndexOf
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getIndexOfParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IndexOf_3=ruleIndexOf();

                    state._fsp--;


                    			current = this_IndexOf_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1815:3: this_Capitalize_4= ruleCapitalize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Capitalize_4=ruleCapitalize();

                    state._fsp--;


                    			current = this_Capitalize_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1824:3: this_Constant_5= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConstantParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_5=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_5;
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


    // $ANTLR start "entryRuleReferenceBase"
    // InternalFirstOrderLogic.g:1836:1: entryRuleReferenceBase returns [EObject current=null] : iv_ruleReferenceBase= ruleReferenceBase EOF ;
    public final EObject entryRuleReferenceBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceBase = null;


        try {
            // InternalFirstOrderLogic.g:1836:54: (iv_ruleReferenceBase= ruleReferenceBase EOF )
            // InternalFirstOrderLogic.g:1837:2: iv_ruleReferenceBase= ruleReferenceBase EOF
            {
             newCompositeNode(grammarAccess.getReferenceBaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceBase=ruleReferenceBase();

            state._fsp--;

             current =iv_ruleReferenceBase; 
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
    // $ANTLR end "entryRuleReferenceBase"


    // $ANTLR start "ruleReferenceBase"
    // InternalFirstOrderLogic.g:1843:1: ruleReferenceBase returns [EObject current=null] : ( (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure ) ( (lv_get_5_0= ruleGet ) )? ) ;
    public final EObject ruleReferenceBase() throws RecognitionException {
        EObject current = null;

        EObject this_VariableRef_0 = null;

        EObject this_Select_1 = null;

        EObject this_GetContainer_2 = null;

        EObject this_GetContainments_3 = null;

        EObject this_GetClosure_4 = null;

        EObject lv_get_5_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1849:2: ( ( (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure ) ( (lv_get_5_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:1850:2: ( (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure ) ( (lv_get_5_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:1850:2: ( (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure ) ( (lv_get_5_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:1851:3: (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure ) ( (lv_get_5_0= ruleGet ) )?
            {
            // InternalFirstOrderLogic.g:1851:3: (this_VariableRef_0= ruleVariableRef | this_Select_1= ruleSelect | this_GetContainer_2= ruleGetContainer | this_GetContainments_3= ruleGetContainments | this_GetClosure_4= ruleGetClosure )
            int alt14=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case 40:
                {
                alt14=2;
                }
                break;
            case 43:
                {
                alt14=3;
                }
                break;
            case 44:
                {
                alt14=4;
                }
                break;
            case 45:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:1852:4: this_VariableRef_0= ruleVariableRef
                    {

                    				newCompositeNode(grammarAccess.getReferenceBaseAccess().getVariableRefParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_23);
                    this_VariableRef_0=ruleVariableRef();

                    state._fsp--;


                    				current = this_VariableRef_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1861:4: this_Select_1= ruleSelect
                    {

                    				newCompositeNode(grammarAccess.getReferenceBaseAccess().getSelectParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_23);
                    this_Select_1=ruleSelect();

                    state._fsp--;


                    				current = this_Select_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1870:4: this_GetContainer_2= ruleGetContainer
                    {

                    				newCompositeNode(grammarAccess.getReferenceBaseAccess().getGetContainerParserRuleCall_0_2());
                    			
                    pushFollow(FOLLOW_23);
                    this_GetContainer_2=ruleGetContainer();

                    state._fsp--;


                    				current = this_GetContainer_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1879:4: this_GetContainments_3= ruleGetContainments
                    {

                    				newCompositeNode(grammarAccess.getReferenceBaseAccess().getGetContainmentsParserRuleCall_0_3());
                    			
                    pushFollow(FOLLOW_23);
                    this_GetContainments_3=ruleGetContainments();

                    state._fsp--;


                    				current = this_GetContainments_3;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1888:4: this_GetClosure_4= ruleGetClosure
                    {

                    				newCompositeNode(grammarAccess.getReferenceBaseAccess().getGetClosureParserRuleCall_0_4());
                    			
                    pushFollow(FOLLOW_23);
                    this_GetClosure_4=ruleGetClosure();

                    state._fsp--;


                    				current = this_GetClosure_4;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:1897:3: ( (lv_get_5_0= ruleGet ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFirstOrderLogic.g:1898:4: (lv_get_5_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:1898:4: (lv_get_5_0= ruleGet )
                    // InternalFirstOrderLogic.g:1899:5: lv_get_5_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getReferenceBaseAccess().getGetGetParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_get_5_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getReferenceBaseRule());
                    					}
                    					set(
                    						current,
                    						"get",
                    						lv_get_5_0,
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
    // $ANTLR end "ruleReferenceBase"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:1920:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalFirstOrderLogic.g:1920:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:1921:2: iv_ruleVariableRef= ruleVariableRef EOF
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
    // InternalFirstOrderLogic.g:1927:1: ruleVariableRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1933:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:1934:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:1934:2: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:1935:3: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1935:3: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:1936:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableRefRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVariableRefAccess().getNameVariableCrossReference_0());
            			

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


    // $ANTLR start "entryRuleSelect"
    // InternalFirstOrderLogic.g:1950:1: entryRuleSelect returns [EObject current=null] : iv_ruleSelect= ruleSelect EOF ;
    public final EObject entryRuleSelect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelect = null;


        try {
            // InternalFirstOrderLogic.g:1950:47: (iv_ruleSelect= ruleSelect EOF )
            // InternalFirstOrderLogic.g:1951:2: iv_ruleSelect= ruleSelect EOF
            {
             newCompositeNode(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelect=ruleSelect();

            state._fsp--;

             current =iv_ruleSelect; 
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
    // $ANTLR end "entryRuleSelect"


    // $ANTLR start "ruleSelect"
    // InternalFirstOrderLogic.g:1957:1: ruleSelect returns [EObject current=null] : (otherlv_0= 'select' otherlv_1= '(' ( (lv_iteration_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_name_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleSelect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_iteration_2_0 = null;

        EObject lv_name_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1963:2: ( (otherlv_0= 'select' otherlv_1= '(' ( (lv_iteration_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_name_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:1964:2: (otherlv_0= 'select' otherlv_1= '(' ( (lv_iteration_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_name_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:1964:2: (otherlv_0= 'select' otherlv_1= '(' ( (lv_iteration_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_name_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:1965:3: otherlv_0= 'select' otherlv_1= '(' ( (lv_iteration_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_name_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectAccess().getSelectKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:1973:3: ( (lv_iteration_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1974:4: (lv_iteration_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1974:4: (lv_iteration_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:1975:5: lv_iteration_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSelectAccess().getIterationTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_iteration_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:1996:3: ( (lv_name_4_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1997:4: (lv_name_4_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1997:4: (lv_name_4_0= ruleVariable )
            // InternalFirstOrderLogic.g:1998:5: lv_name_4_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getSelectAccess().getNameVariableParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_name_4_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getSelectAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:2019:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:2020:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:2020:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:2021:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getSelectAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_19);
            lv_formula_6_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getSelectAccess().getRightParenthesisKeyword_7());
            		

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
    // $ANTLR end "ruleSelect"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:2046:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:2046:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:2047:2: iv_ruleGet= ruleGet EOF
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
    // InternalFirstOrderLogic.g:2053:1: ruleGet returns [EObject current=null] : (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_next_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2059:2: ( (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:2060:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:2060:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:2061:3: otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
            		
            // InternalFirstOrderLogic.g:2065:3: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==42) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:2066:4: ( (otherlv_1= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalFirstOrderLogic.g:2066:4: ( (otherlv_1= RULE_ID ) )
                    // InternalFirstOrderLogic.g:2067:5: (otherlv_1= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:2067:5: (otherlv_1= RULE_ID )
                    // InternalFirstOrderLogic.g:2068:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGetRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_24); 

                    						newLeafNode(otherlv_1, grammarAccess.getGetAccess().getTypeEClassCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,42,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:2084:3: ( (otherlv_3= RULE_ID ) )
            // InternalFirstOrderLogic.g:2085:4: (otherlv_3= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2085:4: (otherlv_3= RULE_ID )
            // InternalFirstOrderLogic.g:2086:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_3, grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:2097:3: ( (lv_next_4_0= ruleGet ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalFirstOrderLogic.g:2098:4: (lv_next_4_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:2098:4: (lv_next_4_0= ruleGet )
                    // InternalFirstOrderLogic.g:2099:5: lv_next_4_0= ruleGet
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
    // InternalFirstOrderLogic.g:2120:1: entryRuleGetContainer returns [EObject current=null] : iv_ruleGetContainer= ruleGetContainer EOF ;
    public final EObject entryRuleGetContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainer = null;


        try {
            // InternalFirstOrderLogic.g:2120:53: (iv_ruleGetContainer= ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:2121:2: iv_ruleGetContainer= ruleGetContainer EOF
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
    // InternalFirstOrderLogic.g:2127:1: ruleGetContainer returns [EObject current=null] : (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleGetContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_element_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2133:2: ( (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2134:2: (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2134:2: (otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2135:3: otherlv_0= 'getContainer' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainerAccess().getGetContainerKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getGetContainerAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2143:3: ( (lv_element_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2144:4: (lv_element_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2144:4: (lv_element_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2145:5: lv_element_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:2170:1: entryRuleGetContainments returns [EObject current=null] : iv_ruleGetContainments= ruleGetContainments EOF ;
    public final EObject entryRuleGetContainments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainments = null;


        try {
            // InternalFirstOrderLogic.g:2170:56: (iv_ruleGetContainments= ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:2171:2: iv_ruleGetContainments= ruleGetContainments EOF
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
    // InternalFirstOrderLogic.g:2177:1: ruleGetContainments returns [EObject current=null] : (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleGetContainments() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_element_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2183:2: ( (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2184:2: (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2184:2: (otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2185:3: otherlv_0= 'getContainments' otherlv_1= '(' ( (lv_element_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getGetContainmentsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2193:3: ( (lv_element_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2194:4: (lv_element_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2194:4: (lv_element_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2195:5: lv_element_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:2220:1: entryRuleGetClosure returns [EObject current=null] : iv_ruleGetClosure= ruleGetClosure EOF ;
    public final EObject entryRuleGetClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetClosure = null;


        try {
            // InternalFirstOrderLogic.g:2220:51: (iv_ruleGetClosure= ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:2221:2: iv_ruleGetClosure= ruleGetClosure EOF
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
    // InternalFirstOrderLogic.g:2227:1: ruleGetClosure returns [EObject current=null] : (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_initial_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_variable_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_iteration_6_0= ruleTerm ) ) otherlv_7= ')' ) ;
    public final EObject ruleGetClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_initial_2_0 = null;

        EObject lv_variable_4_0 = null;

        EObject lv_iteration_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2233:2: ( (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_initial_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_variable_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_iteration_6_0= ruleTerm ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:2234:2: (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_initial_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_variable_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_iteration_6_0= ruleTerm ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:2234:2: (otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_initial_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_variable_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_iteration_6_0= ruleTerm ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:2235:3: otherlv_0= 'getClosure' otherlv_1= '(' ( (lv_initial_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_variable_4_0= ruleVariable ) ) otherlv_5= ':' ( (lv_iteration_6_0= ruleTerm ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getGetClosureAccess().getGetClosureKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getGetClosureAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2243:3: ( (lv_initial_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2244:4: (lv_initial_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2244:4: (lv_initial_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2245:5: lv_initial_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getInitialTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_initial_2_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"initial",
            						lv_initial_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getGetClosureAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2266:3: ( (lv_variable_4_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:2267:4: (lv_variable_4_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:2267:4: (lv_variable_4_0= ruleVariable )
            // InternalFirstOrderLogic.g:2268:5: lv_variable_4_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getVariableVariableParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_variable_4_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_20); 

            			newLeafNode(otherlv_5, grammarAccess.getGetClosureAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:2289:3: ( (lv_iteration_6_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2290:4: (lv_iteration_6_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2290:4: (lv_iteration_6_0= ruleTerm )
            // InternalFirstOrderLogic.g:2291:5: lv_iteration_6_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getIterationTermParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_19);
            lv_iteration_6_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_7());
            		

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
    // InternalFirstOrderLogic.g:2316:1: entryRuleSize returns [EObject current=null] : iv_ruleSize= ruleSize EOF ;
    public final EObject entryRuleSize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSize = null;


        try {
            // InternalFirstOrderLogic.g:2316:45: (iv_ruleSize= ruleSize EOF )
            // InternalFirstOrderLogic.g:2317:2: iv_ruleSize= ruleSize EOF
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
    // InternalFirstOrderLogic.g:2323:1: ruleSize returns [EObject current=null] : (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleSize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2329:2: ( (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2330:2: (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2330:2: (otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2331:3: otherlv_0= 'size' otherlv_1= '(' ( (lv_elements_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getSizeAccess().getSizeKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getSizeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2339:3: ( (lv_elements_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2340:4: (lv_elements_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2340:4: (lv_elements_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2341:5: lv_elements_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:2366:1: entryRuleIndexOf returns [EObject current=null] : iv_ruleIndexOf= ruleIndexOf EOF ;
    public final EObject entryRuleIndexOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexOf = null;


        try {
            // InternalFirstOrderLogic.g:2366:48: (iv_ruleIndexOf= ruleIndexOf EOF )
            // InternalFirstOrderLogic.g:2367:2: iv_ruleIndexOf= ruleIndexOf EOF
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
    // InternalFirstOrderLogic.g:2373:1: ruleIndexOf returns [EObject current=null] : (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_element_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleIndexOf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_container_2_0 = null;

        EObject lv_element_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2379:2: ( (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_element_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:2380:2: (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_element_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:2380:2: (otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_element_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:2381:3: otherlv_0= 'indexOf' otherlv_1= '(' ( (lv_container_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_element_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getIndexOfAccess().getIndexOfKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getIndexOfAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2389:3: ( (lv_container_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2390:4: (lv_container_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2390:4: (lv_container_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2391:5: lv_container_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIndexOfAccess().getContainerTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getIndexOfAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2412:3: ( (lv_element_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2413:4: (lv_element_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2413:4: (lv_element_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:2414:5: lv_element_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_element_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIndexOfRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_5());
            		

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
    // InternalFirstOrderLogic.g:2439:1: entryRuleConcatenate returns [EObject current=null] : iv_ruleConcatenate= ruleConcatenate EOF ;
    public final EObject entryRuleConcatenate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenate = null;


        try {
            // InternalFirstOrderLogic.g:2439:52: (iv_ruleConcatenate= ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:2440:2: iv_ruleConcatenate= ruleConcatenate EOF
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
    // InternalFirstOrderLogic.g:2446:1: ruleConcatenate returns [EObject current=null] : (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
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
            // InternalFirstOrderLogic.g:2452:2: ( (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalFirstOrderLogic.g:2453:2: (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalFirstOrderLogic.g:2453:2: (otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalFirstOrderLogic.g:2454:3: otherlv_0= 'concatenate' otherlv_1= '(' ( (lv_left_2_0= ruleTerm ) ) otherlv_3= ',' ( (lv_right_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatenateAccess().getConcatenateKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getConcatenateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2462:3: ( (lv_left_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2463:4: (lv_left_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2463:4: (lv_left_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2464:5: lv_left_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,29,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getConcatenateAccess().getCommaKeyword_3());
            		
            // InternalFirstOrderLogic.g:2485:3: ( (lv_right_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2486:4: (lv_right_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2486:4: (lv_right_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:2487:5: lv_right_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFirstOrderLogic.g:2512:1: entryRuleCapitalize returns [EObject current=null] : iv_ruleCapitalize= ruleCapitalize EOF ;
    public final EObject entryRuleCapitalize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapitalize = null;


        try {
            // InternalFirstOrderLogic.g:2512:51: (iv_ruleCapitalize= ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:2513:2: iv_ruleCapitalize= ruleCapitalize EOF
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
    // InternalFirstOrderLogic.g:2519:1: ruleCapitalize returns [EObject current=null] : (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' ) ;
    public final EObject ruleCapitalize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_string_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2525:2: ( (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:2526:2: (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:2526:2: (otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:2527:3: otherlv_0= 'capitalize' otherlv_1= '(' ( (lv_string_2_0= ruleTerm ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getCapitalizeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalFirstOrderLogic.g:2535:3: ( (lv_string_2_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2536:4: (lv_string_2_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2536:4: (lv_string_2_0= ruleTerm )
            // InternalFirstOrderLogic.g:2537:5: lv_string_2_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); 

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


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:2562:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalFirstOrderLogic.g:2562:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalFirstOrderLogic.g:2563:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalFirstOrderLogic.g:2569:1: ruleConstant returns [EObject current=null] : (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant | this_MetaConstant_3= ruleMetaConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntConstant_0 = null;

        EObject this_StringConstant_1 = null;

        EObject this_BoolConstant_2 = null;

        EObject this_MetaConstant_3 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2575:2: ( (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant | this_MetaConstant_3= ruleMetaConstant ) )
            // InternalFirstOrderLogic.g:2576:2: (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant | this_MetaConstant_3= ruleMetaConstant )
            {
            // InternalFirstOrderLogic.g:2576:2: (this_IntConstant_0= ruleIntConstant | this_StringConstant_1= ruleStringConstant | this_BoolConstant_2= ruleBoolConstant | this_MetaConstant_3= ruleMetaConstant )
            int alt18=4;
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
            case 50:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalFirstOrderLogic.g:2577:3: this_IntConstant_0= ruleIntConstant
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
                    // InternalFirstOrderLogic.g:2586:3: this_StringConstant_1= ruleStringConstant
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
                    // InternalFirstOrderLogic.g:2595:3: this_BoolConstant_2= ruleBoolConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_2=ruleBoolConstant();

                    state._fsp--;


                    			current = this_BoolConstant_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:2604:3: this_MetaConstant_3= ruleMetaConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getMetaConstantParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MetaConstant_3=ruleMetaConstant();

                    state._fsp--;


                    			current = this_MetaConstant_3;
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
    // InternalFirstOrderLogic.g:2616:1: entryRuleIntConstant returns [EObject current=null] : iv_ruleIntConstant= ruleIntConstant EOF ;
    public final EObject entryRuleIntConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConstant = null;


        try {
            // InternalFirstOrderLogic.g:2616:52: (iv_ruleIntConstant= ruleIntConstant EOF )
            // InternalFirstOrderLogic.g:2617:2: iv_ruleIntConstant= ruleIntConstant EOF
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
    // InternalFirstOrderLogic.g:2623:1: ruleIntConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_SIGNED_INT ) ) ;
    public final EObject ruleIntConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2629:2: ( ( (lv_value_0_0= RULE_SIGNED_INT ) ) )
            // InternalFirstOrderLogic.g:2630:2: ( (lv_value_0_0= RULE_SIGNED_INT ) )
            {
            // InternalFirstOrderLogic.g:2630:2: ( (lv_value_0_0= RULE_SIGNED_INT ) )
            // InternalFirstOrderLogic.g:2631:3: (lv_value_0_0= RULE_SIGNED_INT )
            {
            // InternalFirstOrderLogic.g:2631:3: (lv_value_0_0= RULE_SIGNED_INT )
            // InternalFirstOrderLogic.g:2632:4: lv_value_0_0= RULE_SIGNED_INT
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
    // InternalFirstOrderLogic.g:2651:1: entryRuleStringConstant returns [EObject current=null] : iv_ruleStringConstant= ruleStringConstant EOF ;
    public final EObject entryRuleStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringConstant = null;


        try {
            // InternalFirstOrderLogic.g:2651:55: (iv_ruleStringConstant= ruleStringConstant EOF )
            // InternalFirstOrderLogic.g:2652:2: iv_ruleStringConstant= ruleStringConstant EOF
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
    // InternalFirstOrderLogic.g:2658:1: ruleStringConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2664:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalFirstOrderLogic.g:2665:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalFirstOrderLogic.g:2665:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:2666:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:2666:3: (lv_value_0_0= RULE_STRING )
            // InternalFirstOrderLogic.g:2667:4: lv_value_0_0= RULE_STRING
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
    // InternalFirstOrderLogic.g:2686:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalFirstOrderLogic.g:2686:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:2687:2: iv_ruleBoolConstant= ruleBoolConstant EOF
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
    // InternalFirstOrderLogic.g:2693:1: ruleBoolConstant returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2699:2: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalFirstOrderLogic.g:2700:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalFirstOrderLogic.g:2700:2: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalFirstOrderLogic.g:2701:3: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalFirstOrderLogic.g:2701:3: (lv_value_0_0= RULE_BOOLEAN )
            // InternalFirstOrderLogic.g:2702:4: lv_value_0_0= RULE_BOOLEAN
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


    // $ANTLR start "entryRuleMetaConstant"
    // InternalFirstOrderLogic.g:2721:1: entryRuleMetaConstant returns [EObject current=null] : iv_ruleMetaConstant= ruleMetaConstant EOF ;
    public final EObject entryRuleMetaConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaConstant = null;


        try {
            // InternalFirstOrderLogic.g:2721:53: (iv_ruleMetaConstant= ruleMetaConstant EOF )
            // InternalFirstOrderLogic.g:2722:2: iv_ruleMetaConstant= ruleMetaConstant EOF
            {
             newCompositeNode(grammarAccess.getMetaConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetaConstant=ruleMetaConstant();

            state._fsp--;

             current =iv_ruleMetaConstant; 
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
    // $ANTLR end "entryRuleMetaConstant"


    // $ANTLR start "ruleMetaConstant"
    // InternalFirstOrderLogic.g:2728:1: ruleMetaConstant returns [EObject current=null] : (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleMetaConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2734:2: ( (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalFirstOrderLogic.g:2735:2: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalFirstOrderLogic.g:2735:2: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalFirstOrderLogic.g:2736:3: otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getMetaConstantAccess().getDollarSignKeyword_0());
            		
            // InternalFirstOrderLogic.g:2740:3: ( (otherlv_1= RULE_ID ) )
            // InternalFirstOrderLogic.g:2741:4: (otherlv_1= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2741:4: (otherlv_1= RULE_ID )
            // InternalFirstOrderLogic.g:2742:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetaConstantRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_1, grammarAccess.getMetaConstantAccess().getClassifierEClassifierCrossReference_1_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:2753:3: (otherlv_2= '::' ( (otherlv_3= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==42) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFirstOrderLogic.g:2754:4: otherlv_2= '::' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getMetaConstantAccess().getColonColonKeyword_2_0());
                    			
                    // InternalFirstOrderLogic.g:2758:4: ( (otherlv_3= RULE_ID ) )
                    // InternalFirstOrderLogic.g:2759:5: (otherlv_3= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:2759:5: (otherlv_3= RULE_ID )
                    // InternalFirstOrderLogic.g:2760:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMetaConstantRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getMetaConstantAccess().getLiteralOrFeatureENamedElementCrossReference_2_1_0());
                    					

                    }


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
    // $ANTLR end "ruleMetaConstant"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000BFD6000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0007F9BFD60000F0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000040000000002L});

}