package org.sidiff.validation.laguage.fol.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFirstOrderLogicParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_INT", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not'", "'('", "')'", "'isEqual'", "','", "'isGreater'", "'isGreaterEqual'", "'isSmaller'", "'isSmallerEqual'", "'isEmpty'", "'isInstanceOf'", "'isValueLiteralOf'", "'forAll'", "'in'", "'exists'", "'.'", "'::'", "'getContainer'", "'getContainments'", "'getClosure'", "'size'", "'indexOf'", "'concatenate'", "'capitalize'", "'select'", "'asClassifier'", "'asDataType'"
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

    	public void setGrammarAccess(FirstOrderLogicGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleConstraintLibrary"
    // InternalFirstOrderLogic.g:53:1: entryRuleConstraintLibrary : ruleConstraintLibrary EOF ;
    public final void entryRuleConstraintLibrary() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:54:1: ( ruleConstraintLibrary EOF )
            // InternalFirstOrderLogic.g:55:1: ruleConstraintLibrary EOF
            {
             before(grammarAccess.getConstraintLibraryRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraintLibrary();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintLibrary"


    // $ANTLR start "ruleConstraintLibrary"
    // InternalFirstOrderLogic.g:62:1: ruleConstraintLibrary : ( ( rule__ConstraintLibrary__Group__0 ) ) ;
    public final void ruleConstraintLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:66:2: ( ( ( rule__ConstraintLibrary__Group__0 ) ) )
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintLibrary__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:67:2: ( ( rule__ConstraintLibrary__Group__0 ) )
            // InternalFirstOrderLogic.g:68:3: ( rule__ConstraintLibrary__Group__0 )
            {
             before(grammarAccess.getConstraintLibraryAccess().getGroup()); 
            // InternalFirstOrderLogic.g:69:3: ( rule__ConstraintLibrary__Group__0 )
            // InternalFirstOrderLogic.g:69:4: rule__ConstraintLibrary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintLibraryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintLibrary"


    // $ANTLR start "entryRuleDomain"
    // InternalFirstOrderLogic.g:78:1: entryRuleDomain : ruleDomain EOF ;
    public final void entryRuleDomain() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:79:1: ( ruleDomain EOF )
            // InternalFirstOrderLogic.g:80:1: ruleDomain EOF
            {
             before(grammarAccess.getDomainRule()); 
            pushFollow(FOLLOW_1);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getDomainRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDomain"


    // $ANTLR start "ruleDomain"
    // InternalFirstOrderLogic.g:87:1: ruleDomain : ( ( rule__Domain__Group__0 ) ) ;
    public final void ruleDomain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:91:2: ( ( ( rule__Domain__Group__0 ) ) )
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Domain__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Domain__Group__0 ) )
            // InternalFirstOrderLogic.g:93:3: ( rule__Domain__Group__0 )
            {
             before(grammarAccess.getDomainAccess().getGroup()); 
            // InternalFirstOrderLogic.g:94:3: ( rule__Domain__Group__0 )
            // InternalFirstOrderLogic.g:94:4: rule__Domain__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Domain__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDomainAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDomain"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:103:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:104:1: ( ruleConstraint EOF )
            // InternalFirstOrderLogic.g:105:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalFirstOrderLogic.g:112:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:116:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Constraint__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:117:2: ( ( rule__Constraint__Group__0 ) )
            // InternalFirstOrderLogic.g:118:3: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // InternalFirstOrderLogic.g:119:3: ( rule__Constraint__Group__0 )
            // InternalFirstOrderLogic.g:119:4: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:128:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:129:1: ( ruleVariable EOF )
            // InternalFirstOrderLogic.g:130:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalFirstOrderLogic.g:137:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:141:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalFirstOrderLogic.g:142:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:142:2: ( ( rule__Variable__Group__0 ) )
            // InternalFirstOrderLogic.g:143:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalFirstOrderLogic.g:144:3: ( rule__Variable__Group__0 )
            // InternalFirstOrderLogic.g:144:4: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:153:1: entryRuleFormula : ruleFormula EOF ;
    public final void entryRuleFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:154:1: ( ruleFormula EOF )
            // InternalFirstOrderLogic.g:155:1: ruleFormula EOF
            {
             before(grammarAccess.getFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalFirstOrderLogic.g:162:1: ruleFormula : ( ruleBinaryFormula ) ;
    public final void ruleFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:166:2: ( ( ruleBinaryFormula ) )
            // InternalFirstOrderLogic.g:167:2: ( ruleBinaryFormula )
            {
            // InternalFirstOrderLogic.g:167:2: ( ruleBinaryFormula )
            // InternalFirstOrderLogic.g:168:3: ruleBinaryFormula
            {
             before(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:178:1: entryRuleBinaryFormula : ruleBinaryFormula EOF ;
    public final void entryRuleBinaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:179:1: ( ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:180:1: ruleBinaryFormula EOF
            {
             before(grammarAccess.getBinaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryFormula();

            state._fsp--;

             after(grammarAccess.getBinaryFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinaryFormula"


    // $ANTLR start "ruleBinaryFormula"
    // InternalFirstOrderLogic.g:187:1: ruleBinaryFormula : ( ruleIff ) ;
    public final void ruleBinaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:191:2: ( ( ruleIff ) )
            // InternalFirstOrderLogic.g:192:2: ( ruleIff )
            {
            // InternalFirstOrderLogic.g:192:2: ( ruleIff )
            // InternalFirstOrderLogic.g:193:3: ruleIff
            {
             before(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleIff();

            state._fsp--;

             after(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryFormula"


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:203:1: entryRuleIff : ruleIff EOF ;
    public final void entryRuleIff() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:204:1: ( ruleIff EOF )
            // InternalFirstOrderLogic.g:205:1: ruleIff EOF
            {
             before(grammarAccess.getIffRule()); 
            pushFollow(FOLLOW_1);
            ruleIff();

            state._fsp--;

             after(grammarAccess.getIffRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIff"


    // $ANTLR start "ruleIff"
    // InternalFirstOrderLogic.g:212:1: ruleIff : ( ( rule__Iff__Group__0 ) ) ;
    public final void ruleIff() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:216:2: ( ( ( rule__Iff__Group__0 ) ) )
            // InternalFirstOrderLogic.g:217:2: ( ( rule__Iff__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:217:2: ( ( rule__Iff__Group__0 ) )
            // InternalFirstOrderLogic.g:218:3: ( rule__Iff__Group__0 )
            {
             before(grammarAccess.getIffAccess().getGroup()); 
            // InternalFirstOrderLogic.g:219:3: ( rule__Iff__Group__0 )
            // InternalFirstOrderLogic.g:219:4: rule__Iff__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIffAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:228:1: entryRuleIf : ruleIf EOF ;
    public final void entryRuleIf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:229:1: ( ruleIf EOF )
            // InternalFirstOrderLogic.g:230:1: ruleIf EOF
            {
             before(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalFirstOrderLogic.g:237:1: ruleIf : ( ( rule__If__Group__0 ) ) ;
    public final void ruleIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:241:2: ( ( ( rule__If__Group__0 ) ) )
            // InternalFirstOrderLogic.g:242:2: ( ( rule__If__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:242:2: ( ( rule__If__Group__0 ) )
            // InternalFirstOrderLogic.g:243:3: ( rule__If__Group__0 )
            {
             before(grammarAccess.getIfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:244:3: ( rule__If__Group__0 )
            // InternalFirstOrderLogic.g:244:4: rule__If__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__If__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleXor"
    // InternalFirstOrderLogic.g:253:1: entryRuleXor : ruleXor EOF ;
    public final void entryRuleXor() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:254:1: ( ruleXor EOF )
            // InternalFirstOrderLogic.g:255:1: ruleXor EOF
            {
             before(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getXorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalFirstOrderLogic.g:262:1: ruleXor : ( ( rule__Xor__Group__0 ) ) ;
    public final void ruleXor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:266:2: ( ( ( rule__Xor__Group__0 ) ) )
            // InternalFirstOrderLogic.g:267:2: ( ( rule__Xor__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:267:2: ( ( rule__Xor__Group__0 ) )
            // InternalFirstOrderLogic.g:268:3: ( rule__Xor__Group__0 )
            {
             before(grammarAccess.getXorAccess().getGroup()); 
            // InternalFirstOrderLogic.g:269:3: ( rule__Xor__Group__0 )
            // InternalFirstOrderLogic.g:269:4: rule__Xor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:278:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:279:1: ( ruleOr EOF )
            // InternalFirstOrderLogic.g:280:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalFirstOrderLogic.g:287:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:291:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalFirstOrderLogic.g:292:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:292:2: ( ( rule__Or__Group__0 ) )
            // InternalFirstOrderLogic.g:293:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalFirstOrderLogic.g:294:3: ( rule__Or__Group__0 )
            // InternalFirstOrderLogic.g:294:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:303:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:304:1: ( ruleAnd EOF )
            // InternalFirstOrderLogic.g:305:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalFirstOrderLogic.g:312:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:316:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalFirstOrderLogic.g:317:2: ( ( rule__And__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:317:2: ( ( rule__And__Group__0 ) )
            // InternalFirstOrderLogic.g:318:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalFirstOrderLogic.g:319:3: ( rule__And__Group__0 )
            // InternalFirstOrderLogic.g:319:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:328:1: entryRuleUnaryFormula : ruleUnaryFormula EOF ;
    public final void entryRuleUnaryFormula() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:329:1: ( ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:330:1: ruleUnaryFormula EOF
            {
             before(grammarAccess.getUnaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryFormula();

            state._fsp--;

             after(grammarAccess.getUnaryFormulaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryFormula"


    // $ANTLR start "ruleUnaryFormula"
    // InternalFirstOrderLogic.g:337:1: ruleUnaryFormula : ( ruleNot ) ;
    public final void ruleUnaryFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:341:2: ( ( ruleNot ) )
            // InternalFirstOrderLogic.g:342:2: ( ruleNot )
            {
            // InternalFirstOrderLogic.g:342:2: ( ruleNot )
            // InternalFirstOrderLogic.g:343:3: ruleNot
            {
             before(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryFormula"


    // $ANTLR start "entryRuleNot"
    // InternalFirstOrderLogic.g:353:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:354:1: ( ruleNot EOF )
            // InternalFirstOrderLogic.g:355:1: ruleNot EOF
            {
             before(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getNotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalFirstOrderLogic.g:362:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:366:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:367:2: ( ( rule__Not__Group__0 ) )
            // InternalFirstOrderLogic.g:368:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalFirstOrderLogic.g:369:3: ( rule__Not__Group__0 )
            // InternalFirstOrderLogic.g:369:4: rule__Not__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRulePredicate"
    // InternalFirstOrderLogic.g:378:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:379:1: ( rulePredicate EOF )
            // InternalFirstOrderLogic.g:380:1: rulePredicate EOF
            {
             before(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalFirstOrderLogic.g:387:1: rulePredicate : ( ( rule__Predicate__Alternatives ) ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:391:2: ( ( ( rule__Predicate__Alternatives ) ) )
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Predicate__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:392:2: ( ( rule__Predicate__Alternatives ) )
            // InternalFirstOrderLogic.g:393:3: ( rule__Predicate__Alternatives )
            {
             before(grammarAccess.getPredicateAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:394:3: ( rule__Predicate__Alternatives )
            // InternalFirstOrderLogic.g:394:4: rule__Predicate__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Predicate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleEquals"
    // InternalFirstOrderLogic.g:403:1: entryRuleEquals : ruleEquals EOF ;
    public final void entryRuleEquals() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:404:1: ( ruleEquals EOF )
            // InternalFirstOrderLogic.g:405:1: ruleEquals EOF
            {
             before(grammarAccess.getEqualsRule()); 
            pushFollow(FOLLOW_1);
            ruleEquals();

            state._fsp--;

             after(grammarAccess.getEqualsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalFirstOrderLogic.g:412:1: ruleEquals : ( ( rule__Equals__Group__0 ) ) ;
    public final void ruleEquals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:416:2: ( ( ( rule__Equals__Group__0 ) ) )
            // InternalFirstOrderLogic.g:417:2: ( ( rule__Equals__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:417:2: ( ( rule__Equals__Group__0 ) )
            // InternalFirstOrderLogic.g:418:3: ( rule__Equals__Group__0 )
            {
             before(grammarAccess.getEqualsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:419:3: ( rule__Equals__Group__0 )
            // InternalFirstOrderLogic.g:419:4: rule__Equals__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleInequality"
    // InternalFirstOrderLogic.g:428:1: entryRuleInequality : ruleInequality EOF ;
    public final void entryRuleInequality() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:429:1: ( ruleInequality EOF )
            // InternalFirstOrderLogic.g:430:1: ruleInequality EOF
            {
             before(grammarAccess.getInequalityRule()); 
            pushFollow(FOLLOW_1);
            ruleInequality();

            state._fsp--;

             after(grammarAccess.getInequalityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInequality"


    // $ANTLR start "ruleInequality"
    // InternalFirstOrderLogic.g:437:1: ruleInequality : ( ( rule__Inequality__Alternatives ) ) ;
    public final void ruleInequality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:441:2: ( ( ( rule__Inequality__Alternatives ) ) )
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Inequality__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:442:2: ( ( rule__Inequality__Alternatives ) )
            // InternalFirstOrderLogic.g:443:3: ( rule__Inequality__Alternatives )
            {
             before(grammarAccess.getInequalityAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:444:3: ( rule__Inequality__Alternatives )
            // InternalFirstOrderLogic.g:444:4: rule__Inequality__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Inequality__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInequalityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInequality"


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:453:1: entryRuleGreater : ruleGreater EOF ;
    public final void entryRuleGreater() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:454:1: ( ruleGreater EOF )
            // InternalFirstOrderLogic.g:455:1: ruleGreater EOF
            {
             before(grammarAccess.getGreaterRule()); 
            pushFollow(FOLLOW_1);
            ruleGreater();

            state._fsp--;

             after(grammarAccess.getGreaterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGreater"


    // $ANTLR start "ruleGreater"
    // InternalFirstOrderLogic.g:462:1: ruleGreater : ( ( rule__Greater__Group__0 ) ) ;
    public final void ruleGreater() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:466:2: ( ( ( rule__Greater__Group__0 ) ) )
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Greater__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:467:2: ( ( rule__Greater__Group__0 ) )
            // InternalFirstOrderLogic.g:468:3: ( rule__Greater__Group__0 )
            {
             before(grammarAccess.getGreaterAccess().getGroup()); 
            // InternalFirstOrderLogic.g:469:3: ( rule__Greater__Group__0 )
            // InternalFirstOrderLogic.g:469:4: rule__Greater__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGreater"


    // $ANTLR start "entryRuleGreaterEqual"
    // InternalFirstOrderLogic.g:478:1: entryRuleGreaterEqual : ruleGreaterEqual EOF ;
    public final void entryRuleGreaterEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:479:1: ( ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:480:1: ruleGreaterEqual EOF
            {
             before(grammarAccess.getGreaterEqualRule()); 
            pushFollow(FOLLOW_1);
            ruleGreaterEqual();

            state._fsp--;

             after(grammarAccess.getGreaterEqualRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGreaterEqual"


    // $ANTLR start "ruleGreaterEqual"
    // InternalFirstOrderLogic.g:487:1: ruleGreaterEqual : ( ( rule__GreaterEqual__Group__0 ) ) ;
    public final void ruleGreaterEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:491:2: ( ( ( rule__GreaterEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:492:2: ( ( rule__GreaterEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:492:2: ( ( rule__GreaterEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:493:3: ( rule__GreaterEqual__Group__0 )
            {
             before(grammarAccess.getGreaterEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:494:3: ( rule__GreaterEqual__Group__0 )
            // InternalFirstOrderLogic.g:494:4: rule__GreaterEqual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGreaterEqual"


    // $ANTLR start "entryRuleSmaller"
    // InternalFirstOrderLogic.g:503:1: entryRuleSmaller : ruleSmaller EOF ;
    public final void entryRuleSmaller() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:504:1: ( ruleSmaller EOF )
            // InternalFirstOrderLogic.g:505:1: ruleSmaller EOF
            {
             before(grammarAccess.getSmallerRule()); 
            pushFollow(FOLLOW_1);
            ruleSmaller();

            state._fsp--;

             after(grammarAccess.getSmallerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSmaller"


    // $ANTLR start "ruleSmaller"
    // InternalFirstOrderLogic.g:512:1: ruleSmaller : ( ( rule__Smaller__Group__0 ) ) ;
    public final void ruleSmaller() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:516:2: ( ( ( rule__Smaller__Group__0 ) ) )
            // InternalFirstOrderLogic.g:517:2: ( ( rule__Smaller__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:517:2: ( ( rule__Smaller__Group__0 ) )
            // InternalFirstOrderLogic.g:518:3: ( rule__Smaller__Group__0 )
            {
             before(grammarAccess.getSmallerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:519:3: ( rule__Smaller__Group__0 )
            // InternalFirstOrderLogic.g:519:4: rule__Smaller__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSmaller"


    // $ANTLR start "entryRuleSmallerEqual"
    // InternalFirstOrderLogic.g:528:1: entryRuleSmallerEqual : ruleSmallerEqual EOF ;
    public final void entryRuleSmallerEqual() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:529:1: ( ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:530:1: ruleSmallerEqual EOF
            {
             before(grammarAccess.getSmallerEqualRule()); 
            pushFollow(FOLLOW_1);
            ruleSmallerEqual();

            state._fsp--;

             after(grammarAccess.getSmallerEqualRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSmallerEqual"


    // $ANTLR start "ruleSmallerEqual"
    // InternalFirstOrderLogic.g:537:1: ruleSmallerEqual : ( ( rule__SmallerEqual__Group__0 ) ) ;
    public final void ruleSmallerEqual() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:541:2: ( ( ( rule__SmallerEqual__Group__0 ) ) )
            // InternalFirstOrderLogic.g:542:2: ( ( rule__SmallerEqual__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:542:2: ( ( rule__SmallerEqual__Group__0 ) )
            // InternalFirstOrderLogic.g:543:3: ( rule__SmallerEqual__Group__0 )
            {
             before(grammarAccess.getSmallerEqualAccess().getGroup()); 
            // InternalFirstOrderLogic.g:544:3: ( rule__SmallerEqual__Group__0 )
            // InternalFirstOrderLogic.g:544:4: rule__SmallerEqual__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSmallerEqual"


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:553:1: entryRuleIsEmpty : ruleIsEmpty EOF ;
    public final void entryRuleIsEmpty() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:554:1: ( ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:555:1: ruleIsEmpty EOF
            {
             before(grammarAccess.getIsEmptyRule()); 
            pushFollow(FOLLOW_1);
            ruleIsEmpty();

            state._fsp--;

             after(grammarAccess.getIsEmptyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsEmpty"


    // $ANTLR start "ruleIsEmpty"
    // InternalFirstOrderLogic.g:562:1: ruleIsEmpty : ( ( rule__IsEmpty__Group__0 ) ) ;
    public final void ruleIsEmpty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:566:2: ( ( ( rule__IsEmpty__Group__0 ) ) )
            // InternalFirstOrderLogic.g:567:2: ( ( rule__IsEmpty__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:567:2: ( ( rule__IsEmpty__Group__0 ) )
            // InternalFirstOrderLogic.g:568:3: ( rule__IsEmpty__Group__0 )
            {
             before(grammarAccess.getIsEmptyAccess().getGroup()); 
            // InternalFirstOrderLogic.g:569:3: ( rule__IsEmpty__Group__0 )
            // InternalFirstOrderLogic.g:569:4: rule__IsEmpty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsEmptyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsEmpty"


    // $ANTLR start "entryRuleIsInstanceOf"
    // InternalFirstOrderLogic.g:578:1: entryRuleIsInstanceOf : ruleIsInstanceOf EOF ;
    public final void entryRuleIsInstanceOf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:579:1: ( ruleIsInstanceOf EOF )
            // InternalFirstOrderLogic.g:580:1: ruleIsInstanceOf EOF
            {
             before(grammarAccess.getIsInstanceOfRule()); 
            pushFollow(FOLLOW_1);
            ruleIsInstanceOf();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsInstanceOf"


    // $ANTLR start "ruleIsInstanceOf"
    // InternalFirstOrderLogic.g:587:1: ruleIsInstanceOf : ( ( rule__IsInstanceOf__Group__0 ) ) ;
    public final void ruleIsInstanceOf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:591:2: ( ( ( rule__IsInstanceOf__Group__0 ) ) )
            // InternalFirstOrderLogic.g:592:2: ( ( rule__IsInstanceOf__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:592:2: ( ( rule__IsInstanceOf__Group__0 ) )
            // InternalFirstOrderLogic.g:593:3: ( rule__IsInstanceOf__Group__0 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:594:3: ( rule__IsInstanceOf__Group__0 )
            // InternalFirstOrderLogic.g:594:4: rule__IsInstanceOf__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsInstanceOf"


    // $ANTLR start "entryRuleIsValueLiteralOf"
    // InternalFirstOrderLogic.g:603:1: entryRuleIsValueLiteralOf : ruleIsValueLiteralOf EOF ;
    public final void entryRuleIsValueLiteralOf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:604:1: ( ruleIsValueLiteralOf EOF )
            // InternalFirstOrderLogic.g:605:1: ruleIsValueLiteralOf EOF
            {
             before(grammarAccess.getIsValueLiteralOfRule()); 
            pushFollow(FOLLOW_1);
            ruleIsValueLiteralOf();

            state._fsp--;

             after(grammarAccess.getIsValueLiteralOfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIsValueLiteralOf"


    // $ANTLR start "ruleIsValueLiteralOf"
    // InternalFirstOrderLogic.g:612:1: ruleIsValueLiteralOf : ( ( rule__IsValueLiteralOf__Group__0 ) ) ;
    public final void ruleIsValueLiteralOf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:616:2: ( ( ( rule__IsValueLiteralOf__Group__0 ) ) )
            // InternalFirstOrderLogic.g:617:2: ( ( rule__IsValueLiteralOf__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:617:2: ( ( rule__IsValueLiteralOf__Group__0 ) )
            // InternalFirstOrderLogic.g:618:3: ( rule__IsValueLiteralOf__Group__0 )
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:619:3: ( rule__IsValueLiteralOf__Group__0 )
            // InternalFirstOrderLogic.g:619:4: rule__IsValueLiteralOf__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIsValueLiteralOfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIsValueLiteralOf"


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:628:1: entryRuleQuantifier : ruleQuantifier EOF ;
    public final void entryRuleQuantifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:629:1: ( ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:630:1: ruleQuantifier EOF
            {
             before(grammarAccess.getQuantifierRule()); 
            pushFollow(FOLLOW_1);
            ruleQuantifier();

            state._fsp--;

             after(grammarAccess.getQuantifierRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuantifier"


    // $ANTLR start "ruleQuantifier"
    // InternalFirstOrderLogic.g:637:1: ruleQuantifier : ( ( rule__Quantifier__Alternatives ) ) ;
    public final void ruleQuantifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:641:2: ( ( ( rule__Quantifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Quantifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:642:2: ( ( rule__Quantifier__Alternatives ) )
            // InternalFirstOrderLogic.g:643:3: ( rule__Quantifier__Alternatives )
            {
             before(grammarAccess.getQuantifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:644:3: ( rule__Quantifier__Alternatives )
            // InternalFirstOrderLogic.g:644:4: rule__Quantifier__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Quantifier__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getQuantifierAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuantifier"


    // $ANTLR start "entryRuleForAll"
    // InternalFirstOrderLogic.g:653:1: entryRuleForAll : ruleForAll EOF ;
    public final void entryRuleForAll() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:654:1: ( ruleForAll EOF )
            // InternalFirstOrderLogic.g:655:1: ruleForAll EOF
            {
             before(grammarAccess.getForAllRule()); 
            pushFollow(FOLLOW_1);
            ruleForAll();

            state._fsp--;

             after(grammarAccess.getForAllRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForAll"


    // $ANTLR start "ruleForAll"
    // InternalFirstOrderLogic.g:662:1: ruleForAll : ( ( rule__ForAll__Group__0 ) ) ;
    public final void ruleForAll() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:666:2: ( ( ( rule__ForAll__Group__0 ) ) )
            // InternalFirstOrderLogic.g:667:2: ( ( rule__ForAll__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:667:2: ( ( rule__ForAll__Group__0 ) )
            // InternalFirstOrderLogic.g:668:3: ( rule__ForAll__Group__0 )
            {
             before(grammarAccess.getForAllAccess().getGroup()); 
            // InternalFirstOrderLogic.g:669:3: ( rule__ForAll__Group__0 )
            // InternalFirstOrderLogic.g:669:4: rule__ForAll__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForAll"


    // $ANTLR start "entryRuleExists"
    // InternalFirstOrderLogic.g:678:1: entryRuleExists : ruleExists EOF ;
    public final void entryRuleExists() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:679:1: ( ruleExists EOF )
            // InternalFirstOrderLogic.g:680:1: ruleExists EOF
            {
             before(grammarAccess.getExistsRule()); 
            pushFollow(FOLLOW_1);
            ruleExists();

            state._fsp--;

             after(grammarAccess.getExistsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExists"


    // $ANTLR start "ruleExists"
    // InternalFirstOrderLogic.g:687:1: ruleExists : ( ( rule__Exists__Group__0 ) ) ;
    public final void ruleExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:691:2: ( ( ( rule__Exists__Group__0 ) ) )
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Exists__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:692:2: ( ( rule__Exists__Group__0 ) )
            // InternalFirstOrderLogic.g:693:3: ( rule__Exists__Group__0 )
            {
             before(grammarAccess.getExistsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:694:3: ( rule__Exists__Group__0 )
            // InternalFirstOrderLogic.g:694:4: rule__Exists__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exists__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExists"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalFirstOrderLogic.g:703:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:704:1: ( ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:705:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalFirstOrderLogic.g:712:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:716:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // InternalFirstOrderLogic.g:717:2: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:717:2: ( ( rule__BooleanExpression__Alternatives ) )
            // InternalFirstOrderLogic.g:718:3: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:719:3: ( rule__BooleanExpression__Alternatives )
            // InternalFirstOrderLogic.g:719:4: rule__BooleanExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:728:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:729:1: ( ruleTerm EOF )
            // InternalFirstOrderLogic.g:730:1: ruleTerm EOF
            {
             before(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalFirstOrderLogic.g:737:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:741:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:742:2: ( ( rule__Term__Alternatives ) )
            // InternalFirstOrderLogic.g:743:3: ( rule__Term__Alternatives )
            {
             before(grammarAccess.getTermAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:744:3: ( rule__Term__Alternatives )
            // InternalFirstOrderLogic.g:744:4: rule__Term__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Term__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTermAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:753:1: entryRuleVariableRef : ruleVariableRef EOF ;
    public final void entryRuleVariableRef() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:754:1: ( ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:755:1: ruleVariableRef EOF
            {
             before(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            ruleVariableRef();

            state._fsp--;

             after(grammarAccess.getVariableRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalFirstOrderLogic.g:762:1: ruleVariableRef : ( ( rule__VariableRef__Group__0 ) ) ;
    public final void ruleVariableRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:766:2: ( ( ( rule__VariableRef__Group__0 ) ) )
            // InternalFirstOrderLogic.g:767:2: ( ( rule__VariableRef__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:767:2: ( ( rule__VariableRef__Group__0 ) )
            // InternalFirstOrderLogic.g:768:3: ( rule__VariableRef__Group__0 )
            {
             before(grammarAccess.getVariableRefAccess().getGroup()); 
            // InternalFirstOrderLogic.g:769:3: ( rule__VariableRef__Group__0 )
            // InternalFirstOrderLogic.g:769:4: rule__VariableRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:778:1: entryRuleGet : ruleGet EOF ;
    public final void entryRuleGet() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:779:1: ( ruleGet EOF )
            // InternalFirstOrderLogic.g:780:1: ruleGet EOF
            {
             before(grammarAccess.getGetRule()); 
            pushFollow(FOLLOW_1);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getGetRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGet"


    // $ANTLR start "ruleGet"
    // InternalFirstOrderLogic.g:787:1: ruleGet : ( ( rule__Get__Group__0 ) ) ;
    public final void ruleGet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:791:2: ( ( ( rule__Get__Group__0 ) ) )
            // InternalFirstOrderLogic.g:792:2: ( ( rule__Get__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:792:2: ( ( rule__Get__Group__0 ) )
            // InternalFirstOrderLogic.g:793:3: ( rule__Get__Group__0 )
            {
             before(grammarAccess.getGetAccess().getGroup()); 
            // InternalFirstOrderLogic.g:794:3: ( rule__Get__Group__0 )
            // InternalFirstOrderLogic.g:794:4: rule__Get__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGet"


    // $ANTLR start "entryRuleGetContainer"
    // InternalFirstOrderLogic.g:803:1: entryRuleGetContainer : ruleGetContainer EOF ;
    public final void entryRuleGetContainer() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:804:1: ( ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:805:1: ruleGetContainer EOF
            {
             before(grammarAccess.getGetContainerRule()); 
            pushFollow(FOLLOW_1);
            ruleGetContainer();

            state._fsp--;

             after(grammarAccess.getGetContainerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetContainer"


    // $ANTLR start "ruleGetContainer"
    // InternalFirstOrderLogic.g:812:1: ruleGetContainer : ( ( rule__GetContainer__Group__0 ) ) ;
    public final void ruleGetContainer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:816:2: ( ( ( rule__GetContainer__Group__0 ) ) )
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainer__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:817:2: ( ( rule__GetContainer__Group__0 ) )
            // InternalFirstOrderLogic.g:818:3: ( rule__GetContainer__Group__0 )
            {
             before(grammarAccess.getGetContainerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:819:3: ( rule__GetContainer__Group__0 )
            // InternalFirstOrderLogic.g:819:4: rule__GetContainer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetContainerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetContainer"


    // $ANTLR start "entryRuleGetContainments"
    // InternalFirstOrderLogic.g:828:1: entryRuleGetContainments : ruleGetContainments EOF ;
    public final void entryRuleGetContainments() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:829:1: ( ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:830:1: ruleGetContainments EOF
            {
             before(grammarAccess.getGetContainmentsRule()); 
            pushFollow(FOLLOW_1);
            ruleGetContainments();

            state._fsp--;

             after(grammarAccess.getGetContainmentsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetContainments"


    // $ANTLR start "ruleGetContainments"
    // InternalFirstOrderLogic.g:837:1: ruleGetContainments : ( ( rule__GetContainments__Group__0 ) ) ;
    public final void ruleGetContainments() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:841:2: ( ( ( rule__GetContainments__Group__0 ) ) )
            // InternalFirstOrderLogic.g:842:2: ( ( rule__GetContainments__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:842:2: ( ( rule__GetContainments__Group__0 ) )
            // InternalFirstOrderLogic.g:843:3: ( rule__GetContainments__Group__0 )
            {
             before(grammarAccess.getGetContainmentsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:844:3: ( rule__GetContainments__Group__0 )
            // InternalFirstOrderLogic.g:844:4: rule__GetContainments__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetContainments"


    // $ANTLR start "entryRuleGetClosure"
    // InternalFirstOrderLogic.g:853:1: entryRuleGetClosure : ruleGetClosure EOF ;
    public final void entryRuleGetClosure() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:854:1: ( ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:855:1: ruleGetClosure EOF
            {
             before(grammarAccess.getGetClosureRule()); 
            pushFollow(FOLLOW_1);
            ruleGetClosure();

            state._fsp--;

             after(grammarAccess.getGetClosureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGetClosure"


    // $ANTLR start "ruleGetClosure"
    // InternalFirstOrderLogic.g:862:1: ruleGetClosure : ( ( rule__GetClosure__Group__0 ) ) ;
    public final void ruleGetClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:866:2: ( ( ( rule__GetClosure__Group__0 ) ) )
            // InternalFirstOrderLogic.g:867:2: ( ( rule__GetClosure__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:867:2: ( ( rule__GetClosure__Group__0 ) )
            // InternalFirstOrderLogic.g:868:3: ( rule__GetClosure__Group__0 )
            {
             before(grammarAccess.getGetClosureAccess().getGroup()); 
            // InternalFirstOrderLogic.g:869:3: ( rule__GetClosure__Group__0 )
            // InternalFirstOrderLogic.g:869:4: rule__GetClosure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGetClosure"


    // $ANTLR start "entryRuleSize"
    // InternalFirstOrderLogic.g:878:1: entryRuleSize : ruleSize EOF ;
    public final void entryRuleSize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:879:1: ( ruleSize EOF )
            // InternalFirstOrderLogic.g:880:1: ruleSize EOF
            {
             before(grammarAccess.getSizeRule()); 
            pushFollow(FOLLOW_1);
            ruleSize();

            state._fsp--;

             after(grammarAccess.getSizeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSize"


    // $ANTLR start "ruleSize"
    // InternalFirstOrderLogic.g:887:1: ruleSize : ( ( rule__Size__Group__0 ) ) ;
    public final void ruleSize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:2: ( ( ( rule__Size__Group__0 ) ) )
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Size__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:892:2: ( ( rule__Size__Group__0 ) )
            // InternalFirstOrderLogic.g:893:3: ( rule__Size__Group__0 )
            {
             before(grammarAccess.getSizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:894:3: ( rule__Size__Group__0 )
            // InternalFirstOrderLogic.g:894:4: rule__Size__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Size__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSizeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSize"


    // $ANTLR start "entryRuleIndexOf"
    // InternalFirstOrderLogic.g:903:1: entryRuleIndexOf : ruleIndexOf EOF ;
    public final void entryRuleIndexOf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:904:1: ( ruleIndexOf EOF )
            // InternalFirstOrderLogic.g:905:1: ruleIndexOf EOF
            {
             before(grammarAccess.getIndexOfRule()); 
            pushFollow(FOLLOW_1);
            ruleIndexOf();

            state._fsp--;

             after(grammarAccess.getIndexOfRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIndexOf"


    // $ANTLR start "ruleIndexOf"
    // InternalFirstOrderLogic.g:912:1: ruleIndexOf : ( ( rule__IndexOf__Group__0 ) ) ;
    public final void ruleIndexOf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:916:2: ( ( ( rule__IndexOf__Group__0 ) ) )
            // InternalFirstOrderLogic.g:917:2: ( ( rule__IndexOf__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:917:2: ( ( rule__IndexOf__Group__0 ) )
            // InternalFirstOrderLogic.g:918:3: ( rule__IndexOf__Group__0 )
            {
             before(grammarAccess.getIndexOfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:919:3: ( rule__IndexOf__Group__0 )
            // InternalFirstOrderLogic.g:919:4: rule__IndexOf__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIndexOfAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIndexOf"


    // $ANTLR start "entryRuleConcatenate"
    // InternalFirstOrderLogic.g:928:1: entryRuleConcatenate : ruleConcatenate EOF ;
    public final void entryRuleConcatenate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:929:1: ( ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:930:1: ruleConcatenate EOF
            {
             before(grammarAccess.getConcatenateRule()); 
            pushFollow(FOLLOW_1);
            ruleConcatenate();

            state._fsp--;

             after(grammarAccess.getConcatenateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConcatenate"


    // $ANTLR start "ruleConcatenate"
    // InternalFirstOrderLogic.g:937:1: ruleConcatenate : ( ( rule__Concatenate__Group__0 ) ) ;
    public final void ruleConcatenate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:941:2: ( ( ( rule__Concatenate__Group__0 ) ) )
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Concatenate__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Concatenate__Group__0 ) )
            // InternalFirstOrderLogic.g:943:3: ( rule__Concatenate__Group__0 )
            {
             before(grammarAccess.getConcatenateAccess().getGroup()); 
            // InternalFirstOrderLogic.g:944:3: ( rule__Concatenate__Group__0 )
            // InternalFirstOrderLogic.g:944:4: rule__Concatenate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcatenate"


    // $ANTLR start "entryRuleCapitalize"
    // InternalFirstOrderLogic.g:953:1: entryRuleCapitalize : ruleCapitalize EOF ;
    public final void entryRuleCapitalize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:954:1: ( ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:955:1: ruleCapitalize EOF
            {
             before(grammarAccess.getCapitalizeRule()); 
            pushFollow(FOLLOW_1);
            ruleCapitalize();

            state._fsp--;

             after(grammarAccess.getCapitalizeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCapitalize"


    // $ANTLR start "ruleCapitalize"
    // InternalFirstOrderLogic.g:962:1: ruleCapitalize : ( ( rule__Capitalize__Group__0 ) ) ;
    public final void ruleCapitalize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:966:2: ( ( ( rule__Capitalize__Group__0 ) ) )
            // InternalFirstOrderLogic.g:967:2: ( ( rule__Capitalize__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:967:2: ( ( rule__Capitalize__Group__0 ) )
            // InternalFirstOrderLogic.g:968:3: ( rule__Capitalize__Group__0 )
            {
             before(grammarAccess.getCapitalizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:969:3: ( rule__Capitalize__Group__0 )
            // InternalFirstOrderLogic.g:969:4: rule__Capitalize__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCapitalizeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCapitalize"


    // $ANTLR start "entryRuleIterator"
    // InternalFirstOrderLogic.g:978:1: entryRuleIterator : ruleIterator EOF ;
    public final void entryRuleIterator() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:979:1: ( ruleIterator EOF )
            // InternalFirstOrderLogic.g:980:1: ruleIterator EOF
            {
             before(grammarAccess.getIteratorRule()); 
            pushFollow(FOLLOW_1);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIteratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIterator"


    // $ANTLR start "ruleIterator"
    // InternalFirstOrderLogic.g:987:1: ruleIterator : ( ruleSelect ) ;
    public final void ruleIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:991:2: ( ( ruleSelect ) )
            // InternalFirstOrderLogic.g:992:2: ( ruleSelect )
            {
            // InternalFirstOrderLogic.g:992:2: ( ruleSelect )
            // InternalFirstOrderLogic.g:993:3: ruleSelect
            {
             before(grammarAccess.getIteratorAccess().getSelectParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleSelect();

            state._fsp--;

             after(grammarAccess.getIteratorAccess().getSelectParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIterator"


    // $ANTLR start "entryRuleSelect"
    // InternalFirstOrderLogic.g:1003:1: entryRuleSelect : ruleSelect EOF ;
    public final void entryRuleSelect() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1004:1: ( ruleSelect EOF )
            // InternalFirstOrderLogic.g:1005:1: ruleSelect EOF
            {
             before(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_1);
            ruleSelect();

            state._fsp--;

             after(grammarAccess.getSelectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelect"


    // $ANTLR start "ruleSelect"
    // InternalFirstOrderLogic.g:1012:1: ruleSelect : ( ( rule__Select__Group__0 ) ) ;
    public final void ruleSelect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1016:2: ( ( ( rule__Select__Group__0 ) ) )
            // InternalFirstOrderLogic.g:1017:2: ( ( rule__Select__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:1017:2: ( ( rule__Select__Group__0 ) )
            // InternalFirstOrderLogic.g:1018:3: ( rule__Select__Group__0 )
            {
             before(grammarAccess.getSelectAccess().getGroup()); 
            // InternalFirstOrderLogic.g:1019:3: ( rule__Select__Group__0 )
            // InternalFirstOrderLogic.g:1019:4: rule__Select__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Select__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelect"


    // $ANTLR start "entryRuleFeatureConstant"
    // InternalFirstOrderLogic.g:1028:1: entryRuleFeatureConstant : ruleFeatureConstant EOF ;
    public final void entryRuleFeatureConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1029:1: ( ruleFeatureConstant EOF )
            // InternalFirstOrderLogic.g:1030:1: ruleFeatureConstant EOF
            {
             before(grammarAccess.getFeatureConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleFeatureConstant();

            state._fsp--;

             after(grammarAccess.getFeatureConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureConstant"


    // $ANTLR start "ruleFeatureConstant"
    // InternalFirstOrderLogic.g:1037:1: ruleFeatureConstant : ( ( rule__FeatureConstant__ConstantAssignment ) ) ;
    public final void ruleFeatureConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1041:2: ( ( ( rule__FeatureConstant__ConstantAssignment ) ) )
            // InternalFirstOrderLogic.g:1042:2: ( ( rule__FeatureConstant__ConstantAssignment ) )
            {
            // InternalFirstOrderLogic.g:1042:2: ( ( rule__FeatureConstant__ConstantAssignment ) )
            // InternalFirstOrderLogic.g:1043:3: ( rule__FeatureConstant__ConstantAssignment )
            {
             before(grammarAccess.getFeatureConstantAccess().getConstantAssignment()); 
            // InternalFirstOrderLogic.g:1044:3: ( rule__FeatureConstant__ConstantAssignment )
            // InternalFirstOrderLogic.g:1044:4: rule__FeatureConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_2);
            rule__FeatureConstant__ConstantAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFeatureConstantAccess().getConstantAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeatureConstant"


    // $ANTLR start "entryRuleClassifier"
    // InternalFirstOrderLogic.g:1053:1: entryRuleClassifier : ruleClassifier EOF ;
    public final void entryRuleClassifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1054:1: ( ruleClassifier EOF )
            // InternalFirstOrderLogic.g:1055:1: ruleClassifier EOF
            {
             before(grammarAccess.getClassifierRule()); 
            pushFollow(FOLLOW_1);
            ruleClassifier();

            state._fsp--;

             after(grammarAccess.getClassifierRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassifier"


    // $ANTLR start "ruleClassifier"
    // InternalFirstOrderLogic.g:1062:1: ruleClassifier : ( ( rule__Classifier__Alternatives ) ) ;
    public final void ruleClassifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1066:2: ( ( ( rule__Classifier__Alternatives ) ) )
            // InternalFirstOrderLogic.g:1067:2: ( ( rule__Classifier__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:1067:2: ( ( rule__Classifier__Alternatives ) )
            // InternalFirstOrderLogic.g:1068:3: ( rule__Classifier__Alternatives )
            {
             before(grammarAccess.getClassifierAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:1069:3: ( rule__Classifier__Alternatives )
            // InternalFirstOrderLogic.g:1069:4: rule__Classifier__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Classifier__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getClassifierAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassifier"


    // $ANTLR start "entryRuleClassifierConstant"
    // InternalFirstOrderLogic.g:1078:1: entryRuleClassifierConstant : ruleClassifierConstant EOF ;
    public final void entryRuleClassifierConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1079:1: ( ruleClassifierConstant EOF )
            // InternalFirstOrderLogic.g:1080:1: ruleClassifierConstant EOF
            {
             before(grammarAccess.getClassifierConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleClassifierConstant();

            state._fsp--;

             after(grammarAccess.getClassifierConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassifierConstant"


    // $ANTLR start "ruleClassifierConstant"
    // InternalFirstOrderLogic.g:1087:1: ruleClassifierConstant : ( ( rule__ClassifierConstant__ConstantAssignment ) ) ;
    public final void ruleClassifierConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1091:2: ( ( ( rule__ClassifierConstant__ConstantAssignment ) ) )
            // InternalFirstOrderLogic.g:1092:2: ( ( rule__ClassifierConstant__ConstantAssignment ) )
            {
            // InternalFirstOrderLogic.g:1092:2: ( ( rule__ClassifierConstant__ConstantAssignment ) )
            // InternalFirstOrderLogic.g:1093:3: ( rule__ClassifierConstant__ConstantAssignment )
            {
             before(grammarAccess.getClassifierConstantAccess().getConstantAssignment()); 
            // InternalFirstOrderLogic.g:1094:3: ( rule__ClassifierConstant__ConstantAssignment )
            // InternalFirstOrderLogic.g:1094:4: rule__ClassifierConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierConstant__ConstantAssignment();

            state._fsp--;


            }

             after(grammarAccess.getClassifierConstantAccess().getConstantAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassifierConstant"


    // $ANTLR start "entryRuleAsClassifier"
    // InternalFirstOrderLogic.g:1103:1: entryRuleAsClassifier : ruleAsClassifier EOF ;
    public final void entryRuleAsClassifier() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1104:1: ( ruleAsClassifier EOF )
            // InternalFirstOrderLogic.g:1105:1: ruleAsClassifier EOF
            {
             before(grammarAccess.getAsClassifierRule()); 
            pushFollow(FOLLOW_1);
            ruleAsClassifier();

            state._fsp--;

             after(grammarAccess.getAsClassifierRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAsClassifier"


    // $ANTLR start "ruleAsClassifier"
    // InternalFirstOrderLogic.g:1112:1: ruleAsClassifier : ( ( rule__AsClassifier__Group__0 ) ) ;
    public final void ruleAsClassifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1116:2: ( ( ( rule__AsClassifier__Group__0 ) ) )
            // InternalFirstOrderLogic.g:1117:2: ( ( rule__AsClassifier__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:1117:2: ( ( rule__AsClassifier__Group__0 ) )
            // InternalFirstOrderLogic.g:1118:3: ( rule__AsClassifier__Group__0 )
            {
             before(grammarAccess.getAsClassifierAccess().getGroup()); 
            // InternalFirstOrderLogic.g:1119:3: ( rule__AsClassifier__Group__0 )
            // InternalFirstOrderLogic.g:1119:4: rule__AsClassifier__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AsClassifier__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAsClassifierAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAsClassifier"


    // $ANTLR start "entryRuleDataType"
    // InternalFirstOrderLogic.g:1128:1: entryRuleDataType : ruleDataType EOF ;
    public final void entryRuleDataType() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1129:1: ( ruleDataType EOF )
            // InternalFirstOrderLogic.g:1130:1: ruleDataType EOF
            {
             before(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getDataTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalFirstOrderLogic.g:1137:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1141:2: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalFirstOrderLogic.g:1142:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:1142:2: ( ( rule__DataType__Alternatives ) )
            // InternalFirstOrderLogic.g:1143:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:1144:3: ( rule__DataType__Alternatives )
            // InternalFirstOrderLogic.g:1144:4: rule__DataType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleDataTypeConstant"
    // InternalFirstOrderLogic.g:1153:1: entryRuleDataTypeConstant : ruleDataTypeConstant EOF ;
    public final void entryRuleDataTypeConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1154:1: ( ruleDataTypeConstant EOF )
            // InternalFirstOrderLogic.g:1155:1: ruleDataTypeConstant EOF
            {
             before(grammarAccess.getDataTypeConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleDataTypeConstant();

            state._fsp--;

             after(grammarAccess.getDataTypeConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataTypeConstant"


    // $ANTLR start "ruleDataTypeConstant"
    // InternalFirstOrderLogic.g:1162:1: ruleDataTypeConstant : ( ( rule__DataTypeConstant__ConstantAssignment ) ) ;
    public final void ruleDataTypeConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1166:2: ( ( ( rule__DataTypeConstant__ConstantAssignment ) ) )
            // InternalFirstOrderLogic.g:1167:2: ( ( rule__DataTypeConstant__ConstantAssignment ) )
            {
            // InternalFirstOrderLogic.g:1167:2: ( ( rule__DataTypeConstant__ConstantAssignment ) )
            // InternalFirstOrderLogic.g:1168:3: ( rule__DataTypeConstant__ConstantAssignment )
            {
             before(grammarAccess.getDataTypeConstantAccess().getConstantAssignment()); 
            // InternalFirstOrderLogic.g:1169:3: ( rule__DataTypeConstant__ConstantAssignment )
            // InternalFirstOrderLogic.g:1169:4: rule__DataTypeConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DataTypeConstant__ConstantAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeConstantAccess().getConstantAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataTypeConstant"


    // $ANTLR start "entryRuleAsDataType"
    // InternalFirstOrderLogic.g:1178:1: entryRuleAsDataType : ruleAsDataType EOF ;
    public final void entryRuleAsDataType() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1179:1: ( ruleAsDataType EOF )
            // InternalFirstOrderLogic.g:1180:1: ruleAsDataType EOF
            {
             before(grammarAccess.getAsDataTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleAsDataType();

            state._fsp--;

             after(grammarAccess.getAsDataTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAsDataType"


    // $ANTLR start "ruleAsDataType"
    // InternalFirstOrderLogic.g:1187:1: ruleAsDataType : ( ( rule__AsDataType__Group__0 ) ) ;
    public final void ruleAsDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1191:2: ( ( ( rule__AsDataType__Group__0 ) ) )
            // InternalFirstOrderLogic.g:1192:2: ( ( rule__AsDataType__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:1192:2: ( ( rule__AsDataType__Group__0 ) )
            // InternalFirstOrderLogic.g:1193:3: ( rule__AsDataType__Group__0 )
            {
             before(grammarAccess.getAsDataTypeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:1194:3: ( rule__AsDataType__Group__0 )
            // InternalFirstOrderLogic.g:1194:4: rule__AsDataType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AsDataType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAsDataTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAsDataType"


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:1203:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1204:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:1205:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalFirstOrderLogic.g:1212:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1216:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:1217:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:1217:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:1218:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:1219:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:1219:4: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleIntConstant"
    // InternalFirstOrderLogic.g:1228:1: entryRuleIntConstant : ruleIntConstant EOF ;
    public final void entryRuleIntConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1229:1: ( ruleIntConstant EOF )
            // InternalFirstOrderLogic.g:1230:1: ruleIntConstant EOF
            {
             before(grammarAccess.getIntConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleIntConstant();

            state._fsp--;

             after(grammarAccess.getIntConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntConstant"


    // $ANTLR start "ruleIntConstant"
    // InternalFirstOrderLogic.g:1237:1: ruleIntConstant : ( ( rule__IntConstant__ValueAssignment ) ) ;
    public final void ruleIntConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1241:2: ( ( ( rule__IntConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1242:2: ( ( rule__IntConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1242:2: ( ( rule__IntConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1243:3: ( rule__IntConstant__ValueAssignment )
            {
             before(grammarAccess.getIntConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1244:3: ( rule__IntConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1244:4: rule__IntConstant__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntConstant__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntConstantAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntConstant"


    // $ANTLR start "entryRuleStringConstant"
    // InternalFirstOrderLogic.g:1253:1: entryRuleStringConstant : ruleStringConstant EOF ;
    public final void entryRuleStringConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1254:1: ( ruleStringConstant EOF )
            // InternalFirstOrderLogic.g:1255:1: ruleStringConstant EOF
            {
             before(grammarAccess.getStringConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleStringConstant();

            state._fsp--;

             after(grammarAccess.getStringConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringConstant"


    // $ANTLR start "ruleStringConstant"
    // InternalFirstOrderLogic.g:1262:1: ruleStringConstant : ( ( rule__StringConstant__ValueAssignment ) ) ;
    public final void ruleStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1266:2: ( ( ( rule__StringConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1267:2: ( ( rule__StringConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1267:2: ( ( rule__StringConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1268:3: ( rule__StringConstant__ValueAssignment )
            {
             before(grammarAccess.getStringConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1269:3: ( rule__StringConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1269:4: rule__StringConstant__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringConstant__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringConstantAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalFirstOrderLogic.g:1278:1: entryRuleBoolConstant : ruleBoolConstant EOF ;
    public final void entryRuleBoolConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1279:1: ( ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:1280:1: ruleBoolConstant EOF
            {
             before(grammarAccess.getBoolConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolConstant();

            state._fsp--;

             after(grammarAccess.getBoolConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // InternalFirstOrderLogic.g:1287:1: ruleBoolConstant : ( ( rule__BoolConstant__ValueAssignment ) ) ;
    public final void ruleBoolConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1291:2: ( ( ( rule__BoolConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1292:2: ( ( rule__BoolConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1292:2: ( ( rule__BoolConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1293:3: ( rule__BoolConstant__ValueAssignment )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1294:3: ( rule__BoolConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1294:4: rule__BoolConstant__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BoolConstant__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBoolConstantAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolConstant"


    // $ANTLR start "rule__Predicate__Alternatives"
    // InternalFirstOrderLogic.g:1302:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) | ( ruleIsValueLiteralOf ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1306:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) | ( ruleIsValueLiteralOf ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt1=1;
                }
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt1=2;
                }
                break;
            case 32:
                {
                alt1=3;
                }
                break;
            case 33:
                {
                alt1=4;
                }
                break;
            case 34:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalFirstOrderLogic.g:1307:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:1307:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:1308:3: ruleEquals
                    {
                     before(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEquals();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1313:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:1313:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:1314:3: ruleInequality
                    {
                     before(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleInequality();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1319:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:1319:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:1320:3: ruleIsEmpty
                    {
                     before(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIsEmpty();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1325:2: ( ruleIsInstanceOf )
                    {
                    // InternalFirstOrderLogic.g:1325:2: ( ruleIsInstanceOf )
                    // InternalFirstOrderLogic.g:1326:3: ruleIsInstanceOf
                    {
                     before(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleIsInstanceOf();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1331:2: ( ruleIsValueLiteralOf )
                    {
                    // InternalFirstOrderLogic.g:1331:2: ( ruleIsValueLiteralOf )
                    // InternalFirstOrderLogic.g:1332:3: ruleIsValueLiteralOf
                    {
                     before(grammarAccess.getPredicateAccess().getIsValueLiteralOfParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleIsValueLiteralOf();

                    state._fsp--;

                     after(grammarAccess.getPredicateAccess().getIsValueLiteralOfParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__Alternatives"


    // $ANTLR start "rule__Inequality__Alternatives"
    // InternalFirstOrderLogic.g:1341:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1345:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt2=1;
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            case 31:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalFirstOrderLogic.g:1346:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:1346:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:1347:3: ruleGreater
                    {
                     before(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleGreater();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1352:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:1352:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:1353:3: ruleGreaterEqual
                    {
                     before(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleGreaterEqual();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1358:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:1358:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:1359:3: ruleSmaller
                    {
                     before(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleSmaller();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1364:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:1364:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:1365:3: ruleSmallerEqual
                    {
                     before(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleSmallerEqual();

                    state._fsp--;

                     after(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inequality__Alternatives"


    // $ANTLR start "rule__Quantifier__Alternatives"
    // InternalFirstOrderLogic.g:1374:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1378:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==35) ) {
                alt3=1;
            }
            else if ( (LA3_0==37) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:1379:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:1379:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:1380:3: ruleForAll
                    {
                     before(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleForAll();

                    state._fsp--;

                     after(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1385:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:1385:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:1386:3: ruleExists
                    {
                     before(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExists();

                    state._fsp--;

                     after(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Quantifier__Alternatives"


    // $ANTLR start "rule__BooleanExpression__Alternatives"
    // InternalFirstOrderLogic.g:1395:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1399:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 23:
                {
                alt4=2;
                }
                break;
            case 35:
            case 37:
                {
                alt4=3;
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
                alt4=4;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalFirstOrderLogic.g:1400:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1400:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1401:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1402:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:1402:4: rule__BooleanExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1406:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:1406:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:1407:3: ruleUnaryFormula
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUnaryFormula();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1412:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:1412:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:1413:3: ruleQuantifier
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleQuantifier();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1418:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:1418:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:1419:3: rulePredicate
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    rulePredicate();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1424:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1424:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1425:3: ruleBoolConstant
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolConstant();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Alternatives"


    // $ANTLR start "rule__Term__Alternatives"
    // InternalFirstOrderLogic.g:1434:1: rule__Term__Alternatives : ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainments ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleSize ) | ( ruleIndexOf ) | ( ruleConcatenate ) | ( ruleCapitalize ) | ( ruleIterator ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1438:1: ( ( ruleConstant ) | ( ruleVariableRef ) | ( ruleGetContainments ) | ( ruleGetContainer ) | ( ruleGetClosure ) | ( ruleSize ) | ( ruleIndexOf ) | ( ruleConcatenate ) | ( ruleCapitalize ) | ( ruleIterator ) )
            int alt5=10;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_SIGNED_INT:
            case RULE_BOOLEAN:
                {
                alt5=1;
                }
                break;
            case RULE_ID:
                {
                alt5=2;
                }
                break;
            case 41:
                {
                alt5=3;
                }
                break;
            case 40:
                {
                alt5=4;
                }
                break;
            case 42:
                {
                alt5=5;
                }
                break;
            case 43:
                {
                alt5=6;
                }
                break;
            case 44:
                {
                alt5=7;
                }
                break;
            case 45:
                {
                alt5=8;
                }
                break;
            case 46:
                {
                alt5=9;
                }
                break;
            case 47:
                {
                alt5=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalFirstOrderLogic.g:1439:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1439:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:1440:3: ruleConstant
                    {
                     before(grammarAccess.getTermAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1445:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:1445:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:1446:3: ruleVariableRef
                    {
                     before(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableRef();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1451:2: ( ruleGetContainments )
                    {
                    // InternalFirstOrderLogic.g:1451:2: ( ruleGetContainments )
                    // InternalFirstOrderLogic.g:1452:3: ruleGetContainments
                    {
                     before(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainments();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1457:2: ( ruleGetContainer )
                    {
                    // InternalFirstOrderLogic.g:1457:2: ( ruleGetContainer )
                    // InternalFirstOrderLogic.g:1458:3: ruleGetContainer
                    {
                     before(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainer();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1463:2: ( ruleGetClosure )
                    {
                    // InternalFirstOrderLogic.g:1463:2: ( ruleGetClosure )
                    // InternalFirstOrderLogic.g:1464:3: ruleGetClosure
                    {
                     before(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleGetClosure();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1469:2: ( ruleSize )
                    {
                    // InternalFirstOrderLogic.g:1469:2: ( ruleSize )
                    // InternalFirstOrderLogic.g:1470:3: ruleSize
                    {
                     before(grammarAccess.getTermAccess().getSizeParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleSize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getSizeParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalFirstOrderLogic.g:1475:2: ( ruleIndexOf )
                    {
                    // InternalFirstOrderLogic.g:1475:2: ( ruleIndexOf )
                    // InternalFirstOrderLogic.g:1476:3: ruleIndexOf
                    {
                     before(grammarAccess.getTermAccess().getIndexOfParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleIndexOf();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getIndexOfParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalFirstOrderLogic.g:1481:2: ( ruleConcatenate )
                    {
                    // InternalFirstOrderLogic.g:1481:2: ( ruleConcatenate )
                    // InternalFirstOrderLogic.g:1482:3: ruleConcatenate
                    {
                     before(grammarAccess.getTermAccess().getConcatenateParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleConcatenate();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConcatenateParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalFirstOrderLogic.g:1487:2: ( ruleCapitalize )
                    {
                    // InternalFirstOrderLogic.g:1487:2: ( ruleCapitalize )
                    // InternalFirstOrderLogic.g:1488:3: ruleCapitalize
                    {
                     before(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleCapitalize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalFirstOrderLogic.g:1493:2: ( ruleIterator )
                    {
                    // InternalFirstOrderLogic.g:1493:2: ( ruleIterator )
                    // InternalFirstOrderLogic.g:1494:3: ruleIterator
                    {
                     before(grammarAccess.getTermAccess().getIteratorParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleIterator();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getIteratorParserRuleCall_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Alternatives"


    // $ANTLR start "rule__Classifier__Alternatives"
    // InternalFirstOrderLogic.g:1503:1: rule__Classifier__Alternatives : ( ( ruleClassifierConstant ) | ( ruleAsClassifier ) );
    public final void rule__Classifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1507:1: ( ( ruleClassifierConstant ) | ( ruleAsClassifier ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==48) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1508:2: ( ruleClassifierConstant )
                    {
                    // InternalFirstOrderLogic.g:1508:2: ( ruleClassifierConstant )
                    // InternalFirstOrderLogic.g:1509:3: ruleClassifierConstant
                    {
                     before(grammarAccess.getClassifierAccess().getClassifierConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleClassifierConstant();

                    state._fsp--;

                     after(grammarAccess.getClassifierAccess().getClassifierConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1514:2: ( ruleAsClassifier )
                    {
                    // InternalFirstOrderLogic.g:1514:2: ( ruleAsClassifier )
                    // InternalFirstOrderLogic.g:1515:3: ruleAsClassifier
                    {
                     before(grammarAccess.getClassifierAccess().getAsClassifierParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleAsClassifier();

                    state._fsp--;

                     after(grammarAccess.getClassifierAccess().getAsClassifierParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Classifier__Alternatives"


    // $ANTLR start "rule__DataType__Alternatives"
    // InternalFirstOrderLogic.g:1524:1: rule__DataType__Alternatives : ( ( ruleDataTypeConstant ) | ( ruleAsDataType ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1528:1: ( ( ruleDataTypeConstant ) | ( ruleAsDataType ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==49) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:1529:2: ( ruleDataTypeConstant )
                    {
                    // InternalFirstOrderLogic.g:1529:2: ( ruleDataTypeConstant )
                    // InternalFirstOrderLogic.g:1530:3: ruleDataTypeConstant
                    {
                     before(grammarAccess.getDataTypeAccess().getDataTypeConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDataTypeConstant();

                    state._fsp--;

                     after(grammarAccess.getDataTypeAccess().getDataTypeConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1535:2: ( ruleAsDataType )
                    {
                    // InternalFirstOrderLogic.g:1535:2: ( ruleAsDataType )
                    // InternalFirstOrderLogic.g:1536:3: ruleAsDataType
                    {
                     before(grammarAccess.getDataTypeAccess().getAsDataTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleAsDataType();

                    state._fsp--;

                     after(grammarAccess.getDataTypeAccess().getAsDataTypeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // InternalFirstOrderLogic.g:1545:1: rule__Constant__Alternatives : ( ( ruleIntConstant ) | ( ruleStringConstant ) | ( ruleBoolConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1549:1: ( ( ruleIntConstant ) | ( ruleStringConstant ) | ( ruleBoolConstant ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_SIGNED_INT:
                {
                alt8=1;
                }
                break;
            case RULE_STRING:
                {
                alt8=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:1550:2: ( ruleIntConstant )
                    {
                    // InternalFirstOrderLogic.g:1550:2: ( ruleIntConstant )
                    // InternalFirstOrderLogic.g:1551:3: ruleIntConstant
                    {
                     before(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1556:2: ( ruleStringConstant )
                    {
                    // InternalFirstOrderLogic.g:1556:2: ( ruleStringConstant )
                    // InternalFirstOrderLogic.g:1557:3: ruleStringConstant
                    {
                     before(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStringConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1562:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1562:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1563:3: ruleBoolConstant
                    {
                     before(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Alternatives"


    // $ANTLR start "rule__ConstraintLibrary__Group__0"
    // InternalFirstOrderLogic.g:1572:1: rule__ConstraintLibrary__Group__0 : rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 ;
    public final void rule__ConstraintLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1576:1: ( rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 )
            // InternalFirstOrderLogic.g:1577:2: rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ConstraintLibrary__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__0"


    // $ANTLR start "rule__ConstraintLibrary__Group__0__Impl"
    // InternalFirstOrderLogic.g:1584:1: rule__ConstraintLibrary__Group__0__Impl : ( ( rule__ConstraintLibrary__DomainsAssignment_0 )* ) ;
    public final void rule__ConstraintLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1588:1: ( ( ( rule__ConstraintLibrary__DomainsAssignment_0 )* ) )
            // InternalFirstOrderLogic.g:1589:1: ( ( rule__ConstraintLibrary__DomainsAssignment_0 )* )
            {
            // InternalFirstOrderLogic.g:1589:1: ( ( rule__ConstraintLibrary__DomainsAssignment_0 )* )
            // InternalFirstOrderLogic.g:1590:2: ( rule__ConstraintLibrary__DomainsAssignment_0 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainsAssignment_0()); 
            // InternalFirstOrderLogic.g:1591:2: ( rule__ConstraintLibrary__DomainsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==13) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1591:3: rule__ConstraintLibrary__DomainsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ConstraintLibrary__DomainsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getConstraintLibraryAccess().getDomainsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__0__Impl"


    // $ANTLR start "rule__ConstraintLibrary__Group__1"
    // InternalFirstOrderLogic.g:1599:1: rule__ConstraintLibrary__Group__1 : rule__ConstraintLibrary__Group__1__Impl ;
    public final void rule__ConstraintLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1603:1: ( rule__ConstraintLibrary__Group__1__Impl )
            // InternalFirstOrderLogic.g:1604:2: rule__ConstraintLibrary__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintLibrary__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__1"


    // $ANTLR start "rule__ConstraintLibrary__Group__1__Impl"
    // InternalFirstOrderLogic.g:1610:1: rule__ConstraintLibrary__Group__1__Impl : ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* ) ;
    public final void rule__ConstraintLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1614:1: ( ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* ) )
            // InternalFirstOrderLogic.g:1615:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* )
            {
            // InternalFirstOrderLogic.g:1615:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* )
            // InternalFirstOrderLogic.g:1616:2: ( rule__ConstraintLibrary__ConstraintsAssignment_1 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_1()); 
            // InternalFirstOrderLogic.g:1617:2: ( rule__ConstraintLibrary__ConstraintsAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1617:3: rule__ConstraintLibrary__ConstraintsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__ConstraintLibrary__ConstraintsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__Group__1__Impl"


    // $ANTLR start "rule__Domain__Group__0"
    // InternalFirstOrderLogic.g:1626:1: rule__Domain__Group__0 : rule__Domain__Group__0__Impl rule__Domain__Group__1 ;
    public final void rule__Domain__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1630:1: ( rule__Domain__Group__0__Impl rule__Domain__Group__1 )
            // InternalFirstOrderLogic.g:1631:2: rule__Domain__Group__0__Impl rule__Domain__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Domain__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Domain__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__Group__0"


    // $ANTLR start "rule__Domain__Group__0__Impl"
    // InternalFirstOrderLogic.g:1638:1: rule__Domain__Group__0__Impl : ( 'domain' ) ;
    public final void rule__Domain__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1642:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:1643:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:1643:1: ( 'domain' )
            // InternalFirstOrderLogic.g:1644:2: 'domain'
            {
             before(grammarAccess.getDomainAccess().getDomainKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getDomainAccess().getDomainKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__Group__0__Impl"


    // $ANTLR start "rule__Domain__Group__1"
    // InternalFirstOrderLogic.g:1653:1: rule__Domain__Group__1 : rule__Domain__Group__1__Impl ;
    public final void rule__Domain__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1657:1: ( rule__Domain__Group__1__Impl )
            // InternalFirstOrderLogic.g:1658:2: rule__Domain__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Domain__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__Group__1"


    // $ANTLR start "rule__Domain__Group__1__Impl"
    // InternalFirstOrderLogic.g:1664:1: rule__Domain__Group__1__Impl : ( ( rule__Domain__DomainAssignment_1 ) ) ;
    public final void rule__Domain__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1668:1: ( ( ( rule__Domain__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1669:1: ( ( rule__Domain__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1669:1: ( ( rule__Domain__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1670:2: ( rule__Domain__DomainAssignment_1 )
            {
             before(grammarAccess.getDomainAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1671:2: ( rule__Domain__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1671:3: rule__Domain__DomainAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Domain__DomainAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDomainAccess().getDomainAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalFirstOrderLogic.g:1680:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1684:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1685:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0"


    // $ANTLR start "rule__Constraint__Group__0__Impl"
    // InternalFirstOrderLogic.g:1692:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1696:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1697:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1697:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1698:2: 'constraint'
            {
             before(grammarAccess.getConstraintAccess().getConstraintKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getConstraintKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0__Impl"


    // $ANTLR start "rule__Constraint__Group__1"
    // InternalFirstOrderLogic.g:1707:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1711:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1712:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1"


    // $ANTLR start "rule__Constraint__Group__1__Impl"
    // InternalFirstOrderLogic.g:1719:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1723:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1724:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1724:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1725:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1726:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1726:3: rule__Constraint__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__2"
    // InternalFirstOrderLogic.g:1734:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1738:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1739:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2"


    // $ANTLR start "rule__Constraint__Group__2__Impl"
    // InternalFirstOrderLogic.g:1746:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1750:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1751:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1751:1: ( 'message' )
            // InternalFirstOrderLogic.g:1752:2: 'message'
            {
             before(grammarAccess.getConstraintAccess().getMessageKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getMessageKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__3"
    // InternalFirstOrderLogic.g:1761:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1765:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1766:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Constraint__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3"


    // $ANTLR start "rule__Constraint__Group__3__Impl"
    // InternalFirstOrderLogic.g:1773:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1777:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1778:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1778:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1779:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1780:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1780:3: rule__Constraint__MessageAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__MessageAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3__Impl"


    // $ANTLR start "rule__Constraint__Group__4"
    // InternalFirstOrderLogic.g:1788:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1792:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1793:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4"


    // $ANTLR start "rule__Constraint__Group__4__Impl"
    // InternalFirstOrderLogic.g:1800:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1804:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1805:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1805:1: ( 'context' )
            // InternalFirstOrderLogic.g:1806:2: 'context'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_4()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getContextKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__5"
    // InternalFirstOrderLogic.g:1815:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1819:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1820:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Constraint__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5"


    // $ANTLR start "rule__Constraint__Group__5__Impl"
    // InternalFirstOrderLogic.g:1827:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1831:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1832:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1832:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1833:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1834:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1834:3: rule__Constraint__VariableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__VariableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5__Impl"


    // $ANTLR start "rule__Constraint__Group__6"
    // InternalFirstOrderLogic.g:1842:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1846:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1847:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Constraint__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6"


    // $ANTLR start "rule__Constraint__Group__6__Impl"
    // InternalFirstOrderLogic.g:1854:1: rule__Constraint__Group__6__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1858:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1859:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1859:1: ( ':' )
            // InternalFirstOrderLogic.g:1860:2: ':'
            {
             before(grammarAccess.getConstraintAccess().getColonKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6__Impl"


    // $ANTLR start "rule__Constraint__Group__7"
    // InternalFirstOrderLogic.g:1869:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1873:1: ( rule__Constraint__Group__7__Impl )
            // InternalFirstOrderLogic.g:1874:2: rule__Constraint__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7"


    // $ANTLR start "rule__Constraint__Group__7__Impl"
    // InternalFirstOrderLogic.g:1880:1: rule__Constraint__Group__7__Impl : ( ( rule__Constraint__FormulaAssignment_7 ) ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1884:1: ( ( ( rule__Constraint__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:1885:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:1885:1: ( ( rule__Constraint__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:1886:2: ( rule__Constraint__FormulaAssignment_7 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:1887:2: ( rule__Constraint__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:1887:3: rule__Constraint__FormulaAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__FormulaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getFormulaAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalFirstOrderLogic.g:1896:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1900:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1901:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalFirstOrderLogic.g:1908:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1912:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1913:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1913:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1914:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1915:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1915:3: rule__Variable__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalFirstOrderLogic.g:1923:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1927:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1928:2: rule__Variable__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalFirstOrderLogic.g:1934:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1938:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1939:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1939:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1940:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1941:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1941:3: rule__Variable__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Iff__Group__0"
    // InternalFirstOrderLogic.g:1950:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1954:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1955:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Iff__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__0"


    // $ANTLR start "rule__Iff__Group__0__Impl"
    // InternalFirstOrderLogic.g:1962:1: rule__Iff__Group__0__Impl : ( ruleIf ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1966:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:1967:1: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:1967:1: ( ruleIf )
            // InternalFirstOrderLogic.g:1968:2: ruleIf
            {
             before(grammarAccess.getIffAccess().getIfParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIffAccess().getIfParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__0__Impl"


    // $ANTLR start "rule__Iff__Group__1"
    // InternalFirstOrderLogic.g:1977:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1981:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1982:2: rule__Iff__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__1"


    // $ANTLR start "rule__Iff__Group__1__Impl"
    // InternalFirstOrderLogic.g:1988:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1992:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1993:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1993:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1994:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1995:2: ( rule__Iff__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1995:3: rule__Iff__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Iff__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getIffAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group__1__Impl"


    // $ANTLR start "rule__Iff__Group_1__0"
    // InternalFirstOrderLogic.g:2004:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2008:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:2009:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Iff__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__0"


    // $ANTLR start "rule__Iff__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2016:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2020:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2021:1: ( () )
            {
            // InternalFirstOrderLogic.g:2021:1: ( () )
            // InternalFirstOrderLogic.g:2022:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2023:2: ()
            // InternalFirstOrderLogic.g:2023:3: 
            {
            }

             after(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__0__Impl"


    // $ANTLR start "rule__Iff__Group_1__1"
    // InternalFirstOrderLogic.g:2031:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2035:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:2036:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Iff__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__1"


    // $ANTLR start "rule__Iff__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2043:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2047:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:2048:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:2048:1: ( '=' )
            // InternalFirstOrderLogic.g:2049:2: '='
            {
             before(grammarAccess.getIffAccess().getEqualsSignKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getIffAccess().getEqualsSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__1__Impl"


    // $ANTLR start "rule__Iff__Group_1__2"
    // InternalFirstOrderLogic.g:2058:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2062:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2063:2: rule__Iff__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iff__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__2"


    // $ANTLR start "rule__Iff__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2069:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2073:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2074:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2074:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2075:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2076:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2076:3: rule__Iff__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Iff__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getIffAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__Group_1__2__Impl"


    // $ANTLR start "rule__If__Group__0"
    // InternalFirstOrderLogic.g:2085:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2089:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:2090:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__If__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0"


    // $ANTLR start "rule__If__Group__0__Impl"
    // InternalFirstOrderLogic.g:2097:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2101:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:2102:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:2102:1: ( ruleXor )
            // InternalFirstOrderLogic.g:2103:2: ruleXor
            {
             before(grammarAccess.getIfAccess().getXorParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getIfAccess().getXorParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__0__Impl"


    // $ANTLR start "rule__If__Group__1"
    // InternalFirstOrderLogic.g:2112:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2116:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:2117:2: rule__If__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__If__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1"


    // $ANTLR start "rule__If__Group__1__Impl"
    // InternalFirstOrderLogic.g:2123:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2127:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2128:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2128:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2129:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2130:2: ( rule__If__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2130:3: rule__If__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__If__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getIfAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group__1__Impl"


    // $ANTLR start "rule__If__Group_1__0"
    // InternalFirstOrderLogic.g:2139:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2143:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:2144:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__If__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__0"


    // $ANTLR start "rule__If__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2151:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2155:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2156:1: ( () )
            {
            // InternalFirstOrderLogic.g:2156:1: ( () )
            // InternalFirstOrderLogic.g:2157:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2158:2: ()
            // InternalFirstOrderLogic.g:2158:3: 
            {
            }

             after(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__0__Impl"


    // $ANTLR start "rule__If__Group_1__1"
    // InternalFirstOrderLogic.g:2166:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2170:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:2171:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__If__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__If__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__1"


    // $ANTLR start "rule__If__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2178:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2182:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:2183:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:2183:1: ( 'implies' )
            // InternalFirstOrderLogic.g:2184:2: 'implies'
            {
             before(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__1__Impl"


    // $ANTLR start "rule__If__Group_1__2"
    // InternalFirstOrderLogic.g:2193:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2197:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2198:2: rule__If__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__If__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__2"


    // $ANTLR start "rule__If__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2204:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2208:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2209:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2209:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2210:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2211:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2211:3: rule__If__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__If__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getIfAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__Group_1__2__Impl"


    // $ANTLR start "rule__Xor__Group__0"
    // InternalFirstOrderLogic.g:2220:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2224:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:2225:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Xor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0"


    // $ANTLR start "rule__Xor__Group__0__Impl"
    // InternalFirstOrderLogic.g:2232:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2236:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:2237:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:2237:1: ( ruleOr )
            // InternalFirstOrderLogic.g:2238:2: ruleOr
            {
             before(grammarAccess.getXorAccess().getOrParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getXorAccess().getOrParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__0__Impl"


    // $ANTLR start "rule__Xor__Group__1"
    // InternalFirstOrderLogic.g:2247:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2251:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:2252:2: rule__Xor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1"


    // $ANTLR start "rule__Xor__Group__1__Impl"
    // InternalFirstOrderLogic.g:2258:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2262:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2263:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2263:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2264:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2265:2: ( rule__Xor__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2265:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Xor__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getXorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__0"
    // InternalFirstOrderLogic.g:2274:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2278:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:2279:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__Xor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0"


    // $ANTLR start "rule__Xor__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2286:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2290:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2291:1: ( () )
            {
            // InternalFirstOrderLogic.g:2291:1: ( () )
            // InternalFirstOrderLogic.g:2292:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2293:2: ()
            // InternalFirstOrderLogic.g:2293:3: 
            {
            }

             after(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__0__Impl"


    // $ANTLR start "rule__Xor__Group_1__1"
    // InternalFirstOrderLogic.g:2301:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2305:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:2306:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Xor__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1"


    // $ANTLR start "rule__Xor__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2313:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2317:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:2318:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:2318:1: ( 'xor' )
            // InternalFirstOrderLogic.g:2319:2: 'xor'
            {
             before(grammarAccess.getXorAccess().getXorKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getXorAccess().getXorKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__1__Impl"


    // $ANTLR start "rule__Xor__Group_1__2"
    // InternalFirstOrderLogic.g:2328:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2332:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2333:2: rule__Xor__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Xor__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2"


    // $ANTLR start "rule__Xor__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2339:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2343:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2344:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2344:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2345:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2346:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2346:3: rule__Xor__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Xor__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getXorAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__Group_1__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalFirstOrderLogic.g:2355:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2359:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:2360:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalFirstOrderLogic.g:2367:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2371:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:2372:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:2372:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:2373:2: ruleAnd
            {
             before(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalFirstOrderLogic.g:2382:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2386:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:2387:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalFirstOrderLogic.g:2393:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2397:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2398:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2398:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2399:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2400:2: ( rule__Or__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==21) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2400:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getOrAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // InternalFirstOrderLogic.g:2409:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2413:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:2414:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2421:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2425:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2426:1: ( () )
            {
            // InternalFirstOrderLogic.g:2426:1: ( () )
            // InternalFirstOrderLogic.g:2427:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2428:2: ()
            // InternalFirstOrderLogic.g:2428:3: 
            {
            }

             after(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // InternalFirstOrderLogic.g:2436:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2440:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:2441:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Or__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2448:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2452:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:2453:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:2453:1: ( 'or' )
            // InternalFirstOrderLogic.g:2454:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getOrAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1__2"
    // InternalFirstOrderLogic.g:2463:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2467:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2468:2: rule__Or__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2"


    // $ANTLR start "rule__Or__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2474:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2478:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2479:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2479:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2480:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2481:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2481:3: rule__Or__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Or__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__2__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalFirstOrderLogic.g:2490:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2494:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:2495:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalFirstOrderLogic.g:2502:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2506:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:2507:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:2507:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:2508:2: ruleBooleanExpression
            {
             before(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalFirstOrderLogic.g:2517:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2521:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:2522:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalFirstOrderLogic.g:2528:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2532:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2533:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2533:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2534:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2535:2: ( rule__And__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2535:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__And__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getAndAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalFirstOrderLogic.g:2544:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2548:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:2549:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:2556:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2560:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2561:1: ( () )
            {
            // InternalFirstOrderLogic.g:2561:1: ( () )
            // InternalFirstOrderLogic.g:2562:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2563:2: ()
            // InternalFirstOrderLogic.g:2563:3: 
            {
            }

             after(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalFirstOrderLogic.g:2571:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2575:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:2576:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__And__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:2583:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2587:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2588:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2588:1: ( 'and' )
            // InternalFirstOrderLogic.g:2589:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getAndAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1__2"
    // InternalFirstOrderLogic.g:2598:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2602:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2603:2: rule__And__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2"


    // $ANTLR start "rule__And__Group_1__2__Impl"
    // InternalFirstOrderLogic.g:2609:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2613:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2614:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2614:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2615:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2616:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2616:3: rule__And__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__And__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__2__Impl"


    // $ANTLR start "rule__Not__Group__0"
    // InternalFirstOrderLogic.g:2625:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2629:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2630:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Not__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0"


    // $ANTLR start "rule__Not__Group__0__Impl"
    // InternalFirstOrderLogic.g:2637:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2641:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2642:1: ( () )
            {
            // InternalFirstOrderLogic.g:2642:1: ( () )
            // InternalFirstOrderLogic.g:2643:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2644:2: ()
            // InternalFirstOrderLogic.g:2644:3: 
            {
            }

             after(grammarAccess.getNotAccess().getNotAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0__Impl"


    // $ANTLR start "rule__Not__Group__1"
    // InternalFirstOrderLogic.g:2652:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2656:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2657:2: rule__Not__Group__1__Impl rule__Not__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Not__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1"


    // $ANTLR start "rule__Not__Group__1__Impl"
    // InternalFirstOrderLogic.g:2664:1: rule__Not__Group__1__Impl : ( 'not' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2668:1: ( ( 'not' ) )
            // InternalFirstOrderLogic.g:2669:1: ( 'not' )
            {
            // InternalFirstOrderLogic.g:2669:1: ( 'not' )
            // InternalFirstOrderLogic.g:2670:2: 'not'
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getNotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1__Impl"


    // $ANTLR start "rule__Not__Group__2"
    // InternalFirstOrderLogic.g:2679:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2683:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2684:2: rule__Not__Group__2__Impl rule__Not__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Not__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2"


    // $ANTLR start "rule__Not__Group__2__Impl"
    // InternalFirstOrderLogic.g:2691:1: rule__Not__Group__2__Impl : ( '(' ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2695:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2696:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2696:1: ( '(' )
            // InternalFirstOrderLogic.g:2697:2: '('
            {
             before(grammarAccess.getNotAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2__Impl"


    // $ANTLR start "rule__Not__Group__3"
    // InternalFirstOrderLogic.g:2706:1: rule__Not__Group__3 : rule__Not__Group__3__Impl rule__Not__Group__4 ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2710:1: ( rule__Not__Group__3__Impl rule__Not__Group__4 )
            // InternalFirstOrderLogic.g:2711:2: rule__Not__Group__3__Impl rule__Not__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__Not__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3"


    // $ANTLR start "rule__Not__Group__3__Impl"
    // InternalFirstOrderLogic.g:2718:1: rule__Not__Group__3__Impl : ( ( rule__Not__NotAssignment_3 ) ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2722:1: ( ( ( rule__Not__NotAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2723:1: ( ( rule__Not__NotAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2723:1: ( ( rule__Not__NotAssignment_3 ) )
            // InternalFirstOrderLogic.g:2724:2: ( rule__Not__NotAssignment_3 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_3()); 
            // InternalFirstOrderLogic.g:2725:2: ( rule__Not__NotAssignment_3 )
            // InternalFirstOrderLogic.g:2725:3: rule__Not__NotAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Not__NotAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getNotAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3__Impl"


    // $ANTLR start "rule__Not__Group__4"
    // InternalFirstOrderLogic.g:2733:1: rule__Not__Group__4 : rule__Not__Group__4__Impl ;
    public final void rule__Not__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2737:1: ( rule__Not__Group__4__Impl )
            // InternalFirstOrderLogic.g:2738:2: rule__Not__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__4"


    // $ANTLR start "rule__Not__Group__4__Impl"
    // InternalFirstOrderLogic.g:2744:1: rule__Not__Group__4__Impl : ( ')' ) ;
    public final void rule__Not__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2748:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2749:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2749:1: ( ')' )
            // InternalFirstOrderLogic.g:2750:2: ')'
            {
             before(grammarAccess.getNotAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__4__Impl"


    // $ANTLR start "rule__Equals__Group__0"
    // InternalFirstOrderLogic.g:2760:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2764:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2765:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Equals__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0"


    // $ANTLR start "rule__Equals__Group__0__Impl"
    // InternalFirstOrderLogic.g:2772:1: rule__Equals__Group__0__Impl : ( 'isEqual' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2776:1: ( ( 'isEqual' ) )
            // InternalFirstOrderLogic.g:2777:1: ( 'isEqual' )
            {
            // InternalFirstOrderLogic.g:2777:1: ( 'isEqual' )
            // InternalFirstOrderLogic.g:2778:2: 'isEqual'
            {
             before(grammarAccess.getEqualsAccess().getIsEqualKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getIsEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__0__Impl"


    // $ANTLR start "rule__Equals__Group__1"
    // InternalFirstOrderLogic.g:2787:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2791:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2792:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Equals__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1"


    // $ANTLR start "rule__Equals__Group__1__Impl"
    // InternalFirstOrderLogic.g:2799:1: rule__Equals__Group__1__Impl : ( '(' ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2803:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2804:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2804:1: ( '(' )
            // InternalFirstOrderLogic.g:2805:2: '('
            {
             before(grammarAccess.getEqualsAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__1__Impl"


    // $ANTLR start "rule__Equals__Group__2"
    // InternalFirstOrderLogic.g:2814:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2818:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2819:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Equals__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__2"


    // $ANTLR start "rule__Equals__Group__2__Impl"
    // InternalFirstOrderLogic.g:2826:1: rule__Equals__Group__2__Impl : ( ( rule__Equals__LeftAssignment_2 ) ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2830:1: ( ( ( rule__Equals__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2831:1: ( ( rule__Equals__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2831:1: ( ( rule__Equals__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:2832:2: ( rule__Equals__LeftAssignment_2 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:2833:2: ( rule__Equals__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:2833:3: rule__Equals__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Equals__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__2__Impl"


    // $ANTLR start "rule__Equals__Group__3"
    // InternalFirstOrderLogic.g:2841:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2845:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2846:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Equals__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__3"


    // $ANTLR start "rule__Equals__Group__3__Impl"
    // InternalFirstOrderLogic.g:2853:1: rule__Equals__Group__3__Impl : ( ',' ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2857:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2858:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2858:1: ( ',' )
            // InternalFirstOrderLogic.g:2859:2: ','
            {
             before(grammarAccess.getEqualsAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__3__Impl"


    // $ANTLR start "rule__Equals__Group__4"
    // InternalFirstOrderLogic.g:2868:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl rule__Equals__Group__5 ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2872:1: ( rule__Equals__Group__4__Impl rule__Equals__Group__5 )
            // InternalFirstOrderLogic.g:2873:2: rule__Equals__Group__4__Impl rule__Equals__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Equals__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equals__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__4"


    // $ANTLR start "rule__Equals__Group__4__Impl"
    // InternalFirstOrderLogic.g:2880:1: rule__Equals__Group__4__Impl : ( ( rule__Equals__RightAssignment_4 ) ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2884:1: ( ( ( rule__Equals__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:2885:1: ( ( rule__Equals__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:2885:1: ( ( rule__Equals__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:2886:2: ( rule__Equals__RightAssignment_4 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:2887:2: ( rule__Equals__RightAssignment_4 )
            // InternalFirstOrderLogic.g:2887:3: rule__Equals__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Equals__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEqualsAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__4__Impl"


    // $ANTLR start "rule__Equals__Group__5"
    // InternalFirstOrderLogic.g:2895:1: rule__Equals__Group__5 : rule__Equals__Group__5__Impl ;
    public final void rule__Equals__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2899:1: ( rule__Equals__Group__5__Impl )
            // InternalFirstOrderLogic.g:2900:2: rule__Equals__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equals__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__5"


    // $ANTLR start "rule__Equals__Group__5__Impl"
    // InternalFirstOrderLogic.g:2906:1: rule__Equals__Group__5__Impl : ( ')' ) ;
    public final void rule__Equals__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2910:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2911:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2911:1: ( ')' )
            // InternalFirstOrderLogic.g:2912:2: ')'
            {
             before(grammarAccess.getEqualsAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEqualsAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group__5__Impl"


    // $ANTLR start "rule__Greater__Group__0"
    // InternalFirstOrderLogic.g:2922:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2926:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2927:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Greater__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__0"


    // $ANTLR start "rule__Greater__Group__0__Impl"
    // InternalFirstOrderLogic.g:2934:1: rule__Greater__Group__0__Impl : ( 'isGreater' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2938:1: ( ( 'isGreater' ) )
            // InternalFirstOrderLogic.g:2939:1: ( 'isGreater' )
            {
            // InternalFirstOrderLogic.g:2939:1: ( 'isGreater' )
            // InternalFirstOrderLogic.g:2940:2: 'isGreater'
            {
             before(grammarAccess.getGreaterAccess().getIsGreaterKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getIsGreaterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__0__Impl"


    // $ANTLR start "rule__Greater__Group__1"
    // InternalFirstOrderLogic.g:2949:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2953:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2954:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Greater__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__1"


    // $ANTLR start "rule__Greater__Group__1__Impl"
    // InternalFirstOrderLogic.g:2961:1: rule__Greater__Group__1__Impl : ( '(' ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2965:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2966:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2966:1: ( '(' )
            // InternalFirstOrderLogic.g:2967:2: '('
            {
             before(grammarAccess.getGreaterAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__1__Impl"


    // $ANTLR start "rule__Greater__Group__2"
    // InternalFirstOrderLogic.g:2976:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2980:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2981:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Greater__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__2"


    // $ANTLR start "rule__Greater__Group__2__Impl"
    // InternalFirstOrderLogic.g:2988:1: rule__Greater__Group__2__Impl : ( ( rule__Greater__LeftAssignment_2 ) ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2992:1: ( ( ( rule__Greater__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2993:1: ( ( rule__Greater__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2993:1: ( ( rule__Greater__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:2994:2: ( rule__Greater__LeftAssignment_2 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:2995:2: ( rule__Greater__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:2995:3: rule__Greater__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Greater__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__2__Impl"


    // $ANTLR start "rule__Greater__Group__3"
    // InternalFirstOrderLogic.g:3003:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3007:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:3008:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Greater__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__3"


    // $ANTLR start "rule__Greater__Group__3__Impl"
    // InternalFirstOrderLogic.g:3015:1: rule__Greater__Group__3__Impl : ( ',' ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3019:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3020:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3020:1: ( ',' )
            // InternalFirstOrderLogic.g:3021:2: ','
            {
             before(grammarAccess.getGreaterAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__3__Impl"


    // $ANTLR start "rule__Greater__Group__4"
    // InternalFirstOrderLogic.g:3030:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl rule__Greater__Group__5 ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3034:1: ( rule__Greater__Group__4__Impl rule__Greater__Group__5 )
            // InternalFirstOrderLogic.g:3035:2: rule__Greater__Group__4__Impl rule__Greater__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Greater__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Greater__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__4"


    // $ANTLR start "rule__Greater__Group__4__Impl"
    // InternalFirstOrderLogic.g:3042:1: rule__Greater__Group__4__Impl : ( ( rule__Greater__RightAssignment_4 ) ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3046:1: ( ( ( rule__Greater__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3047:1: ( ( rule__Greater__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3047:1: ( ( rule__Greater__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3048:2: ( rule__Greater__RightAssignment_4 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3049:2: ( rule__Greater__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3049:3: rule__Greater__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Greater__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGreaterAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__4__Impl"


    // $ANTLR start "rule__Greater__Group__5"
    // InternalFirstOrderLogic.g:3057:1: rule__Greater__Group__5 : rule__Greater__Group__5__Impl ;
    public final void rule__Greater__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3061:1: ( rule__Greater__Group__5__Impl )
            // InternalFirstOrderLogic.g:3062:2: rule__Greater__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Greater__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__5"


    // $ANTLR start "rule__Greater__Group__5__Impl"
    // InternalFirstOrderLogic.g:3068:1: rule__Greater__Group__5__Impl : ( ')' ) ;
    public final void rule__Greater__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3072:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3073:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3073:1: ( ')' )
            // InternalFirstOrderLogic.g:3074:2: ')'
            {
             before(grammarAccess.getGreaterAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGreaterAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__Group__5__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__0"
    // InternalFirstOrderLogic.g:3084:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3088:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:3089:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__GreaterEqual__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__0"


    // $ANTLR start "rule__GreaterEqual__Group__0__Impl"
    // InternalFirstOrderLogic.g:3096:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3100:1: ( ( 'isGreaterEqual' ) )
            // InternalFirstOrderLogic.g:3101:1: ( 'isGreaterEqual' )
            {
            // InternalFirstOrderLogic.g:3101:1: ( 'isGreaterEqual' )
            // InternalFirstOrderLogic.g:3102:2: 'isGreaterEqual'
            {
             before(grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__0__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__1"
    // InternalFirstOrderLogic.g:3111:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3115:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:3116:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GreaterEqual__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__1"


    // $ANTLR start "rule__GreaterEqual__Group__1__Impl"
    // InternalFirstOrderLogic.g:3123:1: rule__GreaterEqual__Group__1__Impl : ( '(' ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3127:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3128:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3128:1: ( '(' )
            // InternalFirstOrderLogic.g:3129:2: '('
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__1__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__2"
    // InternalFirstOrderLogic.g:3138:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3142:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:3143:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__GreaterEqual__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__2"


    // $ANTLR start "rule__GreaterEqual__Group__2__Impl"
    // InternalFirstOrderLogic.g:3150:1: rule__GreaterEqual__Group__2__Impl : ( ( rule__GreaterEqual__LeftAssignment_2 ) ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3154:1: ( ( ( rule__GreaterEqual__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3155:1: ( ( rule__GreaterEqual__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3155:1: ( ( rule__GreaterEqual__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3156:2: ( rule__GreaterEqual__LeftAssignment_2 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3157:2: ( rule__GreaterEqual__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3157:3: rule__GreaterEqual__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__2__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__3"
    // InternalFirstOrderLogic.g:3165:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3169:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:3170:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__GreaterEqual__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__3"


    // $ANTLR start "rule__GreaterEqual__Group__3__Impl"
    // InternalFirstOrderLogic.g:3177:1: rule__GreaterEqual__Group__3__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3181:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3182:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3182:1: ( ',' )
            // InternalFirstOrderLogic.g:3183:2: ','
            {
             before(grammarAccess.getGreaterEqualAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__3__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__4"
    // InternalFirstOrderLogic.g:3192:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5 ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3196:1: ( rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5 )
            // InternalFirstOrderLogic.g:3197:2: rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__GreaterEqual__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__4"


    // $ANTLR start "rule__GreaterEqual__Group__4__Impl"
    // InternalFirstOrderLogic.g:3204:1: rule__GreaterEqual__Group__4__Impl : ( ( rule__GreaterEqual__RightAssignment_4 ) ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3208:1: ( ( ( rule__GreaterEqual__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3209:1: ( ( rule__GreaterEqual__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3209:1: ( ( rule__GreaterEqual__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3210:2: ( rule__GreaterEqual__RightAssignment_4 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3211:2: ( rule__GreaterEqual__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3211:3: rule__GreaterEqual__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGreaterEqualAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__4__Impl"


    // $ANTLR start "rule__GreaterEqual__Group__5"
    // InternalFirstOrderLogic.g:3219:1: rule__GreaterEqual__Group__5 : rule__GreaterEqual__Group__5__Impl ;
    public final void rule__GreaterEqual__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3223:1: ( rule__GreaterEqual__Group__5__Impl )
            // InternalFirstOrderLogic.g:3224:2: rule__GreaterEqual__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GreaterEqual__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__5"


    // $ANTLR start "rule__GreaterEqual__Group__5__Impl"
    // InternalFirstOrderLogic.g:3230:1: rule__GreaterEqual__Group__5__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3234:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3235:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3235:1: ( ')' )
            // InternalFirstOrderLogic.g:3236:2: ')'
            {
             before(grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__Group__5__Impl"


    // $ANTLR start "rule__Smaller__Group__0"
    // InternalFirstOrderLogic.g:3246:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3250:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:3251:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Smaller__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__0"


    // $ANTLR start "rule__Smaller__Group__0__Impl"
    // InternalFirstOrderLogic.g:3258:1: rule__Smaller__Group__0__Impl : ( 'isSmaller' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3262:1: ( ( 'isSmaller' ) )
            // InternalFirstOrderLogic.g:3263:1: ( 'isSmaller' )
            {
            // InternalFirstOrderLogic.g:3263:1: ( 'isSmaller' )
            // InternalFirstOrderLogic.g:3264:2: 'isSmaller'
            {
             before(grammarAccess.getSmallerAccess().getIsSmallerKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getIsSmallerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__0__Impl"


    // $ANTLR start "rule__Smaller__Group__1"
    // InternalFirstOrderLogic.g:3273:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3277:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:3278:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Smaller__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__1"


    // $ANTLR start "rule__Smaller__Group__1__Impl"
    // InternalFirstOrderLogic.g:3285:1: rule__Smaller__Group__1__Impl : ( '(' ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3289:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3290:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3290:1: ( '(' )
            // InternalFirstOrderLogic.g:3291:2: '('
            {
             before(grammarAccess.getSmallerAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__1__Impl"


    // $ANTLR start "rule__Smaller__Group__2"
    // InternalFirstOrderLogic.g:3300:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3304:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:3305:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Smaller__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__2"


    // $ANTLR start "rule__Smaller__Group__2__Impl"
    // InternalFirstOrderLogic.g:3312:1: rule__Smaller__Group__2__Impl : ( ( rule__Smaller__LeftAssignment_2 ) ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3316:1: ( ( ( rule__Smaller__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3317:1: ( ( rule__Smaller__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3317:1: ( ( rule__Smaller__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3318:2: ( rule__Smaller__LeftAssignment_2 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3319:2: ( rule__Smaller__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3319:3: rule__Smaller__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__2__Impl"


    // $ANTLR start "rule__Smaller__Group__3"
    // InternalFirstOrderLogic.g:3327:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3331:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:3332:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Smaller__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__3"


    // $ANTLR start "rule__Smaller__Group__3__Impl"
    // InternalFirstOrderLogic.g:3339:1: rule__Smaller__Group__3__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3343:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3344:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3344:1: ( ',' )
            // InternalFirstOrderLogic.g:3345:2: ','
            {
             before(grammarAccess.getSmallerAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__3__Impl"


    // $ANTLR start "rule__Smaller__Group__4"
    // InternalFirstOrderLogic.g:3354:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl rule__Smaller__Group__5 ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3358:1: ( rule__Smaller__Group__4__Impl rule__Smaller__Group__5 )
            // InternalFirstOrderLogic.g:3359:2: rule__Smaller__Group__4__Impl rule__Smaller__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Smaller__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Smaller__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__4"


    // $ANTLR start "rule__Smaller__Group__4__Impl"
    // InternalFirstOrderLogic.g:3366:1: rule__Smaller__Group__4__Impl : ( ( rule__Smaller__RightAssignment_4 ) ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3370:1: ( ( ( rule__Smaller__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3371:1: ( ( rule__Smaller__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3371:1: ( ( rule__Smaller__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3372:2: ( rule__Smaller__RightAssignment_4 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3373:2: ( rule__Smaller__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3373:3: rule__Smaller__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSmallerAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__4__Impl"


    // $ANTLR start "rule__Smaller__Group__5"
    // InternalFirstOrderLogic.g:3381:1: rule__Smaller__Group__5 : rule__Smaller__Group__5__Impl ;
    public final void rule__Smaller__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3385:1: ( rule__Smaller__Group__5__Impl )
            // InternalFirstOrderLogic.g:3386:2: rule__Smaller__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Smaller__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__5"


    // $ANTLR start "rule__Smaller__Group__5__Impl"
    // InternalFirstOrderLogic.g:3392:1: rule__Smaller__Group__5__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3396:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3397:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3397:1: ( ')' )
            // InternalFirstOrderLogic.g:3398:2: ')'
            {
             before(grammarAccess.getSmallerAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSmallerAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__Group__5__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__0"
    // InternalFirstOrderLogic.g:3408:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3412:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:3413:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__SmallerEqual__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__0"


    // $ANTLR start "rule__SmallerEqual__Group__0__Impl"
    // InternalFirstOrderLogic.g:3420:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3424:1: ( ( 'isSmallerEqual' ) )
            // InternalFirstOrderLogic.g:3425:1: ( 'isSmallerEqual' )
            {
            // InternalFirstOrderLogic.g:3425:1: ( 'isSmallerEqual' )
            // InternalFirstOrderLogic.g:3426:2: 'isSmallerEqual'
            {
             before(grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__0__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__1"
    // InternalFirstOrderLogic.g:3435:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3439:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:3440:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__SmallerEqual__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__1"


    // $ANTLR start "rule__SmallerEqual__Group__1__Impl"
    // InternalFirstOrderLogic.g:3447:1: rule__SmallerEqual__Group__1__Impl : ( '(' ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3451:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3452:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3452:1: ( '(' )
            // InternalFirstOrderLogic.g:3453:2: '('
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__1__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__2"
    // InternalFirstOrderLogic.g:3462:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3466:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:3467:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__SmallerEqual__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__2"


    // $ANTLR start "rule__SmallerEqual__Group__2__Impl"
    // InternalFirstOrderLogic.g:3474:1: rule__SmallerEqual__Group__2__Impl : ( ( rule__SmallerEqual__LeftAssignment_2 ) ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3478:1: ( ( ( rule__SmallerEqual__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3479:1: ( ( rule__SmallerEqual__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3479:1: ( ( rule__SmallerEqual__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3480:2: ( rule__SmallerEqual__LeftAssignment_2 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3481:2: ( rule__SmallerEqual__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3481:3: rule__SmallerEqual__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__2__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__3"
    // InternalFirstOrderLogic.g:3489:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3493:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:3494:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__SmallerEqual__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__3"


    // $ANTLR start "rule__SmallerEqual__Group__3__Impl"
    // InternalFirstOrderLogic.g:3501:1: rule__SmallerEqual__Group__3__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3505:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3506:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3506:1: ( ',' )
            // InternalFirstOrderLogic.g:3507:2: ','
            {
             before(grammarAccess.getSmallerEqualAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__3__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__4"
    // InternalFirstOrderLogic.g:3516:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5 ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3520:1: ( rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5 )
            // InternalFirstOrderLogic.g:3521:2: rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__SmallerEqual__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__4"


    // $ANTLR start "rule__SmallerEqual__Group__4__Impl"
    // InternalFirstOrderLogic.g:3528:1: rule__SmallerEqual__Group__4__Impl : ( ( rule__SmallerEqual__RightAssignment_4 ) ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3532:1: ( ( ( rule__SmallerEqual__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3533:1: ( ( rule__SmallerEqual__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3533:1: ( ( rule__SmallerEqual__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3534:2: ( rule__SmallerEqual__RightAssignment_4 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3535:2: ( rule__SmallerEqual__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3535:3: rule__SmallerEqual__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSmallerEqualAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__4__Impl"


    // $ANTLR start "rule__SmallerEqual__Group__5"
    // InternalFirstOrderLogic.g:3543:1: rule__SmallerEqual__Group__5 : rule__SmallerEqual__Group__5__Impl ;
    public final void rule__SmallerEqual__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3547:1: ( rule__SmallerEqual__Group__5__Impl )
            // InternalFirstOrderLogic.g:3548:2: rule__SmallerEqual__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SmallerEqual__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__5"


    // $ANTLR start "rule__SmallerEqual__Group__5__Impl"
    // InternalFirstOrderLogic.g:3554:1: rule__SmallerEqual__Group__5__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3558:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3559:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3559:1: ( ')' )
            // InternalFirstOrderLogic.g:3560:2: ')'
            {
             before(grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__Group__5__Impl"


    // $ANTLR start "rule__IsEmpty__Group__0"
    // InternalFirstOrderLogic.g:3570:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3574:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:3575:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__IsEmpty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__0"


    // $ANTLR start "rule__IsEmpty__Group__0__Impl"
    // InternalFirstOrderLogic.g:3582:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3586:1: ( ( 'isEmpty' ) )
            // InternalFirstOrderLogic.g:3587:1: ( 'isEmpty' )
            {
            // InternalFirstOrderLogic.g:3587:1: ( 'isEmpty' )
            // InternalFirstOrderLogic.g:3588:2: 'isEmpty'
            {
             before(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__0__Impl"


    // $ANTLR start "rule__IsEmpty__Group__1"
    // InternalFirstOrderLogic.g:3597:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3601:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:3602:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IsEmpty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__1"


    // $ANTLR start "rule__IsEmpty__Group__1__Impl"
    // InternalFirstOrderLogic.g:3609:1: rule__IsEmpty__Group__1__Impl : ( '(' ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3613:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3614:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3614:1: ( '(' )
            // InternalFirstOrderLogic.g:3615:2: '('
            {
             before(grammarAccess.getIsEmptyAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__1__Impl"


    // $ANTLR start "rule__IsEmpty__Group__2"
    // InternalFirstOrderLogic.g:3624:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3 ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3628:1: ( rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3 )
            // InternalFirstOrderLogic.g:3629:2: rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__IsEmpty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__2"


    // $ANTLR start "rule__IsEmpty__Group__2__Impl"
    // InternalFirstOrderLogic.g:3636:1: rule__IsEmpty__Group__2__Impl : ( ( rule__IsEmpty__TermAssignment_2 ) ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3640:1: ( ( ( rule__IsEmpty__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3641:1: ( ( rule__IsEmpty__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3641:1: ( ( rule__IsEmpty__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3642:2: ( rule__IsEmpty__TermAssignment_2 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3643:2: ( rule__IsEmpty__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3643:3: rule__IsEmpty__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__TermAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIsEmptyAccess().getTermAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__2__Impl"


    // $ANTLR start "rule__IsEmpty__Group__3"
    // InternalFirstOrderLogic.g:3651:1: rule__IsEmpty__Group__3 : rule__IsEmpty__Group__3__Impl ;
    public final void rule__IsEmpty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3655:1: ( rule__IsEmpty__Group__3__Impl )
            // InternalFirstOrderLogic.g:3656:2: rule__IsEmpty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsEmpty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__3"


    // $ANTLR start "rule__IsEmpty__Group__3__Impl"
    // InternalFirstOrderLogic.g:3662:1: rule__IsEmpty__Group__3__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3666:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3667:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3667:1: ( ')' )
            // InternalFirstOrderLogic.g:3668:2: ')'
            {
             before(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__Group__3__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__0"
    // InternalFirstOrderLogic.g:3678:1: rule__IsInstanceOf__Group__0 : rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 ;
    public final void rule__IsInstanceOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3682:1: ( rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 )
            // InternalFirstOrderLogic.g:3683:2: rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__IsInstanceOf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__0"


    // $ANTLR start "rule__IsInstanceOf__Group__0__Impl"
    // InternalFirstOrderLogic.g:3690:1: rule__IsInstanceOf__Group__0__Impl : ( 'isInstanceOf' ) ;
    public final void rule__IsInstanceOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3694:1: ( ( 'isInstanceOf' ) )
            // InternalFirstOrderLogic.g:3695:1: ( 'isInstanceOf' )
            {
            // InternalFirstOrderLogic.g:3695:1: ( 'isInstanceOf' )
            // InternalFirstOrderLogic.g:3696:2: 'isInstanceOf'
            {
             before(grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__0__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__1"
    // InternalFirstOrderLogic.g:3705:1: rule__IsInstanceOf__Group__1 : rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 ;
    public final void rule__IsInstanceOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3709:1: ( rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 )
            // InternalFirstOrderLogic.g:3710:2: rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IsInstanceOf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__1"


    // $ANTLR start "rule__IsInstanceOf__Group__1__Impl"
    // InternalFirstOrderLogic.g:3717:1: rule__IsInstanceOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IsInstanceOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3721:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3722:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3722:1: ( '(' )
            // InternalFirstOrderLogic.g:3723:2: '('
            {
             before(grammarAccess.getIsInstanceOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__1__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__2"
    // InternalFirstOrderLogic.g:3732:1: rule__IsInstanceOf__Group__2 : rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 ;
    public final void rule__IsInstanceOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3736:1: ( rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 )
            // InternalFirstOrderLogic.g:3737:2: rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__IsInstanceOf__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__2"


    // $ANTLR start "rule__IsInstanceOf__Group__2__Impl"
    // InternalFirstOrderLogic.g:3744:1: rule__IsInstanceOf__Group__2__Impl : ( ( rule__IsInstanceOf__TermAssignment_2 ) ) ;
    public final void rule__IsInstanceOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3748:1: ( ( ( rule__IsInstanceOf__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3749:1: ( ( rule__IsInstanceOf__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3749:1: ( ( rule__IsInstanceOf__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3750:2: ( rule__IsInstanceOf__TermAssignment_2 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3751:2: ( rule__IsInstanceOf__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3751:3: rule__IsInstanceOf__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__TermAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getTermAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__2__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__3"
    // InternalFirstOrderLogic.g:3759:1: rule__IsInstanceOf__Group__3 : rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 ;
    public final void rule__IsInstanceOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3763:1: ( rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 )
            // InternalFirstOrderLogic.g:3764:2: rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__IsInstanceOf__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__3"


    // $ANTLR start "rule__IsInstanceOf__Group__3__Impl"
    // InternalFirstOrderLogic.g:3771:1: rule__IsInstanceOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IsInstanceOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3775:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3776:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3776:1: ( ',' )
            // InternalFirstOrderLogic.g:3777:2: ','
            {
             before(grammarAccess.getIsInstanceOfAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__3__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__4"
    // InternalFirstOrderLogic.g:3786:1: rule__IsInstanceOf__Group__4 : rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5 ;
    public final void rule__IsInstanceOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3790:1: ( rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5 )
            // InternalFirstOrderLogic.g:3791:2: rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__IsInstanceOf__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__4"


    // $ANTLR start "rule__IsInstanceOf__Group__4__Impl"
    // InternalFirstOrderLogic.g:3798:1: rule__IsInstanceOf__Group__4__Impl : ( ( rule__IsInstanceOf__TypeAssignment_4 ) ) ;
    public final void rule__IsInstanceOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3802:1: ( ( ( rule__IsInstanceOf__TypeAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3803:1: ( ( rule__IsInstanceOf__TypeAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3803:1: ( ( rule__IsInstanceOf__TypeAssignment_4 ) )
            // InternalFirstOrderLogic.g:3804:2: ( rule__IsInstanceOf__TypeAssignment_4 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_4()); 
            // InternalFirstOrderLogic.g:3805:2: ( rule__IsInstanceOf__TypeAssignment_4 )
            // InternalFirstOrderLogic.g:3805:3: rule__IsInstanceOf__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__4__Impl"


    // $ANTLR start "rule__IsInstanceOf__Group__5"
    // InternalFirstOrderLogic.g:3813:1: rule__IsInstanceOf__Group__5 : rule__IsInstanceOf__Group__5__Impl ;
    public final void rule__IsInstanceOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3817:1: ( rule__IsInstanceOf__Group__5__Impl )
            // InternalFirstOrderLogic.g:3818:2: rule__IsInstanceOf__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsInstanceOf__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__5"


    // $ANTLR start "rule__IsInstanceOf__Group__5__Impl"
    // InternalFirstOrderLogic.g:3824:1: rule__IsInstanceOf__Group__5__Impl : ( ')' ) ;
    public final void rule__IsInstanceOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3828:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3829:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3829:1: ( ')' )
            // InternalFirstOrderLogic.g:3830:2: ')'
            {
             before(grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__Group__5__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__0"
    // InternalFirstOrderLogic.g:3840:1: rule__IsValueLiteralOf__Group__0 : rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1 ;
    public final void rule__IsValueLiteralOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3844:1: ( rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1 )
            // InternalFirstOrderLogic.g:3845:2: rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__IsValueLiteralOf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__0"


    // $ANTLR start "rule__IsValueLiteralOf__Group__0__Impl"
    // InternalFirstOrderLogic.g:3852:1: rule__IsValueLiteralOf__Group__0__Impl : ( 'isValueLiteralOf' ) ;
    public final void rule__IsValueLiteralOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3856:1: ( ( 'isValueLiteralOf' ) )
            // InternalFirstOrderLogic.g:3857:1: ( 'isValueLiteralOf' )
            {
            // InternalFirstOrderLogic.g:3857:1: ( 'isValueLiteralOf' )
            // InternalFirstOrderLogic.g:3858:2: 'isValueLiteralOf'
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getIsValueLiteralOfKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getIsValueLiteralOfAccess().getIsValueLiteralOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__0__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__1"
    // InternalFirstOrderLogic.g:3867:1: rule__IsValueLiteralOf__Group__1 : rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2 ;
    public final void rule__IsValueLiteralOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3871:1: ( rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2 )
            // InternalFirstOrderLogic.g:3872:2: rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IsValueLiteralOf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__1"


    // $ANTLR start "rule__IsValueLiteralOf__Group__1__Impl"
    // InternalFirstOrderLogic.g:3879:1: rule__IsValueLiteralOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IsValueLiteralOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3883:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3884:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3884:1: ( '(' )
            // InternalFirstOrderLogic.g:3885:2: '('
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getIsValueLiteralOfAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__1__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__2"
    // InternalFirstOrderLogic.g:3894:1: rule__IsValueLiteralOf__Group__2 : rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3 ;
    public final void rule__IsValueLiteralOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3898:1: ( rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3 )
            // InternalFirstOrderLogic.g:3899:2: rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__IsValueLiteralOf__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__2"


    // $ANTLR start "rule__IsValueLiteralOf__Group__2__Impl"
    // InternalFirstOrderLogic.g:3906:1: rule__IsValueLiteralOf__Group__2__Impl : ( ( rule__IsValueLiteralOf__TermAssignment_2 ) ) ;
    public final void rule__IsValueLiteralOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3910:1: ( ( ( rule__IsValueLiteralOf__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3911:1: ( ( rule__IsValueLiteralOf__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3911:1: ( ( rule__IsValueLiteralOf__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3912:2: ( rule__IsValueLiteralOf__TermAssignment_2 )
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3913:2: ( rule__IsValueLiteralOf__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3913:3: rule__IsValueLiteralOf__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__TermAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIsValueLiteralOfAccess().getTermAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__2__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__3"
    // InternalFirstOrderLogic.g:3921:1: rule__IsValueLiteralOf__Group__3 : rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4 ;
    public final void rule__IsValueLiteralOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3925:1: ( rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4 )
            // InternalFirstOrderLogic.g:3926:2: rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__IsValueLiteralOf__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__3"


    // $ANTLR start "rule__IsValueLiteralOf__Group__3__Impl"
    // InternalFirstOrderLogic.g:3933:1: rule__IsValueLiteralOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IsValueLiteralOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3937:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3938:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3938:1: ( ',' )
            // InternalFirstOrderLogic.g:3939:2: ','
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIsValueLiteralOfAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__3__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__4"
    // InternalFirstOrderLogic.g:3948:1: rule__IsValueLiteralOf__Group__4 : rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5 ;
    public final void rule__IsValueLiteralOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3952:1: ( rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5 )
            // InternalFirstOrderLogic.g:3953:2: rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__IsValueLiteralOf__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__4"


    // $ANTLR start "rule__IsValueLiteralOf__Group__4__Impl"
    // InternalFirstOrderLogic.g:3960:1: rule__IsValueLiteralOf__Group__4__Impl : ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) ) ;
    public final void rule__IsValueLiteralOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3964:1: ( ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3965:1: ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3965:1: ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) )
            // InternalFirstOrderLogic.g:3966:2: ( rule__IsValueLiteralOf__TypeAssignment_4 )
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTypeAssignment_4()); 
            // InternalFirstOrderLogic.g:3967:2: ( rule__IsValueLiteralOf__TypeAssignment_4 )
            // InternalFirstOrderLogic.g:3967:3: rule__IsValueLiteralOf__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIsValueLiteralOfAccess().getTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__4__Impl"


    // $ANTLR start "rule__IsValueLiteralOf__Group__5"
    // InternalFirstOrderLogic.g:3975:1: rule__IsValueLiteralOf__Group__5 : rule__IsValueLiteralOf__Group__5__Impl ;
    public final void rule__IsValueLiteralOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3979:1: ( rule__IsValueLiteralOf__Group__5__Impl )
            // InternalFirstOrderLogic.g:3980:2: rule__IsValueLiteralOf__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IsValueLiteralOf__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__5"


    // $ANTLR start "rule__IsValueLiteralOf__Group__5__Impl"
    // InternalFirstOrderLogic.g:3986:1: rule__IsValueLiteralOf__Group__5__Impl : ( ')' ) ;
    public final void rule__IsValueLiteralOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3990:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3991:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3991:1: ( ')' )
            // InternalFirstOrderLogic.g:3992:2: ')'
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIsValueLiteralOfAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__Group__5__Impl"


    // $ANTLR start "rule__ForAll__Group__0"
    // InternalFirstOrderLogic.g:4002:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4006:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:4007:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__ForAll__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__0"


    // $ANTLR start "rule__ForAll__Group__0__Impl"
    // InternalFirstOrderLogic.g:4014:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4018:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4019:1: ( () )
            {
            // InternalFirstOrderLogic.g:4019:1: ( () )
            // InternalFirstOrderLogic.g:4020:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:4021:2: ()
            // InternalFirstOrderLogic.g:4021:3: 
            {
            }

             after(grammarAccess.getForAllAccess().getForAllAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__0__Impl"


    // $ANTLR start "rule__ForAll__Group__1"
    // InternalFirstOrderLogic.g:4029:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4033:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:4034:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__ForAll__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__1"


    // $ANTLR start "rule__ForAll__Group__1__Impl"
    // InternalFirstOrderLogic.g:4041:1: rule__ForAll__Group__1__Impl : ( 'forAll' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4045:1: ( ( 'forAll' ) )
            // InternalFirstOrderLogic.g:4046:1: ( 'forAll' )
            {
            // InternalFirstOrderLogic.g:4046:1: ( 'forAll' )
            // InternalFirstOrderLogic.g:4047:2: 'forAll'
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getForAllKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__1__Impl"


    // $ANTLR start "rule__ForAll__Group__2"
    // InternalFirstOrderLogic.g:4056:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4060:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:4061:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ForAll__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__2"


    // $ANTLR start "rule__ForAll__Group__2__Impl"
    // InternalFirstOrderLogic.g:4068:1: rule__ForAll__Group__2__Impl : ( '(' ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4072:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4073:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4073:1: ( '(' )
            // InternalFirstOrderLogic.g:4074:2: '('
            {
             before(grammarAccess.getForAllAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__2__Impl"


    // $ANTLR start "rule__ForAll__Group__3"
    // InternalFirstOrderLogic.g:4083:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4087:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:4088:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__ForAll__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__3"


    // $ANTLR start "rule__ForAll__Group__3__Impl"
    // InternalFirstOrderLogic.g:4095:1: rule__ForAll__Group__3__Impl : ( ( rule__ForAll__NameAssignment_3 ) ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4099:1: ( ( ( rule__ForAll__NameAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4100:1: ( ( rule__ForAll__NameAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4100:1: ( ( rule__ForAll__NameAssignment_3 ) )
            // InternalFirstOrderLogic.g:4101:2: ( rule__ForAll__NameAssignment_3 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_3()); 
            // InternalFirstOrderLogic.g:4102:2: ( rule__ForAll__NameAssignment_3 )
            // InternalFirstOrderLogic.g:4102:3: rule__ForAll__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__3__Impl"


    // $ANTLR start "rule__ForAll__Group__4"
    // InternalFirstOrderLogic.g:4110:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4114:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:4115:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__ForAll__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__4"


    // $ANTLR start "rule__ForAll__Group__4__Impl"
    // InternalFirstOrderLogic.g:4122:1: rule__ForAll__Group__4__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4126:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:4127:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:4127:1: ( 'in' )
            // InternalFirstOrderLogic.g:4128:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_4()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getInKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__4__Impl"


    // $ANTLR start "rule__ForAll__Group__5"
    // InternalFirstOrderLogic.g:4137:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4141:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:4142:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__ForAll__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__5"


    // $ANTLR start "rule__ForAll__Group__5__Impl"
    // InternalFirstOrderLogic.g:4149:1: rule__ForAll__Group__5__Impl : ( ( rule__ForAll__IterationAssignment_5 ) ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4153:1: ( ( ( rule__ForAll__IterationAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:4154:1: ( ( rule__ForAll__IterationAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:4154:1: ( ( rule__ForAll__IterationAssignment_5 ) )
            // InternalFirstOrderLogic.g:4155:2: ( rule__ForAll__IterationAssignment_5 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_5()); 
            // InternalFirstOrderLogic.g:4156:2: ( rule__ForAll__IterationAssignment_5 )
            // InternalFirstOrderLogic.g:4156:3: rule__ForAll__IterationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__IterationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getIterationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__5__Impl"


    // $ANTLR start "rule__ForAll__Group__6"
    // InternalFirstOrderLogic.g:4164:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4168:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:4169:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__ForAll__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__6"


    // $ANTLR start "rule__ForAll__Group__6__Impl"
    // InternalFirstOrderLogic.g:4176:1: rule__ForAll__Group__6__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4180:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:4181:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:4181:1: ( ':' )
            // InternalFirstOrderLogic.g:4182:2: ':'
            {
             before(grammarAccess.getForAllAccess().getColonKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__6__Impl"


    // $ANTLR start "rule__ForAll__Group__7"
    // InternalFirstOrderLogic.g:4191:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl rule__ForAll__Group__8 ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4195:1: ( rule__ForAll__Group__7__Impl rule__ForAll__Group__8 )
            // InternalFirstOrderLogic.g:4196:2: rule__ForAll__Group__7__Impl rule__ForAll__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__ForAll__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ForAll__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__7"


    // $ANTLR start "rule__ForAll__Group__7__Impl"
    // InternalFirstOrderLogic.g:4203:1: rule__ForAll__Group__7__Impl : ( ( rule__ForAll__FormulaAssignment_7 ) ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4207:1: ( ( ( rule__ForAll__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:4208:1: ( ( rule__ForAll__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:4208:1: ( ( rule__ForAll__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:4209:2: ( rule__ForAll__FormulaAssignment_7 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:4210:2: ( rule__ForAll__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:4210:3: rule__ForAll__FormulaAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__FormulaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getForAllAccess().getFormulaAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__7__Impl"


    // $ANTLR start "rule__ForAll__Group__8"
    // InternalFirstOrderLogic.g:4218:1: rule__ForAll__Group__8 : rule__ForAll__Group__8__Impl ;
    public final void rule__ForAll__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4222:1: ( rule__ForAll__Group__8__Impl )
            // InternalFirstOrderLogic.g:4223:2: rule__ForAll__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ForAll__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__8"


    // $ANTLR start "rule__ForAll__Group__8__Impl"
    // InternalFirstOrderLogic.g:4229:1: rule__ForAll__Group__8__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4233:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4234:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4234:1: ( ')' )
            // InternalFirstOrderLogic.g:4235:2: ')'
            {
             before(grammarAccess.getForAllAccess().getRightParenthesisKeyword_8()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getForAllAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__Group__8__Impl"


    // $ANTLR start "rule__Exists__Group__0"
    // InternalFirstOrderLogic.g:4245:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4249:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:4250:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__Exists__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__0"


    // $ANTLR start "rule__Exists__Group__0__Impl"
    // InternalFirstOrderLogic.g:4257:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4261:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4262:1: ( () )
            {
            // InternalFirstOrderLogic.g:4262:1: ( () )
            // InternalFirstOrderLogic.g:4263:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:4264:2: ()
            // InternalFirstOrderLogic.g:4264:3: 
            {
            }

             after(grammarAccess.getExistsAccess().getExistsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__0__Impl"


    // $ANTLR start "rule__Exists__Group__1"
    // InternalFirstOrderLogic.g:4272:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4276:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:4277:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Exists__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__1"


    // $ANTLR start "rule__Exists__Group__1__Impl"
    // InternalFirstOrderLogic.g:4284:1: rule__Exists__Group__1__Impl : ( 'exists' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4288:1: ( ( 'exists' ) )
            // InternalFirstOrderLogic.g:4289:1: ( 'exists' )
            {
            // InternalFirstOrderLogic.g:4289:1: ( 'exists' )
            // InternalFirstOrderLogic.g:4290:2: 'exists'
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getExistsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__1__Impl"


    // $ANTLR start "rule__Exists__Group__2"
    // InternalFirstOrderLogic.g:4299:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4303:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:4304:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Exists__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__2"


    // $ANTLR start "rule__Exists__Group__2__Impl"
    // InternalFirstOrderLogic.g:4311:1: rule__Exists__Group__2__Impl : ( '(' ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4315:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4316:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4316:1: ( '(' )
            // InternalFirstOrderLogic.g:4317:2: '('
            {
             before(grammarAccess.getExistsAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__2__Impl"


    // $ANTLR start "rule__Exists__Group__3"
    // InternalFirstOrderLogic.g:4326:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4330:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:4331:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__Exists__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__3"


    // $ANTLR start "rule__Exists__Group__3__Impl"
    // InternalFirstOrderLogic.g:4338:1: rule__Exists__Group__3__Impl : ( ( rule__Exists__NameAssignment_3 ) ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4342:1: ( ( ( rule__Exists__NameAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4343:1: ( ( rule__Exists__NameAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4343:1: ( ( rule__Exists__NameAssignment_3 ) )
            // InternalFirstOrderLogic.g:4344:2: ( rule__Exists__NameAssignment_3 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_3()); 
            // InternalFirstOrderLogic.g:4345:2: ( rule__Exists__NameAssignment_3 )
            // InternalFirstOrderLogic.g:4345:3: rule__Exists__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Exists__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__3__Impl"


    // $ANTLR start "rule__Exists__Group__4"
    // InternalFirstOrderLogic.g:4353:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4357:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:4358:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Exists__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__4"


    // $ANTLR start "rule__Exists__Group__4__Impl"
    // InternalFirstOrderLogic.g:4365:1: rule__Exists__Group__4__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4369:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:4370:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:4370:1: ( 'in' )
            // InternalFirstOrderLogic.g:4371:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_4()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getInKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__4__Impl"


    // $ANTLR start "rule__Exists__Group__5"
    // InternalFirstOrderLogic.g:4380:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4384:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:4385:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Exists__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__5"


    // $ANTLR start "rule__Exists__Group__5__Impl"
    // InternalFirstOrderLogic.g:4392:1: rule__Exists__Group__5__Impl : ( ( rule__Exists__IterationAssignment_5 ) ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4396:1: ( ( ( rule__Exists__IterationAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:4397:1: ( ( rule__Exists__IterationAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:4397:1: ( ( rule__Exists__IterationAssignment_5 ) )
            // InternalFirstOrderLogic.g:4398:2: ( rule__Exists__IterationAssignment_5 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_5()); 
            // InternalFirstOrderLogic.g:4399:2: ( rule__Exists__IterationAssignment_5 )
            // InternalFirstOrderLogic.g:4399:3: rule__Exists__IterationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Exists__IterationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getIterationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__5__Impl"


    // $ANTLR start "rule__Exists__Group__6"
    // InternalFirstOrderLogic.g:4407:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4411:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:4412:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Exists__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__6"


    // $ANTLR start "rule__Exists__Group__6__Impl"
    // InternalFirstOrderLogic.g:4419:1: rule__Exists__Group__6__Impl : ( ':' ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4423:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:4424:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:4424:1: ( ':' )
            // InternalFirstOrderLogic.g:4425:2: ':'
            {
             before(grammarAccess.getExistsAccess().getColonKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__6__Impl"


    // $ANTLR start "rule__Exists__Group__7"
    // InternalFirstOrderLogic.g:4434:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl rule__Exists__Group__8 ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4438:1: ( rule__Exists__Group__7__Impl rule__Exists__Group__8 )
            // InternalFirstOrderLogic.g:4439:2: rule__Exists__Group__7__Impl rule__Exists__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__Exists__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exists__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__7"


    // $ANTLR start "rule__Exists__Group__7__Impl"
    // InternalFirstOrderLogic.g:4446:1: rule__Exists__Group__7__Impl : ( ( rule__Exists__FormulaAssignment_7 ) ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4450:1: ( ( ( rule__Exists__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:4451:1: ( ( rule__Exists__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:4451:1: ( ( rule__Exists__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:4452:2: ( rule__Exists__FormulaAssignment_7 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:4453:2: ( rule__Exists__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:4453:3: rule__Exists__FormulaAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Exists__FormulaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getExistsAccess().getFormulaAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__7__Impl"


    // $ANTLR start "rule__Exists__Group__8"
    // InternalFirstOrderLogic.g:4461:1: rule__Exists__Group__8 : rule__Exists__Group__8__Impl ;
    public final void rule__Exists__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4465:1: ( rule__Exists__Group__8__Impl )
            // InternalFirstOrderLogic.g:4466:2: rule__Exists__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exists__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__8"


    // $ANTLR start "rule__Exists__Group__8__Impl"
    // InternalFirstOrderLogic.g:4472:1: rule__Exists__Group__8__Impl : ( ')' ) ;
    public final void rule__Exists__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4476:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4477:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4477:1: ( ')' )
            // InternalFirstOrderLogic.g:4478:2: ')'
            {
             before(grammarAccess.getExistsAccess().getRightParenthesisKeyword_8()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getExistsAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__Group__8__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__0"
    // InternalFirstOrderLogic.g:4488:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4492:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:4493:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
            {
            pushFollow(FOLLOW_11);
            rule__BooleanExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__0"


    // $ANTLR start "rule__BooleanExpression__Group_0__0__Impl"
    // InternalFirstOrderLogic.g:4500:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4504:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4505:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4505:1: ( '(' )
            // InternalFirstOrderLogic.g:4506:2: '('
            {
             before(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__1"
    // InternalFirstOrderLogic.g:4515:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4519:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:4520:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
            {
            pushFollow(FOLLOW_24);
            rule__BooleanExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__1"


    // $ANTLR start "rule__BooleanExpression__Group_0__1__Impl"
    // InternalFirstOrderLogic.g:4527:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4531:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4532:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4532:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:4533:2: ruleFormula
            {
             before(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__1__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_0__2"
    // InternalFirstOrderLogic.g:4542:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4546:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:4547:2: rule__BooleanExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__2"


    // $ANTLR start "rule__BooleanExpression__Group_0__2__Impl"
    // InternalFirstOrderLogic.g:4553:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4557:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4558:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4558:1: ( ')' )
            // InternalFirstOrderLogic.g:4559:2: ')'
            {
             before(grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_0__2__Impl"


    // $ANTLR start "rule__VariableRef__Group__0"
    // InternalFirstOrderLogic.g:4569:1: rule__VariableRef__Group__0 : rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 ;
    public final void rule__VariableRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4573:1: ( rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1 )
            // InternalFirstOrderLogic.g:4574:2: rule__VariableRef__Group__0__Impl rule__VariableRef__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__VariableRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__0"


    // $ANTLR start "rule__VariableRef__Group__0__Impl"
    // InternalFirstOrderLogic.g:4581:1: rule__VariableRef__Group__0__Impl : ( () ) ;
    public final void rule__VariableRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4585:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4586:1: ( () )
            {
            // InternalFirstOrderLogic.g:4586:1: ( () )
            // InternalFirstOrderLogic.g:4587:2: ()
            {
             before(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 
            // InternalFirstOrderLogic.g:4588:2: ()
            // InternalFirstOrderLogic.g:4588:3: 
            {
            }

             after(grammarAccess.getVariableRefAccess().getVariableRefAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__0__Impl"


    // $ANTLR start "rule__VariableRef__Group__1"
    // InternalFirstOrderLogic.g:4596:1: rule__VariableRef__Group__1 : rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 ;
    public final void rule__VariableRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4600:1: ( rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2 )
            // InternalFirstOrderLogic.g:4601:2: rule__VariableRef__Group__1__Impl rule__VariableRef__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__VariableRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__1"


    // $ANTLR start "rule__VariableRef__Group__1__Impl"
    // InternalFirstOrderLogic.g:4608:1: rule__VariableRef__Group__1__Impl : ( ( rule__VariableRef__NameAssignment_1 ) ) ;
    public final void rule__VariableRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4612:1: ( ( ( rule__VariableRef__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:4613:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:4613:1: ( ( rule__VariableRef__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:4614:2: ( rule__VariableRef__NameAssignment_1 )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:4615:2: ( rule__VariableRef__NameAssignment_1 )
            // InternalFirstOrderLogic.g:4615:3: rule__VariableRef__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__1__Impl"


    // $ANTLR start "rule__VariableRef__Group__2"
    // InternalFirstOrderLogic.g:4623:1: rule__VariableRef__Group__2 : rule__VariableRef__Group__2__Impl ;
    public final void rule__VariableRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4627:1: ( rule__VariableRef__Group__2__Impl )
            // InternalFirstOrderLogic.g:4628:2: rule__VariableRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__2"


    // $ANTLR start "rule__VariableRef__Group__2__Impl"
    // InternalFirstOrderLogic.g:4634:1: rule__VariableRef__Group__2__Impl : ( ( rule__VariableRef__GetAssignment_2 )? ) ;
    public final void rule__VariableRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4638:1: ( ( ( rule__VariableRef__GetAssignment_2 )? ) )
            // InternalFirstOrderLogic.g:4639:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            {
            // InternalFirstOrderLogic.g:4639:1: ( ( rule__VariableRef__GetAssignment_2 )? )
            // InternalFirstOrderLogic.g:4640:2: ( rule__VariableRef__GetAssignment_2 )?
            {
             before(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 
            // InternalFirstOrderLogic.g:4641:2: ( rule__VariableRef__GetAssignment_2 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:4641:3: rule__VariableRef__GetAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__VariableRef__GetAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableRefAccess().getGetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__Group__2__Impl"


    // $ANTLR start "rule__Get__Group__0"
    // InternalFirstOrderLogic.g:4650:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4654:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:4655:2: rule__Get__Group__0__Impl rule__Get__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Get__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__0"


    // $ANTLR start "rule__Get__Group__0__Impl"
    // InternalFirstOrderLogic.g:4662:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4666:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:4667:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:4667:1: ( '.' )
            // InternalFirstOrderLogic.g:4668:2: '.'
            {
             before(grammarAccess.getGetAccess().getFullStopKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getFullStopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__0__Impl"


    // $ANTLR start "rule__Get__Group__1"
    // InternalFirstOrderLogic.g:4677:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4681:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:4682:2: rule__Get__Group__1__Impl rule__Get__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Get__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__1"


    // $ANTLR start "rule__Get__Group__1__Impl"
    // InternalFirstOrderLogic.g:4689:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4693:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:4694:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:4694:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:4695:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:4696:2: ( rule__Get__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==39) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalFirstOrderLogic.g:4696:3: rule__Get__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Get__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGetAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__1__Impl"


    // $ANTLR start "rule__Get__Group__2"
    // InternalFirstOrderLogic.g:4704:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4708:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:4709:2: rule__Get__Group__2__Impl rule__Get__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__Get__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__2"


    // $ANTLR start "rule__Get__Group__2__Impl"
    // InternalFirstOrderLogic.g:4716:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4720:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:4721:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:4721:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:4722:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:4723:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:4723:3: rule__Get__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Get__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__2__Impl"


    // $ANTLR start "rule__Get__Group__3"
    // InternalFirstOrderLogic.g:4731:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4735:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:4736:2: rule__Get__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__3"


    // $ANTLR start "rule__Get__Group__3__Impl"
    // InternalFirstOrderLogic.g:4742:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4746:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:4747:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:4747:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:4748:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:4749:2: ( rule__Get__NextAssignment_3 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalFirstOrderLogic.g:4749:3: rule__Get__NextAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Get__NextAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGetAccess().getNextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group__3__Impl"


    // $ANTLR start "rule__Get__Group_1__0"
    // InternalFirstOrderLogic.g:4758:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4762:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:4763:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
            {
            pushFollow(FOLLOW_33);
            rule__Get__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Get__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__0"


    // $ANTLR start "rule__Get__Group_1__0__Impl"
    // InternalFirstOrderLogic.g:4770:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4774:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:4775:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4775:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:4776:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:4777:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:4777:3: rule__Get__TypeAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Get__TypeAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__0__Impl"


    // $ANTLR start "rule__Get__Group_1__1"
    // InternalFirstOrderLogic.g:4785:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4789:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4790:2: rule__Get__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Get__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__1"


    // $ANTLR start "rule__Get__Group_1__1__Impl"
    // InternalFirstOrderLogic.g:4796:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4800:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:4801:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:4801:1: ( '::' )
            // InternalFirstOrderLogic.g:4802:2: '::'
            {
             before(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__Group_1__1__Impl"


    // $ANTLR start "rule__GetContainer__Group__0"
    // InternalFirstOrderLogic.g:4812:1: rule__GetContainer__Group__0 : rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 ;
    public final void rule__GetContainer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4816:1: ( rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 )
            // InternalFirstOrderLogic.g:4817:2: rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__GetContainer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__0"


    // $ANTLR start "rule__GetContainer__Group__0__Impl"
    // InternalFirstOrderLogic.g:4824:1: rule__GetContainer__Group__0__Impl : ( 'getContainer' ) ;
    public final void rule__GetContainer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4828:1: ( ( 'getContainer' ) )
            // InternalFirstOrderLogic.g:4829:1: ( 'getContainer' )
            {
            // InternalFirstOrderLogic.g:4829:1: ( 'getContainer' )
            // InternalFirstOrderLogic.g:4830:2: 'getContainer'
            {
             before(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__0__Impl"


    // $ANTLR start "rule__GetContainer__Group__1"
    // InternalFirstOrderLogic.g:4839:1: rule__GetContainer__Group__1 : rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 ;
    public final void rule__GetContainer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4843:1: ( rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 )
            // InternalFirstOrderLogic.g:4844:2: rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GetContainer__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__1"


    // $ANTLR start "rule__GetContainer__Group__1__Impl"
    // InternalFirstOrderLogic.g:4851:1: rule__GetContainer__Group__1__Impl : ( '(' ) ;
    public final void rule__GetContainer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4855:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4856:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4856:1: ( '(' )
            // InternalFirstOrderLogic.g:4857:2: '('
            {
             before(grammarAccess.getGetContainerAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGetContainerAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__1__Impl"


    // $ANTLR start "rule__GetContainer__Group__2"
    // InternalFirstOrderLogic.g:4866:1: rule__GetContainer__Group__2 : rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3 ;
    public final void rule__GetContainer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4870:1: ( rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3 )
            // InternalFirstOrderLogic.g:4871:2: rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__GetContainer__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__2"


    // $ANTLR start "rule__GetContainer__Group__2__Impl"
    // InternalFirstOrderLogic.g:4878:1: rule__GetContainer__Group__2__Impl : ( ( rule__GetContainer__ElementAssignment_2 ) ) ;
    public final void rule__GetContainer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4882:1: ( ( ( rule__GetContainer__ElementAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:4883:1: ( ( rule__GetContainer__ElementAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:4883:1: ( ( rule__GetContainer__ElementAssignment_2 ) )
            // InternalFirstOrderLogic.g:4884:2: ( rule__GetContainer__ElementAssignment_2 )
            {
             before(grammarAccess.getGetContainerAccess().getElementAssignment_2()); 
            // InternalFirstOrderLogic.g:4885:2: ( rule__GetContainer__ElementAssignment_2 )
            // InternalFirstOrderLogic.g:4885:3: rule__GetContainer__ElementAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__ElementAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetContainerAccess().getElementAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__2__Impl"


    // $ANTLR start "rule__GetContainer__Group__3"
    // InternalFirstOrderLogic.g:4893:1: rule__GetContainer__Group__3 : rule__GetContainer__Group__3__Impl ;
    public final void rule__GetContainer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4897:1: ( rule__GetContainer__Group__3__Impl )
            // InternalFirstOrderLogic.g:4898:2: rule__GetContainer__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetContainer__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__3"


    // $ANTLR start "rule__GetContainer__Group__3__Impl"
    // InternalFirstOrderLogic.g:4904:1: rule__GetContainer__Group__3__Impl : ( ')' ) ;
    public final void rule__GetContainer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4908:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4909:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4909:1: ( ')' )
            // InternalFirstOrderLogic.g:4910:2: ')'
            {
             before(grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__Group__3__Impl"


    // $ANTLR start "rule__GetContainments__Group__0"
    // InternalFirstOrderLogic.g:4920:1: rule__GetContainments__Group__0 : rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 ;
    public final void rule__GetContainments__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4924:1: ( rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 )
            // InternalFirstOrderLogic.g:4925:2: rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__GetContainments__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__0"


    // $ANTLR start "rule__GetContainments__Group__0__Impl"
    // InternalFirstOrderLogic.g:4932:1: rule__GetContainments__Group__0__Impl : ( 'getContainments' ) ;
    public final void rule__GetContainments__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4936:1: ( ( 'getContainments' ) )
            // InternalFirstOrderLogic.g:4937:1: ( 'getContainments' )
            {
            // InternalFirstOrderLogic.g:4937:1: ( 'getContainments' )
            // InternalFirstOrderLogic.g:4938:2: 'getContainments'
            {
             before(grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__0__Impl"


    // $ANTLR start "rule__GetContainments__Group__1"
    // InternalFirstOrderLogic.g:4947:1: rule__GetContainments__Group__1 : rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 ;
    public final void rule__GetContainments__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4951:1: ( rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 )
            // InternalFirstOrderLogic.g:4952:2: rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GetContainments__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__1"


    // $ANTLR start "rule__GetContainments__Group__1__Impl"
    // InternalFirstOrderLogic.g:4959:1: rule__GetContainments__Group__1__Impl : ( '(' ) ;
    public final void rule__GetContainments__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4963:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4964:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4964:1: ( '(' )
            // InternalFirstOrderLogic.g:4965:2: '('
            {
             before(grammarAccess.getGetContainmentsAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGetContainmentsAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__1__Impl"


    // $ANTLR start "rule__GetContainments__Group__2"
    // InternalFirstOrderLogic.g:4974:1: rule__GetContainments__Group__2 : rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3 ;
    public final void rule__GetContainments__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4978:1: ( rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3 )
            // InternalFirstOrderLogic.g:4979:2: rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__GetContainments__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__2"


    // $ANTLR start "rule__GetContainments__Group__2__Impl"
    // InternalFirstOrderLogic.g:4986:1: rule__GetContainments__Group__2__Impl : ( ( rule__GetContainments__ElementAssignment_2 ) ) ;
    public final void rule__GetContainments__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4990:1: ( ( ( rule__GetContainments__ElementAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:4991:1: ( ( rule__GetContainments__ElementAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:4991:1: ( ( rule__GetContainments__ElementAssignment_2 ) )
            // InternalFirstOrderLogic.g:4992:2: ( rule__GetContainments__ElementAssignment_2 )
            {
             before(grammarAccess.getGetContainmentsAccess().getElementAssignment_2()); 
            // InternalFirstOrderLogic.g:4993:2: ( rule__GetContainments__ElementAssignment_2 )
            // InternalFirstOrderLogic.g:4993:3: rule__GetContainments__ElementAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__ElementAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetContainmentsAccess().getElementAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__2__Impl"


    // $ANTLR start "rule__GetContainments__Group__3"
    // InternalFirstOrderLogic.g:5001:1: rule__GetContainments__Group__3 : rule__GetContainments__Group__3__Impl ;
    public final void rule__GetContainments__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5005:1: ( rule__GetContainments__Group__3__Impl )
            // InternalFirstOrderLogic.g:5006:2: rule__GetContainments__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetContainments__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__3"


    // $ANTLR start "rule__GetContainments__Group__3__Impl"
    // InternalFirstOrderLogic.g:5012:1: rule__GetContainments__Group__3__Impl : ( ')' ) ;
    public final void rule__GetContainments__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5016:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5017:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5017:1: ( ')' )
            // InternalFirstOrderLogic.g:5018:2: ')'
            {
             before(grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__Group__3__Impl"


    // $ANTLR start "rule__GetClosure__Group__0"
    // InternalFirstOrderLogic.g:5028:1: rule__GetClosure__Group__0 : rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 ;
    public final void rule__GetClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5032:1: ( rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 )
            // InternalFirstOrderLogic.g:5033:2: rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__GetClosure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__0"


    // $ANTLR start "rule__GetClosure__Group__0__Impl"
    // InternalFirstOrderLogic.g:5040:1: rule__GetClosure__Group__0__Impl : ( 'getClosure' ) ;
    public final void rule__GetClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5044:1: ( ( 'getClosure' ) )
            // InternalFirstOrderLogic.g:5045:1: ( 'getClosure' )
            {
            // InternalFirstOrderLogic.g:5045:1: ( 'getClosure' )
            // InternalFirstOrderLogic.g:5046:2: 'getClosure'
            {
             before(grammarAccess.getGetClosureAccess().getGetClosureKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getGetClosureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__0__Impl"


    // $ANTLR start "rule__GetClosure__Group__1"
    // InternalFirstOrderLogic.g:5055:1: rule__GetClosure__Group__1 : rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 ;
    public final void rule__GetClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5059:1: ( rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 )
            // InternalFirstOrderLogic.g:5060:2: rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__GetClosure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__1"


    // $ANTLR start "rule__GetClosure__Group__1__Impl"
    // InternalFirstOrderLogic.g:5067:1: rule__GetClosure__Group__1__Impl : ( '(' ) ;
    public final void rule__GetClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5071:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5072:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5072:1: ( '(' )
            // InternalFirstOrderLogic.g:5073:2: '('
            {
             before(grammarAccess.getGetClosureAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__1__Impl"


    // $ANTLR start "rule__GetClosure__Group__2"
    // InternalFirstOrderLogic.g:5082:1: rule__GetClosure__Group__2 : rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 ;
    public final void rule__GetClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5086:1: ( rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 )
            // InternalFirstOrderLogic.g:5087:2: rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__GetClosure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__2"


    // $ANTLR start "rule__GetClosure__Group__2__Impl"
    // InternalFirstOrderLogic.g:5094:1: rule__GetClosure__Group__2__Impl : ( ( rule__GetClosure__ElementAssignment_2 ) ) ;
    public final void rule__GetClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5098:1: ( ( ( rule__GetClosure__ElementAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5099:1: ( ( rule__GetClosure__ElementAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5099:1: ( ( rule__GetClosure__ElementAssignment_2 ) )
            // InternalFirstOrderLogic.g:5100:2: ( rule__GetClosure__ElementAssignment_2 )
            {
             before(grammarAccess.getGetClosureAccess().getElementAssignment_2()); 
            // InternalFirstOrderLogic.g:5101:2: ( rule__GetClosure__ElementAssignment_2 )
            // InternalFirstOrderLogic.g:5101:3: rule__GetClosure__ElementAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__ElementAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getElementAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__2__Impl"


    // $ANTLR start "rule__GetClosure__Group__3"
    // InternalFirstOrderLogic.g:5109:1: rule__GetClosure__Group__3 : rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 ;
    public final void rule__GetClosure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5113:1: ( rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 )
            // InternalFirstOrderLogic.g:5114:2: rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__GetClosure__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__3"


    // $ANTLR start "rule__GetClosure__Group__3__Impl"
    // InternalFirstOrderLogic.g:5121:1: rule__GetClosure__Group__3__Impl : ( ',' ) ;
    public final void rule__GetClosure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5125:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5126:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5126:1: ( ',' )
            // InternalFirstOrderLogic.g:5127:2: ','
            {
             before(grammarAccess.getGetClosureAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__3__Impl"


    // $ANTLR start "rule__GetClosure__Group__4"
    // InternalFirstOrderLogic.g:5136:1: rule__GetClosure__Group__4 : rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5 ;
    public final void rule__GetClosure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5140:1: ( rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5 )
            // InternalFirstOrderLogic.g:5141:2: rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__GetClosure__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__4"


    // $ANTLR start "rule__GetClosure__Group__4__Impl"
    // InternalFirstOrderLogic.g:5148:1: rule__GetClosure__Group__4__Impl : ( ( rule__GetClosure__FeatureAssignment_4 ) ) ;
    public final void rule__GetClosure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5152:1: ( ( ( rule__GetClosure__FeatureAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5153:1: ( ( rule__GetClosure__FeatureAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5153:1: ( ( rule__GetClosure__FeatureAssignment_4 ) )
            // InternalFirstOrderLogic.g:5154:2: ( rule__GetClosure__FeatureAssignment_4 )
            {
             before(grammarAccess.getGetClosureAccess().getFeatureAssignment_4()); 
            // InternalFirstOrderLogic.g:5155:2: ( rule__GetClosure__FeatureAssignment_4 )
            // InternalFirstOrderLogic.g:5155:3: rule__GetClosure__FeatureAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__FeatureAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getFeatureAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__4__Impl"


    // $ANTLR start "rule__GetClosure__Group__5"
    // InternalFirstOrderLogic.g:5163:1: rule__GetClosure__Group__5 : rule__GetClosure__Group__5__Impl ;
    public final void rule__GetClosure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5167:1: ( rule__GetClosure__Group__5__Impl )
            // InternalFirstOrderLogic.g:5168:2: rule__GetClosure__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__5"


    // $ANTLR start "rule__GetClosure__Group__5__Impl"
    // InternalFirstOrderLogic.g:5174:1: rule__GetClosure__Group__5__Impl : ( ')' ) ;
    public final void rule__GetClosure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5178:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5179:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5179:1: ( ')' )
            // InternalFirstOrderLogic.g:5180:2: ')'
            {
             before(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__5__Impl"


    // $ANTLR start "rule__Size__Group__0"
    // InternalFirstOrderLogic.g:5190:1: rule__Size__Group__0 : rule__Size__Group__0__Impl rule__Size__Group__1 ;
    public final void rule__Size__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5194:1: ( rule__Size__Group__0__Impl rule__Size__Group__1 )
            // InternalFirstOrderLogic.g:5195:2: rule__Size__Group__0__Impl rule__Size__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Size__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Size__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__0"


    // $ANTLR start "rule__Size__Group__0__Impl"
    // InternalFirstOrderLogic.g:5202:1: rule__Size__Group__0__Impl : ( 'size' ) ;
    public final void rule__Size__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5206:1: ( ( 'size' ) )
            // InternalFirstOrderLogic.g:5207:1: ( 'size' )
            {
            // InternalFirstOrderLogic.g:5207:1: ( 'size' )
            // InternalFirstOrderLogic.g:5208:2: 'size'
            {
             before(grammarAccess.getSizeAccess().getSizeKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getSizeAccess().getSizeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__0__Impl"


    // $ANTLR start "rule__Size__Group__1"
    // InternalFirstOrderLogic.g:5217:1: rule__Size__Group__1 : rule__Size__Group__1__Impl rule__Size__Group__2 ;
    public final void rule__Size__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5221:1: ( rule__Size__Group__1__Impl rule__Size__Group__2 )
            // InternalFirstOrderLogic.g:5222:2: rule__Size__Group__1__Impl rule__Size__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Size__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Size__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__1"


    // $ANTLR start "rule__Size__Group__1__Impl"
    // InternalFirstOrderLogic.g:5229:1: rule__Size__Group__1__Impl : ( '(' ) ;
    public final void rule__Size__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5233:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5234:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5234:1: ( '(' )
            // InternalFirstOrderLogic.g:5235:2: '('
            {
             before(grammarAccess.getSizeAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSizeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__1__Impl"


    // $ANTLR start "rule__Size__Group__2"
    // InternalFirstOrderLogic.g:5244:1: rule__Size__Group__2 : rule__Size__Group__2__Impl rule__Size__Group__3 ;
    public final void rule__Size__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5248:1: ( rule__Size__Group__2__Impl rule__Size__Group__3 )
            // InternalFirstOrderLogic.g:5249:2: rule__Size__Group__2__Impl rule__Size__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Size__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Size__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__2"


    // $ANTLR start "rule__Size__Group__2__Impl"
    // InternalFirstOrderLogic.g:5256:1: rule__Size__Group__2__Impl : ( ( rule__Size__ElementsAssignment_2 ) ) ;
    public final void rule__Size__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5260:1: ( ( ( rule__Size__ElementsAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5261:1: ( ( rule__Size__ElementsAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5261:1: ( ( rule__Size__ElementsAssignment_2 ) )
            // InternalFirstOrderLogic.g:5262:2: ( rule__Size__ElementsAssignment_2 )
            {
             before(grammarAccess.getSizeAccess().getElementsAssignment_2()); 
            // InternalFirstOrderLogic.g:5263:2: ( rule__Size__ElementsAssignment_2 )
            // InternalFirstOrderLogic.g:5263:3: rule__Size__ElementsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Size__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSizeAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__2__Impl"


    // $ANTLR start "rule__Size__Group__3"
    // InternalFirstOrderLogic.g:5271:1: rule__Size__Group__3 : rule__Size__Group__3__Impl ;
    public final void rule__Size__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5275:1: ( rule__Size__Group__3__Impl )
            // InternalFirstOrderLogic.g:5276:2: rule__Size__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Size__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__3"


    // $ANTLR start "rule__Size__Group__3__Impl"
    // InternalFirstOrderLogic.g:5282:1: rule__Size__Group__3__Impl : ( ')' ) ;
    public final void rule__Size__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5286:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5287:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5287:1: ( ')' )
            // InternalFirstOrderLogic.g:5288:2: ')'
            {
             before(grammarAccess.getSizeAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSizeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__Group__3__Impl"


    // $ANTLR start "rule__IndexOf__Group__0"
    // InternalFirstOrderLogic.g:5298:1: rule__IndexOf__Group__0 : rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1 ;
    public final void rule__IndexOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5302:1: ( rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1 )
            // InternalFirstOrderLogic.g:5303:2: rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__IndexOf__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__0"


    // $ANTLR start "rule__IndexOf__Group__0__Impl"
    // InternalFirstOrderLogic.g:5310:1: rule__IndexOf__Group__0__Impl : ( 'indexOf' ) ;
    public final void rule__IndexOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5314:1: ( ( 'indexOf' ) )
            // InternalFirstOrderLogic.g:5315:1: ( 'indexOf' )
            {
            // InternalFirstOrderLogic.g:5315:1: ( 'indexOf' )
            // InternalFirstOrderLogic.g:5316:2: 'indexOf'
            {
             before(grammarAccess.getIndexOfAccess().getIndexOfKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getIndexOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__0__Impl"


    // $ANTLR start "rule__IndexOf__Group__1"
    // InternalFirstOrderLogic.g:5325:1: rule__IndexOf__Group__1 : rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2 ;
    public final void rule__IndexOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5329:1: ( rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2 )
            // InternalFirstOrderLogic.g:5330:2: rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__IndexOf__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__1"


    // $ANTLR start "rule__IndexOf__Group__1__Impl"
    // InternalFirstOrderLogic.g:5337:1: rule__IndexOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IndexOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5341:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5342:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5342:1: ( '(' )
            // InternalFirstOrderLogic.g:5343:2: '('
            {
             before(grammarAccess.getIndexOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__1__Impl"


    // $ANTLR start "rule__IndexOf__Group__2"
    // InternalFirstOrderLogic.g:5352:1: rule__IndexOf__Group__2 : rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3 ;
    public final void rule__IndexOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5356:1: ( rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3 )
            // InternalFirstOrderLogic.g:5357:2: rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__IndexOf__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__2"


    // $ANTLR start "rule__IndexOf__Group__2__Impl"
    // InternalFirstOrderLogic.g:5364:1: rule__IndexOf__Group__2__Impl : ( ( rule__IndexOf__ContainerAssignment_2 ) ) ;
    public final void rule__IndexOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5368:1: ( ( ( rule__IndexOf__ContainerAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5369:1: ( ( rule__IndexOf__ContainerAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5369:1: ( ( rule__IndexOf__ContainerAssignment_2 ) )
            // InternalFirstOrderLogic.g:5370:2: ( rule__IndexOf__ContainerAssignment_2 )
            {
             before(grammarAccess.getIndexOfAccess().getContainerAssignment_2()); 
            // InternalFirstOrderLogic.g:5371:2: ( rule__IndexOf__ContainerAssignment_2 )
            // InternalFirstOrderLogic.g:5371:3: rule__IndexOf__ContainerAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__ContainerAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIndexOfAccess().getContainerAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__2__Impl"


    // $ANTLR start "rule__IndexOf__Group__3"
    // InternalFirstOrderLogic.g:5379:1: rule__IndexOf__Group__3 : rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4 ;
    public final void rule__IndexOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5383:1: ( rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4 )
            // InternalFirstOrderLogic.g:5384:2: rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__IndexOf__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__3"


    // $ANTLR start "rule__IndexOf__Group__3__Impl"
    // InternalFirstOrderLogic.g:5391:1: rule__IndexOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IndexOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5395:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5396:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5396:1: ( ',' )
            // InternalFirstOrderLogic.g:5397:2: ','
            {
             before(grammarAccess.getIndexOfAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__3__Impl"


    // $ANTLR start "rule__IndexOf__Group__4"
    // InternalFirstOrderLogic.g:5406:1: rule__IndexOf__Group__4 : rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5 ;
    public final void rule__IndexOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5410:1: ( rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5 )
            // InternalFirstOrderLogic.g:5411:2: rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__IndexOf__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__4"


    // $ANTLR start "rule__IndexOf__Group__4__Impl"
    // InternalFirstOrderLogic.g:5418:1: rule__IndexOf__Group__4__Impl : ( ( rule__IndexOf__FeatureAssignment_4 ) ) ;
    public final void rule__IndexOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5422:1: ( ( ( rule__IndexOf__FeatureAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5423:1: ( ( rule__IndexOf__FeatureAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5423:1: ( ( rule__IndexOf__FeatureAssignment_4 ) )
            // InternalFirstOrderLogic.g:5424:2: ( rule__IndexOf__FeatureAssignment_4 )
            {
             before(grammarAccess.getIndexOfAccess().getFeatureAssignment_4()); 
            // InternalFirstOrderLogic.g:5425:2: ( rule__IndexOf__FeatureAssignment_4 )
            // InternalFirstOrderLogic.g:5425:3: rule__IndexOf__FeatureAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__FeatureAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIndexOfAccess().getFeatureAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__4__Impl"


    // $ANTLR start "rule__IndexOf__Group__5"
    // InternalFirstOrderLogic.g:5433:1: rule__IndexOf__Group__5 : rule__IndexOf__Group__5__Impl rule__IndexOf__Group__6 ;
    public final void rule__IndexOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5437:1: ( rule__IndexOf__Group__5__Impl rule__IndexOf__Group__6 )
            // InternalFirstOrderLogic.g:5438:2: rule__IndexOf__Group__5__Impl rule__IndexOf__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__IndexOf__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__5"


    // $ANTLR start "rule__IndexOf__Group__5__Impl"
    // InternalFirstOrderLogic.g:5445:1: rule__IndexOf__Group__5__Impl : ( ',' ) ;
    public final void rule__IndexOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5449:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5450:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5450:1: ( ',' )
            // InternalFirstOrderLogic.g:5451:2: ','
            {
             before(grammarAccess.getIndexOfAccess().getCommaKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__5__Impl"


    // $ANTLR start "rule__IndexOf__Group__6"
    // InternalFirstOrderLogic.g:5460:1: rule__IndexOf__Group__6 : rule__IndexOf__Group__6__Impl rule__IndexOf__Group__7 ;
    public final void rule__IndexOf__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5464:1: ( rule__IndexOf__Group__6__Impl rule__IndexOf__Group__7 )
            // InternalFirstOrderLogic.g:5465:2: rule__IndexOf__Group__6__Impl rule__IndexOf__Group__7
            {
            pushFollow(FOLLOW_24);
            rule__IndexOf__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__6"


    // $ANTLR start "rule__IndexOf__Group__6__Impl"
    // InternalFirstOrderLogic.g:5472:1: rule__IndexOf__Group__6__Impl : ( ( rule__IndexOf__ElementAssignment_6 ) ) ;
    public final void rule__IndexOf__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5476:1: ( ( ( rule__IndexOf__ElementAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:5477:1: ( ( rule__IndexOf__ElementAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:5477:1: ( ( rule__IndexOf__ElementAssignment_6 ) )
            // InternalFirstOrderLogic.g:5478:2: ( rule__IndexOf__ElementAssignment_6 )
            {
             before(grammarAccess.getIndexOfAccess().getElementAssignment_6()); 
            // InternalFirstOrderLogic.g:5479:2: ( rule__IndexOf__ElementAssignment_6 )
            // InternalFirstOrderLogic.g:5479:3: rule__IndexOf__ElementAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__ElementAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIndexOfAccess().getElementAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__6__Impl"


    // $ANTLR start "rule__IndexOf__Group__7"
    // InternalFirstOrderLogic.g:5487:1: rule__IndexOf__Group__7 : rule__IndexOf__Group__7__Impl ;
    public final void rule__IndexOf__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5491:1: ( rule__IndexOf__Group__7__Impl )
            // InternalFirstOrderLogic.g:5492:2: rule__IndexOf__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__7"


    // $ANTLR start "rule__IndexOf__Group__7__Impl"
    // InternalFirstOrderLogic.g:5498:1: rule__IndexOf__Group__7__Impl : ( ')' ) ;
    public final void rule__IndexOf__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5502:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5503:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5503:1: ( ')' )
            // InternalFirstOrderLogic.g:5504:2: ')'
            {
             before(grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__Group__7__Impl"


    // $ANTLR start "rule__Concatenate__Group__0"
    // InternalFirstOrderLogic.g:5514:1: rule__Concatenate__Group__0 : rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 ;
    public final void rule__Concatenate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5518:1: ( rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 )
            // InternalFirstOrderLogic.g:5519:2: rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Concatenate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__0"


    // $ANTLR start "rule__Concatenate__Group__0__Impl"
    // InternalFirstOrderLogic.g:5526:1: rule__Concatenate__Group__0__Impl : ( 'concatenate' ) ;
    public final void rule__Concatenate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5530:1: ( ( 'concatenate' ) )
            // InternalFirstOrderLogic.g:5531:1: ( 'concatenate' )
            {
            // InternalFirstOrderLogic.g:5531:1: ( 'concatenate' )
            // InternalFirstOrderLogic.g:5532:2: 'concatenate'
            {
             before(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__0__Impl"


    // $ANTLR start "rule__Concatenate__Group__1"
    // InternalFirstOrderLogic.g:5541:1: rule__Concatenate__Group__1 : rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 ;
    public final void rule__Concatenate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5545:1: ( rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 )
            // InternalFirstOrderLogic.g:5546:2: rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Concatenate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__1"


    // $ANTLR start "rule__Concatenate__Group__1__Impl"
    // InternalFirstOrderLogic.g:5553:1: rule__Concatenate__Group__1__Impl : ( '(' ) ;
    public final void rule__Concatenate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5557:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5558:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5558:1: ( '(' )
            // InternalFirstOrderLogic.g:5559:2: '('
            {
             before(grammarAccess.getConcatenateAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__1__Impl"


    // $ANTLR start "rule__Concatenate__Group__2"
    // InternalFirstOrderLogic.g:5568:1: rule__Concatenate__Group__2 : rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 ;
    public final void rule__Concatenate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5572:1: ( rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 )
            // InternalFirstOrderLogic.g:5573:2: rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__Concatenate__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__2"


    // $ANTLR start "rule__Concatenate__Group__2__Impl"
    // InternalFirstOrderLogic.g:5580:1: rule__Concatenate__Group__2__Impl : ( ( rule__Concatenate__LeftAssignment_2 ) ) ;
    public final void rule__Concatenate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5584:1: ( ( ( rule__Concatenate__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5585:1: ( ( rule__Concatenate__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5585:1: ( ( rule__Concatenate__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:5586:2: ( rule__Concatenate__LeftAssignment_2 )
            {
             before(grammarAccess.getConcatenateAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:5587:2: ( rule__Concatenate__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:5587:3: rule__Concatenate__LeftAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__LeftAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getLeftAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__2__Impl"


    // $ANTLR start "rule__Concatenate__Group__3"
    // InternalFirstOrderLogic.g:5595:1: rule__Concatenate__Group__3 : rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 ;
    public final void rule__Concatenate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5599:1: ( rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 )
            // InternalFirstOrderLogic.g:5600:2: rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__Concatenate__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__3"


    // $ANTLR start "rule__Concatenate__Group__3__Impl"
    // InternalFirstOrderLogic.g:5607:1: rule__Concatenate__Group__3__Impl : ( ',' ) ;
    public final void rule__Concatenate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5611:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5612:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5612:1: ( ',' )
            // InternalFirstOrderLogic.g:5613:2: ','
            {
             before(grammarAccess.getConcatenateAccess().getCommaKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__3__Impl"


    // $ANTLR start "rule__Concatenate__Group__4"
    // InternalFirstOrderLogic.g:5622:1: rule__Concatenate__Group__4 : rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5 ;
    public final void rule__Concatenate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5626:1: ( rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5 )
            // InternalFirstOrderLogic.g:5627:2: rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Concatenate__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__4"


    // $ANTLR start "rule__Concatenate__Group__4__Impl"
    // InternalFirstOrderLogic.g:5634:1: rule__Concatenate__Group__4__Impl : ( ( rule__Concatenate__RightAssignment_4 ) ) ;
    public final void rule__Concatenate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5638:1: ( ( ( rule__Concatenate__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5639:1: ( ( rule__Concatenate__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5639:1: ( ( rule__Concatenate__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:5640:2: ( rule__Concatenate__RightAssignment_4 )
            {
             before(grammarAccess.getConcatenateAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:5641:2: ( rule__Concatenate__RightAssignment_4 )
            // InternalFirstOrderLogic.g:5641:3: rule__Concatenate__RightAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__RightAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConcatenateAccess().getRightAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__4__Impl"


    // $ANTLR start "rule__Concatenate__Group__5"
    // InternalFirstOrderLogic.g:5649:1: rule__Concatenate__Group__5 : rule__Concatenate__Group__5__Impl ;
    public final void rule__Concatenate__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5653:1: ( rule__Concatenate__Group__5__Impl )
            // InternalFirstOrderLogic.g:5654:2: rule__Concatenate__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Concatenate__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__5"


    // $ANTLR start "rule__Concatenate__Group__5__Impl"
    // InternalFirstOrderLogic.g:5660:1: rule__Concatenate__Group__5__Impl : ( ')' ) ;
    public final void rule__Concatenate__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5664:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5665:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5665:1: ( ')' )
            // InternalFirstOrderLogic.g:5666:2: ')'
            {
             before(grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__Group__5__Impl"


    // $ANTLR start "rule__Capitalize__Group__0"
    // InternalFirstOrderLogic.g:5676:1: rule__Capitalize__Group__0 : rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 ;
    public final void rule__Capitalize__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5680:1: ( rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 )
            // InternalFirstOrderLogic.g:5681:2: rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__Capitalize__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__0"


    // $ANTLR start "rule__Capitalize__Group__0__Impl"
    // InternalFirstOrderLogic.g:5688:1: rule__Capitalize__Group__0__Impl : ( 'capitalize' ) ;
    public final void rule__Capitalize__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5692:1: ( ( 'capitalize' ) )
            // InternalFirstOrderLogic.g:5693:1: ( 'capitalize' )
            {
            // InternalFirstOrderLogic.g:5693:1: ( 'capitalize' )
            // InternalFirstOrderLogic.g:5694:2: 'capitalize'
            {
             before(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__0__Impl"


    // $ANTLR start "rule__Capitalize__Group__1"
    // InternalFirstOrderLogic.g:5703:1: rule__Capitalize__Group__1 : rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 ;
    public final void rule__Capitalize__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5707:1: ( rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 )
            // InternalFirstOrderLogic.g:5708:2: rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Capitalize__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__1"


    // $ANTLR start "rule__Capitalize__Group__1__Impl"
    // InternalFirstOrderLogic.g:5715:1: rule__Capitalize__Group__1__Impl : ( '(' ) ;
    public final void rule__Capitalize__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5719:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5720:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5720:1: ( '(' )
            // InternalFirstOrderLogic.g:5721:2: '('
            {
             before(grammarAccess.getCapitalizeAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getCapitalizeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__1__Impl"


    // $ANTLR start "rule__Capitalize__Group__2"
    // InternalFirstOrderLogic.g:5730:1: rule__Capitalize__Group__2 : rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3 ;
    public final void rule__Capitalize__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5734:1: ( rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3 )
            // InternalFirstOrderLogic.g:5735:2: rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Capitalize__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__2"


    // $ANTLR start "rule__Capitalize__Group__2__Impl"
    // InternalFirstOrderLogic.g:5742:1: rule__Capitalize__Group__2__Impl : ( ( rule__Capitalize__StringAssignment_2 ) ) ;
    public final void rule__Capitalize__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5746:1: ( ( ( rule__Capitalize__StringAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5747:1: ( ( rule__Capitalize__StringAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5747:1: ( ( rule__Capitalize__StringAssignment_2 ) )
            // InternalFirstOrderLogic.g:5748:2: ( rule__Capitalize__StringAssignment_2 )
            {
             before(grammarAccess.getCapitalizeAccess().getStringAssignment_2()); 
            // InternalFirstOrderLogic.g:5749:2: ( rule__Capitalize__StringAssignment_2 )
            // InternalFirstOrderLogic.g:5749:3: rule__Capitalize__StringAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__StringAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCapitalizeAccess().getStringAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__2__Impl"


    // $ANTLR start "rule__Capitalize__Group__3"
    // InternalFirstOrderLogic.g:5757:1: rule__Capitalize__Group__3 : rule__Capitalize__Group__3__Impl ;
    public final void rule__Capitalize__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5761:1: ( rule__Capitalize__Group__3__Impl )
            // InternalFirstOrderLogic.g:5762:2: rule__Capitalize__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Capitalize__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__3"


    // $ANTLR start "rule__Capitalize__Group__3__Impl"
    // InternalFirstOrderLogic.g:5768:1: rule__Capitalize__Group__3__Impl : ( ')' ) ;
    public final void rule__Capitalize__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5772:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5773:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5773:1: ( ')' )
            // InternalFirstOrderLogic.g:5774:2: ')'
            {
             before(grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__Group__3__Impl"


    // $ANTLR start "rule__Select__Group__0"
    // InternalFirstOrderLogic.g:5784:1: rule__Select__Group__0 : rule__Select__Group__0__Impl rule__Select__Group__1 ;
    public final void rule__Select__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5788:1: ( rule__Select__Group__0__Impl rule__Select__Group__1 )
            // InternalFirstOrderLogic.g:5789:2: rule__Select__Group__0__Impl rule__Select__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Select__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__0"


    // $ANTLR start "rule__Select__Group__0__Impl"
    // InternalFirstOrderLogic.g:5796:1: rule__Select__Group__0__Impl : ( () ) ;
    public final void rule__Select__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5800:1: ( ( () ) )
            // InternalFirstOrderLogic.g:5801:1: ( () )
            {
            // InternalFirstOrderLogic.g:5801:1: ( () )
            // InternalFirstOrderLogic.g:5802:2: ()
            {
             before(grammarAccess.getSelectAccess().getSelectAction_0()); 
            // InternalFirstOrderLogic.g:5803:2: ()
            // InternalFirstOrderLogic.g:5803:3: 
            {
            }

             after(grammarAccess.getSelectAccess().getSelectAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__0__Impl"


    // $ANTLR start "rule__Select__Group__1"
    // InternalFirstOrderLogic.g:5811:1: rule__Select__Group__1 : rule__Select__Group__1__Impl rule__Select__Group__2 ;
    public final void rule__Select__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5815:1: ( rule__Select__Group__1__Impl rule__Select__Group__2 )
            // InternalFirstOrderLogic.g:5816:2: rule__Select__Group__1__Impl rule__Select__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Select__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__1"


    // $ANTLR start "rule__Select__Group__1__Impl"
    // InternalFirstOrderLogic.g:5823:1: rule__Select__Group__1__Impl : ( 'select' ) ;
    public final void rule__Select__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5827:1: ( ( 'select' ) )
            // InternalFirstOrderLogic.g:5828:1: ( 'select' )
            {
            // InternalFirstOrderLogic.g:5828:1: ( 'select' )
            // InternalFirstOrderLogic.g:5829:2: 'select'
            {
             before(grammarAccess.getSelectAccess().getSelectKeyword_1()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getSelectKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__1__Impl"


    // $ANTLR start "rule__Select__Group__2"
    // InternalFirstOrderLogic.g:5838:1: rule__Select__Group__2 : rule__Select__Group__2__Impl rule__Select__Group__3 ;
    public final void rule__Select__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5842:1: ( rule__Select__Group__2__Impl rule__Select__Group__3 )
            // InternalFirstOrderLogic.g:5843:2: rule__Select__Group__2__Impl rule__Select__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Select__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__2"


    // $ANTLR start "rule__Select__Group__2__Impl"
    // InternalFirstOrderLogic.g:5850:1: rule__Select__Group__2__Impl : ( '(' ) ;
    public final void rule__Select__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5854:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5855:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5855:1: ( '(' )
            // InternalFirstOrderLogic.g:5856:2: '('
            {
             before(grammarAccess.getSelectAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__2__Impl"


    // $ANTLR start "rule__Select__Group__3"
    // InternalFirstOrderLogic.g:5865:1: rule__Select__Group__3 : rule__Select__Group__3__Impl rule__Select__Group__4 ;
    public final void rule__Select__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5869:1: ( rule__Select__Group__3__Impl rule__Select__Group__4 )
            // InternalFirstOrderLogic.g:5870:2: rule__Select__Group__3__Impl rule__Select__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__Select__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__3"


    // $ANTLR start "rule__Select__Group__3__Impl"
    // InternalFirstOrderLogic.g:5877:1: rule__Select__Group__3__Impl : ( ( rule__Select__NameAssignment_3 ) ) ;
    public final void rule__Select__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5881:1: ( ( ( rule__Select__NameAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:5882:1: ( ( rule__Select__NameAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:5882:1: ( ( rule__Select__NameAssignment_3 ) )
            // InternalFirstOrderLogic.g:5883:2: ( rule__Select__NameAssignment_3 )
            {
             before(grammarAccess.getSelectAccess().getNameAssignment_3()); 
            // InternalFirstOrderLogic.g:5884:2: ( rule__Select__NameAssignment_3 )
            // InternalFirstOrderLogic.g:5884:3: rule__Select__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Select__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__3__Impl"


    // $ANTLR start "rule__Select__Group__4"
    // InternalFirstOrderLogic.g:5892:1: rule__Select__Group__4 : rule__Select__Group__4__Impl rule__Select__Group__5 ;
    public final void rule__Select__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5896:1: ( rule__Select__Group__4__Impl rule__Select__Group__5 )
            // InternalFirstOrderLogic.g:5897:2: rule__Select__Group__4__Impl rule__Select__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__Select__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__4"


    // $ANTLR start "rule__Select__Group__4__Impl"
    // InternalFirstOrderLogic.g:5904:1: rule__Select__Group__4__Impl : ( 'in' ) ;
    public final void rule__Select__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5908:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:5909:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:5909:1: ( 'in' )
            // InternalFirstOrderLogic.g:5910:2: 'in'
            {
             before(grammarAccess.getSelectAccess().getInKeyword_4()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getInKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__4__Impl"


    // $ANTLR start "rule__Select__Group__5"
    // InternalFirstOrderLogic.g:5919:1: rule__Select__Group__5 : rule__Select__Group__5__Impl rule__Select__Group__6 ;
    public final void rule__Select__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5923:1: ( rule__Select__Group__5__Impl rule__Select__Group__6 )
            // InternalFirstOrderLogic.g:5924:2: rule__Select__Group__5__Impl rule__Select__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Select__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__5"


    // $ANTLR start "rule__Select__Group__5__Impl"
    // InternalFirstOrderLogic.g:5931:1: rule__Select__Group__5__Impl : ( ( rule__Select__IterationAssignment_5 ) ) ;
    public final void rule__Select__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5935:1: ( ( ( rule__Select__IterationAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:5936:1: ( ( rule__Select__IterationAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:5936:1: ( ( rule__Select__IterationAssignment_5 ) )
            // InternalFirstOrderLogic.g:5937:2: ( rule__Select__IterationAssignment_5 )
            {
             before(grammarAccess.getSelectAccess().getIterationAssignment_5()); 
            // InternalFirstOrderLogic.g:5938:2: ( rule__Select__IterationAssignment_5 )
            // InternalFirstOrderLogic.g:5938:3: rule__Select__IterationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Select__IterationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getIterationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__5__Impl"


    // $ANTLR start "rule__Select__Group__6"
    // InternalFirstOrderLogic.g:5946:1: rule__Select__Group__6 : rule__Select__Group__6__Impl rule__Select__Group__7 ;
    public final void rule__Select__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5950:1: ( rule__Select__Group__6__Impl rule__Select__Group__7 )
            // InternalFirstOrderLogic.g:5951:2: rule__Select__Group__6__Impl rule__Select__Group__7
            {
            pushFollow(FOLLOW_11);
            rule__Select__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__6"


    // $ANTLR start "rule__Select__Group__6__Impl"
    // InternalFirstOrderLogic.g:5958:1: rule__Select__Group__6__Impl : ( ':' ) ;
    public final void rule__Select__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5962:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:5963:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:5963:1: ( ':' )
            // InternalFirstOrderLogic.g:5964:2: ':'
            {
             before(grammarAccess.getSelectAccess().getColonKeyword_6()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__6__Impl"


    // $ANTLR start "rule__Select__Group__7"
    // InternalFirstOrderLogic.g:5973:1: rule__Select__Group__7 : rule__Select__Group__7__Impl rule__Select__Group__8 ;
    public final void rule__Select__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5977:1: ( rule__Select__Group__7__Impl rule__Select__Group__8 )
            // InternalFirstOrderLogic.g:5978:2: rule__Select__Group__7__Impl rule__Select__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__Select__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Select__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__7"


    // $ANTLR start "rule__Select__Group__7__Impl"
    // InternalFirstOrderLogic.g:5985:1: rule__Select__Group__7__Impl : ( ( rule__Select__FormulaAssignment_7 ) ) ;
    public final void rule__Select__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5989:1: ( ( ( rule__Select__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:5990:1: ( ( rule__Select__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:5990:1: ( ( rule__Select__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:5991:2: ( rule__Select__FormulaAssignment_7 )
            {
             before(grammarAccess.getSelectAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:5992:2: ( rule__Select__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:5992:3: rule__Select__FormulaAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Select__FormulaAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getFormulaAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__7__Impl"


    // $ANTLR start "rule__Select__Group__8"
    // InternalFirstOrderLogic.g:6000:1: rule__Select__Group__8 : rule__Select__Group__8__Impl ;
    public final void rule__Select__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6004:1: ( rule__Select__Group__8__Impl )
            // InternalFirstOrderLogic.g:6005:2: rule__Select__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Select__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__8"


    // $ANTLR start "rule__Select__Group__8__Impl"
    // InternalFirstOrderLogic.g:6011:1: rule__Select__Group__8__Impl : ( ')' ) ;
    public final void rule__Select__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6015:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:6016:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:6016:1: ( ')' )
            // InternalFirstOrderLogic.g:6017:2: ')'
            {
             before(grammarAccess.getSelectAccess().getRightParenthesisKeyword_8()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__8__Impl"


    // $ANTLR start "rule__AsClassifier__Group__0"
    // InternalFirstOrderLogic.g:6027:1: rule__AsClassifier__Group__0 : rule__AsClassifier__Group__0__Impl rule__AsClassifier__Group__1 ;
    public final void rule__AsClassifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6031:1: ( rule__AsClassifier__Group__0__Impl rule__AsClassifier__Group__1 )
            // InternalFirstOrderLogic.g:6032:2: rule__AsClassifier__Group__0__Impl rule__AsClassifier__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__AsClassifier__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsClassifier__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__0"


    // $ANTLR start "rule__AsClassifier__Group__0__Impl"
    // InternalFirstOrderLogic.g:6039:1: rule__AsClassifier__Group__0__Impl : ( 'asClassifier' ) ;
    public final void rule__AsClassifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6043:1: ( ( 'asClassifier' ) )
            // InternalFirstOrderLogic.g:6044:1: ( 'asClassifier' )
            {
            // InternalFirstOrderLogic.g:6044:1: ( 'asClassifier' )
            // InternalFirstOrderLogic.g:6045:2: 'asClassifier'
            {
             before(grammarAccess.getAsClassifierAccess().getAsClassifierKeyword_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getAsClassifierAccess().getAsClassifierKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__0__Impl"


    // $ANTLR start "rule__AsClassifier__Group__1"
    // InternalFirstOrderLogic.g:6054:1: rule__AsClassifier__Group__1 : rule__AsClassifier__Group__1__Impl rule__AsClassifier__Group__2 ;
    public final void rule__AsClassifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6058:1: ( rule__AsClassifier__Group__1__Impl rule__AsClassifier__Group__2 )
            // InternalFirstOrderLogic.g:6059:2: rule__AsClassifier__Group__1__Impl rule__AsClassifier__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__AsClassifier__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsClassifier__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__1"


    // $ANTLR start "rule__AsClassifier__Group__1__Impl"
    // InternalFirstOrderLogic.g:6066:1: rule__AsClassifier__Group__1__Impl : ( '(' ) ;
    public final void rule__AsClassifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6070:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:6071:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:6071:1: ( '(' )
            // InternalFirstOrderLogic.g:6072:2: '('
            {
             before(grammarAccess.getAsClassifierAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAsClassifierAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__1__Impl"


    // $ANTLR start "rule__AsClassifier__Group__2"
    // InternalFirstOrderLogic.g:6081:1: rule__AsClassifier__Group__2 : rule__AsClassifier__Group__2__Impl rule__AsClassifier__Group__3 ;
    public final void rule__AsClassifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6085:1: ( rule__AsClassifier__Group__2__Impl rule__AsClassifier__Group__3 )
            // InternalFirstOrderLogic.g:6086:2: rule__AsClassifier__Group__2__Impl rule__AsClassifier__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__AsClassifier__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsClassifier__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__2"


    // $ANTLR start "rule__AsClassifier__Group__2__Impl"
    // InternalFirstOrderLogic.g:6093:1: rule__AsClassifier__Group__2__Impl : ( ( rule__AsClassifier__TermAssignment_2 ) ) ;
    public final void rule__AsClassifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6097:1: ( ( ( rule__AsClassifier__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:6098:1: ( ( rule__AsClassifier__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:6098:1: ( ( rule__AsClassifier__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:6099:2: ( rule__AsClassifier__TermAssignment_2 )
            {
             before(grammarAccess.getAsClassifierAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:6100:2: ( rule__AsClassifier__TermAssignment_2 )
            // InternalFirstOrderLogic.g:6100:3: rule__AsClassifier__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AsClassifier__TermAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAsClassifierAccess().getTermAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__2__Impl"


    // $ANTLR start "rule__AsClassifier__Group__3"
    // InternalFirstOrderLogic.g:6108:1: rule__AsClassifier__Group__3 : rule__AsClassifier__Group__3__Impl ;
    public final void rule__AsClassifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6112:1: ( rule__AsClassifier__Group__3__Impl )
            // InternalFirstOrderLogic.g:6113:2: rule__AsClassifier__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AsClassifier__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__3"


    // $ANTLR start "rule__AsClassifier__Group__3__Impl"
    // InternalFirstOrderLogic.g:6119:1: rule__AsClassifier__Group__3__Impl : ( ')' ) ;
    public final void rule__AsClassifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6123:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:6124:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:6124:1: ( ')' )
            // InternalFirstOrderLogic.g:6125:2: ')'
            {
             before(grammarAccess.getAsClassifierAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getAsClassifierAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__Group__3__Impl"


    // $ANTLR start "rule__AsDataType__Group__0"
    // InternalFirstOrderLogic.g:6135:1: rule__AsDataType__Group__0 : rule__AsDataType__Group__0__Impl rule__AsDataType__Group__1 ;
    public final void rule__AsDataType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6139:1: ( rule__AsDataType__Group__0__Impl rule__AsDataType__Group__1 )
            // InternalFirstOrderLogic.g:6140:2: rule__AsDataType__Group__0__Impl rule__AsDataType__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__AsDataType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsDataType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__0"


    // $ANTLR start "rule__AsDataType__Group__0__Impl"
    // InternalFirstOrderLogic.g:6147:1: rule__AsDataType__Group__0__Impl : ( 'asDataType' ) ;
    public final void rule__AsDataType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6151:1: ( ( 'asDataType' ) )
            // InternalFirstOrderLogic.g:6152:1: ( 'asDataType' )
            {
            // InternalFirstOrderLogic.g:6152:1: ( 'asDataType' )
            // InternalFirstOrderLogic.g:6153:2: 'asDataType'
            {
             before(grammarAccess.getAsDataTypeAccess().getAsDataTypeKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getAsDataTypeAccess().getAsDataTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__0__Impl"


    // $ANTLR start "rule__AsDataType__Group__1"
    // InternalFirstOrderLogic.g:6162:1: rule__AsDataType__Group__1 : rule__AsDataType__Group__1__Impl rule__AsDataType__Group__2 ;
    public final void rule__AsDataType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6166:1: ( rule__AsDataType__Group__1__Impl rule__AsDataType__Group__2 )
            // InternalFirstOrderLogic.g:6167:2: rule__AsDataType__Group__1__Impl rule__AsDataType__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__AsDataType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsDataType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__1"


    // $ANTLR start "rule__AsDataType__Group__1__Impl"
    // InternalFirstOrderLogic.g:6174:1: rule__AsDataType__Group__1__Impl : ( '(' ) ;
    public final void rule__AsDataType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6178:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:6179:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:6179:1: ( '(' )
            // InternalFirstOrderLogic.g:6180:2: '('
            {
             before(grammarAccess.getAsDataTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAsDataTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__1__Impl"


    // $ANTLR start "rule__AsDataType__Group__2"
    // InternalFirstOrderLogic.g:6189:1: rule__AsDataType__Group__2 : rule__AsDataType__Group__2__Impl rule__AsDataType__Group__3 ;
    public final void rule__AsDataType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6193:1: ( rule__AsDataType__Group__2__Impl rule__AsDataType__Group__3 )
            // InternalFirstOrderLogic.g:6194:2: rule__AsDataType__Group__2__Impl rule__AsDataType__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__AsDataType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AsDataType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__2"


    // $ANTLR start "rule__AsDataType__Group__2__Impl"
    // InternalFirstOrderLogic.g:6201:1: rule__AsDataType__Group__2__Impl : ( ( rule__AsDataType__TermAssignment_2 ) ) ;
    public final void rule__AsDataType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6205:1: ( ( ( rule__AsDataType__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:6206:1: ( ( rule__AsDataType__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:6206:1: ( ( rule__AsDataType__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:6207:2: ( rule__AsDataType__TermAssignment_2 )
            {
             before(grammarAccess.getAsDataTypeAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:6208:2: ( rule__AsDataType__TermAssignment_2 )
            // InternalFirstOrderLogic.g:6208:3: rule__AsDataType__TermAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AsDataType__TermAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAsDataTypeAccess().getTermAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__2__Impl"


    // $ANTLR start "rule__AsDataType__Group__3"
    // InternalFirstOrderLogic.g:6216:1: rule__AsDataType__Group__3 : rule__AsDataType__Group__3__Impl ;
    public final void rule__AsDataType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6220:1: ( rule__AsDataType__Group__3__Impl )
            // InternalFirstOrderLogic.g:6221:2: rule__AsDataType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AsDataType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__3"


    // $ANTLR start "rule__AsDataType__Group__3__Impl"
    // InternalFirstOrderLogic.g:6227:1: rule__AsDataType__Group__3__Impl : ( ')' ) ;
    public final void rule__AsDataType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6231:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:6232:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:6232:1: ( ')' )
            // InternalFirstOrderLogic.g:6233:2: ')'
            {
             before(grammarAccess.getAsDataTypeAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getAsDataTypeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__Group__3__Impl"


    // $ANTLR start "rule__ConstraintLibrary__DomainsAssignment_0"
    // InternalFirstOrderLogic.g:6243:1: rule__ConstraintLibrary__DomainsAssignment_0 : ( ruleDomain ) ;
    public final void rule__ConstraintLibrary__DomainsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6247:1: ( ( ruleDomain ) )
            // InternalFirstOrderLogic.g:6248:2: ( ruleDomain )
            {
            // InternalFirstOrderLogic.g:6248:2: ( ruleDomain )
            // InternalFirstOrderLogic.g:6249:3: ruleDomain
            {
             before(grammarAccess.getConstraintLibraryAccess().getDomainsDomainParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDomain();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryAccess().getDomainsDomainParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__DomainsAssignment_0"


    // $ANTLR start "rule__ConstraintLibrary__ConstraintsAssignment_1"
    // InternalFirstOrderLogic.g:6258:1: rule__ConstraintLibrary__ConstraintsAssignment_1 : ( ruleConstraint ) ;
    public final void rule__ConstraintLibrary__ConstraintsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6262:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:6263:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:6263:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:6264:3: ruleConstraint
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__ConstraintsAssignment_1"


    // $ANTLR start "rule__Domain__DomainAssignment_1"
    // InternalFirstOrderLogic.g:6273:1: rule__Domain__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Domain__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6277:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:6278:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:6278:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:6279:3: RULE_STRING
            {
             before(grammarAccess.getDomainAccess().getDomainSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDomainAccess().getDomainSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Domain__DomainAssignment_1"


    // $ANTLR start "rule__Constraint__NameAssignment_1"
    // InternalFirstOrderLogic.g:6288:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6292:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6293:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:6293:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:6294:3: RULE_ID
            {
             before(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__NameAssignment_1"


    // $ANTLR start "rule__Constraint__MessageAssignment_3"
    // InternalFirstOrderLogic.g:6303:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6307:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:6308:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:6308:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:6309:3: RULE_STRING
            {
             before(grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__MessageAssignment_3"


    // $ANTLR start "rule__Constraint__VariableAssignment_5"
    // InternalFirstOrderLogic.g:6318:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6322:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6323:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6323:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6324:3: ruleVariable
            {
             before(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__VariableAssignment_5"


    // $ANTLR start "rule__Constraint__FormulaAssignment_7"
    // InternalFirstOrderLogic.g:6333:1: rule__Constraint__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6337:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6338:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6338:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6339:3: ruleFormula
            {
             before(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__FormulaAssignment_7"


    // $ANTLR start "rule__Variable__TypeAssignment_0"
    // InternalFirstOrderLogic.g:6348:1: rule__Variable__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6352:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6353:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6353:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6354:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0()); 
            // InternalFirstOrderLogic.g:6355:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6356:4: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getTypeEClassifierIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getTypeEClassifierIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__TypeAssignment_0"


    // $ANTLR start "rule__Variable__NameAssignment_1"
    // InternalFirstOrderLogic.g:6367:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6371:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6372:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:6372:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:6373:3: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_1"


    // $ANTLR start "rule__Iff__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:6382:1: rule__Iff__RightAssignment_1_2 : ( ruleIf ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6386:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:6387:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:6387:2: ( ruleIf )
            // InternalFirstOrderLogic.g:6388:3: ruleIf
            {
             before(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIf();

            state._fsp--;

             after(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iff__RightAssignment_1_2"


    // $ANTLR start "rule__If__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:6397:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6401:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:6402:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:6402:2: ( ruleXor )
            // InternalFirstOrderLogic.g:6403:3: ruleXor
            {
             before(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXor();

            state._fsp--;

             after(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__If__RightAssignment_1_2"


    // $ANTLR start "rule__Xor__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:6412:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6416:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:6417:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:6417:2: ( ruleOr )
            // InternalFirstOrderLogic.g:6418:3: ruleOr
            {
             before(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xor__RightAssignment_1_2"


    // $ANTLR start "rule__Or__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:6427:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6431:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:6432:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:6432:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:6433:3: ruleAnd
            {
             before(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_2"


    // $ANTLR start "rule__And__RightAssignment_1_2"
    // InternalFirstOrderLogic.g:6442:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6446:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:6447:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:6447:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:6448:3: ruleBooleanExpression
            {
             before(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__RightAssignment_1_2"


    // $ANTLR start "rule__Not__NotAssignment_3"
    // InternalFirstOrderLogic.g:6457:1: rule__Not__NotAssignment_3 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6461:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6462:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6462:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6463:3: ruleFormula
            {
             before(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__NotAssignment_3"


    // $ANTLR start "rule__Equals__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6472:1: rule__Equals__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6476:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6477:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6477:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6478:3: ruleTerm
            {
             before(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__LeftAssignment_2"


    // $ANTLR start "rule__Equals__RightAssignment_4"
    // InternalFirstOrderLogic.g:6487:1: rule__Equals__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6491:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6492:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6492:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6493:3: ruleTerm
            {
             before(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__RightAssignment_4"


    // $ANTLR start "rule__Greater__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6502:1: rule__Greater__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6506:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6507:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6507:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6508:3: ruleTerm
            {
             before(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__LeftAssignment_2"


    // $ANTLR start "rule__Greater__RightAssignment_4"
    // InternalFirstOrderLogic.g:6517:1: rule__Greater__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6521:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6522:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6522:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6523:3: ruleTerm
            {
             before(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Greater__RightAssignment_4"


    // $ANTLR start "rule__GreaterEqual__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6532:1: rule__GreaterEqual__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6536:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6537:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6537:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6538:3: ruleTerm
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__LeftAssignment_2"


    // $ANTLR start "rule__GreaterEqual__RightAssignment_4"
    // InternalFirstOrderLogic.g:6547:1: rule__GreaterEqual__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6551:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6552:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6552:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6553:3: ruleTerm
            {
             before(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GreaterEqual__RightAssignment_4"


    // $ANTLR start "rule__Smaller__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6562:1: rule__Smaller__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6566:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6567:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6567:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6568:3: ruleTerm
            {
             before(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__LeftAssignment_2"


    // $ANTLR start "rule__Smaller__RightAssignment_4"
    // InternalFirstOrderLogic.g:6577:1: rule__Smaller__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6581:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6582:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6582:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6583:3: ruleTerm
            {
             before(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Smaller__RightAssignment_4"


    // $ANTLR start "rule__SmallerEqual__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6592:1: rule__SmallerEqual__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6596:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6597:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6597:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6598:3: ruleTerm
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__LeftAssignment_2"


    // $ANTLR start "rule__SmallerEqual__RightAssignment_4"
    // InternalFirstOrderLogic.g:6607:1: rule__SmallerEqual__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6611:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6612:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6612:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6613:3: ruleTerm
            {
             before(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SmallerEqual__RightAssignment_4"


    // $ANTLR start "rule__IsEmpty__TermAssignment_2"
    // InternalFirstOrderLogic.g:6622:1: rule__IsEmpty__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6626:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6627:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6627:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6628:3: ruleTerm
            {
             before(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsEmpty__TermAssignment_2"


    // $ANTLR start "rule__IsInstanceOf__TermAssignment_2"
    // InternalFirstOrderLogic.g:6637:1: rule__IsInstanceOf__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsInstanceOf__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6641:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6642:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6642:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6643:3: ruleTerm
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__TermAssignment_2"


    // $ANTLR start "rule__IsInstanceOf__TypeAssignment_4"
    // InternalFirstOrderLogic.g:6652:1: rule__IsInstanceOf__TypeAssignment_4 : ( ruleClassifier ) ;
    public final void rule__IsInstanceOf__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6656:1: ( ( ruleClassifier ) )
            // InternalFirstOrderLogic.g:6657:2: ( ruleClassifier )
            {
            // InternalFirstOrderLogic.g:6657:2: ( ruleClassifier )
            // InternalFirstOrderLogic.g:6658:3: ruleClassifier
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeClassifierParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleClassifier();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfAccess().getTypeClassifierParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsInstanceOf__TypeAssignment_4"


    // $ANTLR start "rule__IsValueLiteralOf__TermAssignment_2"
    // InternalFirstOrderLogic.g:6667:1: rule__IsValueLiteralOf__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsValueLiteralOf__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6671:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6672:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6672:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6673:3: ruleTerm
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTermTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsValueLiteralOfAccess().getTermTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__TermAssignment_2"


    // $ANTLR start "rule__IsValueLiteralOf__TypeAssignment_4"
    // InternalFirstOrderLogic.g:6682:1: rule__IsValueLiteralOf__TypeAssignment_4 : ( ruleDataType ) ;
    public final void rule__IsValueLiteralOf__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6686:1: ( ( ruleDataType ) )
            // InternalFirstOrderLogic.g:6687:2: ( ruleDataType )
            {
            // InternalFirstOrderLogic.g:6687:2: ( ruleDataType )
            // InternalFirstOrderLogic.g:6688:3: ruleDataType
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTypeDataTypeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getIsValueLiteralOfAccess().getTypeDataTypeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IsValueLiteralOf__TypeAssignment_4"


    // $ANTLR start "rule__ForAll__NameAssignment_3"
    // InternalFirstOrderLogic.g:6697:1: rule__ForAll__NameAssignment_3 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6701:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6702:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6702:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6703:3: ruleVariable
            {
             before(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__NameAssignment_3"


    // $ANTLR start "rule__ForAll__IterationAssignment_5"
    // InternalFirstOrderLogic.g:6712:1: rule__ForAll__IterationAssignment_5 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6716:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6717:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6717:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6718:3: ruleTerm
            {
             before(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__IterationAssignment_5"


    // $ANTLR start "rule__ForAll__FormulaAssignment_7"
    // InternalFirstOrderLogic.g:6727:1: rule__ForAll__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6731:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6732:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6732:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6733:3: ruleFormula
            {
             before(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForAll__FormulaAssignment_7"


    // $ANTLR start "rule__Exists__NameAssignment_3"
    // InternalFirstOrderLogic.g:6742:1: rule__Exists__NameAssignment_3 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6746:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6747:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6747:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6748:3: ruleVariable
            {
             before(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__NameAssignment_3"


    // $ANTLR start "rule__Exists__IterationAssignment_5"
    // InternalFirstOrderLogic.g:6757:1: rule__Exists__IterationAssignment_5 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6761:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6762:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6762:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6763:3: ruleTerm
            {
             before(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__IterationAssignment_5"


    // $ANTLR start "rule__Exists__FormulaAssignment_7"
    // InternalFirstOrderLogic.g:6772:1: rule__Exists__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6776:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6777:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6777:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6778:3: ruleFormula
            {
             before(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exists__FormulaAssignment_7"


    // $ANTLR start "rule__VariableRef__NameAssignment_1"
    // InternalFirstOrderLogic.g:6787:1: rule__VariableRef__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6791:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6792:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6792:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6793:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:6794:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6795:4: RULE_ID
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__NameAssignment_1"


    // $ANTLR start "rule__VariableRef__GetAssignment_2"
    // InternalFirstOrderLogic.g:6806:1: rule__VariableRef__GetAssignment_2 : ( ruleGet ) ;
    public final void rule__VariableRef__GetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6810:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:6811:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:6811:2: ( ruleGet )
            // InternalFirstOrderLogic.g:6812:3: ruleGet
            {
             before(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__GetAssignment_2"


    // $ANTLR start "rule__Get__TypeAssignment_1_0"
    // InternalFirstOrderLogic.g:6821:1: rule__Get__TypeAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6825:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6826:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6826:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6827:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0()); 
            // InternalFirstOrderLogic.g:6828:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6829:4: RULE_ID
            {
             before(grammarAccess.getGetAccess().getTypeEClassifierIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getTypeEClassifierIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__TypeAssignment_1_0"


    // $ANTLR start "rule__Get__NameAssignment_2"
    // InternalFirstOrderLogic.g:6840:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6844:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6845:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6845:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6846:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:6847:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6848:4: RULE_ID
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getNameEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__NameAssignment_2"


    // $ANTLR start "rule__Get__NextAssignment_3"
    // InternalFirstOrderLogic.g:6859:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6863:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:6864:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:6864:2: ( ruleGet )
            // InternalFirstOrderLogic.g:6865:3: ruleGet
            {
             before(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Get__NextAssignment_3"


    // $ANTLR start "rule__GetContainer__ElementAssignment_2"
    // InternalFirstOrderLogic.g:6874:1: rule__GetContainer__ElementAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetContainer__ElementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6878:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6879:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6879:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6880:3: ruleTerm
            {
             before(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainer__ElementAssignment_2"


    // $ANTLR start "rule__GetContainments__ElementAssignment_2"
    // InternalFirstOrderLogic.g:6889:1: rule__GetContainments__ElementAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetContainments__ElementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6893:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6894:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6894:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6895:3: ruleTerm
            {
             before(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetContainments__ElementAssignment_2"


    // $ANTLR start "rule__GetClosure__ElementAssignment_2"
    // InternalFirstOrderLogic.g:6904:1: rule__GetClosure__ElementAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetClosure__ElementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6908:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6909:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6909:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6910:3: ruleTerm
            {
             before(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__ElementAssignment_2"


    // $ANTLR start "rule__GetClosure__FeatureAssignment_4"
    // InternalFirstOrderLogic.g:6919:1: rule__GetClosure__FeatureAssignment_4 : ( ruleFeatureConstant ) ;
    public final void rule__GetClosure__FeatureAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6923:1: ( ( ruleFeatureConstant ) )
            // InternalFirstOrderLogic.g:6924:2: ( ruleFeatureConstant )
            {
            // InternalFirstOrderLogic.g:6924:2: ( ruleFeatureConstant )
            // InternalFirstOrderLogic.g:6925:3: ruleFeatureConstant
            {
             before(grammarAccess.getGetClosureAccess().getFeatureFeatureConstantParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureConstant();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getFeatureFeatureConstantParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__FeatureAssignment_4"


    // $ANTLR start "rule__Size__ElementsAssignment_2"
    // InternalFirstOrderLogic.g:6934:1: rule__Size__ElementsAssignment_2 : ( ruleTerm ) ;
    public final void rule__Size__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6938:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6939:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6939:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6940:3: ruleTerm
            {
             before(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Size__ElementsAssignment_2"


    // $ANTLR start "rule__IndexOf__ContainerAssignment_2"
    // InternalFirstOrderLogic.g:6949:1: rule__IndexOf__ContainerAssignment_2 : ( ruleTerm ) ;
    public final void rule__IndexOf__ContainerAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6953:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6954:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6954:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6955:3: ruleTerm
            {
             before(grammarAccess.getIndexOfAccess().getContainerTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIndexOfAccess().getContainerTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__ContainerAssignment_2"


    // $ANTLR start "rule__IndexOf__FeatureAssignment_4"
    // InternalFirstOrderLogic.g:6964:1: rule__IndexOf__FeatureAssignment_4 : ( ruleFeatureConstant ) ;
    public final void rule__IndexOf__FeatureAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6968:1: ( ( ruleFeatureConstant ) )
            // InternalFirstOrderLogic.g:6969:2: ( ruleFeatureConstant )
            {
            // InternalFirstOrderLogic.g:6969:2: ( ruleFeatureConstant )
            // InternalFirstOrderLogic.g:6970:3: ruleFeatureConstant
            {
             before(grammarAccess.getIndexOfAccess().getFeatureFeatureConstantParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFeatureConstant();

            state._fsp--;

             after(grammarAccess.getIndexOfAccess().getFeatureFeatureConstantParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__FeatureAssignment_4"


    // $ANTLR start "rule__IndexOf__ElementAssignment_6"
    // InternalFirstOrderLogic.g:6979:1: rule__IndexOf__ElementAssignment_6 : ( ruleTerm ) ;
    public final void rule__IndexOf__ElementAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6983:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6984:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6984:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6985:3: ruleTerm
            {
             before(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__ElementAssignment_6"


    // $ANTLR start "rule__Concatenate__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6994:1: rule__Concatenate__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Concatenate__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6998:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6999:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6999:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7000:3: ruleTerm
            {
             before(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__LeftAssignment_2"


    // $ANTLR start "rule__Concatenate__RightAssignment_4"
    // InternalFirstOrderLogic.g:7009:1: rule__Concatenate__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Concatenate__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7013:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:7014:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:7014:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7015:3: ruleTerm
            {
             before(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concatenate__RightAssignment_4"


    // $ANTLR start "rule__Capitalize__StringAssignment_2"
    // InternalFirstOrderLogic.g:7024:1: rule__Capitalize__StringAssignment_2 : ( ruleTerm ) ;
    public final void rule__Capitalize__StringAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7028:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:7029:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:7029:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7030:3: ruleTerm
            {
             before(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Capitalize__StringAssignment_2"


    // $ANTLR start "rule__Select__NameAssignment_3"
    // InternalFirstOrderLogic.g:7039:1: rule__Select__NameAssignment_3 : ( ruleVariable ) ;
    public final void rule__Select__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7043:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:7044:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:7044:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:7045:3: ruleVariable
            {
             before(grammarAccess.getSelectAccess().getNameVariableParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getNameVariableParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__NameAssignment_3"


    // $ANTLR start "rule__Select__IterationAssignment_5"
    // InternalFirstOrderLogic.g:7054:1: rule__Select__IterationAssignment_5 : ( ruleTerm ) ;
    public final void rule__Select__IterationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7058:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:7059:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:7059:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7060:3: ruleTerm
            {
             before(grammarAccess.getSelectAccess().getIterationTermParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getIterationTermParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__IterationAssignment_5"


    // $ANTLR start "rule__Select__FormulaAssignment_7"
    // InternalFirstOrderLogic.g:7069:1: rule__Select__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Select__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7073:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:7074:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:7074:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:7075:3: ruleFormula
            {
             before(grammarAccess.getSelectAccess().getFormulaFormulaParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getFormulaFormulaParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__FormulaAssignment_7"


    // $ANTLR start "rule__FeatureConstant__ConstantAssignment"
    // InternalFirstOrderLogic.g:7084:1: rule__FeatureConstant__ConstantAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FeatureConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7088:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:7089:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:7089:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:7090:3: ( RULE_ID )
            {
             before(grammarAccess.getFeatureConstantAccess().getConstantEStructuralFeatureCrossReference_0()); 
            // InternalFirstOrderLogic.g:7091:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:7092:4: RULE_ID
            {
             before(grammarAccess.getFeatureConstantAccess().getConstantEStructuralFeatureIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFeatureConstantAccess().getConstantEStructuralFeatureIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getFeatureConstantAccess().getConstantEStructuralFeatureCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FeatureConstant__ConstantAssignment"


    // $ANTLR start "rule__ClassifierConstant__ConstantAssignment"
    // InternalFirstOrderLogic.g:7103:1: rule__ClassifierConstant__ConstantAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ClassifierConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7107:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:7108:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:7108:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:7109:3: ( RULE_ID )
            {
             before(grammarAccess.getClassifierConstantAccess().getConstantEClassifierCrossReference_0()); 
            // InternalFirstOrderLogic.g:7110:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:7111:4: RULE_ID
            {
             before(grammarAccess.getClassifierConstantAccess().getConstantEClassifierIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassifierConstantAccess().getConstantEClassifierIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getClassifierConstantAccess().getConstantEClassifierCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierConstant__ConstantAssignment"


    // $ANTLR start "rule__AsClassifier__TermAssignment_2"
    // InternalFirstOrderLogic.g:7122:1: rule__AsClassifier__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__AsClassifier__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7126:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:7127:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:7127:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7128:3: ruleTerm
            {
             before(grammarAccess.getAsClassifierAccess().getTermTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getAsClassifierAccess().getTermTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsClassifier__TermAssignment_2"


    // $ANTLR start "rule__DataTypeConstant__ConstantAssignment"
    // InternalFirstOrderLogic.g:7137:1: rule__DataTypeConstant__ConstantAssignment : ( ( RULE_ID ) ) ;
    public final void rule__DataTypeConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7141:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:7142:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:7142:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:7143:3: ( RULE_ID )
            {
             before(grammarAccess.getDataTypeConstantAccess().getConstantEDataTypeCrossReference_0()); 
            // InternalFirstOrderLogic.g:7144:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:7145:4: RULE_ID
            {
             before(grammarAccess.getDataTypeConstantAccess().getConstantEDataTypeIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDataTypeConstantAccess().getConstantEDataTypeIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getDataTypeConstantAccess().getConstantEDataTypeCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeConstant__ConstantAssignment"


    // $ANTLR start "rule__AsDataType__TermAssignment_2"
    // InternalFirstOrderLogic.g:7156:1: rule__AsDataType__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__AsDataType__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7160:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:7161:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:7161:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:7162:3: ruleTerm
            {
             before(grammarAccess.getAsDataTypeAccess().getTermTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getAsDataTypeAccess().getTermTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AsDataType__TermAssignment_2"


    // $ANTLR start "rule__IntConstant__ValueAssignment"
    // InternalFirstOrderLogic.g:7171:1: rule__IntConstant__ValueAssignment : ( RULE_SIGNED_INT ) ;
    public final void rule__IntConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7175:1: ( ( RULE_SIGNED_INT ) )
            // InternalFirstOrderLogic.g:7176:2: ( RULE_SIGNED_INT )
            {
            // InternalFirstOrderLogic.g:7176:2: ( RULE_SIGNED_INT )
            // InternalFirstOrderLogic.g:7177:3: RULE_SIGNED_INT
            {
             before(grammarAccess.getIntConstantAccess().getValueSIGNED_INTTerminalRuleCall_0()); 
            match(input,RULE_SIGNED_INT,FOLLOW_2); 
             after(grammarAccess.getIntConstantAccess().getValueSIGNED_INTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConstant__ValueAssignment"


    // $ANTLR start "rule__StringConstant__ValueAssignment"
    // InternalFirstOrderLogic.g:7186:1: rule__StringConstant__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7190:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:7191:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:7191:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:7192:3: RULE_STRING
            {
             before(grammarAccess.getStringConstantAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringConstantAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringConstant__ValueAssignment"


    // $ANTLR start "rule__BoolConstant__ValueAssignment"
    // InternalFirstOrderLogic.g:7201:1: rule__BoolConstant__ValueAssignment : ( RULE_BOOLEAN ) ;
    public final void rule__BoolConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:7205:1: ( ( RULE_BOOLEAN ) )
            // InternalFirstOrderLogic.g:7206:2: ( RULE_BOOLEAN )
            {
            // InternalFirstOrderLogic.g:7206:2: ( RULE_BOOLEAN )
            // InternalFirstOrderLogic.g:7207:3: RULE_BOOLEAN
            {
             before(grammarAccess.getBoolConstantAccess().getValueBOOLEANTerminalRuleCall_0()); 
            match(input,RULE_BOOLEAN,FOLLOW_2); 
             after(grammarAccess.getBoolConstantAccess().getValueBOOLEANTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolConstant__ValueAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002FF5800080L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000FF2FF58000F0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001000000000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0002000000000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008000000000L});

}