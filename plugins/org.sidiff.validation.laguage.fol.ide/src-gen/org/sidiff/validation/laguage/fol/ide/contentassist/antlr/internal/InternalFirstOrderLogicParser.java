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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_INT", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'constraint'", "'message'", "'context'", "':'", "'<'", "'>'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not'", "'('", "')'", "'isEqual'", "','", "'isGreater'", "'isGreaterEqual'", "'isSmaller'", "'isSmallerEqual'", "'isEmpty'", "'isInstanceOf'", "'isValueLiteralOf'", "'forAll'", "'in'", "'exists'", "'select'", "'.'", "'::'", "'getContainer'", "'getContainments'", "'getClosure'", "'size'", "'indexOf'", "'concatenate'", "'capitalize'", "'$'"
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


    // $ANTLR start "entryRuleImport"
    // InternalFirstOrderLogic.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:79:1: ( ruleImport EOF )
            // InternalFirstOrderLogic.g:80:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalFirstOrderLogic.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalFirstOrderLogic.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalFirstOrderLogic.g:94:3: ( rule__Import__Group__0 )
            // InternalFirstOrderLogic.g:94:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


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


    // $ANTLR start "entryRuleReferenceBase"
    // InternalFirstOrderLogic.g:753:1: entryRuleReferenceBase : ruleReferenceBase EOF ;
    public final void entryRuleReferenceBase() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:754:1: ( ruleReferenceBase EOF )
            // InternalFirstOrderLogic.g:755:1: ruleReferenceBase EOF
            {
             before(grammarAccess.getReferenceBaseRule()); 
            pushFollow(FOLLOW_1);
            ruleReferenceBase();

            state._fsp--;

             after(grammarAccess.getReferenceBaseRule()); 
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
    // $ANTLR end "entryRuleReferenceBase"


    // $ANTLR start "ruleReferenceBase"
    // InternalFirstOrderLogic.g:762:1: ruleReferenceBase : ( ( rule__ReferenceBase__Group__0 ) ) ;
    public final void ruleReferenceBase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:766:2: ( ( ( rule__ReferenceBase__Group__0 ) ) )
            // InternalFirstOrderLogic.g:767:2: ( ( rule__ReferenceBase__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:767:2: ( ( rule__ReferenceBase__Group__0 ) )
            // InternalFirstOrderLogic.g:768:3: ( rule__ReferenceBase__Group__0 )
            {
             before(grammarAccess.getReferenceBaseAccess().getGroup()); 
            // InternalFirstOrderLogic.g:769:3: ( rule__ReferenceBase__Group__0 )
            // InternalFirstOrderLogic.g:769:4: rule__ReferenceBase__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceBase__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceBaseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferenceBase"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:778:1: entryRuleVariableRef : ruleVariableRef EOF ;
    public final void entryRuleVariableRef() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:779:1: ( ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:780:1: ruleVariableRef EOF
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
    // InternalFirstOrderLogic.g:787:1: ruleVariableRef : ( ( rule__VariableRef__NameAssignment ) ) ;
    public final void ruleVariableRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:791:2: ( ( ( rule__VariableRef__NameAssignment ) ) )
            // InternalFirstOrderLogic.g:792:2: ( ( rule__VariableRef__NameAssignment ) )
            {
            // InternalFirstOrderLogic.g:792:2: ( ( rule__VariableRef__NameAssignment ) )
            // InternalFirstOrderLogic.g:793:3: ( rule__VariableRef__NameAssignment )
            {
             before(grammarAccess.getVariableRefAccess().getNameAssignment()); 
            // InternalFirstOrderLogic.g:794:3: ( rule__VariableRef__NameAssignment )
            // InternalFirstOrderLogic.g:794:4: rule__VariableRef__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VariableRef__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVariableRefAccess().getNameAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleSelect"
    // InternalFirstOrderLogic.g:803:1: entryRuleSelect : ruleSelect EOF ;
    public final void entryRuleSelect() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:804:1: ( ruleSelect EOF )
            // InternalFirstOrderLogic.g:805:1: ruleSelect EOF
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
    // InternalFirstOrderLogic.g:812:1: ruleSelect : ( ( rule__Select__Group__0 ) ) ;
    public final void ruleSelect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:816:2: ( ( ( rule__Select__Group__0 ) ) )
            // InternalFirstOrderLogic.g:817:2: ( ( rule__Select__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:817:2: ( ( rule__Select__Group__0 ) )
            // InternalFirstOrderLogic.g:818:3: ( rule__Select__Group__0 )
            {
             before(grammarAccess.getSelectAccess().getGroup()); 
            // InternalFirstOrderLogic.g:819:3: ( rule__Select__Group__0 )
            // InternalFirstOrderLogic.g:819:4: rule__Select__Group__0
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


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:828:1: entryRuleGet : ruleGet EOF ;
    public final void entryRuleGet() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:829:1: ( ruleGet EOF )
            // InternalFirstOrderLogic.g:830:1: ruleGet EOF
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
    // InternalFirstOrderLogic.g:837:1: ruleGet : ( ( rule__Get__Group__0 ) ) ;
    public final void ruleGet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:841:2: ( ( ( rule__Get__Group__0 ) ) )
            // InternalFirstOrderLogic.g:842:2: ( ( rule__Get__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:842:2: ( ( rule__Get__Group__0 ) )
            // InternalFirstOrderLogic.g:843:3: ( rule__Get__Group__0 )
            {
             before(grammarAccess.getGetAccess().getGroup()); 
            // InternalFirstOrderLogic.g:844:3: ( rule__Get__Group__0 )
            // InternalFirstOrderLogic.g:844:4: rule__Get__Group__0
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
    // InternalFirstOrderLogic.g:853:1: entryRuleGetContainer : ruleGetContainer EOF ;
    public final void entryRuleGetContainer() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:854:1: ( ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:855:1: ruleGetContainer EOF
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
    // InternalFirstOrderLogic.g:862:1: ruleGetContainer : ( ( rule__GetContainer__Group__0 ) ) ;
    public final void ruleGetContainer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:866:2: ( ( ( rule__GetContainer__Group__0 ) ) )
            // InternalFirstOrderLogic.g:867:2: ( ( rule__GetContainer__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:867:2: ( ( rule__GetContainer__Group__0 ) )
            // InternalFirstOrderLogic.g:868:3: ( rule__GetContainer__Group__0 )
            {
             before(grammarAccess.getGetContainerAccess().getGroup()); 
            // InternalFirstOrderLogic.g:869:3: ( rule__GetContainer__Group__0 )
            // InternalFirstOrderLogic.g:869:4: rule__GetContainer__Group__0
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
    // InternalFirstOrderLogic.g:878:1: entryRuleGetContainments : ruleGetContainments EOF ;
    public final void entryRuleGetContainments() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:879:1: ( ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:880:1: ruleGetContainments EOF
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
    // InternalFirstOrderLogic.g:887:1: ruleGetContainments : ( ( rule__GetContainments__Group__0 ) ) ;
    public final void ruleGetContainments() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:891:2: ( ( ( rule__GetContainments__Group__0 ) ) )
            // InternalFirstOrderLogic.g:892:2: ( ( rule__GetContainments__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:892:2: ( ( rule__GetContainments__Group__0 ) )
            // InternalFirstOrderLogic.g:893:3: ( rule__GetContainments__Group__0 )
            {
             before(grammarAccess.getGetContainmentsAccess().getGroup()); 
            // InternalFirstOrderLogic.g:894:3: ( rule__GetContainments__Group__0 )
            // InternalFirstOrderLogic.g:894:4: rule__GetContainments__Group__0
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
    // InternalFirstOrderLogic.g:903:1: entryRuleGetClosure : ruleGetClosure EOF ;
    public final void entryRuleGetClosure() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:904:1: ( ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:905:1: ruleGetClosure EOF
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
    // InternalFirstOrderLogic.g:912:1: ruleGetClosure : ( ( rule__GetClosure__Group__0 ) ) ;
    public final void ruleGetClosure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:916:2: ( ( ( rule__GetClosure__Group__0 ) ) )
            // InternalFirstOrderLogic.g:917:2: ( ( rule__GetClosure__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:917:2: ( ( rule__GetClosure__Group__0 ) )
            // InternalFirstOrderLogic.g:918:3: ( rule__GetClosure__Group__0 )
            {
             before(grammarAccess.getGetClosureAccess().getGroup()); 
            // InternalFirstOrderLogic.g:919:3: ( rule__GetClosure__Group__0 )
            // InternalFirstOrderLogic.g:919:4: rule__GetClosure__Group__0
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
    // InternalFirstOrderLogic.g:928:1: entryRuleSize : ruleSize EOF ;
    public final void entryRuleSize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:929:1: ( ruleSize EOF )
            // InternalFirstOrderLogic.g:930:1: ruleSize EOF
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
    // InternalFirstOrderLogic.g:937:1: ruleSize : ( ( rule__Size__Group__0 ) ) ;
    public final void ruleSize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:941:2: ( ( ( rule__Size__Group__0 ) ) )
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Size__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:942:2: ( ( rule__Size__Group__0 ) )
            // InternalFirstOrderLogic.g:943:3: ( rule__Size__Group__0 )
            {
             before(grammarAccess.getSizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:944:3: ( rule__Size__Group__0 )
            // InternalFirstOrderLogic.g:944:4: rule__Size__Group__0
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
    // InternalFirstOrderLogic.g:953:1: entryRuleIndexOf : ruleIndexOf EOF ;
    public final void entryRuleIndexOf() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:954:1: ( ruleIndexOf EOF )
            // InternalFirstOrderLogic.g:955:1: ruleIndexOf EOF
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
    // InternalFirstOrderLogic.g:962:1: ruleIndexOf : ( ( rule__IndexOf__Group__0 ) ) ;
    public final void ruleIndexOf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:966:2: ( ( ( rule__IndexOf__Group__0 ) ) )
            // InternalFirstOrderLogic.g:967:2: ( ( rule__IndexOf__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:967:2: ( ( rule__IndexOf__Group__0 ) )
            // InternalFirstOrderLogic.g:968:3: ( rule__IndexOf__Group__0 )
            {
             before(grammarAccess.getIndexOfAccess().getGroup()); 
            // InternalFirstOrderLogic.g:969:3: ( rule__IndexOf__Group__0 )
            // InternalFirstOrderLogic.g:969:4: rule__IndexOf__Group__0
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
    // InternalFirstOrderLogic.g:978:1: entryRuleConcatenate : ruleConcatenate EOF ;
    public final void entryRuleConcatenate() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:979:1: ( ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:980:1: ruleConcatenate EOF
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
    // InternalFirstOrderLogic.g:987:1: ruleConcatenate : ( ( rule__Concatenate__Group__0 ) ) ;
    public final void ruleConcatenate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:991:2: ( ( ( rule__Concatenate__Group__0 ) ) )
            // InternalFirstOrderLogic.g:992:2: ( ( rule__Concatenate__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:992:2: ( ( rule__Concatenate__Group__0 ) )
            // InternalFirstOrderLogic.g:993:3: ( rule__Concatenate__Group__0 )
            {
             before(grammarAccess.getConcatenateAccess().getGroup()); 
            // InternalFirstOrderLogic.g:994:3: ( rule__Concatenate__Group__0 )
            // InternalFirstOrderLogic.g:994:4: rule__Concatenate__Group__0
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
    // InternalFirstOrderLogic.g:1003:1: entryRuleCapitalize : ruleCapitalize EOF ;
    public final void entryRuleCapitalize() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1004:1: ( ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:1005:1: ruleCapitalize EOF
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
    // InternalFirstOrderLogic.g:1012:1: ruleCapitalize : ( ( rule__Capitalize__Group__0 ) ) ;
    public final void ruleCapitalize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1016:2: ( ( ( rule__Capitalize__Group__0 ) ) )
            // InternalFirstOrderLogic.g:1017:2: ( ( rule__Capitalize__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:1017:2: ( ( rule__Capitalize__Group__0 ) )
            // InternalFirstOrderLogic.g:1018:3: ( rule__Capitalize__Group__0 )
            {
             before(grammarAccess.getCapitalizeAccess().getGroup()); 
            // InternalFirstOrderLogic.g:1019:3: ( rule__Capitalize__Group__0 )
            // InternalFirstOrderLogic.g:1019:4: rule__Capitalize__Group__0
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


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:1028:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1029:1: ( ruleConstant EOF )
            // InternalFirstOrderLogic.g:1030:1: ruleConstant EOF
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
    // InternalFirstOrderLogic.g:1037:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1041:2: ( ( ( rule__Constant__Alternatives ) ) )
            // InternalFirstOrderLogic.g:1042:2: ( ( rule__Constant__Alternatives ) )
            {
            // InternalFirstOrderLogic.g:1042:2: ( ( rule__Constant__Alternatives ) )
            // InternalFirstOrderLogic.g:1043:3: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // InternalFirstOrderLogic.g:1044:3: ( rule__Constant__Alternatives )
            // InternalFirstOrderLogic.g:1044:4: rule__Constant__Alternatives
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
    // InternalFirstOrderLogic.g:1053:1: entryRuleIntConstant : ruleIntConstant EOF ;
    public final void entryRuleIntConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1054:1: ( ruleIntConstant EOF )
            // InternalFirstOrderLogic.g:1055:1: ruleIntConstant EOF
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
    // InternalFirstOrderLogic.g:1062:1: ruleIntConstant : ( ( rule__IntConstant__ValueAssignment ) ) ;
    public final void ruleIntConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1066:2: ( ( ( rule__IntConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1067:2: ( ( rule__IntConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1067:2: ( ( rule__IntConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1068:3: ( rule__IntConstant__ValueAssignment )
            {
             before(grammarAccess.getIntConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1069:3: ( rule__IntConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1069:4: rule__IntConstant__ValueAssignment
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
    // InternalFirstOrderLogic.g:1078:1: entryRuleStringConstant : ruleStringConstant EOF ;
    public final void entryRuleStringConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1079:1: ( ruleStringConstant EOF )
            // InternalFirstOrderLogic.g:1080:1: ruleStringConstant EOF
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
    // InternalFirstOrderLogic.g:1087:1: ruleStringConstant : ( ( rule__StringConstant__ValueAssignment ) ) ;
    public final void ruleStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1091:2: ( ( ( rule__StringConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1092:2: ( ( rule__StringConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1092:2: ( ( rule__StringConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1093:3: ( rule__StringConstant__ValueAssignment )
            {
             before(grammarAccess.getStringConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1094:3: ( rule__StringConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1094:4: rule__StringConstant__ValueAssignment
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
    // InternalFirstOrderLogic.g:1103:1: entryRuleBoolConstant : ruleBoolConstant EOF ;
    public final void entryRuleBoolConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1104:1: ( ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:1105:1: ruleBoolConstant EOF
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
    // InternalFirstOrderLogic.g:1112:1: ruleBoolConstant : ( ( rule__BoolConstant__ValueAssignment ) ) ;
    public final void ruleBoolConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1116:2: ( ( ( rule__BoolConstant__ValueAssignment ) ) )
            // InternalFirstOrderLogic.g:1117:2: ( ( rule__BoolConstant__ValueAssignment ) )
            {
            // InternalFirstOrderLogic.g:1117:2: ( ( rule__BoolConstant__ValueAssignment ) )
            // InternalFirstOrderLogic.g:1118:3: ( rule__BoolConstant__ValueAssignment )
            {
             before(grammarAccess.getBoolConstantAccess().getValueAssignment()); 
            // InternalFirstOrderLogic.g:1119:3: ( rule__BoolConstant__ValueAssignment )
            // InternalFirstOrderLogic.g:1119:4: rule__BoolConstant__ValueAssignment
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


    // $ANTLR start "entryRuleMetaConstant"
    // InternalFirstOrderLogic.g:1128:1: entryRuleMetaConstant : ruleMetaConstant EOF ;
    public final void entryRuleMetaConstant() throws RecognitionException {
        try {
            // InternalFirstOrderLogic.g:1129:1: ( ruleMetaConstant EOF )
            // InternalFirstOrderLogic.g:1130:1: ruleMetaConstant EOF
            {
             before(grammarAccess.getMetaConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleMetaConstant();

            state._fsp--;

             after(grammarAccess.getMetaConstantRule()); 
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
    // $ANTLR end "entryRuleMetaConstant"


    // $ANTLR start "ruleMetaConstant"
    // InternalFirstOrderLogic.g:1137:1: ruleMetaConstant : ( ( rule__MetaConstant__Group__0 ) ) ;
    public final void ruleMetaConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1141:2: ( ( ( rule__MetaConstant__Group__0 ) ) )
            // InternalFirstOrderLogic.g:1142:2: ( ( rule__MetaConstant__Group__0 ) )
            {
            // InternalFirstOrderLogic.g:1142:2: ( ( rule__MetaConstant__Group__0 ) )
            // InternalFirstOrderLogic.g:1143:3: ( rule__MetaConstant__Group__0 )
            {
             before(grammarAccess.getMetaConstantAccess().getGroup()); 
            // InternalFirstOrderLogic.g:1144:3: ( rule__MetaConstant__Group__0 )
            // InternalFirstOrderLogic.g:1144:4: rule__MetaConstant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetaConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetaConstant"


    // $ANTLR start "rule__Predicate__Alternatives"
    // InternalFirstOrderLogic.g:1152:1: rule__Predicate__Alternatives : ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) | ( ruleIsValueLiteralOf ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1156:1: ( ( ruleEquals ) | ( ruleInequality ) | ( ruleIsEmpty ) | ( ruleIsInstanceOf ) | ( ruleIsValueLiteralOf ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt1=1;
                }
                break;
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt1=2;
                }
                break;
            case 34:
                {
                alt1=3;
                }
                break;
            case 35:
                {
                alt1=4;
                }
                break;
            case 36:
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
                    // InternalFirstOrderLogic.g:1157:2: ( ruleEquals )
                    {
                    // InternalFirstOrderLogic.g:1157:2: ( ruleEquals )
                    // InternalFirstOrderLogic.g:1158:3: ruleEquals
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
                    // InternalFirstOrderLogic.g:1163:2: ( ruleInequality )
                    {
                    // InternalFirstOrderLogic.g:1163:2: ( ruleInequality )
                    // InternalFirstOrderLogic.g:1164:3: ruleInequality
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
                    // InternalFirstOrderLogic.g:1169:2: ( ruleIsEmpty )
                    {
                    // InternalFirstOrderLogic.g:1169:2: ( ruleIsEmpty )
                    // InternalFirstOrderLogic.g:1170:3: ruleIsEmpty
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
                    // InternalFirstOrderLogic.g:1175:2: ( ruleIsInstanceOf )
                    {
                    // InternalFirstOrderLogic.g:1175:2: ( ruleIsInstanceOf )
                    // InternalFirstOrderLogic.g:1176:3: ruleIsInstanceOf
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
                    // InternalFirstOrderLogic.g:1181:2: ( ruleIsValueLiteralOf )
                    {
                    // InternalFirstOrderLogic.g:1181:2: ( ruleIsValueLiteralOf )
                    // InternalFirstOrderLogic.g:1182:3: ruleIsValueLiteralOf
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
    // InternalFirstOrderLogic.g:1191:1: rule__Inequality__Alternatives : ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) );
    public final void rule__Inequality__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1195:1: ( ( ruleGreater ) | ( ruleGreaterEqual ) | ( ruleSmaller ) | ( ruleSmallerEqual ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt2=1;
                }
                break;
            case 31:
                {
                alt2=2;
                }
                break;
            case 32:
                {
                alt2=3;
                }
                break;
            case 33:
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
                    // InternalFirstOrderLogic.g:1196:2: ( ruleGreater )
                    {
                    // InternalFirstOrderLogic.g:1196:2: ( ruleGreater )
                    // InternalFirstOrderLogic.g:1197:3: ruleGreater
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
                    // InternalFirstOrderLogic.g:1202:2: ( ruleGreaterEqual )
                    {
                    // InternalFirstOrderLogic.g:1202:2: ( ruleGreaterEqual )
                    // InternalFirstOrderLogic.g:1203:3: ruleGreaterEqual
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
                    // InternalFirstOrderLogic.g:1208:2: ( ruleSmaller )
                    {
                    // InternalFirstOrderLogic.g:1208:2: ( ruleSmaller )
                    // InternalFirstOrderLogic.g:1209:3: ruleSmaller
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
                    // InternalFirstOrderLogic.g:1214:2: ( ruleSmallerEqual )
                    {
                    // InternalFirstOrderLogic.g:1214:2: ( ruleSmallerEqual )
                    // InternalFirstOrderLogic.g:1215:3: ruleSmallerEqual
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
    // InternalFirstOrderLogic.g:1224:1: rule__Quantifier__Alternatives : ( ( ruleForAll ) | ( ruleExists ) );
    public final void rule__Quantifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1228:1: ( ( ruleForAll ) | ( ruleExists ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==37) ) {
                alt3=1;
            }
            else if ( (LA3_0==39) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFirstOrderLogic.g:1229:2: ( ruleForAll )
                    {
                    // InternalFirstOrderLogic.g:1229:2: ( ruleForAll )
                    // InternalFirstOrderLogic.g:1230:3: ruleForAll
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
                    // InternalFirstOrderLogic.g:1235:2: ( ruleExists )
                    {
                    // InternalFirstOrderLogic.g:1235:2: ( ruleExists )
                    // InternalFirstOrderLogic.g:1236:3: ruleExists
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
    // InternalFirstOrderLogic.g:1245:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1249:1: ( ( ( rule__BooleanExpression__Group_0__0 ) ) | ( ruleUnaryFormula ) | ( ruleQuantifier ) | ( rulePredicate ) | ( ruleBoolConstant ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt4=1;
                }
                break;
            case 25:
                {
                alt4=2;
                }
                break;
            case 37:
            case 39:
                {
                alt4=3;
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
                    // InternalFirstOrderLogic.g:1250:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    {
                    // InternalFirstOrderLogic.g:1250:2: ( ( rule__BooleanExpression__Group_0__0 ) )
                    // InternalFirstOrderLogic.g:1251:3: ( rule__BooleanExpression__Group_0__0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getGroup_0()); 
                    // InternalFirstOrderLogic.g:1252:3: ( rule__BooleanExpression__Group_0__0 )
                    // InternalFirstOrderLogic.g:1252:4: rule__BooleanExpression__Group_0__0
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
                    // InternalFirstOrderLogic.g:1256:2: ( ruleUnaryFormula )
                    {
                    // InternalFirstOrderLogic.g:1256:2: ( ruleUnaryFormula )
                    // InternalFirstOrderLogic.g:1257:3: ruleUnaryFormula
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
                    // InternalFirstOrderLogic.g:1262:2: ( ruleQuantifier )
                    {
                    // InternalFirstOrderLogic.g:1262:2: ( ruleQuantifier )
                    // InternalFirstOrderLogic.g:1263:3: ruleQuantifier
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
                    // InternalFirstOrderLogic.g:1268:2: ( rulePredicate )
                    {
                    // InternalFirstOrderLogic.g:1268:2: ( rulePredicate )
                    // InternalFirstOrderLogic.g:1269:3: rulePredicate
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
                    // InternalFirstOrderLogic.g:1274:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1274:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1275:3: ruleBoolConstant
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
    // InternalFirstOrderLogic.g:1284:1: rule__Term__Alternatives : ( ( ruleReferenceBase ) | ( ruleConcatenate ) | ( ruleSize ) | ( ruleIndexOf ) | ( ruleCapitalize ) | ( ruleConstant ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1288:1: ( ( ruleReferenceBase ) | ( ruleConcatenate ) | ( ruleSize ) | ( ruleIndexOf ) | ( ruleCapitalize ) | ( ruleConstant ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 40:
            case 43:
            case 44:
            case 45:
                {
                alt5=1;
                }
                break;
            case 48:
                {
                alt5=2;
                }
                break;
            case 46:
                {
                alt5=3;
                }
                break;
            case 47:
                {
                alt5=4;
                }
                break;
            case 49:
                {
                alt5=5;
                }
                break;
            case RULE_STRING:
            case RULE_SIGNED_INT:
            case RULE_BOOLEAN:
            case 50:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalFirstOrderLogic.g:1289:2: ( ruleReferenceBase )
                    {
                    // InternalFirstOrderLogic.g:1289:2: ( ruleReferenceBase )
                    // InternalFirstOrderLogic.g:1290:3: ruleReferenceBase
                    {
                     before(grammarAccess.getTermAccess().getReferenceBaseParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleReferenceBase();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getReferenceBaseParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1295:2: ( ruleConcatenate )
                    {
                    // InternalFirstOrderLogic.g:1295:2: ( ruleConcatenate )
                    // InternalFirstOrderLogic.g:1296:3: ruleConcatenate
                    {
                     before(grammarAccess.getTermAccess().getConcatenateParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleConcatenate();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConcatenateParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1301:2: ( ruleSize )
                    {
                    // InternalFirstOrderLogic.g:1301:2: ( ruleSize )
                    // InternalFirstOrderLogic.g:1302:3: ruleSize
                    {
                     before(grammarAccess.getTermAccess().getSizeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleSize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getSizeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1307:2: ( ruleIndexOf )
                    {
                    // InternalFirstOrderLogic.g:1307:2: ( ruleIndexOf )
                    // InternalFirstOrderLogic.g:1308:3: ruleIndexOf
                    {
                     before(grammarAccess.getTermAccess().getIndexOfParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleIndexOf();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getIndexOfParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1313:2: ( ruleCapitalize )
                    {
                    // InternalFirstOrderLogic.g:1313:2: ( ruleCapitalize )
                    // InternalFirstOrderLogic.g:1314:3: ruleCapitalize
                    {
                     before(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleCapitalize();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1319:2: ( ruleConstant )
                    {
                    // InternalFirstOrderLogic.g:1319:2: ( ruleConstant )
                    // InternalFirstOrderLogic.g:1320:3: ruleConstant
                    {
                     before(grammarAccess.getTermAccess().getConstantParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getConstantParserRuleCall_5()); 

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


    // $ANTLR start "rule__ReferenceBase__Alternatives_0"
    // InternalFirstOrderLogic.g:1329:1: rule__ReferenceBase__Alternatives_0 : ( ( ruleVariableRef ) | ( ruleSelect ) | ( ruleGetContainer ) | ( ruleGetContainments ) | ( ruleGetClosure ) );
    public final void rule__ReferenceBase__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1333:1: ( ( ruleVariableRef ) | ( ruleSelect ) | ( ruleGetContainer ) | ( ruleGetContainments ) | ( ruleGetClosure ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case 40:
                {
                alt6=2;
                }
                break;
            case 43:
                {
                alt6=3;
                }
                break;
            case 44:
                {
                alt6=4;
                }
                break;
            case 45:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalFirstOrderLogic.g:1334:2: ( ruleVariableRef )
                    {
                    // InternalFirstOrderLogic.g:1334:2: ( ruleVariableRef )
                    // InternalFirstOrderLogic.g:1335:3: ruleVariableRef
                    {
                     before(grammarAccess.getReferenceBaseAccess().getVariableRefParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableRef();

                    state._fsp--;

                     after(grammarAccess.getReferenceBaseAccess().getVariableRefParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1340:2: ( ruleSelect )
                    {
                    // InternalFirstOrderLogic.g:1340:2: ( ruleSelect )
                    // InternalFirstOrderLogic.g:1341:3: ruleSelect
                    {
                     before(grammarAccess.getReferenceBaseAccess().getSelectParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleSelect();

                    state._fsp--;

                     after(grammarAccess.getReferenceBaseAccess().getSelectParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1346:2: ( ruleGetContainer )
                    {
                    // InternalFirstOrderLogic.g:1346:2: ( ruleGetContainer )
                    // InternalFirstOrderLogic.g:1347:3: ruleGetContainer
                    {
                     before(grammarAccess.getReferenceBaseAccess().getGetContainerParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainer();

                    state._fsp--;

                     after(grammarAccess.getReferenceBaseAccess().getGetContainerParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1352:2: ( ruleGetContainments )
                    {
                    // InternalFirstOrderLogic.g:1352:2: ( ruleGetContainments )
                    // InternalFirstOrderLogic.g:1353:3: ruleGetContainments
                    {
                     before(grammarAccess.getReferenceBaseAccess().getGetContainmentsParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleGetContainments();

                    state._fsp--;

                     after(grammarAccess.getReferenceBaseAccess().getGetContainmentsParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1358:2: ( ruleGetClosure )
                    {
                    // InternalFirstOrderLogic.g:1358:2: ( ruleGetClosure )
                    // InternalFirstOrderLogic.g:1359:3: ruleGetClosure
                    {
                     before(grammarAccess.getReferenceBaseAccess().getGetClosureParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_2);
                    ruleGetClosure();

                    state._fsp--;

                     after(grammarAccess.getReferenceBaseAccess().getGetClosureParserRuleCall_0_4()); 

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
    // $ANTLR end "rule__ReferenceBase__Alternatives_0"


    // $ANTLR start "rule__Constant__Alternatives"
    // InternalFirstOrderLogic.g:1368:1: rule__Constant__Alternatives : ( ( ruleIntConstant ) | ( ruleStringConstant ) | ( ruleBoolConstant ) | ( ruleMetaConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1372:1: ( ( ruleIntConstant ) | ( ruleStringConstant ) | ( ruleBoolConstant ) | ( ruleMetaConstant ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_SIGNED_INT:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
                {
                alt7=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt7=3;
                }
                break;
            case 50:
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
                    // InternalFirstOrderLogic.g:1373:2: ( ruleIntConstant )
                    {
                    // InternalFirstOrderLogic.g:1373:2: ( ruleIntConstant )
                    // InternalFirstOrderLogic.g:1374:3: ruleIntConstant
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
                    // InternalFirstOrderLogic.g:1379:2: ( ruleStringConstant )
                    {
                    // InternalFirstOrderLogic.g:1379:2: ( ruleStringConstant )
                    // InternalFirstOrderLogic.g:1380:3: ruleStringConstant
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
                    // InternalFirstOrderLogic.g:1385:2: ( ruleBoolConstant )
                    {
                    // InternalFirstOrderLogic.g:1385:2: ( ruleBoolConstant )
                    // InternalFirstOrderLogic.g:1386:3: ruleBoolConstant
                    {
                     before(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1391:2: ( ruleMetaConstant )
                    {
                    // InternalFirstOrderLogic.g:1391:2: ( ruleMetaConstant )
                    // InternalFirstOrderLogic.g:1392:3: ruleMetaConstant
                    {
                     before(grammarAccess.getConstantAccess().getMetaConstantParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleMetaConstant();

                    state._fsp--;

                     after(grammarAccess.getConstantAccess().getMetaConstantParserRuleCall_3()); 

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
    // InternalFirstOrderLogic.g:1401:1: rule__ConstraintLibrary__Group__0 : rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 ;
    public final void rule__ConstraintLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1405:1: ( rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1 )
            // InternalFirstOrderLogic.g:1406:2: rule__ConstraintLibrary__Group__0__Impl rule__ConstraintLibrary__Group__1
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
    // InternalFirstOrderLogic.g:1413:1: rule__ConstraintLibrary__Group__0__Impl : ( ( rule__ConstraintLibrary__ImportsAssignment_0 )* ) ;
    public final void rule__ConstraintLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1417:1: ( ( ( rule__ConstraintLibrary__ImportsAssignment_0 )* ) )
            // InternalFirstOrderLogic.g:1418:1: ( ( rule__ConstraintLibrary__ImportsAssignment_0 )* )
            {
            // InternalFirstOrderLogic.g:1418:1: ( ( rule__ConstraintLibrary__ImportsAssignment_0 )* )
            // InternalFirstOrderLogic.g:1419:2: ( rule__ConstraintLibrary__ImportsAssignment_0 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getImportsAssignment_0()); 
            // InternalFirstOrderLogic.g:1420:2: ( rule__ConstraintLibrary__ImportsAssignment_0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==13) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1420:3: rule__ConstraintLibrary__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ConstraintLibrary__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getConstraintLibraryAccess().getImportsAssignment_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:1428:1: rule__ConstraintLibrary__Group__1 : rule__ConstraintLibrary__Group__1__Impl ;
    public final void rule__ConstraintLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1432:1: ( rule__ConstraintLibrary__Group__1__Impl )
            // InternalFirstOrderLogic.g:1433:2: rule__ConstraintLibrary__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1439:1: rule__ConstraintLibrary__Group__1__Impl : ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* ) ;
    public final void rule__ConstraintLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1443:1: ( ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* ) )
            // InternalFirstOrderLogic.g:1444:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* )
            {
            // InternalFirstOrderLogic.g:1444:1: ( ( rule__ConstraintLibrary__ConstraintsAssignment_1 )* )
            // InternalFirstOrderLogic.g:1445:2: ( rule__ConstraintLibrary__ConstraintsAssignment_1 )*
            {
             before(grammarAccess.getConstraintLibraryAccess().getConstraintsAssignment_1()); 
            // InternalFirstOrderLogic.g:1446:2: ( rule__ConstraintLibrary__ConstraintsAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1446:3: rule__ConstraintLibrary__ConstraintsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__ConstraintLibrary__ConstraintsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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


    // $ANTLR start "rule__Import__Group__0"
    // InternalFirstOrderLogic.g:1455:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1459:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalFirstOrderLogic.g:1460:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalFirstOrderLogic.g:1467:1: rule__Import__Group__0__Impl : ( 'domain' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1471:1: ( ( 'domain' ) )
            // InternalFirstOrderLogic.g:1472:1: ( 'domain' )
            {
            // InternalFirstOrderLogic.g:1472:1: ( 'domain' )
            // InternalFirstOrderLogic.g:1473:2: 'domain'
            {
             before(grammarAccess.getImportAccess().getDomainKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getDomainKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalFirstOrderLogic.g:1482:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1486:1: ( rule__Import__Group__1__Impl )
            // InternalFirstOrderLogic.g:1487:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalFirstOrderLogic.g:1493:1: rule__Import__Group__1__Impl : ( ( rule__Import__DomainAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1497:1: ( ( ( rule__Import__DomainAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1498:1: ( ( rule__Import__DomainAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1498:1: ( ( rule__Import__DomainAssignment_1 ) )
            // InternalFirstOrderLogic.g:1499:2: ( rule__Import__DomainAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getDomainAssignment_1()); 
            // InternalFirstOrderLogic.g:1500:2: ( rule__Import__DomainAssignment_1 )
            // InternalFirstOrderLogic.g:1500:3: rule__Import__DomainAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__DomainAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getDomainAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalFirstOrderLogic.g:1509:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1513:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalFirstOrderLogic.g:1514:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalFirstOrderLogic.g:1521:1: rule__Constraint__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1525:1: ( ( 'constraint' ) )
            // InternalFirstOrderLogic.g:1526:1: ( 'constraint' )
            {
            // InternalFirstOrderLogic.g:1526:1: ( 'constraint' )
            // InternalFirstOrderLogic.g:1527:2: 'constraint'
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
    // InternalFirstOrderLogic.g:1536:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1540:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalFirstOrderLogic.g:1541:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalFirstOrderLogic.g:1548:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1552:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1553:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1553:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1554:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1555:2: ( rule__Constraint__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1555:3: rule__Constraint__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1563:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1567:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalFirstOrderLogic.g:1568:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalFirstOrderLogic.g:1575:1: rule__Constraint__Group__2__Impl : ( 'message' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1579:1: ( ( 'message' ) )
            // InternalFirstOrderLogic.g:1580:1: ( 'message' )
            {
            // InternalFirstOrderLogic.g:1580:1: ( 'message' )
            // InternalFirstOrderLogic.g:1581:2: 'message'
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
    // InternalFirstOrderLogic.g:1590:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1594:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalFirstOrderLogic.g:1595:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalFirstOrderLogic.g:1602:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__MessageAssignment_3 ) ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1606:1: ( ( ( rule__Constraint__MessageAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:1607:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:1607:1: ( ( rule__Constraint__MessageAssignment_3 ) )
            // InternalFirstOrderLogic.g:1608:2: ( rule__Constraint__MessageAssignment_3 )
            {
             before(grammarAccess.getConstraintAccess().getMessageAssignment_3()); 
            // InternalFirstOrderLogic.g:1609:2: ( rule__Constraint__MessageAssignment_3 )
            // InternalFirstOrderLogic.g:1609:3: rule__Constraint__MessageAssignment_3
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
    // InternalFirstOrderLogic.g:1617:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1621:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalFirstOrderLogic.g:1622:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalFirstOrderLogic.g:1629:1: rule__Constraint__Group__4__Impl : ( 'context' ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1633:1: ( ( 'context' ) )
            // InternalFirstOrderLogic.g:1634:1: ( 'context' )
            {
            // InternalFirstOrderLogic.g:1634:1: ( 'context' )
            // InternalFirstOrderLogic.g:1635:2: 'context'
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
    // InternalFirstOrderLogic.g:1644:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1648:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalFirstOrderLogic.g:1649:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalFirstOrderLogic.g:1656:1: rule__Constraint__Group__5__Impl : ( ( rule__Constraint__VariableAssignment_5 ) ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1660:1: ( ( ( rule__Constraint__VariableAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:1661:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:1661:1: ( ( rule__Constraint__VariableAssignment_5 ) )
            // InternalFirstOrderLogic.g:1662:2: ( rule__Constraint__VariableAssignment_5 )
            {
             before(grammarAccess.getConstraintAccess().getVariableAssignment_5()); 
            // InternalFirstOrderLogic.g:1663:2: ( rule__Constraint__VariableAssignment_5 )
            // InternalFirstOrderLogic.g:1663:3: rule__Constraint__VariableAssignment_5
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
    // InternalFirstOrderLogic.g:1671:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1675:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalFirstOrderLogic.g:1676:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
            {
            pushFollow(FOLLOW_10);
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
    // InternalFirstOrderLogic.g:1683:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__Group_6__0 )? ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1687:1: ( ( ( rule__Constraint__Group_6__0 )? ) )
            // InternalFirstOrderLogic.g:1688:1: ( ( rule__Constraint__Group_6__0 )? )
            {
            // InternalFirstOrderLogic.g:1688:1: ( ( rule__Constraint__Group_6__0 )? )
            // InternalFirstOrderLogic.g:1689:2: ( rule__Constraint__Group_6__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_6()); 
            // InternalFirstOrderLogic.g:1690:2: ( rule__Constraint__Group_6__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFirstOrderLogic.g:1690:3: rule__Constraint__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constraint__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstraintAccess().getGroup_6()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:1698:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1702:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalFirstOrderLogic.g:1703:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Constraint__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__8();

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
    // InternalFirstOrderLogic.g:1710:1: rule__Constraint__Group__7__Impl : ( ':' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1714:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:1715:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:1715:1: ( ':' )
            // InternalFirstOrderLogic.g:1716:2: ':'
            {
             before(grammarAccess.getConstraintAccess().getColonKeyword_7()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getColonKeyword_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__Constraint__Group__8"
    // InternalFirstOrderLogic.g:1725:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1729:1: ( rule__Constraint__Group__8__Impl )
            // InternalFirstOrderLogic.g:1730:2: rule__Constraint__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__8__Impl();

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
    // $ANTLR end "rule__Constraint__Group__8"


    // $ANTLR start "rule__Constraint__Group__8__Impl"
    // InternalFirstOrderLogic.g:1736:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__FormulaAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1740:1: ( ( ( rule__Constraint__FormulaAssignment_8 ) ) )
            // InternalFirstOrderLogic.g:1741:1: ( ( rule__Constraint__FormulaAssignment_8 ) )
            {
            // InternalFirstOrderLogic.g:1741:1: ( ( rule__Constraint__FormulaAssignment_8 ) )
            // InternalFirstOrderLogic.g:1742:2: ( rule__Constraint__FormulaAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getFormulaAssignment_8()); 
            // InternalFirstOrderLogic.g:1743:2: ( rule__Constraint__FormulaAssignment_8 )
            // InternalFirstOrderLogic.g:1743:3: rule__Constraint__FormulaAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__FormulaAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getFormulaAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__8__Impl"


    // $ANTLR start "rule__Constraint__Group_6__0"
    // InternalFirstOrderLogic.g:1752:1: rule__Constraint__Group_6__0 : rule__Constraint__Group_6__0__Impl rule__Constraint__Group_6__1 ;
    public final void rule__Constraint__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1756:1: ( rule__Constraint__Group_6__0__Impl rule__Constraint__Group_6__1 )
            // InternalFirstOrderLogic.g:1757:2: rule__Constraint__Group_6__0__Impl rule__Constraint__Group_6__1
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_6__1();

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
    // $ANTLR end "rule__Constraint__Group_6__0"


    // $ANTLR start "rule__Constraint__Group_6__0__Impl"
    // InternalFirstOrderLogic.g:1764:1: rule__Constraint__Group_6__0__Impl : ( '<' ) ;
    public final void rule__Constraint__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1768:1: ( ( '<' ) )
            // InternalFirstOrderLogic.g:1769:1: ( '<' )
            {
            // InternalFirstOrderLogic.g:1769:1: ( '<' )
            // InternalFirstOrderLogic.g:1770:2: '<'
            {
             before(grammarAccess.getConstraintAccess().getLessThanSignKeyword_6_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getLessThanSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_6__0__Impl"


    // $ANTLR start "rule__Constraint__Group_6__1"
    // InternalFirstOrderLogic.g:1779:1: rule__Constraint__Group_6__1 : rule__Constraint__Group_6__1__Impl rule__Constraint__Group_6__2 ;
    public final void rule__Constraint__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1783:1: ( rule__Constraint__Group_6__1__Impl rule__Constraint__Group_6__2 )
            // InternalFirstOrderLogic.g:1784:2: rule__Constraint__Group_6__1__Impl rule__Constraint__Group_6__2
            {
            pushFollow(FOLLOW_12);
            rule__Constraint__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_6__2();

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
    // $ANTLR end "rule__Constraint__Group_6__1"


    // $ANTLR start "rule__Constraint__Group_6__1__Impl"
    // InternalFirstOrderLogic.g:1791:1: rule__Constraint__Group_6__1__Impl : ( ( rule__Constraint__TypeAssignment_6_1 ) ) ;
    public final void rule__Constraint__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1795:1: ( ( ( rule__Constraint__TypeAssignment_6_1 ) ) )
            // InternalFirstOrderLogic.g:1796:1: ( ( rule__Constraint__TypeAssignment_6_1 ) )
            {
            // InternalFirstOrderLogic.g:1796:1: ( ( rule__Constraint__TypeAssignment_6_1 ) )
            // InternalFirstOrderLogic.g:1797:2: ( rule__Constraint__TypeAssignment_6_1 )
            {
             before(grammarAccess.getConstraintAccess().getTypeAssignment_6_1()); 
            // InternalFirstOrderLogic.g:1798:2: ( rule__Constraint__TypeAssignment_6_1 )
            // InternalFirstOrderLogic.g:1798:3: rule__Constraint__TypeAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__TypeAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getTypeAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_6__1__Impl"


    // $ANTLR start "rule__Constraint__Group_6__2"
    // InternalFirstOrderLogic.g:1806:1: rule__Constraint__Group_6__2 : rule__Constraint__Group_6__2__Impl ;
    public final void rule__Constraint__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1810:1: ( rule__Constraint__Group_6__2__Impl )
            // InternalFirstOrderLogic.g:1811:2: rule__Constraint__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group_6__2__Impl();

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
    // $ANTLR end "rule__Constraint__Group_6__2"


    // $ANTLR start "rule__Constraint__Group_6__2__Impl"
    // InternalFirstOrderLogic.g:1817:1: rule__Constraint__Group_6__2__Impl : ( '>' ) ;
    public final void rule__Constraint__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1821:1: ( ( '>' ) )
            // InternalFirstOrderLogic.g:1822:1: ( '>' )
            {
            // InternalFirstOrderLogic.g:1822:1: ( '>' )
            // InternalFirstOrderLogic.g:1823:2: '>'
            {
             before(grammarAccess.getConstraintAccess().getGreaterThanSignKeyword_6_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getGreaterThanSignKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_6__2__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalFirstOrderLogic.g:1833:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1837:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalFirstOrderLogic.g:1838:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalFirstOrderLogic.g:1845:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__TypeAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1849:1: ( ( ( rule__Variable__TypeAssignment_0 ) ) )
            // InternalFirstOrderLogic.g:1850:1: ( ( rule__Variable__TypeAssignment_0 ) )
            {
            // InternalFirstOrderLogic.g:1850:1: ( ( rule__Variable__TypeAssignment_0 ) )
            // InternalFirstOrderLogic.g:1851:2: ( rule__Variable__TypeAssignment_0 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_0()); 
            // InternalFirstOrderLogic.g:1852:2: ( rule__Variable__TypeAssignment_0 )
            // InternalFirstOrderLogic.g:1852:3: rule__Variable__TypeAssignment_0
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
    // InternalFirstOrderLogic.g:1860:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1864:1: ( rule__Variable__Group__1__Impl )
            // InternalFirstOrderLogic.g:1865:2: rule__Variable__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1871:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1875:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:1876:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:1876:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalFirstOrderLogic.g:1877:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalFirstOrderLogic.g:1878:2: ( rule__Variable__NameAssignment_1 )
            // InternalFirstOrderLogic.g:1878:3: rule__Variable__NameAssignment_1
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
    // InternalFirstOrderLogic.g:1887:1: rule__Iff__Group__0 : rule__Iff__Group__0__Impl rule__Iff__Group__1 ;
    public final void rule__Iff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1891:1: ( rule__Iff__Group__0__Impl rule__Iff__Group__1 )
            // InternalFirstOrderLogic.g:1892:2: rule__Iff__Group__0__Impl rule__Iff__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalFirstOrderLogic.g:1899:1: rule__Iff__Group__0__Impl : ( ruleIf ) ;
    public final void rule__Iff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1903:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:1904:1: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:1904:1: ( ruleIf )
            // InternalFirstOrderLogic.g:1905:2: ruleIf
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
    // InternalFirstOrderLogic.g:1914:1: rule__Iff__Group__1 : rule__Iff__Group__1__Impl ;
    public final void rule__Iff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1918:1: ( rule__Iff__Group__1__Impl )
            // InternalFirstOrderLogic.g:1919:2: rule__Iff__Group__1__Impl
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
    // InternalFirstOrderLogic.g:1925:1: rule__Iff__Group__1__Impl : ( ( rule__Iff__Group_1__0 )* ) ;
    public final void rule__Iff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1929:1: ( ( ( rule__Iff__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:1930:1: ( ( rule__Iff__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:1930:1: ( ( rule__Iff__Group_1__0 )* )
            // InternalFirstOrderLogic.g:1931:2: ( rule__Iff__Group_1__0 )*
            {
             before(grammarAccess.getIffAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:1932:2: ( rule__Iff__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:1932:3: rule__Iff__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
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
    // InternalFirstOrderLogic.g:1941:1: rule__Iff__Group_1__0 : rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 ;
    public final void rule__Iff__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1945:1: ( rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1 )
            // InternalFirstOrderLogic.g:1946:2: rule__Iff__Group_1__0__Impl rule__Iff__Group_1__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalFirstOrderLogic.g:1953:1: rule__Iff__Group_1__0__Impl : ( () ) ;
    public final void rule__Iff__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1957:1: ( ( () ) )
            // InternalFirstOrderLogic.g:1958:1: ( () )
            {
            // InternalFirstOrderLogic.g:1958:1: ( () )
            // InternalFirstOrderLogic.g:1959:2: ()
            {
             before(grammarAccess.getIffAccess().getIffLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:1960:2: ()
            // InternalFirstOrderLogic.g:1960:3: 
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
    // InternalFirstOrderLogic.g:1968:1: rule__Iff__Group_1__1 : rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 ;
    public final void rule__Iff__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1972:1: ( rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2 )
            // InternalFirstOrderLogic.g:1973:2: rule__Iff__Group_1__1__Impl rule__Iff__Group_1__2
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
    // InternalFirstOrderLogic.g:1980:1: rule__Iff__Group_1__1__Impl : ( '=' ) ;
    public final void rule__Iff__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1984:1: ( ( '=' ) )
            // InternalFirstOrderLogic.g:1985:1: ( '=' )
            {
            // InternalFirstOrderLogic.g:1985:1: ( '=' )
            // InternalFirstOrderLogic.g:1986:2: '='
            {
             before(grammarAccess.getIffAccess().getEqualsSignKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:1995:1: rule__Iff__Group_1__2 : rule__Iff__Group_1__2__Impl ;
    public final void rule__Iff__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:1999:1: ( rule__Iff__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2000:2: rule__Iff__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2006:1: rule__Iff__Group_1__2__Impl : ( ( rule__Iff__RightAssignment_1_2 ) ) ;
    public final void rule__Iff__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2010:1: ( ( ( rule__Iff__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2011:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2011:1: ( ( rule__Iff__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2012:2: ( rule__Iff__RightAssignment_1_2 )
            {
             before(grammarAccess.getIffAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2013:2: ( rule__Iff__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2013:3: rule__Iff__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2022:1: rule__If__Group__0 : rule__If__Group__0__Impl rule__If__Group__1 ;
    public final void rule__If__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2026:1: ( rule__If__Group__0__Impl rule__If__Group__1 )
            // InternalFirstOrderLogic.g:2027:2: rule__If__Group__0__Impl rule__If__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalFirstOrderLogic.g:2034:1: rule__If__Group__0__Impl : ( ruleXor ) ;
    public final void rule__If__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2038:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:2039:1: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:2039:1: ( ruleXor )
            // InternalFirstOrderLogic.g:2040:2: ruleXor
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
    // InternalFirstOrderLogic.g:2049:1: rule__If__Group__1 : rule__If__Group__1__Impl ;
    public final void rule__If__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2053:1: ( rule__If__Group__1__Impl )
            // InternalFirstOrderLogic.g:2054:2: rule__If__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2060:1: rule__If__Group__1__Impl : ( ( rule__If__Group_1__0 )* ) ;
    public final void rule__If__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2064:1: ( ( ( rule__If__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2065:1: ( ( rule__If__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2065:1: ( ( rule__If__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2066:2: ( rule__If__Group_1__0 )*
            {
             before(grammarAccess.getIfAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2067:2: ( rule__If__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2067:3: rule__If__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
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
    // InternalFirstOrderLogic.g:2076:1: rule__If__Group_1__0 : rule__If__Group_1__0__Impl rule__If__Group_1__1 ;
    public final void rule__If__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2080:1: ( rule__If__Group_1__0__Impl rule__If__Group_1__1 )
            // InternalFirstOrderLogic.g:2081:2: rule__If__Group_1__0__Impl rule__If__Group_1__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalFirstOrderLogic.g:2088:1: rule__If__Group_1__0__Impl : ( () ) ;
    public final void rule__If__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2092:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2093:1: ( () )
            {
            // InternalFirstOrderLogic.g:2093:1: ( () )
            // InternalFirstOrderLogic.g:2094:2: ()
            {
             before(grammarAccess.getIfAccess().getIfLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2095:2: ()
            // InternalFirstOrderLogic.g:2095:3: 
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
    // InternalFirstOrderLogic.g:2103:1: rule__If__Group_1__1 : rule__If__Group_1__1__Impl rule__If__Group_1__2 ;
    public final void rule__If__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2107:1: ( rule__If__Group_1__1__Impl rule__If__Group_1__2 )
            // InternalFirstOrderLogic.g:2108:2: rule__If__Group_1__1__Impl rule__If__Group_1__2
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
    // InternalFirstOrderLogic.g:2115:1: rule__If__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__If__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2119:1: ( ( 'implies' ) )
            // InternalFirstOrderLogic.g:2120:1: ( 'implies' )
            {
            // InternalFirstOrderLogic.g:2120:1: ( 'implies' )
            // InternalFirstOrderLogic.g:2121:2: 'implies'
            {
             before(grammarAccess.getIfAccess().getImpliesKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2130:1: rule__If__Group_1__2 : rule__If__Group_1__2__Impl ;
    public final void rule__If__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2134:1: ( rule__If__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2135:2: rule__If__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2141:1: rule__If__Group_1__2__Impl : ( ( rule__If__RightAssignment_1_2 ) ) ;
    public final void rule__If__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2145:1: ( ( ( rule__If__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2146:1: ( ( rule__If__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2146:1: ( ( rule__If__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2147:2: ( rule__If__RightAssignment_1_2 )
            {
             before(grammarAccess.getIfAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2148:2: ( rule__If__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2148:3: rule__If__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2157:1: rule__Xor__Group__0 : rule__Xor__Group__0__Impl rule__Xor__Group__1 ;
    public final void rule__Xor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2161:1: ( rule__Xor__Group__0__Impl rule__Xor__Group__1 )
            // InternalFirstOrderLogic.g:2162:2: rule__Xor__Group__0__Impl rule__Xor__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalFirstOrderLogic.g:2169:1: rule__Xor__Group__0__Impl : ( ruleOr ) ;
    public final void rule__Xor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2173:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:2174:1: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:2174:1: ( ruleOr )
            // InternalFirstOrderLogic.g:2175:2: ruleOr
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
    // InternalFirstOrderLogic.g:2184:1: rule__Xor__Group__1 : rule__Xor__Group__1__Impl ;
    public final void rule__Xor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2188:1: ( rule__Xor__Group__1__Impl )
            // InternalFirstOrderLogic.g:2189:2: rule__Xor__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2195:1: rule__Xor__Group__1__Impl : ( ( rule__Xor__Group_1__0 )* ) ;
    public final void rule__Xor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2199:1: ( ( ( rule__Xor__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2200:1: ( ( rule__Xor__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2200:1: ( ( rule__Xor__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2201:2: ( rule__Xor__Group_1__0 )*
            {
             before(grammarAccess.getXorAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2202:2: ( rule__Xor__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2202:3: rule__Xor__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
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
    // InternalFirstOrderLogic.g:2211:1: rule__Xor__Group_1__0 : rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 ;
    public final void rule__Xor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2215:1: ( rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1 )
            // InternalFirstOrderLogic.g:2216:2: rule__Xor__Group_1__0__Impl rule__Xor__Group_1__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalFirstOrderLogic.g:2223:1: rule__Xor__Group_1__0__Impl : ( () ) ;
    public final void rule__Xor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2227:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2228:1: ( () )
            {
            // InternalFirstOrderLogic.g:2228:1: ( () )
            // InternalFirstOrderLogic.g:2229:2: ()
            {
             before(grammarAccess.getXorAccess().getXorLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2230:2: ()
            // InternalFirstOrderLogic.g:2230:3: 
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
    // InternalFirstOrderLogic.g:2238:1: rule__Xor__Group_1__1 : rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 ;
    public final void rule__Xor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2242:1: ( rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2 )
            // InternalFirstOrderLogic.g:2243:2: rule__Xor__Group_1__1__Impl rule__Xor__Group_1__2
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
    // InternalFirstOrderLogic.g:2250:1: rule__Xor__Group_1__1__Impl : ( 'xor' ) ;
    public final void rule__Xor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2254:1: ( ( 'xor' ) )
            // InternalFirstOrderLogic.g:2255:1: ( 'xor' )
            {
            // InternalFirstOrderLogic.g:2255:1: ( 'xor' )
            // InternalFirstOrderLogic.g:2256:2: 'xor'
            {
             before(grammarAccess.getXorAccess().getXorKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2265:1: rule__Xor__Group_1__2 : rule__Xor__Group_1__2__Impl ;
    public final void rule__Xor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2269:1: ( rule__Xor__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2270:2: rule__Xor__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2276:1: rule__Xor__Group_1__2__Impl : ( ( rule__Xor__RightAssignment_1_2 ) ) ;
    public final void rule__Xor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2280:1: ( ( ( rule__Xor__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2281:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2281:1: ( ( rule__Xor__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2282:2: ( rule__Xor__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2283:2: ( rule__Xor__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2283:3: rule__Xor__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2292:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2296:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalFirstOrderLogic.g:2297:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:2304:1: rule__Or__Group__0__Impl : ( ruleAnd ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2308:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:2309:1: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:2309:1: ( ruleAnd )
            // InternalFirstOrderLogic.g:2310:2: ruleAnd
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
    // InternalFirstOrderLogic.g:2319:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2323:1: ( rule__Or__Group__1__Impl )
            // InternalFirstOrderLogic.g:2324:2: rule__Or__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2330:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2334:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2335:1: ( ( rule__Or__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2335:1: ( ( rule__Or__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2336:2: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2337:2: ( rule__Or__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2337:3: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
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
    // InternalFirstOrderLogic.g:2346:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2350:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // InternalFirstOrderLogic.g:2351:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalFirstOrderLogic.g:2358:1: rule__Or__Group_1__0__Impl : ( () ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2362:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2363:1: ( () )
            {
            // InternalFirstOrderLogic.g:2363:1: ( () )
            // InternalFirstOrderLogic.g:2364:2: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2365:2: ()
            // InternalFirstOrderLogic.g:2365:3: 
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
    // InternalFirstOrderLogic.g:2373:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl rule__Or__Group_1__2 ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2377:1: ( rule__Or__Group_1__1__Impl rule__Or__Group_1__2 )
            // InternalFirstOrderLogic.g:2378:2: rule__Or__Group_1__1__Impl rule__Or__Group_1__2
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
    // InternalFirstOrderLogic.g:2385:1: rule__Or__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2389:1: ( ( 'or' ) )
            // InternalFirstOrderLogic.g:2390:1: ( 'or' )
            {
            // InternalFirstOrderLogic.g:2390:1: ( 'or' )
            // InternalFirstOrderLogic.g:2391:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_1_1()); 
            match(input,23,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2400:1: rule__Or__Group_1__2 : rule__Or__Group_1__2__Impl ;
    public final void rule__Or__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2404:1: ( rule__Or__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2405:2: rule__Or__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2411:1: rule__Or__Group_1__2__Impl : ( ( rule__Or__RightAssignment_1_2 ) ) ;
    public final void rule__Or__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2415:1: ( ( ( rule__Or__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2416:1: ( ( rule__Or__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2416:1: ( ( rule__Or__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2417:2: ( rule__Or__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2418:2: ( rule__Or__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2418:3: rule__Or__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2427:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2431:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalFirstOrderLogic.g:2432:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2439:1: rule__And__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2443:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:2444:1: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:2444:1: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:2445:2: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:2454:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2458:1: ( rule__And__Group__1__Impl )
            // InternalFirstOrderLogic.g:2459:2: rule__And__Group__1__Impl
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
    // InternalFirstOrderLogic.g:2465:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )* ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2469:1: ( ( ( rule__And__Group_1__0 )* ) )
            // InternalFirstOrderLogic.g:2470:1: ( ( rule__And__Group_1__0 )* )
            {
            // InternalFirstOrderLogic.g:2470:1: ( ( rule__And__Group_1__0 )* )
            // InternalFirstOrderLogic.g:2471:2: ( rule__And__Group_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:2472:2: ( rule__And__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:2472:3: rule__And__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
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
    // InternalFirstOrderLogic.g:2481:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2485:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalFirstOrderLogic.g:2486:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalFirstOrderLogic.g:2493:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2497:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2498:1: ( () )
            {
            // InternalFirstOrderLogic.g:2498:1: ( () )
            // InternalFirstOrderLogic.g:2499:2: ()
            {
             before(grammarAccess.getAndAccess().getAndLeftAction_1_0()); 
            // InternalFirstOrderLogic.g:2500:2: ()
            // InternalFirstOrderLogic.g:2500:3: 
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
    // InternalFirstOrderLogic.g:2508:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl rule__And__Group_1__2 ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2512:1: ( rule__And__Group_1__1__Impl rule__And__Group_1__2 )
            // InternalFirstOrderLogic.g:2513:2: rule__And__Group_1__1__Impl rule__And__Group_1__2
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
    // InternalFirstOrderLogic.g:2520:1: rule__And__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2524:1: ( ( 'and' ) )
            // InternalFirstOrderLogic.g:2525:1: ( 'and' )
            {
            // InternalFirstOrderLogic.g:2525:1: ( 'and' )
            // InternalFirstOrderLogic.g:2526:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_1_1()); 
            match(input,24,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2535:1: rule__And__Group_1__2 : rule__And__Group_1__2__Impl ;
    public final void rule__And__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2539:1: ( rule__And__Group_1__2__Impl )
            // InternalFirstOrderLogic.g:2540:2: rule__And__Group_1__2__Impl
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
    // InternalFirstOrderLogic.g:2546:1: rule__And__Group_1__2__Impl : ( ( rule__And__RightAssignment_1_2 ) ) ;
    public final void rule__And__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2550:1: ( ( ( rule__And__RightAssignment_1_2 ) ) )
            // InternalFirstOrderLogic.g:2551:1: ( ( rule__And__RightAssignment_1_2 ) )
            {
            // InternalFirstOrderLogic.g:2551:1: ( ( rule__And__RightAssignment_1_2 ) )
            // InternalFirstOrderLogic.g:2552:2: ( rule__And__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndAccess().getRightAssignment_1_2()); 
            // InternalFirstOrderLogic.g:2553:2: ( rule__And__RightAssignment_1_2 )
            // InternalFirstOrderLogic.g:2553:3: rule__And__RightAssignment_1_2
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
    // InternalFirstOrderLogic.g:2562:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2566:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalFirstOrderLogic.g:2567:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalFirstOrderLogic.g:2574:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2578:1: ( ( () ) )
            // InternalFirstOrderLogic.g:2579:1: ( () )
            {
            // InternalFirstOrderLogic.g:2579:1: ( () )
            // InternalFirstOrderLogic.g:2580:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalFirstOrderLogic.g:2581:2: ()
            // InternalFirstOrderLogic.g:2581:3: 
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
    // InternalFirstOrderLogic.g:2589:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2593:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalFirstOrderLogic.g:2594:2: rule__Not__Group__1__Impl rule__Not__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:2601:1: rule__Not__Group__1__Impl : ( 'not' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2605:1: ( ( 'not' ) )
            // InternalFirstOrderLogic.g:2606:1: ( 'not' )
            {
            // InternalFirstOrderLogic.g:2606:1: ( 'not' )
            // InternalFirstOrderLogic.g:2607:2: 'not'
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,25,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2616:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2620:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalFirstOrderLogic.g:2621:2: rule__Not__Group__2__Impl rule__Not__Group__3
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
    // InternalFirstOrderLogic.g:2628:1: rule__Not__Group__2__Impl : ( '(' ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2632:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2633:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2633:1: ( '(' )
            // InternalFirstOrderLogic.g:2634:2: '('
            {
             before(grammarAccess.getNotAccess().getLeftParenthesisKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2643:1: rule__Not__Group__3 : rule__Not__Group__3__Impl rule__Not__Group__4 ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2647:1: ( rule__Not__Group__3__Impl rule__Not__Group__4 )
            // InternalFirstOrderLogic.g:2648:2: rule__Not__Group__3__Impl rule__Not__Group__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:2655:1: rule__Not__Group__3__Impl : ( ( rule__Not__NotAssignment_3 ) ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2659:1: ( ( ( rule__Not__NotAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:2660:1: ( ( rule__Not__NotAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:2660:1: ( ( rule__Not__NotAssignment_3 ) )
            // InternalFirstOrderLogic.g:2661:2: ( rule__Not__NotAssignment_3 )
            {
             before(grammarAccess.getNotAccess().getNotAssignment_3()); 
            // InternalFirstOrderLogic.g:2662:2: ( rule__Not__NotAssignment_3 )
            // InternalFirstOrderLogic.g:2662:3: rule__Not__NotAssignment_3
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
    // InternalFirstOrderLogic.g:2670:1: rule__Not__Group__4 : rule__Not__Group__4__Impl ;
    public final void rule__Not__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2674:1: ( rule__Not__Group__4__Impl )
            // InternalFirstOrderLogic.g:2675:2: rule__Not__Group__4__Impl
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
    // InternalFirstOrderLogic.g:2681:1: rule__Not__Group__4__Impl : ( ')' ) ;
    public final void rule__Not__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2685:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2686:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2686:1: ( ')' )
            // InternalFirstOrderLogic.g:2687:2: ')'
            {
             before(grammarAccess.getNotAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2697:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2701:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // InternalFirstOrderLogic.g:2702:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:2709:1: rule__Equals__Group__0__Impl : ( 'isEqual' ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2713:1: ( ( 'isEqual' ) )
            // InternalFirstOrderLogic.g:2714:1: ( 'isEqual' )
            {
            // InternalFirstOrderLogic.g:2714:1: ( 'isEqual' )
            // InternalFirstOrderLogic.g:2715:2: 'isEqual'
            {
             before(grammarAccess.getEqualsAccess().getIsEqualKeyword_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2724:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl rule__Equals__Group__2 ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2728:1: ( rule__Equals__Group__1__Impl rule__Equals__Group__2 )
            // InternalFirstOrderLogic.g:2729:2: rule__Equals__Group__1__Impl rule__Equals__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:2736:1: rule__Equals__Group__1__Impl : ( '(' ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2740:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2741:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2741:1: ( '(' )
            // InternalFirstOrderLogic.g:2742:2: '('
            {
             before(grammarAccess.getEqualsAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2751:1: rule__Equals__Group__2 : rule__Equals__Group__2__Impl rule__Equals__Group__3 ;
    public final void rule__Equals__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2755:1: ( rule__Equals__Group__2__Impl rule__Equals__Group__3 )
            // InternalFirstOrderLogic.g:2756:2: rule__Equals__Group__2__Impl rule__Equals__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:2763:1: rule__Equals__Group__2__Impl : ( ( rule__Equals__LeftAssignment_2 ) ) ;
    public final void rule__Equals__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2767:1: ( ( ( rule__Equals__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2768:1: ( ( rule__Equals__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2768:1: ( ( rule__Equals__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:2769:2: ( rule__Equals__LeftAssignment_2 )
            {
             before(grammarAccess.getEqualsAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:2770:2: ( rule__Equals__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:2770:3: rule__Equals__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:2778:1: rule__Equals__Group__3 : rule__Equals__Group__3__Impl rule__Equals__Group__4 ;
    public final void rule__Equals__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2782:1: ( rule__Equals__Group__3__Impl rule__Equals__Group__4 )
            // InternalFirstOrderLogic.g:2783:2: rule__Equals__Group__3__Impl rule__Equals__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:2790:1: rule__Equals__Group__3__Impl : ( ',' ) ;
    public final void rule__Equals__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2794:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2795:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2795:1: ( ',' )
            // InternalFirstOrderLogic.g:2796:2: ','
            {
             before(grammarAccess.getEqualsAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2805:1: rule__Equals__Group__4 : rule__Equals__Group__4__Impl rule__Equals__Group__5 ;
    public final void rule__Equals__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2809:1: ( rule__Equals__Group__4__Impl rule__Equals__Group__5 )
            // InternalFirstOrderLogic.g:2810:2: rule__Equals__Group__4__Impl rule__Equals__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:2817:1: rule__Equals__Group__4__Impl : ( ( rule__Equals__RightAssignment_4 ) ) ;
    public final void rule__Equals__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2821:1: ( ( ( rule__Equals__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:2822:1: ( ( rule__Equals__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:2822:1: ( ( rule__Equals__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:2823:2: ( rule__Equals__RightAssignment_4 )
            {
             before(grammarAccess.getEqualsAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:2824:2: ( rule__Equals__RightAssignment_4 )
            // InternalFirstOrderLogic.g:2824:3: rule__Equals__RightAssignment_4
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
    // InternalFirstOrderLogic.g:2832:1: rule__Equals__Group__5 : rule__Equals__Group__5__Impl ;
    public final void rule__Equals__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2836:1: ( rule__Equals__Group__5__Impl )
            // InternalFirstOrderLogic.g:2837:2: rule__Equals__Group__5__Impl
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
    // InternalFirstOrderLogic.g:2843:1: rule__Equals__Group__5__Impl : ( ')' ) ;
    public final void rule__Equals__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2847:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:2848:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:2848:1: ( ')' )
            // InternalFirstOrderLogic.g:2849:2: ')'
            {
             before(grammarAccess.getEqualsAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2859:1: rule__Greater__Group__0 : rule__Greater__Group__0__Impl rule__Greater__Group__1 ;
    public final void rule__Greater__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2863:1: ( rule__Greater__Group__0__Impl rule__Greater__Group__1 )
            // InternalFirstOrderLogic.g:2864:2: rule__Greater__Group__0__Impl rule__Greater__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:2871:1: rule__Greater__Group__0__Impl : ( 'isGreater' ) ;
    public final void rule__Greater__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2875:1: ( ( 'isGreater' ) )
            // InternalFirstOrderLogic.g:2876:1: ( 'isGreater' )
            {
            // InternalFirstOrderLogic.g:2876:1: ( 'isGreater' )
            // InternalFirstOrderLogic.g:2877:2: 'isGreater'
            {
             before(grammarAccess.getGreaterAccess().getIsGreaterKeyword_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2886:1: rule__Greater__Group__1 : rule__Greater__Group__1__Impl rule__Greater__Group__2 ;
    public final void rule__Greater__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2890:1: ( rule__Greater__Group__1__Impl rule__Greater__Group__2 )
            // InternalFirstOrderLogic.g:2891:2: rule__Greater__Group__1__Impl rule__Greater__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:2898:1: rule__Greater__Group__1__Impl : ( '(' ) ;
    public final void rule__Greater__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2902:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:2903:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:2903:1: ( '(' )
            // InternalFirstOrderLogic.g:2904:2: '('
            {
             before(grammarAccess.getGreaterAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2913:1: rule__Greater__Group__2 : rule__Greater__Group__2__Impl rule__Greater__Group__3 ;
    public final void rule__Greater__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2917:1: ( rule__Greater__Group__2__Impl rule__Greater__Group__3 )
            // InternalFirstOrderLogic.g:2918:2: rule__Greater__Group__2__Impl rule__Greater__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:2925:1: rule__Greater__Group__2__Impl : ( ( rule__Greater__LeftAssignment_2 ) ) ;
    public final void rule__Greater__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2929:1: ( ( ( rule__Greater__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:2930:1: ( ( rule__Greater__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:2930:1: ( ( rule__Greater__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:2931:2: ( rule__Greater__LeftAssignment_2 )
            {
             before(grammarAccess.getGreaterAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:2932:2: ( rule__Greater__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:2932:3: rule__Greater__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:2940:1: rule__Greater__Group__3 : rule__Greater__Group__3__Impl rule__Greater__Group__4 ;
    public final void rule__Greater__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2944:1: ( rule__Greater__Group__3__Impl rule__Greater__Group__4 )
            // InternalFirstOrderLogic.g:2945:2: rule__Greater__Group__3__Impl rule__Greater__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:2952:1: rule__Greater__Group__3__Impl : ( ',' ) ;
    public final void rule__Greater__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2956:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:2957:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:2957:1: ( ',' )
            // InternalFirstOrderLogic.g:2958:2: ','
            {
             before(grammarAccess.getGreaterAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:2967:1: rule__Greater__Group__4 : rule__Greater__Group__4__Impl rule__Greater__Group__5 ;
    public final void rule__Greater__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2971:1: ( rule__Greater__Group__4__Impl rule__Greater__Group__5 )
            // InternalFirstOrderLogic.g:2972:2: rule__Greater__Group__4__Impl rule__Greater__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:2979:1: rule__Greater__Group__4__Impl : ( ( rule__Greater__RightAssignment_4 ) ) ;
    public final void rule__Greater__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2983:1: ( ( ( rule__Greater__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:2984:1: ( ( rule__Greater__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:2984:1: ( ( rule__Greater__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:2985:2: ( rule__Greater__RightAssignment_4 )
            {
             before(grammarAccess.getGreaterAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:2986:2: ( rule__Greater__RightAssignment_4 )
            // InternalFirstOrderLogic.g:2986:3: rule__Greater__RightAssignment_4
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
    // InternalFirstOrderLogic.g:2994:1: rule__Greater__Group__5 : rule__Greater__Group__5__Impl ;
    public final void rule__Greater__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:2998:1: ( rule__Greater__Group__5__Impl )
            // InternalFirstOrderLogic.g:2999:2: rule__Greater__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3005:1: rule__Greater__Group__5__Impl : ( ')' ) ;
    public final void rule__Greater__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3009:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3010:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3010:1: ( ')' )
            // InternalFirstOrderLogic.g:3011:2: ')'
            {
             before(grammarAccess.getGreaterAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3021:1: rule__GreaterEqual__Group__0 : rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 ;
    public final void rule__GreaterEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3025:1: ( rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1 )
            // InternalFirstOrderLogic.g:3026:2: rule__GreaterEqual__Group__0__Impl rule__GreaterEqual__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3033:1: rule__GreaterEqual__Group__0__Impl : ( 'isGreaterEqual' ) ;
    public final void rule__GreaterEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3037:1: ( ( 'isGreaterEqual' ) )
            // InternalFirstOrderLogic.g:3038:1: ( 'isGreaterEqual' )
            {
            // InternalFirstOrderLogic.g:3038:1: ( 'isGreaterEqual' )
            // InternalFirstOrderLogic.g:3039:2: 'isGreaterEqual'
            {
             before(grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3048:1: rule__GreaterEqual__Group__1 : rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 ;
    public final void rule__GreaterEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3052:1: ( rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2 )
            // InternalFirstOrderLogic.g:3053:2: rule__GreaterEqual__Group__1__Impl rule__GreaterEqual__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3060:1: rule__GreaterEqual__Group__1__Impl : ( '(' ) ;
    public final void rule__GreaterEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3064:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3065:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3065:1: ( '(' )
            // InternalFirstOrderLogic.g:3066:2: '('
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3075:1: rule__GreaterEqual__Group__2 : rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 ;
    public final void rule__GreaterEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3079:1: ( rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3 )
            // InternalFirstOrderLogic.g:3080:2: rule__GreaterEqual__Group__2__Impl rule__GreaterEqual__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:3087:1: rule__GreaterEqual__Group__2__Impl : ( ( rule__GreaterEqual__LeftAssignment_2 ) ) ;
    public final void rule__GreaterEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3091:1: ( ( ( rule__GreaterEqual__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3092:1: ( ( rule__GreaterEqual__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3092:1: ( ( rule__GreaterEqual__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3093:2: ( rule__GreaterEqual__LeftAssignment_2 )
            {
             before(grammarAccess.getGreaterEqualAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3094:2: ( rule__GreaterEqual__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3094:3: rule__GreaterEqual__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:3102:1: rule__GreaterEqual__Group__3 : rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 ;
    public final void rule__GreaterEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3106:1: ( rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4 )
            // InternalFirstOrderLogic.g:3107:2: rule__GreaterEqual__Group__3__Impl rule__GreaterEqual__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3114:1: rule__GreaterEqual__Group__3__Impl : ( ',' ) ;
    public final void rule__GreaterEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3118:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3119:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3119:1: ( ',' )
            // InternalFirstOrderLogic.g:3120:2: ','
            {
             before(grammarAccess.getGreaterEqualAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3129:1: rule__GreaterEqual__Group__4 : rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5 ;
    public final void rule__GreaterEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3133:1: ( rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5 )
            // InternalFirstOrderLogic.g:3134:2: rule__GreaterEqual__Group__4__Impl rule__GreaterEqual__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3141:1: rule__GreaterEqual__Group__4__Impl : ( ( rule__GreaterEqual__RightAssignment_4 ) ) ;
    public final void rule__GreaterEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3145:1: ( ( ( rule__GreaterEqual__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3146:1: ( ( rule__GreaterEqual__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3146:1: ( ( rule__GreaterEqual__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3147:2: ( rule__GreaterEqual__RightAssignment_4 )
            {
             before(grammarAccess.getGreaterEqualAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3148:2: ( rule__GreaterEqual__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3148:3: rule__GreaterEqual__RightAssignment_4
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
    // InternalFirstOrderLogic.g:3156:1: rule__GreaterEqual__Group__5 : rule__GreaterEqual__Group__5__Impl ;
    public final void rule__GreaterEqual__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3160:1: ( rule__GreaterEqual__Group__5__Impl )
            // InternalFirstOrderLogic.g:3161:2: rule__GreaterEqual__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3167:1: rule__GreaterEqual__Group__5__Impl : ( ')' ) ;
    public final void rule__GreaterEqual__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3171:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3172:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3172:1: ( ')' )
            // InternalFirstOrderLogic.g:3173:2: ')'
            {
             before(grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3183:1: rule__Smaller__Group__0 : rule__Smaller__Group__0__Impl rule__Smaller__Group__1 ;
    public final void rule__Smaller__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3187:1: ( rule__Smaller__Group__0__Impl rule__Smaller__Group__1 )
            // InternalFirstOrderLogic.g:3188:2: rule__Smaller__Group__0__Impl rule__Smaller__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3195:1: rule__Smaller__Group__0__Impl : ( 'isSmaller' ) ;
    public final void rule__Smaller__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3199:1: ( ( 'isSmaller' ) )
            // InternalFirstOrderLogic.g:3200:1: ( 'isSmaller' )
            {
            // InternalFirstOrderLogic.g:3200:1: ( 'isSmaller' )
            // InternalFirstOrderLogic.g:3201:2: 'isSmaller'
            {
             before(grammarAccess.getSmallerAccess().getIsSmallerKeyword_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3210:1: rule__Smaller__Group__1 : rule__Smaller__Group__1__Impl rule__Smaller__Group__2 ;
    public final void rule__Smaller__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3214:1: ( rule__Smaller__Group__1__Impl rule__Smaller__Group__2 )
            // InternalFirstOrderLogic.g:3215:2: rule__Smaller__Group__1__Impl rule__Smaller__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3222:1: rule__Smaller__Group__1__Impl : ( '(' ) ;
    public final void rule__Smaller__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3226:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3227:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3227:1: ( '(' )
            // InternalFirstOrderLogic.g:3228:2: '('
            {
             before(grammarAccess.getSmallerAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3237:1: rule__Smaller__Group__2 : rule__Smaller__Group__2__Impl rule__Smaller__Group__3 ;
    public final void rule__Smaller__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3241:1: ( rule__Smaller__Group__2__Impl rule__Smaller__Group__3 )
            // InternalFirstOrderLogic.g:3242:2: rule__Smaller__Group__2__Impl rule__Smaller__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:3249:1: rule__Smaller__Group__2__Impl : ( ( rule__Smaller__LeftAssignment_2 ) ) ;
    public final void rule__Smaller__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3253:1: ( ( ( rule__Smaller__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3254:1: ( ( rule__Smaller__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3254:1: ( ( rule__Smaller__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3255:2: ( rule__Smaller__LeftAssignment_2 )
            {
             before(grammarAccess.getSmallerAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3256:2: ( rule__Smaller__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3256:3: rule__Smaller__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:3264:1: rule__Smaller__Group__3 : rule__Smaller__Group__3__Impl rule__Smaller__Group__4 ;
    public final void rule__Smaller__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3268:1: ( rule__Smaller__Group__3__Impl rule__Smaller__Group__4 )
            // InternalFirstOrderLogic.g:3269:2: rule__Smaller__Group__3__Impl rule__Smaller__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3276:1: rule__Smaller__Group__3__Impl : ( ',' ) ;
    public final void rule__Smaller__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3280:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3281:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3281:1: ( ',' )
            // InternalFirstOrderLogic.g:3282:2: ','
            {
             before(grammarAccess.getSmallerAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3291:1: rule__Smaller__Group__4 : rule__Smaller__Group__4__Impl rule__Smaller__Group__5 ;
    public final void rule__Smaller__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3295:1: ( rule__Smaller__Group__4__Impl rule__Smaller__Group__5 )
            // InternalFirstOrderLogic.g:3296:2: rule__Smaller__Group__4__Impl rule__Smaller__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3303:1: rule__Smaller__Group__4__Impl : ( ( rule__Smaller__RightAssignment_4 ) ) ;
    public final void rule__Smaller__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3307:1: ( ( ( rule__Smaller__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3308:1: ( ( rule__Smaller__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3308:1: ( ( rule__Smaller__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3309:2: ( rule__Smaller__RightAssignment_4 )
            {
             before(grammarAccess.getSmallerAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3310:2: ( rule__Smaller__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3310:3: rule__Smaller__RightAssignment_4
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
    // InternalFirstOrderLogic.g:3318:1: rule__Smaller__Group__5 : rule__Smaller__Group__5__Impl ;
    public final void rule__Smaller__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3322:1: ( rule__Smaller__Group__5__Impl )
            // InternalFirstOrderLogic.g:3323:2: rule__Smaller__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3329:1: rule__Smaller__Group__5__Impl : ( ')' ) ;
    public final void rule__Smaller__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3333:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3334:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3334:1: ( ')' )
            // InternalFirstOrderLogic.g:3335:2: ')'
            {
             before(grammarAccess.getSmallerAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3345:1: rule__SmallerEqual__Group__0 : rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 ;
    public final void rule__SmallerEqual__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3349:1: ( rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1 )
            // InternalFirstOrderLogic.g:3350:2: rule__SmallerEqual__Group__0__Impl rule__SmallerEqual__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3357:1: rule__SmallerEqual__Group__0__Impl : ( 'isSmallerEqual' ) ;
    public final void rule__SmallerEqual__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3361:1: ( ( 'isSmallerEqual' ) )
            // InternalFirstOrderLogic.g:3362:1: ( 'isSmallerEqual' )
            {
            // InternalFirstOrderLogic.g:3362:1: ( 'isSmallerEqual' )
            // InternalFirstOrderLogic.g:3363:2: 'isSmallerEqual'
            {
             before(grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3372:1: rule__SmallerEqual__Group__1 : rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 ;
    public final void rule__SmallerEqual__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3376:1: ( rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2 )
            // InternalFirstOrderLogic.g:3377:2: rule__SmallerEqual__Group__1__Impl rule__SmallerEqual__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3384:1: rule__SmallerEqual__Group__1__Impl : ( '(' ) ;
    public final void rule__SmallerEqual__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3388:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3389:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3389:1: ( '(' )
            // InternalFirstOrderLogic.g:3390:2: '('
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3399:1: rule__SmallerEqual__Group__2 : rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 ;
    public final void rule__SmallerEqual__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3403:1: ( rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3 )
            // InternalFirstOrderLogic.g:3404:2: rule__SmallerEqual__Group__2__Impl rule__SmallerEqual__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:3411:1: rule__SmallerEqual__Group__2__Impl : ( ( rule__SmallerEqual__LeftAssignment_2 ) ) ;
    public final void rule__SmallerEqual__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3415:1: ( ( ( rule__SmallerEqual__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3416:1: ( ( rule__SmallerEqual__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3416:1: ( ( rule__SmallerEqual__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:3417:2: ( rule__SmallerEqual__LeftAssignment_2 )
            {
             before(grammarAccess.getSmallerEqualAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:3418:2: ( rule__SmallerEqual__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:3418:3: rule__SmallerEqual__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:3426:1: rule__SmallerEqual__Group__3 : rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 ;
    public final void rule__SmallerEqual__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3430:1: ( rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4 )
            // InternalFirstOrderLogic.g:3431:2: rule__SmallerEqual__Group__3__Impl rule__SmallerEqual__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3438:1: rule__SmallerEqual__Group__3__Impl : ( ',' ) ;
    public final void rule__SmallerEqual__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3442:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3443:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3443:1: ( ',' )
            // InternalFirstOrderLogic.g:3444:2: ','
            {
             before(grammarAccess.getSmallerEqualAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3453:1: rule__SmallerEqual__Group__4 : rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5 ;
    public final void rule__SmallerEqual__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3457:1: ( rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5 )
            // InternalFirstOrderLogic.g:3458:2: rule__SmallerEqual__Group__4__Impl rule__SmallerEqual__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3465:1: rule__SmallerEqual__Group__4__Impl : ( ( rule__SmallerEqual__RightAssignment_4 ) ) ;
    public final void rule__SmallerEqual__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3469:1: ( ( ( rule__SmallerEqual__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3470:1: ( ( rule__SmallerEqual__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3470:1: ( ( rule__SmallerEqual__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:3471:2: ( rule__SmallerEqual__RightAssignment_4 )
            {
             before(grammarAccess.getSmallerEqualAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:3472:2: ( rule__SmallerEqual__RightAssignment_4 )
            // InternalFirstOrderLogic.g:3472:3: rule__SmallerEqual__RightAssignment_4
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
    // InternalFirstOrderLogic.g:3480:1: rule__SmallerEqual__Group__5 : rule__SmallerEqual__Group__5__Impl ;
    public final void rule__SmallerEqual__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3484:1: ( rule__SmallerEqual__Group__5__Impl )
            // InternalFirstOrderLogic.g:3485:2: rule__SmallerEqual__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3491:1: rule__SmallerEqual__Group__5__Impl : ( ')' ) ;
    public final void rule__SmallerEqual__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3495:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3496:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3496:1: ( ')' )
            // InternalFirstOrderLogic.g:3497:2: ')'
            {
             before(grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3507:1: rule__IsEmpty__Group__0 : rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 ;
    public final void rule__IsEmpty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3511:1: ( rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1 )
            // InternalFirstOrderLogic.g:3512:2: rule__IsEmpty__Group__0__Impl rule__IsEmpty__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3519:1: rule__IsEmpty__Group__0__Impl : ( 'isEmpty' ) ;
    public final void rule__IsEmpty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3523:1: ( ( 'isEmpty' ) )
            // InternalFirstOrderLogic.g:3524:1: ( 'isEmpty' )
            {
            // InternalFirstOrderLogic.g:3524:1: ( 'isEmpty' )
            // InternalFirstOrderLogic.g:3525:2: 'isEmpty'
            {
             before(grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3534:1: rule__IsEmpty__Group__1 : rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 ;
    public final void rule__IsEmpty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3538:1: ( rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2 )
            // InternalFirstOrderLogic.g:3539:2: rule__IsEmpty__Group__1__Impl rule__IsEmpty__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3546:1: rule__IsEmpty__Group__1__Impl : ( '(' ) ;
    public final void rule__IsEmpty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3550:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3551:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3551:1: ( '(' )
            // InternalFirstOrderLogic.g:3552:2: '('
            {
             before(grammarAccess.getIsEmptyAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3561:1: rule__IsEmpty__Group__2 : rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3 ;
    public final void rule__IsEmpty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3565:1: ( rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3 )
            // InternalFirstOrderLogic.g:3566:2: rule__IsEmpty__Group__2__Impl rule__IsEmpty__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3573:1: rule__IsEmpty__Group__2__Impl : ( ( rule__IsEmpty__TermAssignment_2 ) ) ;
    public final void rule__IsEmpty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3577:1: ( ( ( rule__IsEmpty__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3578:1: ( ( rule__IsEmpty__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3578:1: ( ( rule__IsEmpty__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3579:2: ( rule__IsEmpty__TermAssignment_2 )
            {
             before(grammarAccess.getIsEmptyAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3580:2: ( rule__IsEmpty__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3580:3: rule__IsEmpty__TermAssignment_2
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
    // InternalFirstOrderLogic.g:3588:1: rule__IsEmpty__Group__3 : rule__IsEmpty__Group__3__Impl ;
    public final void rule__IsEmpty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3592:1: ( rule__IsEmpty__Group__3__Impl )
            // InternalFirstOrderLogic.g:3593:2: rule__IsEmpty__Group__3__Impl
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
    // InternalFirstOrderLogic.g:3599:1: rule__IsEmpty__Group__3__Impl : ( ')' ) ;
    public final void rule__IsEmpty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3603:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3604:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3604:1: ( ')' )
            // InternalFirstOrderLogic.g:3605:2: ')'
            {
             before(grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3615:1: rule__IsInstanceOf__Group__0 : rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 ;
    public final void rule__IsInstanceOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3619:1: ( rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1 )
            // InternalFirstOrderLogic.g:3620:2: rule__IsInstanceOf__Group__0__Impl rule__IsInstanceOf__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3627:1: rule__IsInstanceOf__Group__0__Impl : ( 'isInstanceOf' ) ;
    public final void rule__IsInstanceOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3631:1: ( ( 'isInstanceOf' ) )
            // InternalFirstOrderLogic.g:3632:1: ( 'isInstanceOf' )
            {
            // InternalFirstOrderLogic.g:3632:1: ( 'isInstanceOf' )
            // InternalFirstOrderLogic.g:3633:2: 'isInstanceOf'
            {
             before(grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3642:1: rule__IsInstanceOf__Group__1 : rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 ;
    public final void rule__IsInstanceOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3646:1: ( rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2 )
            // InternalFirstOrderLogic.g:3647:2: rule__IsInstanceOf__Group__1__Impl rule__IsInstanceOf__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3654:1: rule__IsInstanceOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IsInstanceOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3658:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3659:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3659:1: ( '(' )
            // InternalFirstOrderLogic.g:3660:2: '('
            {
             before(grammarAccess.getIsInstanceOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3669:1: rule__IsInstanceOf__Group__2 : rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 ;
    public final void rule__IsInstanceOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3673:1: ( rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3 )
            // InternalFirstOrderLogic.g:3674:2: rule__IsInstanceOf__Group__2__Impl rule__IsInstanceOf__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:3681:1: rule__IsInstanceOf__Group__2__Impl : ( ( rule__IsInstanceOf__TermAssignment_2 ) ) ;
    public final void rule__IsInstanceOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3685:1: ( ( ( rule__IsInstanceOf__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3686:1: ( ( rule__IsInstanceOf__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3686:1: ( ( rule__IsInstanceOf__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3687:2: ( rule__IsInstanceOf__TermAssignment_2 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3688:2: ( rule__IsInstanceOf__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3688:3: rule__IsInstanceOf__TermAssignment_2
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
    // InternalFirstOrderLogic.g:3696:1: rule__IsInstanceOf__Group__3 : rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 ;
    public final void rule__IsInstanceOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3700:1: ( rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4 )
            // InternalFirstOrderLogic.g:3701:2: rule__IsInstanceOf__Group__3__Impl rule__IsInstanceOf__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3708:1: rule__IsInstanceOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IsInstanceOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3712:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3713:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3713:1: ( ',' )
            // InternalFirstOrderLogic.g:3714:2: ','
            {
             before(grammarAccess.getIsInstanceOfAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3723:1: rule__IsInstanceOf__Group__4 : rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5 ;
    public final void rule__IsInstanceOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3727:1: ( rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5 )
            // InternalFirstOrderLogic.g:3728:2: rule__IsInstanceOf__Group__4__Impl rule__IsInstanceOf__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3735:1: rule__IsInstanceOf__Group__4__Impl : ( ( rule__IsInstanceOf__TypeAssignment_4 ) ) ;
    public final void rule__IsInstanceOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3739:1: ( ( ( rule__IsInstanceOf__TypeAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3740:1: ( ( rule__IsInstanceOf__TypeAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3740:1: ( ( rule__IsInstanceOf__TypeAssignment_4 ) )
            // InternalFirstOrderLogic.g:3741:2: ( rule__IsInstanceOf__TypeAssignment_4 )
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeAssignment_4()); 
            // InternalFirstOrderLogic.g:3742:2: ( rule__IsInstanceOf__TypeAssignment_4 )
            // InternalFirstOrderLogic.g:3742:3: rule__IsInstanceOf__TypeAssignment_4
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
    // InternalFirstOrderLogic.g:3750:1: rule__IsInstanceOf__Group__5 : rule__IsInstanceOf__Group__5__Impl ;
    public final void rule__IsInstanceOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3754:1: ( rule__IsInstanceOf__Group__5__Impl )
            // InternalFirstOrderLogic.g:3755:2: rule__IsInstanceOf__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3761:1: rule__IsInstanceOf__Group__5__Impl : ( ')' ) ;
    public final void rule__IsInstanceOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3765:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3766:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3766:1: ( ')' )
            // InternalFirstOrderLogic.g:3767:2: ')'
            {
             before(grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3777:1: rule__IsValueLiteralOf__Group__0 : rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1 ;
    public final void rule__IsValueLiteralOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3781:1: ( rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1 )
            // InternalFirstOrderLogic.g:3782:2: rule__IsValueLiteralOf__Group__0__Impl rule__IsValueLiteralOf__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3789:1: rule__IsValueLiteralOf__Group__0__Impl : ( 'isValueLiteralOf' ) ;
    public final void rule__IsValueLiteralOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3793:1: ( ( 'isValueLiteralOf' ) )
            // InternalFirstOrderLogic.g:3794:1: ( 'isValueLiteralOf' )
            {
            // InternalFirstOrderLogic.g:3794:1: ( 'isValueLiteralOf' )
            // InternalFirstOrderLogic.g:3795:2: 'isValueLiteralOf'
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getIsValueLiteralOfKeyword_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3804:1: rule__IsValueLiteralOf__Group__1 : rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2 ;
    public final void rule__IsValueLiteralOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3808:1: ( rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2 )
            // InternalFirstOrderLogic.g:3809:2: rule__IsValueLiteralOf__Group__1__Impl rule__IsValueLiteralOf__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3816:1: rule__IsValueLiteralOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IsValueLiteralOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3820:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:3821:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:3821:1: ( '(' )
            // InternalFirstOrderLogic.g:3822:2: '('
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3831:1: rule__IsValueLiteralOf__Group__2 : rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3 ;
    public final void rule__IsValueLiteralOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3835:1: ( rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3 )
            // InternalFirstOrderLogic.g:3836:2: rule__IsValueLiteralOf__Group__2__Impl rule__IsValueLiteralOf__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:3843:1: rule__IsValueLiteralOf__Group__2__Impl : ( ( rule__IsValueLiteralOf__TermAssignment_2 ) ) ;
    public final void rule__IsValueLiteralOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3847:1: ( ( ( rule__IsValueLiteralOf__TermAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:3848:1: ( ( rule__IsValueLiteralOf__TermAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:3848:1: ( ( rule__IsValueLiteralOf__TermAssignment_2 ) )
            // InternalFirstOrderLogic.g:3849:2: ( rule__IsValueLiteralOf__TermAssignment_2 )
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTermAssignment_2()); 
            // InternalFirstOrderLogic.g:3850:2: ( rule__IsValueLiteralOf__TermAssignment_2 )
            // InternalFirstOrderLogic.g:3850:3: rule__IsValueLiteralOf__TermAssignment_2
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
    // InternalFirstOrderLogic.g:3858:1: rule__IsValueLiteralOf__Group__3 : rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4 ;
    public final void rule__IsValueLiteralOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3862:1: ( rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4 )
            // InternalFirstOrderLogic.g:3863:2: rule__IsValueLiteralOf__Group__3__Impl rule__IsValueLiteralOf__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:3870:1: rule__IsValueLiteralOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IsValueLiteralOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3874:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:3875:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:3875:1: ( ',' )
            // InternalFirstOrderLogic.g:3876:2: ','
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3885:1: rule__IsValueLiteralOf__Group__4 : rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5 ;
    public final void rule__IsValueLiteralOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3889:1: ( rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5 )
            // InternalFirstOrderLogic.g:3890:2: rule__IsValueLiteralOf__Group__4__Impl rule__IsValueLiteralOf__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:3897:1: rule__IsValueLiteralOf__Group__4__Impl : ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) ) ;
    public final void rule__IsValueLiteralOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3901:1: ( ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:3902:1: ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:3902:1: ( ( rule__IsValueLiteralOf__TypeAssignment_4 ) )
            // InternalFirstOrderLogic.g:3903:2: ( rule__IsValueLiteralOf__TypeAssignment_4 )
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTypeAssignment_4()); 
            // InternalFirstOrderLogic.g:3904:2: ( rule__IsValueLiteralOf__TypeAssignment_4 )
            // InternalFirstOrderLogic.g:3904:3: rule__IsValueLiteralOf__TypeAssignment_4
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
    // InternalFirstOrderLogic.g:3912:1: rule__IsValueLiteralOf__Group__5 : rule__IsValueLiteralOf__Group__5__Impl ;
    public final void rule__IsValueLiteralOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3916:1: ( rule__IsValueLiteralOf__Group__5__Impl )
            // InternalFirstOrderLogic.g:3917:2: rule__IsValueLiteralOf__Group__5__Impl
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
    // InternalFirstOrderLogic.g:3923:1: rule__IsValueLiteralOf__Group__5__Impl : ( ')' ) ;
    public final void rule__IsValueLiteralOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3927:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:3928:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:3928:1: ( ')' )
            // InternalFirstOrderLogic.g:3929:2: ')'
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3939:1: rule__ForAll__Group__0 : rule__ForAll__Group__0__Impl rule__ForAll__Group__1 ;
    public final void rule__ForAll__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3943:1: ( rule__ForAll__Group__0__Impl rule__ForAll__Group__1 )
            // InternalFirstOrderLogic.g:3944:2: rule__ForAll__Group__0__Impl rule__ForAll__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalFirstOrderLogic.g:3951:1: rule__ForAll__Group__0__Impl : ( () ) ;
    public final void rule__ForAll__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3955:1: ( ( () ) )
            // InternalFirstOrderLogic.g:3956:1: ( () )
            {
            // InternalFirstOrderLogic.g:3956:1: ( () )
            // InternalFirstOrderLogic.g:3957:2: ()
            {
             before(grammarAccess.getForAllAccess().getForAllAction_0()); 
            // InternalFirstOrderLogic.g:3958:2: ()
            // InternalFirstOrderLogic.g:3958:3: 
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
    // InternalFirstOrderLogic.g:3966:1: rule__ForAll__Group__1 : rule__ForAll__Group__1__Impl rule__ForAll__Group__2 ;
    public final void rule__ForAll__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3970:1: ( rule__ForAll__Group__1__Impl rule__ForAll__Group__2 )
            // InternalFirstOrderLogic.g:3971:2: rule__ForAll__Group__1__Impl rule__ForAll__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:3978:1: rule__ForAll__Group__1__Impl : ( 'forAll' ) ;
    public final void rule__ForAll__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3982:1: ( ( 'forAll' ) )
            // InternalFirstOrderLogic.g:3983:1: ( 'forAll' )
            {
            // InternalFirstOrderLogic.g:3983:1: ( 'forAll' )
            // InternalFirstOrderLogic.g:3984:2: 'forAll'
            {
             before(grammarAccess.getForAllAccess().getForAllKeyword_1()); 
            match(input,37,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:3993:1: rule__ForAll__Group__2 : rule__ForAll__Group__2__Impl rule__ForAll__Group__3 ;
    public final void rule__ForAll__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:3997:1: ( rule__ForAll__Group__2__Impl rule__ForAll__Group__3 )
            // InternalFirstOrderLogic.g:3998:2: rule__ForAll__Group__2__Impl rule__ForAll__Group__3
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
    // InternalFirstOrderLogic.g:4005:1: rule__ForAll__Group__2__Impl : ( '(' ) ;
    public final void rule__ForAll__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4009:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4010:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4010:1: ( '(' )
            // InternalFirstOrderLogic.g:4011:2: '('
            {
             before(grammarAccess.getForAllAccess().getLeftParenthesisKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4020:1: rule__ForAll__Group__3 : rule__ForAll__Group__3__Impl rule__ForAll__Group__4 ;
    public final void rule__ForAll__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4024:1: ( rule__ForAll__Group__3__Impl rule__ForAll__Group__4 )
            // InternalFirstOrderLogic.g:4025:2: rule__ForAll__Group__3__Impl rule__ForAll__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalFirstOrderLogic.g:4032:1: rule__ForAll__Group__3__Impl : ( ( rule__ForAll__NameAssignment_3 ) ) ;
    public final void rule__ForAll__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4036:1: ( ( ( rule__ForAll__NameAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4037:1: ( ( rule__ForAll__NameAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4037:1: ( ( rule__ForAll__NameAssignment_3 ) )
            // InternalFirstOrderLogic.g:4038:2: ( rule__ForAll__NameAssignment_3 )
            {
             before(grammarAccess.getForAllAccess().getNameAssignment_3()); 
            // InternalFirstOrderLogic.g:4039:2: ( rule__ForAll__NameAssignment_3 )
            // InternalFirstOrderLogic.g:4039:3: rule__ForAll__NameAssignment_3
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
    // InternalFirstOrderLogic.g:4047:1: rule__ForAll__Group__4 : rule__ForAll__Group__4__Impl rule__ForAll__Group__5 ;
    public final void rule__ForAll__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4051:1: ( rule__ForAll__Group__4__Impl rule__ForAll__Group__5 )
            // InternalFirstOrderLogic.g:4052:2: rule__ForAll__Group__4__Impl rule__ForAll__Group__5
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:4059:1: rule__ForAll__Group__4__Impl : ( 'in' ) ;
    public final void rule__ForAll__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4063:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:4064:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:4064:1: ( 'in' )
            // InternalFirstOrderLogic.g:4065:2: 'in'
            {
             before(grammarAccess.getForAllAccess().getInKeyword_4()); 
            match(input,38,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4074:1: rule__ForAll__Group__5 : rule__ForAll__Group__5__Impl rule__ForAll__Group__6 ;
    public final void rule__ForAll__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4078:1: ( rule__ForAll__Group__5__Impl rule__ForAll__Group__6 )
            // InternalFirstOrderLogic.g:4079:2: rule__ForAll__Group__5__Impl rule__ForAll__Group__6
            {
            pushFollow(FOLLOW_30);
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
    // InternalFirstOrderLogic.g:4086:1: rule__ForAll__Group__5__Impl : ( ( rule__ForAll__IterationAssignment_5 ) ) ;
    public final void rule__ForAll__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4090:1: ( ( ( rule__ForAll__IterationAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:4091:1: ( ( rule__ForAll__IterationAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:4091:1: ( ( rule__ForAll__IterationAssignment_5 ) )
            // InternalFirstOrderLogic.g:4092:2: ( rule__ForAll__IterationAssignment_5 )
            {
             before(grammarAccess.getForAllAccess().getIterationAssignment_5()); 
            // InternalFirstOrderLogic.g:4093:2: ( rule__ForAll__IterationAssignment_5 )
            // InternalFirstOrderLogic.g:4093:3: rule__ForAll__IterationAssignment_5
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
    // InternalFirstOrderLogic.g:4101:1: rule__ForAll__Group__6 : rule__ForAll__Group__6__Impl rule__ForAll__Group__7 ;
    public final void rule__ForAll__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4105:1: ( rule__ForAll__Group__6__Impl rule__ForAll__Group__7 )
            // InternalFirstOrderLogic.g:4106:2: rule__ForAll__Group__6__Impl rule__ForAll__Group__7
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
    // InternalFirstOrderLogic.g:4113:1: rule__ForAll__Group__6__Impl : ( ':' ) ;
    public final void rule__ForAll__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4117:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:4118:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:4118:1: ( ':' )
            // InternalFirstOrderLogic.g:4119:2: ':'
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
    // InternalFirstOrderLogic.g:4128:1: rule__ForAll__Group__7 : rule__ForAll__Group__7__Impl rule__ForAll__Group__8 ;
    public final void rule__ForAll__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4132:1: ( rule__ForAll__Group__7__Impl rule__ForAll__Group__8 )
            // InternalFirstOrderLogic.g:4133:2: rule__ForAll__Group__7__Impl rule__ForAll__Group__8
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:4140:1: rule__ForAll__Group__7__Impl : ( ( rule__ForAll__FormulaAssignment_7 ) ) ;
    public final void rule__ForAll__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4144:1: ( ( ( rule__ForAll__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:4145:1: ( ( rule__ForAll__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:4145:1: ( ( rule__ForAll__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:4146:2: ( rule__ForAll__FormulaAssignment_7 )
            {
             before(grammarAccess.getForAllAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:4147:2: ( rule__ForAll__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:4147:3: rule__ForAll__FormulaAssignment_7
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
    // InternalFirstOrderLogic.g:4155:1: rule__ForAll__Group__8 : rule__ForAll__Group__8__Impl ;
    public final void rule__ForAll__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4159:1: ( rule__ForAll__Group__8__Impl )
            // InternalFirstOrderLogic.g:4160:2: rule__ForAll__Group__8__Impl
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
    // InternalFirstOrderLogic.g:4166:1: rule__ForAll__Group__8__Impl : ( ')' ) ;
    public final void rule__ForAll__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4170:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4171:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4171:1: ( ')' )
            // InternalFirstOrderLogic.g:4172:2: ')'
            {
             before(grammarAccess.getForAllAccess().getRightParenthesisKeyword_8()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4182:1: rule__Exists__Group__0 : rule__Exists__Group__0__Impl rule__Exists__Group__1 ;
    public final void rule__Exists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4186:1: ( rule__Exists__Group__0__Impl rule__Exists__Group__1 )
            // InternalFirstOrderLogic.g:4187:2: rule__Exists__Group__0__Impl rule__Exists__Group__1
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
    // InternalFirstOrderLogic.g:4194:1: rule__Exists__Group__0__Impl : ( () ) ;
    public final void rule__Exists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4198:1: ( ( () ) )
            // InternalFirstOrderLogic.g:4199:1: ( () )
            {
            // InternalFirstOrderLogic.g:4199:1: ( () )
            // InternalFirstOrderLogic.g:4200:2: ()
            {
             before(grammarAccess.getExistsAccess().getExistsAction_0()); 
            // InternalFirstOrderLogic.g:4201:2: ()
            // InternalFirstOrderLogic.g:4201:3: 
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
    // InternalFirstOrderLogic.g:4209:1: rule__Exists__Group__1 : rule__Exists__Group__1__Impl rule__Exists__Group__2 ;
    public final void rule__Exists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4213:1: ( rule__Exists__Group__1__Impl rule__Exists__Group__2 )
            // InternalFirstOrderLogic.g:4214:2: rule__Exists__Group__1__Impl rule__Exists__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:4221:1: rule__Exists__Group__1__Impl : ( 'exists' ) ;
    public final void rule__Exists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4225:1: ( ( 'exists' ) )
            // InternalFirstOrderLogic.g:4226:1: ( 'exists' )
            {
            // InternalFirstOrderLogic.g:4226:1: ( 'exists' )
            // InternalFirstOrderLogic.g:4227:2: 'exists'
            {
             before(grammarAccess.getExistsAccess().getExistsKeyword_1()); 
            match(input,39,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4236:1: rule__Exists__Group__2 : rule__Exists__Group__2__Impl rule__Exists__Group__3 ;
    public final void rule__Exists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4240:1: ( rule__Exists__Group__2__Impl rule__Exists__Group__3 )
            // InternalFirstOrderLogic.g:4241:2: rule__Exists__Group__2__Impl rule__Exists__Group__3
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
    // InternalFirstOrderLogic.g:4248:1: rule__Exists__Group__2__Impl : ( '(' ) ;
    public final void rule__Exists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4252:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4253:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4253:1: ( '(' )
            // InternalFirstOrderLogic.g:4254:2: '('
            {
             before(grammarAccess.getExistsAccess().getLeftParenthesisKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4263:1: rule__Exists__Group__3 : rule__Exists__Group__3__Impl rule__Exists__Group__4 ;
    public final void rule__Exists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4267:1: ( rule__Exists__Group__3__Impl rule__Exists__Group__4 )
            // InternalFirstOrderLogic.g:4268:2: rule__Exists__Group__3__Impl rule__Exists__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalFirstOrderLogic.g:4275:1: rule__Exists__Group__3__Impl : ( ( rule__Exists__NameAssignment_3 ) ) ;
    public final void rule__Exists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4279:1: ( ( ( rule__Exists__NameAssignment_3 ) ) )
            // InternalFirstOrderLogic.g:4280:1: ( ( rule__Exists__NameAssignment_3 ) )
            {
            // InternalFirstOrderLogic.g:4280:1: ( ( rule__Exists__NameAssignment_3 ) )
            // InternalFirstOrderLogic.g:4281:2: ( rule__Exists__NameAssignment_3 )
            {
             before(grammarAccess.getExistsAccess().getNameAssignment_3()); 
            // InternalFirstOrderLogic.g:4282:2: ( rule__Exists__NameAssignment_3 )
            // InternalFirstOrderLogic.g:4282:3: rule__Exists__NameAssignment_3
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
    // InternalFirstOrderLogic.g:4290:1: rule__Exists__Group__4 : rule__Exists__Group__4__Impl rule__Exists__Group__5 ;
    public final void rule__Exists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4294:1: ( rule__Exists__Group__4__Impl rule__Exists__Group__5 )
            // InternalFirstOrderLogic.g:4295:2: rule__Exists__Group__4__Impl rule__Exists__Group__5
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:4302:1: rule__Exists__Group__4__Impl : ( 'in' ) ;
    public final void rule__Exists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4306:1: ( ( 'in' ) )
            // InternalFirstOrderLogic.g:4307:1: ( 'in' )
            {
            // InternalFirstOrderLogic.g:4307:1: ( 'in' )
            // InternalFirstOrderLogic.g:4308:2: 'in'
            {
             before(grammarAccess.getExistsAccess().getInKeyword_4()); 
            match(input,38,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4317:1: rule__Exists__Group__5 : rule__Exists__Group__5__Impl rule__Exists__Group__6 ;
    public final void rule__Exists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4321:1: ( rule__Exists__Group__5__Impl rule__Exists__Group__6 )
            // InternalFirstOrderLogic.g:4322:2: rule__Exists__Group__5__Impl rule__Exists__Group__6
            {
            pushFollow(FOLLOW_30);
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
    // InternalFirstOrderLogic.g:4329:1: rule__Exists__Group__5__Impl : ( ( rule__Exists__IterationAssignment_5 ) ) ;
    public final void rule__Exists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4333:1: ( ( ( rule__Exists__IterationAssignment_5 ) ) )
            // InternalFirstOrderLogic.g:4334:1: ( ( rule__Exists__IterationAssignment_5 ) )
            {
            // InternalFirstOrderLogic.g:4334:1: ( ( rule__Exists__IterationAssignment_5 ) )
            // InternalFirstOrderLogic.g:4335:2: ( rule__Exists__IterationAssignment_5 )
            {
             before(grammarAccess.getExistsAccess().getIterationAssignment_5()); 
            // InternalFirstOrderLogic.g:4336:2: ( rule__Exists__IterationAssignment_5 )
            // InternalFirstOrderLogic.g:4336:3: rule__Exists__IterationAssignment_5
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
    // InternalFirstOrderLogic.g:4344:1: rule__Exists__Group__6 : rule__Exists__Group__6__Impl rule__Exists__Group__7 ;
    public final void rule__Exists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4348:1: ( rule__Exists__Group__6__Impl rule__Exists__Group__7 )
            // InternalFirstOrderLogic.g:4349:2: rule__Exists__Group__6__Impl rule__Exists__Group__7
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
    // InternalFirstOrderLogic.g:4356:1: rule__Exists__Group__6__Impl : ( ':' ) ;
    public final void rule__Exists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4360:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:4361:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:4361:1: ( ':' )
            // InternalFirstOrderLogic.g:4362:2: ':'
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
    // InternalFirstOrderLogic.g:4371:1: rule__Exists__Group__7 : rule__Exists__Group__7__Impl rule__Exists__Group__8 ;
    public final void rule__Exists__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4375:1: ( rule__Exists__Group__7__Impl rule__Exists__Group__8 )
            // InternalFirstOrderLogic.g:4376:2: rule__Exists__Group__7__Impl rule__Exists__Group__8
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:4383:1: rule__Exists__Group__7__Impl : ( ( rule__Exists__FormulaAssignment_7 ) ) ;
    public final void rule__Exists__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4387:1: ( ( ( rule__Exists__FormulaAssignment_7 ) ) )
            // InternalFirstOrderLogic.g:4388:1: ( ( rule__Exists__FormulaAssignment_7 ) )
            {
            // InternalFirstOrderLogic.g:4388:1: ( ( rule__Exists__FormulaAssignment_7 ) )
            // InternalFirstOrderLogic.g:4389:2: ( rule__Exists__FormulaAssignment_7 )
            {
             before(grammarAccess.getExistsAccess().getFormulaAssignment_7()); 
            // InternalFirstOrderLogic.g:4390:2: ( rule__Exists__FormulaAssignment_7 )
            // InternalFirstOrderLogic.g:4390:3: rule__Exists__FormulaAssignment_7
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
    // InternalFirstOrderLogic.g:4398:1: rule__Exists__Group__8 : rule__Exists__Group__8__Impl ;
    public final void rule__Exists__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4402:1: ( rule__Exists__Group__8__Impl )
            // InternalFirstOrderLogic.g:4403:2: rule__Exists__Group__8__Impl
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
    // InternalFirstOrderLogic.g:4409:1: rule__Exists__Group__8__Impl : ( ')' ) ;
    public final void rule__Exists__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4413:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4414:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4414:1: ( ')' )
            // InternalFirstOrderLogic.g:4415:2: ')'
            {
             before(grammarAccess.getExistsAccess().getRightParenthesisKeyword_8()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4425:1: rule__BooleanExpression__Group_0__0 : rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 ;
    public final void rule__BooleanExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4429:1: ( rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1 )
            // InternalFirstOrderLogic.g:4430:2: rule__BooleanExpression__Group_0__0__Impl rule__BooleanExpression__Group_0__1
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
    // InternalFirstOrderLogic.g:4437:1: rule__BooleanExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BooleanExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4441:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4442:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4442:1: ( '(' )
            // InternalFirstOrderLogic.g:4443:2: '('
            {
             before(grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4452:1: rule__BooleanExpression__Group_0__1 : rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 ;
    public final void rule__BooleanExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4456:1: ( rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2 )
            // InternalFirstOrderLogic.g:4457:2: rule__BooleanExpression__Group_0__1__Impl rule__BooleanExpression__Group_0__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:4464:1: rule__BooleanExpression__Group_0__1__Impl : ( ruleFormula ) ;
    public final void rule__BooleanExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4468:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:4469:1: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:4469:1: ( ruleFormula )
            // InternalFirstOrderLogic.g:4470:2: ruleFormula
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
    // InternalFirstOrderLogic.g:4479:1: rule__BooleanExpression__Group_0__2 : rule__BooleanExpression__Group_0__2__Impl ;
    public final void rule__BooleanExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4483:1: ( rule__BooleanExpression__Group_0__2__Impl )
            // InternalFirstOrderLogic.g:4484:2: rule__BooleanExpression__Group_0__2__Impl
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
    // InternalFirstOrderLogic.g:4490:1: rule__BooleanExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BooleanExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4494:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4495:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4495:1: ( ')' )
            // InternalFirstOrderLogic.g:4496:2: ')'
            {
             before(grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,27,FOLLOW_2); 
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


    // $ANTLR start "rule__ReferenceBase__Group__0"
    // InternalFirstOrderLogic.g:4506:1: rule__ReferenceBase__Group__0 : rule__ReferenceBase__Group__0__Impl rule__ReferenceBase__Group__1 ;
    public final void rule__ReferenceBase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4510:1: ( rule__ReferenceBase__Group__0__Impl rule__ReferenceBase__Group__1 )
            // InternalFirstOrderLogic.g:4511:2: rule__ReferenceBase__Group__0__Impl rule__ReferenceBase__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__ReferenceBase__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ReferenceBase__Group__1();

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
    // $ANTLR end "rule__ReferenceBase__Group__0"


    // $ANTLR start "rule__ReferenceBase__Group__0__Impl"
    // InternalFirstOrderLogic.g:4518:1: rule__ReferenceBase__Group__0__Impl : ( ( rule__ReferenceBase__Alternatives_0 ) ) ;
    public final void rule__ReferenceBase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4522:1: ( ( ( rule__ReferenceBase__Alternatives_0 ) ) )
            // InternalFirstOrderLogic.g:4523:1: ( ( rule__ReferenceBase__Alternatives_0 ) )
            {
            // InternalFirstOrderLogic.g:4523:1: ( ( rule__ReferenceBase__Alternatives_0 ) )
            // InternalFirstOrderLogic.g:4524:2: ( rule__ReferenceBase__Alternatives_0 )
            {
             before(grammarAccess.getReferenceBaseAccess().getAlternatives_0()); 
            // InternalFirstOrderLogic.g:4525:2: ( rule__ReferenceBase__Alternatives_0 )
            // InternalFirstOrderLogic.g:4525:3: rule__ReferenceBase__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceBase__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceBaseAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceBase__Group__0__Impl"


    // $ANTLR start "rule__ReferenceBase__Group__1"
    // InternalFirstOrderLogic.g:4533:1: rule__ReferenceBase__Group__1 : rule__ReferenceBase__Group__1__Impl ;
    public final void rule__ReferenceBase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4537:1: ( rule__ReferenceBase__Group__1__Impl )
            // InternalFirstOrderLogic.g:4538:2: rule__ReferenceBase__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ReferenceBase__Group__1__Impl();

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
    // $ANTLR end "rule__ReferenceBase__Group__1"


    // $ANTLR start "rule__ReferenceBase__Group__1__Impl"
    // InternalFirstOrderLogic.g:4544:1: rule__ReferenceBase__Group__1__Impl : ( ( rule__ReferenceBase__GetAssignment_1 )? ) ;
    public final void rule__ReferenceBase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4548:1: ( ( ( rule__ReferenceBase__GetAssignment_1 )? ) )
            // InternalFirstOrderLogic.g:4549:1: ( ( rule__ReferenceBase__GetAssignment_1 )? )
            {
            // InternalFirstOrderLogic.g:4549:1: ( ( rule__ReferenceBase__GetAssignment_1 )? )
            // InternalFirstOrderLogic.g:4550:2: ( rule__ReferenceBase__GetAssignment_1 )?
            {
             before(grammarAccess.getReferenceBaseAccess().getGetAssignment_1()); 
            // InternalFirstOrderLogic.g:4551:2: ( rule__ReferenceBase__GetAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==41) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:4551:3: rule__ReferenceBase__GetAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ReferenceBase__GetAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceBaseAccess().getGetAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceBase__Group__1__Impl"


    // $ANTLR start "rule__Select__Group__0"
    // InternalFirstOrderLogic.g:4560:1: rule__Select__Group__0 : rule__Select__Group__0__Impl rule__Select__Group__1 ;
    public final void rule__Select__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4564:1: ( rule__Select__Group__0__Impl rule__Select__Group__1 )
            // InternalFirstOrderLogic.g:4565:2: rule__Select__Group__0__Impl rule__Select__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:4572:1: rule__Select__Group__0__Impl : ( 'select' ) ;
    public final void rule__Select__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4576:1: ( ( 'select' ) )
            // InternalFirstOrderLogic.g:4577:1: ( 'select' )
            {
            // InternalFirstOrderLogic.g:4577:1: ( 'select' )
            // InternalFirstOrderLogic.g:4578:2: 'select'
            {
             before(grammarAccess.getSelectAccess().getSelectKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getSelectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__Group__0__Impl"


    // $ANTLR start "rule__Select__Group__1"
    // InternalFirstOrderLogic.g:4587:1: rule__Select__Group__1 : rule__Select__Group__1__Impl rule__Select__Group__2 ;
    public final void rule__Select__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4591:1: ( rule__Select__Group__1__Impl rule__Select__Group__2 )
            // InternalFirstOrderLogic.g:4592:2: rule__Select__Group__1__Impl rule__Select__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:4599:1: rule__Select__Group__1__Impl : ( '(' ) ;
    public final void rule__Select__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4603:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4604:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4604:1: ( '(' )
            // InternalFirstOrderLogic.g:4605:2: '('
            {
             before(grammarAccess.getSelectAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4614:1: rule__Select__Group__2 : rule__Select__Group__2__Impl rule__Select__Group__3 ;
    public final void rule__Select__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4618:1: ( rule__Select__Group__2__Impl rule__Select__Group__3 )
            // InternalFirstOrderLogic.g:4619:2: rule__Select__Group__2__Impl rule__Select__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:4626:1: rule__Select__Group__2__Impl : ( ( rule__Select__IterationAssignment_2 ) ) ;
    public final void rule__Select__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4630:1: ( ( ( rule__Select__IterationAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:4631:1: ( ( rule__Select__IterationAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:4631:1: ( ( rule__Select__IterationAssignment_2 ) )
            // InternalFirstOrderLogic.g:4632:2: ( rule__Select__IterationAssignment_2 )
            {
             before(grammarAccess.getSelectAccess().getIterationAssignment_2()); 
            // InternalFirstOrderLogic.g:4633:2: ( rule__Select__IterationAssignment_2 )
            // InternalFirstOrderLogic.g:4633:3: rule__Select__IterationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Select__IterationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getIterationAssignment_2()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4641:1: rule__Select__Group__3 : rule__Select__Group__3__Impl rule__Select__Group__4 ;
    public final void rule__Select__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4645:1: ( rule__Select__Group__3__Impl rule__Select__Group__4 )
            // InternalFirstOrderLogic.g:4646:2: rule__Select__Group__3__Impl rule__Select__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalFirstOrderLogic.g:4653:1: rule__Select__Group__3__Impl : ( ',' ) ;
    public final void rule__Select__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4657:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:4658:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:4658:1: ( ',' )
            // InternalFirstOrderLogic.g:4659:2: ','
            {
             before(grammarAccess.getSelectAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getCommaKeyword_3()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4668:1: rule__Select__Group__4 : rule__Select__Group__4__Impl rule__Select__Group__5 ;
    public final void rule__Select__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4672:1: ( rule__Select__Group__4__Impl rule__Select__Group__5 )
            // InternalFirstOrderLogic.g:4673:2: rule__Select__Group__4__Impl rule__Select__Group__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalFirstOrderLogic.g:4680:1: rule__Select__Group__4__Impl : ( ( rule__Select__NameAssignment_4 ) ) ;
    public final void rule__Select__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4684:1: ( ( ( rule__Select__NameAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:4685:1: ( ( rule__Select__NameAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:4685:1: ( ( rule__Select__NameAssignment_4 ) )
            // InternalFirstOrderLogic.g:4686:2: ( rule__Select__NameAssignment_4 )
            {
             before(grammarAccess.getSelectAccess().getNameAssignment_4()); 
            // InternalFirstOrderLogic.g:4687:2: ( rule__Select__NameAssignment_4 )
            // InternalFirstOrderLogic.g:4687:3: rule__Select__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Select__NameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getNameAssignment_4()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4695:1: rule__Select__Group__5 : rule__Select__Group__5__Impl rule__Select__Group__6 ;
    public final void rule__Select__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4699:1: ( rule__Select__Group__5__Impl rule__Select__Group__6 )
            // InternalFirstOrderLogic.g:4700:2: rule__Select__Group__5__Impl rule__Select__Group__6
            {
            pushFollow(FOLLOW_11);
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
    // InternalFirstOrderLogic.g:4707:1: rule__Select__Group__5__Impl : ( ':' ) ;
    public final void rule__Select__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4711:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:4712:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:4712:1: ( ':' )
            // InternalFirstOrderLogic.g:4713:2: ':'
            {
             before(grammarAccess.getSelectAccess().getColonKeyword_5()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getColonKeyword_5()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4722:1: rule__Select__Group__6 : rule__Select__Group__6__Impl rule__Select__Group__7 ;
    public final void rule__Select__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4726:1: ( rule__Select__Group__6__Impl rule__Select__Group__7 )
            // InternalFirstOrderLogic.g:4727:2: rule__Select__Group__6__Impl rule__Select__Group__7
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:4734:1: rule__Select__Group__6__Impl : ( ( rule__Select__FormulaAssignment_6 ) ) ;
    public final void rule__Select__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4738:1: ( ( ( rule__Select__FormulaAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:4739:1: ( ( rule__Select__FormulaAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:4739:1: ( ( rule__Select__FormulaAssignment_6 ) )
            // InternalFirstOrderLogic.g:4740:2: ( rule__Select__FormulaAssignment_6 )
            {
             before(grammarAccess.getSelectAccess().getFormulaAssignment_6()); 
            // InternalFirstOrderLogic.g:4741:2: ( rule__Select__FormulaAssignment_6 )
            // InternalFirstOrderLogic.g:4741:3: rule__Select__FormulaAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Select__FormulaAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getSelectAccess().getFormulaAssignment_6()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:4749:1: rule__Select__Group__7 : rule__Select__Group__7__Impl ;
    public final void rule__Select__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4753:1: ( rule__Select__Group__7__Impl )
            // InternalFirstOrderLogic.g:4754:2: rule__Select__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Select__Group__7__Impl();

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
    // InternalFirstOrderLogic.g:4760:1: rule__Select__Group__7__Impl : ( ')' ) ;
    public final void rule__Select__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4764:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:4765:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:4765:1: ( ')' )
            // InternalFirstOrderLogic.g:4766:2: ')'
            {
             before(grammarAccess.getSelectAccess().getRightParenthesisKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSelectAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
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


    // $ANTLR start "rule__Get__Group__0"
    // InternalFirstOrderLogic.g:4776:1: rule__Get__Group__0 : rule__Get__Group__0__Impl rule__Get__Group__1 ;
    public final void rule__Get__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4780:1: ( rule__Get__Group__0__Impl rule__Get__Group__1 )
            // InternalFirstOrderLogic.g:4781:2: rule__Get__Group__0__Impl rule__Get__Group__1
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
    // InternalFirstOrderLogic.g:4788:1: rule__Get__Group__0__Impl : ( '.' ) ;
    public final void rule__Get__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4792:1: ( ( '.' ) )
            // InternalFirstOrderLogic.g:4793:1: ( '.' )
            {
            // InternalFirstOrderLogic.g:4793:1: ( '.' )
            // InternalFirstOrderLogic.g:4794:2: '.'
            {
             before(grammarAccess.getGetAccess().getFullStopKeyword_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4803:1: rule__Get__Group__1 : rule__Get__Group__1__Impl rule__Get__Group__2 ;
    public final void rule__Get__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4807:1: ( rule__Get__Group__1__Impl rule__Get__Group__2 )
            // InternalFirstOrderLogic.g:4808:2: rule__Get__Group__1__Impl rule__Get__Group__2
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
    // InternalFirstOrderLogic.g:4815:1: rule__Get__Group__1__Impl : ( ( rule__Get__Group_1__0 )? ) ;
    public final void rule__Get__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4819:1: ( ( ( rule__Get__Group_1__0 )? ) )
            // InternalFirstOrderLogic.g:4820:1: ( ( rule__Get__Group_1__0 )? )
            {
            // InternalFirstOrderLogic.g:4820:1: ( ( rule__Get__Group_1__0 )? )
            // InternalFirstOrderLogic.g:4821:2: ( rule__Get__Group_1__0 )?
            {
             before(grammarAccess.getGetAccess().getGroup_1()); 
            // InternalFirstOrderLogic.g:4822:2: ( rule__Get__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==42) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalFirstOrderLogic.g:4822:3: rule__Get__Group_1__0
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
    // InternalFirstOrderLogic.g:4830:1: rule__Get__Group__2 : rule__Get__Group__2__Impl rule__Get__Group__3 ;
    public final void rule__Get__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4834:1: ( rule__Get__Group__2__Impl rule__Get__Group__3 )
            // InternalFirstOrderLogic.g:4835:2: rule__Get__Group__2__Impl rule__Get__Group__3
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
    // InternalFirstOrderLogic.g:4842:1: rule__Get__Group__2__Impl : ( ( rule__Get__NameAssignment_2 ) ) ;
    public final void rule__Get__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4846:1: ( ( ( rule__Get__NameAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:4847:1: ( ( rule__Get__NameAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:4847:1: ( ( rule__Get__NameAssignment_2 ) )
            // InternalFirstOrderLogic.g:4848:2: ( rule__Get__NameAssignment_2 )
            {
             before(grammarAccess.getGetAccess().getNameAssignment_2()); 
            // InternalFirstOrderLogic.g:4849:2: ( rule__Get__NameAssignment_2 )
            // InternalFirstOrderLogic.g:4849:3: rule__Get__NameAssignment_2
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
    // InternalFirstOrderLogic.g:4857:1: rule__Get__Group__3 : rule__Get__Group__3__Impl ;
    public final void rule__Get__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4861:1: ( rule__Get__Group__3__Impl )
            // InternalFirstOrderLogic.g:4862:2: rule__Get__Group__3__Impl
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
    // InternalFirstOrderLogic.g:4868:1: rule__Get__Group__3__Impl : ( ( rule__Get__NextAssignment_3 )? ) ;
    public final void rule__Get__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4872:1: ( ( ( rule__Get__NextAssignment_3 )? ) )
            // InternalFirstOrderLogic.g:4873:1: ( ( rule__Get__NextAssignment_3 )? )
            {
            // InternalFirstOrderLogic.g:4873:1: ( ( rule__Get__NextAssignment_3 )? )
            // InternalFirstOrderLogic.g:4874:2: ( rule__Get__NextAssignment_3 )?
            {
             before(grammarAccess.getGetAccess().getNextAssignment_3()); 
            // InternalFirstOrderLogic.g:4875:2: ( rule__Get__NextAssignment_3 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalFirstOrderLogic.g:4875:3: rule__Get__NextAssignment_3
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
    // InternalFirstOrderLogic.g:4884:1: rule__Get__Group_1__0 : rule__Get__Group_1__0__Impl rule__Get__Group_1__1 ;
    public final void rule__Get__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4888:1: ( rule__Get__Group_1__0__Impl rule__Get__Group_1__1 )
            // InternalFirstOrderLogic.g:4889:2: rule__Get__Group_1__0__Impl rule__Get__Group_1__1
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
    // InternalFirstOrderLogic.g:4896:1: rule__Get__Group_1__0__Impl : ( ( rule__Get__TypeAssignment_1_0 ) ) ;
    public final void rule__Get__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4900:1: ( ( ( rule__Get__TypeAssignment_1_0 ) ) )
            // InternalFirstOrderLogic.g:4901:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            {
            // InternalFirstOrderLogic.g:4901:1: ( ( rule__Get__TypeAssignment_1_0 ) )
            // InternalFirstOrderLogic.g:4902:2: ( rule__Get__TypeAssignment_1_0 )
            {
             before(grammarAccess.getGetAccess().getTypeAssignment_1_0()); 
            // InternalFirstOrderLogic.g:4903:2: ( rule__Get__TypeAssignment_1_0 )
            // InternalFirstOrderLogic.g:4903:3: rule__Get__TypeAssignment_1_0
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
    // InternalFirstOrderLogic.g:4911:1: rule__Get__Group_1__1 : rule__Get__Group_1__1__Impl ;
    public final void rule__Get__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4915:1: ( rule__Get__Group_1__1__Impl )
            // InternalFirstOrderLogic.g:4916:2: rule__Get__Group_1__1__Impl
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
    // InternalFirstOrderLogic.g:4922:1: rule__Get__Group_1__1__Impl : ( '::' ) ;
    public final void rule__Get__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4926:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:4927:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:4927:1: ( '::' )
            // InternalFirstOrderLogic.g:4928:2: '::'
            {
             before(grammarAccess.getGetAccess().getColonColonKeyword_1_1()); 
            match(input,42,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4938:1: rule__GetContainer__Group__0 : rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 ;
    public final void rule__GetContainer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4942:1: ( rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1 )
            // InternalFirstOrderLogic.g:4943:2: rule__GetContainer__Group__0__Impl rule__GetContainer__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:4950:1: rule__GetContainer__Group__0__Impl : ( 'getContainer' ) ;
    public final void rule__GetContainer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4954:1: ( ( 'getContainer' ) )
            // InternalFirstOrderLogic.g:4955:1: ( 'getContainer' )
            {
            // InternalFirstOrderLogic.g:4955:1: ( 'getContainer' )
            // InternalFirstOrderLogic.g:4956:2: 'getContainer'
            {
             before(grammarAccess.getGetContainerAccess().getGetContainerKeyword_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4965:1: rule__GetContainer__Group__1 : rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 ;
    public final void rule__GetContainer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4969:1: ( rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2 )
            // InternalFirstOrderLogic.g:4970:2: rule__GetContainer__Group__1__Impl rule__GetContainer__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:4977:1: rule__GetContainer__Group__1__Impl : ( '(' ) ;
    public final void rule__GetContainer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4981:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:4982:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:4982:1: ( '(' )
            // InternalFirstOrderLogic.g:4983:2: '('
            {
             before(grammarAccess.getGetContainerAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:4992:1: rule__GetContainer__Group__2 : rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3 ;
    public final void rule__GetContainer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:4996:1: ( rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3 )
            // InternalFirstOrderLogic.g:4997:2: rule__GetContainer__Group__2__Impl rule__GetContainer__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5004:1: rule__GetContainer__Group__2__Impl : ( ( rule__GetContainer__ElementAssignment_2 ) ) ;
    public final void rule__GetContainer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5008:1: ( ( ( rule__GetContainer__ElementAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5009:1: ( ( rule__GetContainer__ElementAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5009:1: ( ( rule__GetContainer__ElementAssignment_2 ) )
            // InternalFirstOrderLogic.g:5010:2: ( rule__GetContainer__ElementAssignment_2 )
            {
             before(grammarAccess.getGetContainerAccess().getElementAssignment_2()); 
            // InternalFirstOrderLogic.g:5011:2: ( rule__GetContainer__ElementAssignment_2 )
            // InternalFirstOrderLogic.g:5011:3: rule__GetContainer__ElementAssignment_2
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
    // InternalFirstOrderLogic.g:5019:1: rule__GetContainer__Group__3 : rule__GetContainer__Group__3__Impl ;
    public final void rule__GetContainer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5023:1: ( rule__GetContainer__Group__3__Impl )
            // InternalFirstOrderLogic.g:5024:2: rule__GetContainer__Group__3__Impl
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
    // InternalFirstOrderLogic.g:5030:1: rule__GetContainer__Group__3__Impl : ( ')' ) ;
    public final void rule__GetContainer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5034:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5035:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5035:1: ( ')' )
            // InternalFirstOrderLogic.g:5036:2: ')'
            {
             before(grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5046:1: rule__GetContainments__Group__0 : rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 ;
    public final void rule__GetContainments__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5050:1: ( rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1 )
            // InternalFirstOrderLogic.g:5051:2: rule__GetContainments__Group__0__Impl rule__GetContainments__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5058:1: rule__GetContainments__Group__0__Impl : ( 'getContainments' ) ;
    public final void rule__GetContainments__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5062:1: ( ( 'getContainments' ) )
            // InternalFirstOrderLogic.g:5063:1: ( 'getContainments' )
            {
            // InternalFirstOrderLogic.g:5063:1: ( 'getContainments' )
            // InternalFirstOrderLogic.g:5064:2: 'getContainments'
            {
             before(grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5073:1: rule__GetContainments__Group__1 : rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 ;
    public final void rule__GetContainments__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5077:1: ( rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2 )
            // InternalFirstOrderLogic.g:5078:2: rule__GetContainments__Group__1__Impl rule__GetContainments__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5085:1: rule__GetContainments__Group__1__Impl : ( '(' ) ;
    public final void rule__GetContainments__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5089:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5090:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5090:1: ( '(' )
            // InternalFirstOrderLogic.g:5091:2: '('
            {
             before(grammarAccess.getGetContainmentsAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5100:1: rule__GetContainments__Group__2 : rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3 ;
    public final void rule__GetContainments__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5104:1: ( rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3 )
            // InternalFirstOrderLogic.g:5105:2: rule__GetContainments__Group__2__Impl rule__GetContainments__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5112:1: rule__GetContainments__Group__2__Impl : ( ( rule__GetContainments__ElementAssignment_2 ) ) ;
    public final void rule__GetContainments__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5116:1: ( ( ( rule__GetContainments__ElementAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5117:1: ( ( rule__GetContainments__ElementAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5117:1: ( ( rule__GetContainments__ElementAssignment_2 ) )
            // InternalFirstOrderLogic.g:5118:2: ( rule__GetContainments__ElementAssignment_2 )
            {
             before(grammarAccess.getGetContainmentsAccess().getElementAssignment_2()); 
            // InternalFirstOrderLogic.g:5119:2: ( rule__GetContainments__ElementAssignment_2 )
            // InternalFirstOrderLogic.g:5119:3: rule__GetContainments__ElementAssignment_2
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
    // InternalFirstOrderLogic.g:5127:1: rule__GetContainments__Group__3 : rule__GetContainments__Group__3__Impl ;
    public final void rule__GetContainments__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5131:1: ( rule__GetContainments__Group__3__Impl )
            // InternalFirstOrderLogic.g:5132:2: rule__GetContainments__Group__3__Impl
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
    // InternalFirstOrderLogic.g:5138:1: rule__GetContainments__Group__3__Impl : ( ')' ) ;
    public final void rule__GetContainments__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5142:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5143:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5143:1: ( ')' )
            // InternalFirstOrderLogic.g:5144:2: ')'
            {
             before(grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5154:1: rule__GetClosure__Group__0 : rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 ;
    public final void rule__GetClosure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5158:1: ( rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1 )
            // InternalFirstOrderLogic.g:5159:2: rule__GetClosure__Group__0__Impl rule__GetClosure__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5166:1: rule__GetClosure__Group__0__Impl : ( 'getClosure' ) ;
    public final void rule__GetClosure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5170:1: ( ( 'getClosure' ) )
            // InternalFirstOrderLogic.g:5171:1: ( 'getClosure' )
            {
            // InternalFirstOrderLogic.g:5171:1: ( 'getClosure' )
            // InternalFirstOrderLogic.g:5172:2: 'getClosure'
            {
             before(grammarAccess.getGetClosureAccess().getGetClosureKeyword_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5181:1: rule__GetClosure__Group__1 : rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 ;
    public final void rule__GetClosure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5185:1: ( rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2 )
            // InternalFirstOrderLogic.g:5186:2: rule__GetClosure__Group__1__Impl rule__GetClosure__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5193:1: rule__GetClosure__Group__1__Impl : ( '(' ) ;
    public final void rule__GetClosure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5197:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5198:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5198:1: ( '(' )
            // InternalFirstOrderLogic.g:5199:2: '('
            {
             before(grammarAccess.getGetClosureAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5208:1: rule__GetClosure__Group__2 : rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 ;
    public final void rule__GetClosure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5212:1: ( rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3 )
            // InternalFirstOrderLogic.g:5213:2: rule__GetClosure__Group__2__Impl rule__GetClosure__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:5220:1: rule__GetClosure__Group__2__Impl : ( ( rule__GetClosure__InitialAssignment_2 ) ) ;
    public final void rule__GetClosure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5224:1: ( ( ( rule__GetClosure__InitialAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5225:1: ( ( rule__GetClosure__InitialAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5225:1: ( ( rule__GetClosure__InitialAssignment_2 ) )
            // InternalFirstOrderLogic.g:5226:2: ( rule__GetClosure__InitialAssignment_2 )
            {
             before(grammarAccess.getGetClosureAccess().getInitialAssignment_2()); 
            // InternalFirstOrderLogic.g:5227:2: ( rule__GetClosure__InitialAssignment_2 )
            // InternalFirstOrderLogic.g:5227:3: rule__GetClosure__InitialAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__InitialAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getInitialAssignment_2()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:5235:1: rule__GetClosure__Group__3 : rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 ;
    public final void rule__GetClosure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5239:1: ( rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4 )
            // InternalFirstOrderLogic.g:5240:2: rule__GetClosure__Group__3__Impl rule__GetClosure__Group__4
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
    // InternalFirstOrderLogic.g:5247:1: rule__GetClosure__Group__3__Impl : ( ',' ) ;
    public final void rule__GetClosure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5251:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5252:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5252:1: ( ',' )
            // InternalFirstOrderLogic.g:5253:2: ','
            {
             before(grammarAccess.getGetClosureAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5262:1: rule__GetClosure__Group__4 : rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5 ;
    public final void rule__GetClosure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5266:1: ( rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5 )
            // InternalFirstOrderLogic.g:5267:2: rule__GetClosure__Group__4__Impl rule__GetClosure__Group__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalFirstOrderLogic.g:5274:1: rule__GetClosure__Group__4__Impl : ( ( rule__GetClosure__VariableAssignment_4 ) ) ;
    public final void rule__GetClosure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5278:1: ( ( ( rule__GetClosure__VariableAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5279:1: ( ( rule__GetClosure__VariableAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5279:1: ( ( rule__GetClosure__VariableAssignment_4 ) )
            // InternalFirstOrderLogic.g:5280:2: ( rule__GetClosure__VariableAssignment_4 )
            {
             before(grammarAccess.getGetClosureAccess().getVariableAssignment_4()); 
            // InternalFirstOrderLogic.g:5281:2: ( rule__GetClosure__VariableAssignment_4 )
            // InternalFirstOrderLogic.g:5281:3: rule__GetClosure__VariableAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__VariableAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getVariableAssignment_4()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:5289:1: rule__GetClosure__Group__5 : rule__GetClosure__Group__5__Impl rule__GetClosure__Group__6 ;
    public final void rule__GetClosure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5293:1: ( rule__GetClosure__Group__5__Impl rule__GetClosure__Group__6 )
            // InternalFirstOrderLogic.g:5294:2: rule__GetClosure__Group__5__Impl rule__GetClosure__Group__6
            {
            pushFollow(FOLLOW_26);
            rule__GetClosure__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__6();

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
    // InternalFirstOrderLogic.g:5301:1: rule__GetClosure__Group__5__Impl : ( ':' ) ;
    public final void rule__GetClosure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5305:1: ( ( ':' ) )
            // InternalFirstOrderLogic.g:5306:1: ( ':' )
            {
            // InternalFirstOrderLogic.g:5306:1: ( ':' )
            // InternalFirstOrderLogic.g:5307:2: ':'
            {
             before(grammarAccess.getGetClosureAccess().getColonKeyword_5()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getColonKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__GetClosure__Group__6"
    // InternalFirstOrderLogic.g:5316:1: rule__GetClosure__Group__6 : rule__GetClosure__Group__6__Impl rule__GetClosure__Group__7 ;
    public final void rule__GetClosure__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5320:1: ( rule__GetClosure__Group__6__Impl rule__GetClosure__Group__7 )
            // InternalFirstOrderLogic.g:5321:2: rule__GetClosure__Group__6__Impl rule__GetClosure__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__GetClosure__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__7();

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
    // $ANTLR end "rule__GetClosure__Group__6"


    // $ANTLR start "rule__GetClosure__Group__6__Impl"
    // InternalFirstOrderLogic.g:5328:1: rule__GetClosure__Group__6__Impl : ( ( rule__GetClosure__IterationAssignment_6 ) ) ;
    public final void rule__GetClosure__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5332:1: ( ( ( rule__GetClosure__IterationAssignment_6 ) ) )
            // InternalFirstOrderLogic.g:5333:1: ( ( rule__GetClosure__IterationAssignment_6 ) )
            {
            // InternalFirstOrderLogic.g:5333:1: ( ( rule__GetClosure__IterationAssignment_6 ) )
            // InternalFirstOrderLogic.g:5334:2: ( rule__GetClosure__IterationAssignment_6 )
            {
             before(grammarAccess.getGetClosureAccess().getIterationAssignment_6()); 
            // InternalFirstOrderLogic.g:5335:2: ( rule__GetClosure__IterationAssignment_6 )
            // InternalFirstOrderLogic.g:5335:3: rule__GetClosure__IterationAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__IterationAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getGetClosureAccess().getIterationAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__6__Impl"


    // $ANTLR start "rule__GetClosure__Group__7"
    // InternalFirstOrderLogic.g:5343:1: rule__GetClosure__Group__7 : rule__GetClosure__Group__7__Impl ;
    public final void rule__GetClosure__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5347:1: ( rule__GetClosure__Group__7__Impl )
            // InternalFirstOrderLogic.g:5348:2: rule__GetClosure__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GetClosure__Group__7__Impl();

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
    // $ANTLR end "rule__GetClosure__Group__7"


    // $ANTLR start "rule__GetClosure__Group__7__Impl"
    // InternalFirstOrderLogic.g:5354:1: rule__GetClosure__Group__7__Impl : ( ')' ) ;
    public final void rule__GetClosure__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5358:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5359:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5359:1: ( ')' )
            // InternalFirstOrderLogic.g:5360:2: ')'
            {
             before(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__Group__7__Impl"


    // $ANTLR start "rule__Size__Group__0"
    // InternalFirstOrderLogic.g:5370:1: rule__Size__Group__0 : rule__Size__Group__0__Impl rule__Size__Group__1 ;
    public final void rule__Size__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5374:1: ( rule__Size__Group__0__Impl rule__Size__Group__1 )
            // InternalFirstOrderLogic.g:5375:2: rule__Size__Group__0__Impl rule__Size__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5382:1: rule__Size__Group__0__Impl : ( 'size' ) ;
    public final void rule__Size__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5386:1: ( ( 'size' ) )
            // InternalFirstOrderLogic.g:5387:1: ( 'size' )
            {
            // InternalFirstOrderLogic.g:5387:1: ( 'size' )
            // InternalFirstOrderLogic.g:5388:2: 'size'
            {
             before(grammarAccess.getSizeAccess().getSizeKeyword_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5397:1: rule__Size__Group__1 : rule__Size__Group__1__Impl rule__Size__Group__2 ;
    public final void rule__Size__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5401:1: ( rule__Size__Group__1__Impl rule__Size__Group__2 )
            // InternalFirstOrderLogic.g:5402:2: rule__Size__Group__1__Impl rule__Size__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5409:1: rule__Size__Group__1__Impl : ( '(' ) ;
    public final void rule__Size__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5413:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5414:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5414:1: ( '(' )
            // InternalFirstOrderLogic.g:5415:2: '('
            {
             before(grammarAccess.getSizeAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5424:1: rule__Size__Group__2 : rule__Size__Group__2__Impl rule__Size__Group__3 ;
    public final void rule__Size__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5428:1: ( rule__Size__Group__2__Impl rule__Size__Group__3 )
            // InternalFirstOrderLogic.g:5429:2: rule__Size__Group__2__Impl rule__Size__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5436:1: rule__Size__Group__2__Impl : ( ( rule__Size__ElementsAssignment_2 ) ) ;
    public final void rule__Size__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5440:1: ( ( ( rule__Size__ElementsAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5441:1: ( ( rule__Size__ElementsAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5441:1: ( ( rule__Size__ElementsAssignment_2 ) )
            // InternalFirstOrderLogic.g:5442:2: ( rule__Size__ElementsAssignment_2 )
            {
             before(grammarAccess.getSizeAccess().getElementsAssignment_2()); 
            // InternalFirstOrderLogic.g:5443:2: ( rule__Size__ElementsAssignment_2 )
            // InternalFirstOrderLogic.g:5443:3: rule__Size__ElementsAssignment_2
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
    // InternalFirstOrderLogic.g:5451:1: rule__Size__Group__3 : rule__Size__Group__3__Impl ;
    public final void rule__Size__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5455:1: ( rule__Size__Group__3__Impl )
            // InternalFirstOrderLogic.g:5456:2: rule__Size__Group__3__Impl
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
    // InternalFirstOrderLogic.g:5462:1: rule__Size__Group__3__Impl : ( ')' ) ;
    public final void rule__Size__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5466:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5467:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5467:1: ( ')' )
            // InternalFirstOrderLogic.g:5468:2: ')'
            {
             before(grammarAccess.getSizeAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5478:1: rule__IndexOf__Group__0 : rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1 ;
    public final void rule__IndexOf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5482:1: ( rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1 )
            // InternalFirstOrderLogic.g:5483:2: rule__IndexOf__Group__0__Impl rule__IndexOf__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5490:1: rule__IndexOf__Group__0__Impl : ( 'indexOf' ) ;
    public final void rule__IndexOf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5494:1: ( ( 'indexOf' ) )
            // InternalFirstOrderLogic.g:5495:1: ( 'indexOf' )
            {
            // InternalFirstOrderLogic.g:5495:1: ( 'indexOf' )
            // InternalFirstOrderLogic.g:5496:2: 'indexOf'
            {
             before(grammarAccess.getIndexOfAccess().getIndexOfKeyword_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5505:1: rule__IndexOf__Group__1 : rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2 ;
    public final void rule__IndexOf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5509:1: ( rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2 )
            // InternalFirstOrderLogic.g:5510:2: rule__IndexOf__Group__1__Impl rule__IndexOf__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5517:1: rule__IndexOf__Group__1__Impl : ( '(' ) ;
    public final void rule__IndexOf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5521:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5522:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5522:1: ( '(' )
            // InternalFirstOrderLogic.g:5523:2: '('
            {
             before(grammarAccess.getIndexOfAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5532:1: rule__IndexOf__Group__2 : rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3 ;
    public final void rule__IndexOf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5536:1: ( rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3 )
            // InternalFirstOrderLogic.g:5537:2: rule__IndexOf__Group__2__Impl rule__IndexOf__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:5544:1: rule__IndexOf__Group__2__Impl : ( ( rule__IndexOf__ContainerAssignment_2 ) ) ;
    public final void rule__IndexOf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5548:1: ( ( ( rule__IndexOf__ContainerAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5549:1: ( ( rule__IndexOf__ContainerAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5549:1: ( ( rule__IndexOf__ContainerAssignment_2 ) )
            // InternalFirstOrderLogic.g:5550:2: ( rule__IndexOf__ContainerAssignment_2 )
            {
             before(grammarAccess.getIndexOfAccess().getContainerAssignment_2()); 
            // InternalFirstOrderLogic.g:5551:2: ( rule__IndexOf__ContainerAssignment_2 )
            // InternalFirstOrderLogic.g:5551:3: rule__IndexOf__ContainerAssignment_2
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
    // InternalFirstOrderLogic.g:5559:1: rule__IndexOf__Group__3 : rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4 ;
    public final void rule__IndexOf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5563:1: ( rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4 )
            // InternalFirstOrderLogic.g:5564:2: rule__IndexOf__Group__3__Impl rule__IndexOf__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5571:1: rule__IndexOf__Group__3__Impl : ( ',' ) ;
    public final void rule__IndexOf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5575:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5576:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5576:1: ( ',' )
            // InternalFirstOrderLogic.g:5577:2: ','
            {
             before(grammarAccess.getIndexOfAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5586:1: rule__IndexOf__Group__4 : rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5 ;
    public final void rule__IndexOf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5590:1: ( rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5 )
            // InternalFirstOrderLogic.g:5591:2: rule__IndexOf__Group__4__Impl rule__IndexOf__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5598:1: rule__IndexOf__Group__4__Impl : ( ( rule__IndexOf__ElementAssignment_4 ) ) ;
    public final void rule__IndexOf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5602:1: ( ( ( rule__IndexOf__ElementAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5603:1: ( ( rule__IndexOf__ElementAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5603:1: ( ( rule__IndexOf__ElementAssignment_4 ) )
            // InternalFirstOrderLogic.g:5604:2: ( rule__IndexOf__ElementAssignment_4 )
            {
             before(grammarAccess.getIndexOfAccess().getElementAssignment_4()); 
            // InternalFirstOrderLogic.g:5605:2: ( rule__IndexOf__ElementAssignment_4 )
            // InternalFirstOrderLogic.g:5605:3: rule__IndexOf__ElementAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__ElementAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIndexOfAccess().getElementAssignment_4()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:5613:1: rule__IndexOf__Group__5 : rule__IndexOf__Group__5__Impl ;
    public final void rule__IndexOf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5617:1: ( rule__IndexOf__Group__5__Impl )
            // InternalFirstOrderLogic.g:5618:2: rule__IndexOf__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IndexOf__Group__5__Impl();

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
    // InternalFirstOrderLogic.g:5624:1: rule__IndexOf__Group__5__Impl : ( ')' ) ;
    public final void rule__IndexOf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5628:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5629:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5629:1: ( ')' )
            // InternalFirstOrderLogic.g:5630:2: ')'
            {
             before(grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getIndexOfAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__Concatenate__Group__0"
    // InternalFirstOrderLogic.g:5640:1: rule__Concatenate__Group__0 : rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 ;
    public final void rule__Concatenate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5644:1: ( rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1 )
            // InternalFirstOrderLogic.g:5645:2: rule__Concatenate__Group__0__Impl rule__Concatenate__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5652:1: rule__Concatenate__Group__0__Impl : ( 'concatenate' ) ;
    public final void rule__Concatenate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5656:1: ( ( 'concatenate' ) )
            // InternalFirstOrderLogic.g:5657:1: ( 'concatenate' )
            {
            // InternalFirstOrderLogic.g:5657:1: ( 'concatenate' )
            // InternalFirstOrderLogic.g:5658:2: 'concatenate'
            {
             before(grammarAccess.getConcatenateAccess().getConcatenateKeyword_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5667:1: rule__Concatenate__Group__1 : rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 ;
    public final void rule__Concatenate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5671:1: ( rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2 )
            // InternalFirstOrderLogic.g:5672:2: rule__Concatenate__Group__1__Impl rule__Concatenate__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5679:1: rule__Concatenate__Group__1__Impl : ( '(' ) ;
    public final void rule__Concatenate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5683:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5684:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5684:1: ( '(' )
            // InternalFirstOrderLogic.g:5685:2: '('
            {
             before(grammarAccess.getConcatenateAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5694:1: rule__Concatenate__Group__2 : rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 ;
    public final void rule__Concatenate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5698:1: ( rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3 )
            // InternalFirstOrderLogic.g:5699:2: rule__Concatenate__Group__2__Impl rule__Concatenate__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalFirstOrderLogic.g:5706:1: rule__Concatenate__Group__2__Impl : ( ( rule__Concatenate__LeftAssignment_2 ) ) ;
    public final void rule__Concatenate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5710:1: ( ( ( rule__Concatenate__LeftAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5711:1: ( ( rule__Concatenate__LeftAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5711:1: ( ( rule__Concatenate__LeftAssignment_2 ) )
            // InternalFirstOrderLogic.g:5712:2: ( rule__Concatenate__LeftAssignment_2 )
            {
             before(grammarAccess.getConcatenateAccess().getLeftAssignment_2()); 
            // InternalFirstOrderLogic.g:5713:2: ( rule__Concatenate__LeftAssignment_2 )
            // InternalFirstOrderLogic.g:5713:3: rule__Concatenate__LeftAssignment_2
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
    // InternalFirstOrderLogic.g:5721:1: rule__Concatenate__Group__3 : rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 ;
    public final void rule__Concatenate__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5725:1: ( rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4 )
            // InternalFirstOrderLogic.g:5726:2: rule__Concatenate__Group__3__Impl rule__Concatenate__Group__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5733:1: rule__Concatenate__Group__3__Impl : ( ',' ) ;
    public final void rule__Concatenate__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5737:1: ( ( ',' ) )
            // InternalFirstOrderLogic.g:5738:1: ( ',' )
            {
            // InternalFirstOrderLogic.g:5738:1: ( ',' )
            // InternalFirstOrderLogic.g:5739:2: ','
            {
             before(grammarAccess.getConcatenateAccess().getCommaKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5748:1: rule__Concatenate__Group__4 : rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5 ;
    public final void rule__Concatenate__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5752:1: ( rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5 )
            // InternalFirstOrderLogic.g:5753:2: rule__Concatenate__Group__4__Impl rule__Concatenate__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5760:1: rule__Concatenate__Group__4__Impl : ( ( rule__Concatenate__RightAssignment_4 ) ) ;
    public final void rule__Concatenate__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5764:1: ( ( ( rule__Concatenate__RightAssignment_4 ) ) )
            // InternalFirstOrderLogic.g:5765:1: ( ( rule__Concatenate__RightAssignment_4 ) )
            {
            // InternalFirstOrderLogic.g:5765:1: ( ( rule__Concatenate__RightAssignment_4 ) )
            // InternalFirstOrderLogic.g:5766:2: ( rule__Concatenate__RightAssignment_4 )
            {
             before(grammarAccess.getConcatenateAccess().getRightAssignment_4()); 
            // InternalFirstOrderLogic.g:5767:2: ( rule__Concatenate__RightAssignment_4 )
            // InternalFirstOrderLogic.g:5767:3: rule__Concatenate__RightAssignment_4
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
    // InternalFirstOrderLogic.g:5775:1: rule__Concatenate__Group__5 : rule__Concatenate__Group__5__Impl ;
    public final void rule__Concatenate__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5779:1: ( rule__Concatenate__Group__5__Impl )
            // InternalFirstOrderLogic.g:5780:2: rule__Concatenate__Group__5__Impl
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
    // InternalFirstOrderLogic.g:5786:1: rule__Concatenate__Group__5__Impl : ( ')' ) ;
    public final void rule__Concatenate__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5790:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5791:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5791:1: ( ')' )
            // InternalFirstOrderLogic.g:5792:2: ')'
            {
             before(grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5802:1: rule__Capitalize__Group__0 : rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 ;
    public final void rule__Capitalize__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5806:1: ( rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1 )
            // InternalFirstOrderLogic.g:5807:2: rule__Capitalize__Group__0__Impl rule__Capitalize__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalFirstOrderLogic.g:5814:1: rule__Capitalize__Group__0__Impl : ( 'capitalize' ) ;
    public final void rule__Capitalize__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5818:1: ( ( 'capitalize' ) )
            // InternalFirstOrderLogic.g:5819:1: ( 'capitalize' )
            {
            // InternalFirstOrderLogic.g:5819:1: ( 'capitalize' )
            // InternalFirstOrderLogic.g:5820:2: 'capitalize'
            {
             before(grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5829:1: rule__Capitalize__Group__1 : rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 ;
    public final void rule__Capitalize__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5833:1: ( rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2 )
            // InternalFirstOrderLogic.g:5834:2: rule__Capitalize__Group__1__Impl rule__Capitalize__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalFirstOrderLogic.g:5841:1: rule__Capitalize__Group__1__Impl : ( '(' ) ;
    public final void rule__Capitalize__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5845:1: ( ( '(' ) )
            // InternalFirstOrderLogic.g:5846:1: ( '(' )
            {
            // InternalFirstOrderLogic.g:5846:1: ( '(' )
            // InternalFirstOrderLogic.g:5847:2: '('
            {
             before(grammarAccess.getCapitalizeAccess().getLeftParenthesisKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalFirstOrderLogic.g:5856:1: rule__Capitalize__Group__2 : rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3 ;
    public final void rule__Capitalize__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5860:1: ( rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3 )
            // InternalFirstOrderLogic.g:5861:2: rule__Capitalize__Group__2__Impl rule__Capitalize__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalFirstOrderLogic.g:5868:1: rule__Capitalize__Group__2__Impl : ( ( rule__Capitalize__StringAssignment_2 ) ) ;
    public final void rule__Capitalize__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5872:1: ( ( ( rule__Capitalize__StringAssignment_2 ) ) )
            // InternalFirstOrderLogic.g:5873:1: ( ( rule__Capitalize__StringAssignment_2 ) )
            {
            // InternalFirstOrderLogic.g:5873:1: ( ( rule__Capitalize__StringAssignment_2 ) )
            // InternalFirstOrderLogic.g:5874:2: ( rule__Capitalize__StringAssignment_2 )
            {
             before(grammarAccess.getCapitalizeAccess().getStringAssignment_2()); 
            // InternalFirstOrderLogic.g:5875:2: ( rule__Capitalize__StringAssignment_2 )
            // InternalFirstOrderLogic.g:5875:3: rule__Capitalize__StringAssignment_2
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
    // InternalFirstOrderLogic.g:5883:1: rule__Capitalize__Group__3 : rule__Capitalize__Group__3__Impl ;
    public final void rule__Capitalize__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5887:1: ( rule__Capitalize__Group__3__Impl )
            // InternalFirstOrderLogic.g:5888:2: rule__Capitalize__Group__3__Impl
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
    // InternalFirstOrderLogic.g:5894:1: rule__Capitalize__Group__3__Impl : ( ')' ) ;
    public final void rule__Capitalize__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5898:1: ( ( ')' ) )
            // InternalFirstOrderLogic.g:5899:1: ( ')' )
            {
            // InternalFirstOrderLogic.g:5899:1: ( ')' )
            // InternalFirstOrderLogic.g:5900:2: ')'
            {
             before(grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
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


    // $ANTLR start "rule__MetaConstant__Group__0"
    // InternalFirstOrderLogic.g:5910:1: rule__MetaConstant__Group__0 : rule__MetaConstant__Group__0__Impl rule__MetaConstant__Group__1 ;
    public final void rule__MetaConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5914:1: ( rule__MetaConstant__Group__0__Impl rule__MetaConstant__Group__1 )
            // InternalFirstOrderLogic.g:5915:2: rule__MetaConstant__Group__0__Impl rule__MetaConstant__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__MetaConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group__1();

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
    // $ANTLR end "rule__MetaConstant__Group__0"


    // $ANTLR start "rule__MetaConstant__Group__0__Impl"
    // InternalFirstOrderLogic.g:5922:1: rule__MetaConstant__Group__0__Impl : ( '$' ) ;
    public final void rule__MetaConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5926:1: ( ( '$' ) )
            // InternalFirstOrderLogic.g:5927:1: ( '$' )
            {
            // InternalFirstOrderLogic.g:5927:1: ( '$' )
            // InternalFirstOrderLogic.g:5928:2: '$'
            {
             before(grammarAccess.getMetaConstantAccess().getDollarSignKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getMetaConstantAccess().getDollarSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__Group__0__Impl"


    // $ANTLR start "rule__MetaConstant__Group__1"
    // InternalFirstOrderLogic.g:5937:1: rule__MetaConstant__Group__1 : rule__MetaConstant__Group__1__Impl rule__MetaConstant__Group__2 ;
    public final void rule__MetaConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5941:1: ( rule__MetaConstant__Group__1__Impl rule__MetaConstant__Group__2 )
            // InternalFirstOrderLogic.g:5942:2: rule__MetaConstant__Group__1__Impl rule__MetaConstant__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__MetaConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group__2();

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
    // $ANTLR end "rule__MetaConstant__Group__1"


    // $ANTLR start "rule__MetaConstant__Group__1__Impl"
    // InternalFirstOrderLogic.g:5949:1: rule__MetaConstant__Group__1__Impl : ( ( rule__MetaConstant__ClassifierAssignment_1 ) ) ;
    public final void rule__MetaConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5953:1: ( ( ( rule__MetaConstant__ClassifierAssignment_1 ) ) )
            // InternalFirstOrderLogic.g:5954:1: ( ( rule__MetaConstant__ClassifierAssignment_1 ) )
            {
            // InternalFirstOrderLogic.g:5954:1: ( ( rule__MetaConstant__ClassifierAssignment_1 ) )
            // InternalFirstOrderLogic.g:5955:2: ( rule__MetaConstant__ClassifierAssignment_1 )
            {
             before(grammarAccess.getMetaConstantAccess().getClassifierAssignment_1()); 
            // InternalFirstOrderLogic.g:5956:2: ( rule__MetaConstant__ClassifierAssignment_1 )
            // InternalFirstOrderLogic.g:5956:3: rule__MetaConstant__ClassifierAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MetaConstant__ClassifierAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMetaConstantAccess().getClassifierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__Group__1__Impl"


    // $ANTLR start "rule__MetaConstant__Group__2"
    // InternalFirstOrderLogic.g:5964:1: rule__MetaConstant__Group__2 : rule__MetaConstant__Group__2__Impl ;
    public final void rule__MetaConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5968:1: ( rule__MetaConstant__Group__2__Impl )
            // InternalFirstOrderLogic.g:5969:2: rule__MetaConstant__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group__2__Impl();

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
    // $ANTLR end "rule__MetaConstant__Group__2"


    // $ANTLR start "rule__MetaConstant__Group__2__Impl"
    // InternalFirstOrderLogic.g:5975:1: rule__MetaConstant__Group__2__Impl : ( ( rule__MetaConstant__Group_2__0 )? ) ;
    public final void rule__MetaConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5979:1: ( ( ( rule__MetaConstant__Group_2__0 )? ) )
            // InternalFirstOrderLogic.g:5980:1: ( ( rule__MetaConstant__Group_2__0 )? )
            {
            // InternalFirstOrderLogic.g:5980:1: ( ( rule__MetaConstant__Group_2__0 )? )
            // InternalFirstOrderLogic.g:5981:2: ( rule__MetaConstant__Group_2__0 )?
            {
             before(grammarAccess.getMetaConstantAccess().getGroup_2()); 
            // InternalFirstOrderLogic.g:5982:2: ( rule__MetaConstant__Group_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==42) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFirstOrderLogic.g:5982:3: rule__MetaConstant__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetaConstant__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMetaConstantAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__Group__2__Impl"


    // $ANTLR start "rule__MetaConstant__Group_2__0"
    // InternalFirstOrderLogic.g:5991:1: rule__MetaConstant__Group_2__0 : rule__MetaConstant__Group_2__0__Impl rule__MetaConstant__Group_2__1 ;
    public final void rule__MetaConstant__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:5995:1: ( rule__MetaConstant__Group_2__0__Impl rule__MetaConstant__Group_2__1 )
            // InternalFirstOrderLogic.g:5996:2: rule__MetaConstant__Group_2__0__Impl rule__MetaConstant__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__MetaConstant__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group_2__1();

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
    // $ANTLR end "rule__MetaConstant__Group_2__0"


    // $ANTLR start "rule__MetaConstant__Group_2__0__Impl"
    // InternalFirstOrderLogic.g:6003:1: rule__MetaConstant__Group_2__0__Impl : ( '::' ) ;
    public final void rule__MetaConstant__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6007:1: ( ( '::' ) )
            // InternalFirstOrderLogic.g:6008:1: ( '::' )
            {
            // InternalFirstOrderLogic.g:6008:1: ( '::' )
            // InternalFirstOrderLogic.g:6009:2: '::'
            {
             before(grammarAccess.getMetaConstantAccess().getColonColonKeyword_2_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getMetaConstantAccess().getColonColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__Group_2__0__Impl"


    // $ANTLR start "rule__MetaConstant__Group_2__1"
    // InternalFirstOrderLogic.g:6018:1: rule__MetaConstant__Group_2__1 : rule__MetaConstant__Group_2__1__Impl ;
    public final void rule__MetaConstant__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6022:1: ( rule__MetaConstant__Group_2__1__Impl )
            // InternalFirstOrderLogic.g:6023:2: rule__MetaConstant__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetaConstant__Group_2__1__Impl();

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
    // $ANTLR end "rule__MetaConstant__Group_2__1"


    // $ANTLR start "rule__MetaConstant__Group_2__1__Impl"
    // InternalFirstOrderLogic.g:6029:1: rule__MetaConstant__Group_2__1__Impl : ( ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 ) ) ;
    public final void rule__MetaConstant__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6033:1: ( ( ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 ) ) )
            // InternalFirstOrderLogic.g:6034:1: ( ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 ) )
            {
            // InternalFirstOrderLogic.g:6034:1: ( ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 ) )
            // InternalFirstOrderLogic.g:6035:2: ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 )
            {
             before(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureAssignment_2_1()); 
            // InternalFirstOrderLogic.g:6036:2: ( rule__MetaConstant__LiteralOrFeatureAssignment_2_1 )
            // InternalFirstOrderLogic.g:6036:3: rule__MetaConstant__LiteralOrFeatureAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__MetaConstant__LiteralOrFeatureAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__Group_2__1__Impl"


    // $ANTLR start "rule__ConstraintLibrary__ImportsAssignment_0"
    // InternalFirstOrderLogic.g:6045:1: rule__ConstraintLibrary__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__ConstraintLibrary__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6049:1: ( ( ruleImport ) )
            // InternalFirstOrderLogic.g:6050:2: ( ruleImport )
            {
            // InternalFirstOrderLogic.g:6050:2: ( ruleImport )
            // InternalFirstOrderLogic.g:6051:3: ruleImport
            {
             before(grammarAccess.getConstraintLibraryAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getConstraintLibraryAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintLibrary__ImportsAssignment_0"


    // $ANTLR start "rule__ConstraintLibrary__ConstraintsAssignment_1"
    // InternalFirstOrderLogic.g:6060:1: rule__ConstraintLibrary__ConstraintsAssignment_1 : ( ruleConstraint ) ;
    public final void rule__ConstraintLibrary__ConstraintsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6064:1: ( ( ruleConstraint ) )
            // InternalFirstOrderLogic.g:6065:2: ( ruleConstraint )
            {
            // InternalFirstOrderLogic.g:6065:2: ( ruleConstraint )
            // InternalFirstOrderLogic.g:6066:3: ruleConstraint
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


    // $ANTLR start "rule__Import__DomainAssignment_1"
    // InternalFirstOrderLogic.g:6075:1: rule__Import__DomainAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__DomainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6079:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:6080:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:6080:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:6081:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getDomainSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getDomainSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__DomainAssignment_1"


    // $ANTLR start "rule__Constraint__NameAssignment_1"
    // InternalFirstOrderLogic.g:6090:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6094:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6095:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:6095:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:6096:3: RULE_ID
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
    // InternalFirstOrderLogic.g:6105:1: rule__Constraint__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Constraint__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6109:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:6110:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:6110:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:6111:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:6120:1: rule__Constraint__VariableAssignment_5 : ( ruleVariable ) ;
    public final void rule__Constraint__VariableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6124:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6125:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6125:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6126:3: ruleVariable
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


    // $ANTLR start "rule__Constraint__TypeAssignment_6_1"
    // InternalFirstOrderLogic.g:6135:1: rule__Constraint__TypeAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Constraint__TypeAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6139:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6140:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6140:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6141:3: ( RULE_ID )
            {
             before(grammarAccess.getConstraintAccess().getTypeEClassifierCrossReference_6_1_0()); 
            // InternalFirstOrderLogic.g:6142:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6143:4: RULE_ID
            {
             before(grammarAccess.getConstraintAccess().getTypeEClassifierIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getTypeEClassifierIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getConstraintAccess().getTypeEClassifierCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__TypeAssignment_6_1"


    // $ANTLR start "rule__Constraint__FormulaAssignment_8"
    // InternalFirstOrderLogic.g:6154:1: rule__Constraint__FormulaAssignment_8 : ( ruleFormula ) ;
    public final void rule__Constraint__FormulaAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6158:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6159:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6159:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6160:3: ruleFormula
            {
             before(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__FormulaAssignment_8"


    // $ANTLR start "rule__Variable__TypeAssignment_0"
    // InternalFirstOrderLogic.g:6169:1: rule__Variable__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6173:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6174:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6174:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6175:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0()); 
            // InternalFirstOrderLogic.g:6176:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6177:4: RULE_ID
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
    // InternalFirstOrderLogic.g:6188:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6192:1: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6193:2: ( RULE_ID )
            {
            // InternalFirstOrderLogic.g:6193:2: ( RULE_ID )
            // InternalFirstOrderLogic.g:6194:3: RULE_ID
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
    // InternalFirstOrderLogic.g:6203:1: rule__Iff__RightAssignment_1_2 : ( ruleIf ) ;
    public final void rule__Iff__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6207:1: ( ( ruleIf ) )
            // InternalFirstOrderLogic.g:6208:2: ( ruleIf )
            {
            // InternalFirstOrderLogic.g:6208:2: ( ruleIf )
            // InternalFirstOrderLogic.g:6209:3: ruleIf
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
    // InternalFirstOrderLogic.g:6218:1: rule__If__RightAssignment_1_2 : ( ruleXor ) ;
    public final void rule__If__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6222:1: ( ( ruleXor ) )
            // InternalFirstOrderLogic.g:6223:2: ( ruleXor )
            {
            // InternalFirstOrderLogic.g:6223:2: ( ruleXor )
            // InternalFirstOrderLogic.g:6224:3: ruleXor
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
    // InternalFirstOrderLogic.g:6233:1: rule__Xor__RightAssignment_1_2 : ( ruleOr ) ;
    public final void rule__Xor__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6237:1: ( ( ruleOr ) )
            // InternalFirstOrderLogic.g:6238:2: ( ruleOr )
            {
            // InternalFirstOrderLogic.g:6238:2: ( ruleOr )
            // InternalFirstOrderLogic.g:6239:3: ruleOr
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
    // InternalFirstOrderLogic.g:6248:1: rule__Or__RightAssignment_1_2 : ( ruleAnd ) ;
    public final void rule__Or__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6252:1: ( ( ruleAnd ) )
            // InternalFirstOrderLogic.g:6253:2: ( ruleAnd )
            {
            // InternalFirstOrderLogic.g:6253:2: ( ruleAnd )
            // InternalFirstOrderLogic.g:6254:3: ruleAnd
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
    // InternalFirstOrderLogic.g:6263:1: rule__And__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__And__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6267:1: ( ( ruleBooleanExpression ) )
            // InternalFirstOrderLogic.g:6268:2: ( ruleBooleanExpression )
            {
            // InternalFirstOrderLogic.g:6268:2: ( ruleBooleanExpression )
            // InternalFirstOrderLogic.g:6269:3: ruleBooleanExpression
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
    // InternalFirstOrderLogic.g:6278:1: rule__Not__NotAssignment_3 : ( ruleFormula ) ;
    public final void rule__Not__NotAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6282:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6283:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6283:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6284:3: ruleFormula
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
    // InternalFirstOrderLogic.g:6293:1: rule__Equals__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Equals__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6297:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6298:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6298:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6299:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6308:1: rule__Equals__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Equals__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6312:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6313:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6313:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6314:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6323:1: rule__Greater__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Greater__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6327:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6328:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6328:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6329:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6338:1: rule__Greater__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Greater__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6342:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6343:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6343:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6344:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6353:1: rule__GreaterEqual__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6357:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6358:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6358:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6359:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6368:1: rule__GreaterEqual__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__GreaterEqual__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6372:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6373:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6373:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6374:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6383:1: rule__Smaller__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Smaller__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6387:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6388:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6388:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6389:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6398:1: rule__Smaller__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Smaller__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6402:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6403:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6403:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6404:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6413:1: rule__SmallerEqual__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6417:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6418:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6418:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6419:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6428:1: rule__SmallerEqual__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__SmallerEqual__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6432:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6433:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6433:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6434:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6443:1: rule__IsEmpty__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsEmpty__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6447:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6448:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6448:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6449:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6458:1: rule__IsInstanceOf__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsInstanceOf__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6462:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6463:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6463:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6464:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6473:1: rule__IsInstanceOf__TypeAssignment_4 : ( ruleTerm ) ;
    public final void rule__IsInstanceOf__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6477:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6478:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6478:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6479:3: ruleTerm
            {
             before(grammarAccess.getIsInstanceOfAccess().getTypeTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsInstanceOfAccess().getTypeTermParserRuleCall_4_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:6488:1: rule__IsValueLiteralOf__TermAssignment_2 : ( ruleTerm ) ;
    public final void rule__IsValueLiteralOf__TermAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6492:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6493:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6493:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6494:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6503:1: rule__IsValueLiteralOf__TypeAssignment_4 : ( ruleTerm ) ;
    public final void rule__IsValueLiteralOf__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6507:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6508:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6508:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6509:3: ruleTerm
            {
             before(grammarAccess.getIsValueLiteralOfAccess().getTypeTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIsValueLiteralOfAccess().getTypeTermParserRuleCall_4_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:6518:1: rule__ForAll__NameAssignment_3 : ( ruleVariable ) ;
    public final void rule__ForAll__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6522:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6523:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6523:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6524:3: ruleVariable
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
    // InternalFirstOrderLogic.g:6533:1: rule__ForAll__IterationAssignment_5 : ( ruleTerm ) ;
    public final void rule__ForAll__IterationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6537:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6538:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6538:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6539:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6548:1: rule__ForAll__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__ForAll__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6552:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6553:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6553:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6554:3: ruleFormula
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
    // InternalFirstOrderLogic.g:6563:1: rule__Exists__NameAssignment_3 : ( ruleVariable ) ;
    public final void rule__Exists__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6567:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6568:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6568:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6569:3: ruleVariable
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
    // InternalFirstOrderLogic.g:6578:1: rule__Exists__IterationAssignment_5 : ( ruleTerm ) ;
    public final void rule__Exists__IterationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6582:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6583:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6583:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6584:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6593:1: rule__Exists__FormulaAssignment_7 : ( ruleFormula ) ;
    public final void rule__Exists__FormulaAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6597:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6598:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6598:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6599:3: ruleFormula
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


    // $ANTLR start "rule__ReferenceBase__GetAssignment_1"
    // InternalFirstOrderLogic.g:6608:1: rule__ReferenceBase__GetAssignment_1 : ( ruleGet ) ;
    public final void rule__ReferenceBase__GetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6612:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:6613:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:6613:2: ( ruleGet )
            // InternalFirstOrderLogic.g:6614:3: ruleGet
            {
             before(grammarAccess.getReferenceBaseAccess().getGetGetParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGet();

            state._fsp--;

             after(grammarAccess.getReferenceBaseAccess().getGetGetParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceBase__GetAssignment_1"


    // $ANTLR start "rule__VariableRef__NameAssignment"
    // InternalFirstOrderLogic.g:6623:1: rule__VariableRef__NameAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VariableRef__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6627:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6628:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6628:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6629:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_0()); 
            // InternalFirstOrderLogic.g:6630:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6631:4: RULE_ID
            {
             before(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableRefAccess().getNameVariableIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getVariableRefAccess().getNameVariableCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableRef__NameAssignment"


    // $ANTLR start "rule__Select__IterationAssignment_2"
    // InternalFirstOrderLogic.g:6642:1: rule__Select__IterationAssignment_2 : ( ruleTerm ) ;
    public final void rule__Select__IterationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6646:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6647:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6647:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6648:3: ruleTerm
            {
             before(grammarAccess.getSelectAccess().getIterationTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getIterationTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__IterationAssignment_2"


    // $ANTLR start "rule__Select__NameAssignment_4"
    // InternalFirstOrderLogic.g:6657:1: rule__Select__NameAssignment_4 : ( ruleVariable ) ;
    public final void rule__Select__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6661:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6662:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6662:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6663:3: ruleVariable
            {
             before(grammarAccess.getSelectAccess().getNameVariableParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getNameVariableParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__NameAssignment_4"


    // $ANTLR start "rule__Select__FormulaAssignment_6"
    // InternalFirstOrderLogic.g:6672:1: rule__Select__FormulaAssignment_6 : ( ruleFormula ) ;
    public final void rule__Select__FormulaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6676:1: ( ( ruleFormula ) )
            // InternalFirstOrderLogic.g:6677:2: ( ruleFormula )
            {
            // InternalFirstOrderLogic.g:6677:2: ( ruleFormula )
            // InternalFirstOrderLogic.g:6678:3: ruleFormula
            {
             before(grammarAccess.getSelectAccess().getFormulaFormulaParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleFormula();

            state._fsp--;

             after(grammarAccess.getSelectAccess().getFormulaFormulaParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Select__FormulaAssignment_6"


    // $ANTLR start "rule__Get__TypeAssignment_1_0"
    // InternalFirstOrderLogic.g:6687:1: rule__Get__TypeAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Get__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6691:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6692:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6692:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6693:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getTypeEClassCrossReference_1_0_0()); 
            // InternalFirstOrderLogic.g:6694:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6695:4: RULE_ID
            {
             before(grammarAccess.getGetAccess().getTypeEClassIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGetAccess().getTypeEClassIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getGetAccess().getTypeEClassCrossReference_1_0_0()); 

            }


            }

        }
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
    // InternalFirstOrderLogic.g:6706:1: rule__Get__NameAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Get__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6710:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6711:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6711:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6712:3: ( RULE_ID )
            {
             before(grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0()); 
            // InternalFirstOrderLogic.g:6713:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6714:4: RULE_ID
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
    // InternalFirstOrderLogic.g:6725:1: rule__Get__NextAssignment_3 : ( ruleGet ) ;
    public final void rule__Get__NextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6729:1: ( ( ruleGet ) )
            // InternalFirstOrderLogic.g:6730:2: ( ruleGet )
            {
            // InternalFirstOrderLogic.g:6730:2: ( ruleGet )
            // InternalFirstOrderLogic.g:6731:3: ruleGet
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
    // InternalFirstOrderLogic.g:6740:1: rule__GetContainer__ElementAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetContainer__ElementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6744:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6745:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6745:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6746:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6755:1: rule__GetContainments__ElementAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetContainments__ElementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6759:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6760:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6760:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6761:3: ruleTerm
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


    // $ANTLR start "rule__GetClosure__InitialAssignment_2"
    // InternalFirstOrderLogic.g:6770:1: rule__GetClosure__InitialAssignment_2 : ( ruleTerm ) ;
    public final void rule__GetClosure__InitialAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6774:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6775:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6775:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6776:3: ruleTerm
            {
             before(grammarAccess.getGetClosureAccess().getInitialTermParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getInitialTermParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__InitialAssignment_2"


    // $ANTLR start "rule__GetClosure__VariableAssignment_4"
    // InternalFirstOrderLogic.g:6785:1: rule__GetClosure__VariableAssignment_4 : ( ruleVariable ) ;
    public final void rule__GetClosure__VariableAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6789:1: ( ( ruleVariable ) )
            // InternalFirstOrderLogic.g:6790:2: ( ruleVariable )
            {
            // InternalFirstOrderLogic.g:6790:2: ( ruleVariable )
            // InternalFirstOrderLogic.g:6791:3: ruleVariable
            {
             before(grammarAccess.getGetClosureAccess().getVariableVariableParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getVariableVariableParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__VariableAssignment_4"


    // $ANTLR start "rule__GetClosure__IterationAssignment_6"
    // InternalFirstOrderLogic.g:6800:1: rule__GetClosure__IterationAssignment_6 : ( ruleTerm ) ;
    public final void rule__GetClosure__IterationAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6804:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6805:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6805:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6806:3: ruleTerm
            {
             before(grammarAccess.getGetClosureAccess().getIterationTermParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getGetClosureAccess().getIterationTermParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GetClosure__IterationAssignment_6"


    // $ANTLR start "rule__Size__ElementsAssignment_2"
    // InternalFirstOrderLogic.g:6815:1: rule__Size__ElementsAssignment_2 : ( ruleTerm ) ;
    public final void rule__Size__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6819:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6820:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6820:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6821:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6830:1: rule__IndexOf__ContainerAssignment_2 : ( ruleTerm ) ;
    public final void rule__IndexOf__ContainerAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6834:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6835:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6835:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6836:3: ruleTerm
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


    // $ANTLR start "rule__IndexOf__ElementAssignment_4"
    // InternalFirstOrderLogic.g:6845:1: rule__IndexOf__ElementAssignment_4 : ( ruleTerm ) ;
    public final void rule__IndexOf__ElementAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6849:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6850:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6850:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6851:3: ruleTerm
            {
             before(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getIndexOfAccess().getElementTermParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexOf__ElementAssignment_4"


    // $ANTLR start "rule__Concatenate__LeftAssignment_2"
    // InternalFirstOrderLogic.g:6860:1: rule__Concatenate__LeftAssignment_2 : ( ruleTerm ) ;
    public final void rule__Concatenate__LeftAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6864:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6865:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6865:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6866:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6875:1: rule__Concatenate__RightAssignment_4 : ( ruleTerm ) ;
    public final void rule__Concatenate__RightAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6879:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6880:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6880:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6881:3: ruleTerm
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
    // InternalFirstOrderLogic.g:6890:1: rule__Capitalize__StringAssignment_2 : ( ruleTerm ) ;
    public final void rule__Capitalize__StringAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6894:1: ( ( ruleTerm ) )
            // InternalFirstOrderLogic.g:6895:2: ( ruleTerm )
            {
            // InternalFirstOrderLogic.g:6895:2: ( ruleTerm )
            // InternalFirstOrderLogic.g:6896:3: ruleTerm
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


    // $ANTLR start "rule__IntConstant__ValueAssignment"
    // InternalFirstOrderLogic.g:6905:1: rule__IntConstant__ValueAssignment : ( RULE_SIGNED_INT ) ;
    public final void rule__IntConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6909:1: ( ( RULE_SIGNED_INT ) )
            // InternalFirstOrderLogic.g:6910:2: ( RULE_SIGNED_INT )
            {
            // InternalFirstOrderLogic.g:6910:2: ( RULE_SIGNED_INT )
            // InternalFirstOrderLogic.g:6911:3: RULE_SIGNED_INT
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
    // InternalFirstOrderLogic.g:6920:1: rule__StringConstant__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6924:1: ( ( RULE_STRING ) )
            // InternalFirstOrderLogic.g:6925:2: ( RULE_STRING )
            {
            // InternalFirstOrderLogic.g:6925:2: ( RULE_STRING )
            // InternalFirstOrderLogic.g:6926:3: RULE_STRING
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
    // InternalFirstOrderLogic.g:6935:1: rule__BoolConstant__ValueAssignment : ( RULE_BOOLEAN ) ;
    public final void rule__BoolConstant__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6939:1: ( ( RULE_BOOLEAN ) )
            // InternalFirstOrderLogic.g:6940:2: ( RULE_BOOLEAN )
            {
            // InternalFirstOrderLogic.g:6940:2: ( RULE_BOOLEAN )
            // InternalFirstOrderLogic.g:6941:3: RULE_BOOLEAN
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


    // $ANTLR start "rule__MetaConstant__ClassifierAssignment_1"
    // InternalFirstOrderLogic.g:6950:1: rule__MetaConstant__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MetaConstant__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6954:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6955:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6955:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6956:3: ( RULE_ID )
            {
             before(grammarAccess.getMetaConstantAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalFirstOrderLogic.g:6957:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6958:4: RULE_ID
            {
             before(grammarAccess.getMetaConstantAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMetaConstantAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMetaConstantAccess().getClassifierEClassifierCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__ClassifierAssignment_1"


    // $ANTLR start "rule__MetaConstant__LiteralOrFeatureAssignment_2_1"
    // InternalFirstOrderLogic.g:6969:1: rule__MetaConstant__LiteralOrFeatureAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MetaConstant__LiteralOrFeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFirstOrderLogic.g:6973:1: ( ( ( RULE_ID ) ) )
            // InternalFirstOrderLogic.g:6974:2: ( ( RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:6974:2: ( ( RULE_ID ) )
            // InternalFirstOrderLogic.g:6975:3: ( RULE_ID )
            {
             before(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureENamedElementCrossReference_2_1_0()); 
            // InternalFirstOrderLogic.g:6976:3: ( RULE_ID )
            // InternalFirstOrderLogic.g:6977:4: RULE_ID
            {
             before(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureENamedElementIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureENamedElementIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getMetaConstantAccess().getLiteralOrFeatureENamedElementCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaConstant__LiteralOrFeatureAssignment_2_1"

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
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000BFD6000080L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0007F9BFD60000F0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000040000000000L});

}