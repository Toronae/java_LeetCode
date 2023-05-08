/*! For license information please see tsMode.js.LICENSE.txt */
define("vs/language/typescript/tsMode",["require","require"],(e=>(()=>{var t,i,r=Object.create,s=Object.defineProperty,n=Object.getOwnPropertyDescriptor,a=Object.getOwnPropertyNames,o=Object.getPrototypeOf,l=Object.prototype.hasOwnProperty,d=e=>s(e,"__esModule",{value:!0}),u=(t=function(t){if(void 0!==e)return e.apply(this,arguments);throw new Error('Dynamic require of "'+t+'" is not supported')},void 0!==e?e:"undefined"!=typeof Proxy?new Proxy(t,{get:(t,i)=>(void 0!==e?e:t)[i]}):t),c=(e,t,i,r)=>{if(t&&"object"==typeof t||"function"==typeof t)for(let o of a(t))!l.call(e,o)&&(i||"default"!==o)&&s(e,o,{get:()=>t[o],enumerable:!(r=n(t,o))||r.enumerable});return e},g=(e,t)=>c(d(s(null!=e?r(o(e)):{},"default",!t&&e&&e.__esModule?{get:()=>e.default,enumerable:!0}:{value:e,enumerable:!0})),e),p=(e=>(t,i)=>e&&e.get(t)||(i=c(d({}),t,1),e&&e.set(t,i),i))("undefined"!=typeof WeakMap?new WeakMap:0),m=(e,t,i)=>(((e,t,i)=>{t in e?s(e,t,{enumerable:!0,configurable:!0,writable:!0,value:i}):e[t]=i})(e,"symbol"!=typeof t?t+"":t,i),i),f=()=>{return i||(e=i={exports:{}},t=g(u("vs/editor/editor.api")),e.exports=t),i.exports;var e,t},b={};((e,t)=>{for(var i in t)s(e,i,{get:t[i],enumerable:!0})})(b,{Adapter:()=>v,CodeActionAdaptor:()=>V,DefinitionAdapter:()=>P,DiagnosticsAdapter:()=>C,FormatAdapter:()=>H,FormatHelper:()=>E,FormatOnTypeAdapter:()=>W,InlayHintsAdapter:()=>B,Kind:()=>N,LibFiles:()=>k,OccurrencesAdapter:()=>L,OutlineAdapter:()=>T,QuickInfoAdapter:()=>I,ReferenceAdapter:()=>O,RenameAdapter:()=>j,SignatureHelpAdapter:()=>F,SuggestAdapter:()=>D,WorkerManager:()=>_,flattenDiagnosticMessageText:()=>S,getJavaScriptWorker:()=>z,getTypeScriptWorker:()=>q,setupJavaScript:()=>$,setupTypeScript:()=>U});var h={};c(h,g(f()));var _=class{_modeId;_defaults;_configChangeListener;_updateExtraLibsToken;_extraLibsChangeListener;_worker;_client;constructor(e,t){this._modeId=e,this._defaults=t,this._worker=null,this._client=null,this._configChangeListener=this._defaults.onDidChange((()=>this._stopWorker())),this._updateExtraLibsToken=0,this._extraLibsChangeListener=this._defaults.onDidExtraLibsChange((()=>this._updateExtraLibs()))}_stopWorker(){this._worker&&(this._worker.dispose(),this._worker=null),this._client=null}dispose(){this._configChangeListener.dispose(),this._extraLibsChangeListener.dispose(),this._stopWorker()}async _updateExtraLibs(){if(!this._worker)return;let e=++this._updateExtraLibsToken,t=await this._worker.getProxy();this._updateExtraLibsToken===e&&t.updateExtraLibs(this._defaults.getExtraLibs())}_getClient(){if(!this._client){this._worker=h.editor.createWebWorker({moduleId:"vs/language/typescript/tsWorker",label:this._modeId,keepIdleModels:!0,createData:{compilerOptions:this._defaults.getCompilerOptions(),extraLibs:this._defaults.getExtraLibs(),customWorkerPath:this._defaults.workerOptions.customWorkerPath,inlayHintsOptions:this._defaults.inlayHintsOptions}});let e=this._worker.getProxy();this._defaults.getEagerModelSync()&&(e=e.then((e=>this._worker?this._worker.withSyncedResources(h.editor.getModels().filter((e=>e.getLanguageId()===this._modeId)).map((e=>e.uri))):e))),this._client=e}return this._client}getLanguageServiceWorker(...e){let t;return this._getClient().then((e=>{t=e})).then((t=>{if(this._worker)return this._worker.withSyncedResources(e)})).then((e=>t))}},y=u("./monaco.contribution"),w={};function S(e,t,i=0){if("string"==typeof e)return e;if(void 0===e)return"";let r="";if(i){r+=t;for(let e=0;e<i;e++)r+="  "}if(r+=e.messageText,i++,e.next)for(let s of e.next)r+=S(s,t,i);return r}function x(e){return e?e.map((e=>e.text)).join(""):""}w["lib.d.ts"]=!0,w["lib.dom.d.ts"]=!0,w["lib.dom.iterable.d.ts"]=!0,w["lib.es2015.collection.d.ts"]=!0,w["lib.es2015.core.d.ts"]=!0,w["lib.es2015.d.ts"]=!0,w["lib.es2015.generator.d.ts"]=!0,w["lib.es2015.iterable.d.ts"]=!0,w["lib.es2015.promise.d.ts"]=!0,w["lib.es2015.proxy.d.ts"]=!0,w["lib.es2015.reflect.d.ts"]=!0,w["lib.es2015.symbol.d.ts"]=!0,w["lib.es2015.symbol.wellknown.d.ts"]=!0,w["lib.es2016.array.include.d.ts"]=!0,w["lib.es2016.d.ts"]=!0,w["lib.es2016.full.d.ts"]=!0,w["lib.es2017.d.ts"]=!0,w["lib.es2017.full.d.ts"]=!0,w["lib.es2017.intl.d.ts"]=!0,w["lib.es2017.object.d.ts"]=!0,w["lib.es2017.sharedmemory.d.ts"]=!0,w["lib.es2017.string.d.ts"]=!0,w["lib.es2017.typedarrays.d.ts"]=!0,w["lib.es2018.asyncgenerator.d.ts"]=!0,w["lib.es2018.asynciterable.d.ts"]=!0,w["lib.es2018.d.ts"]=!0,w["lib.es2018.full.d.ts"]=!0,w["lib.es2018.intl.d.ts"]=!0,w["lib.es2018.promise.d.ts"]=!0,w["lib.es2018.regexp.d.ts"]=!0,w["lib.es2019.array.d.ts"]=!0,w["lib.es2019.d.ts"]=!0,w["lib.es2019.full.d.ts"]=!0,w["lib.es2019.object.d.ts"]=!0,w["lib.es2019.string.d.ts"]=!0,w["lib.es2019.symbol.d.ts"]=!0,w["lib.es2020.bigint.d.ts"]=!0,w["lib.es2020.d.ts"]=!0,w["lib.es2020.full.d.ts"]=!0,w["lib.es2020.intl.d.ts"]=!0,w["lib.es2020.promise.d.ts"]=!0,w["lib.es2020.sharedmemory.d.ts"]=!0,w["lib.es2020.string.d.ts"]=!0,w["lib.es2020.symbol.wellknown.d.ts"]=!0,w["lib.es2021.d.ts"]=!0,w["lib.es2021.full.d.ts"]=!0,w["lib.es2021.intl.d.ts"]=!0,w["lib.es2021.promise.d.ts"]=!0,w["lib.es2021.string.d.ts"]=!0,w["lib.es2021.weakref.d.ts"]=!0,w["lib.es5.d.ts"]=!0,w["lib.es6.d.ts"]=!0,w["lib.esnext.d.ts"]=!0,w["lib.esnext.full.d.ts"]=!0,w["lib.esnext.intl.d.ts"]=!0,w["lib.esnext.promise.d.ts"]=!0,w["lib.esnext.string.d.ts"]=!0,w["lib.esnext.weakref.d.ts"]=!0,w["lib.scripthost.d.ts"]=!0,w["lib.webworker.d.ts"]=!0,w["lib.webworker.importscripts.d.ts"]=!0,w["lib.webworker.iterable.d.ts"]=!0;var v=class{constructor(e){this._worker=e}_textSpanToRange(e,t){let i=e.getPositionAt(t.start),r=e.getPositionAt(t.start+t.length),{lineNumber:s,column:n}=i,{lineNumber:a,column:o}=r;return{startLineNumber:s,startColumn:n,endLineNumber:a,endColumn:o}}},k=class{constructor(e){this._worker=e,this._libFiles={},this._hasFetchedLibFiles=!1,this._fetchLibFilesPromise=null}_libFiles;_hasFetchedLibFiles;_fetchLibFilesPromise;isLibFile(e){return!(!e||0!==e.path.indexOf("/lib.")||!w[e.path.slice(1)])}getOrCreateModel(e){let t=h.Uri.parse(e),i=h.editor.getModel(t);if(i)return i;if(this.isLibFile(t)&&this._hasFetchedLibFiles)return h.editor.createModel(this._libFiles[t.path.slice(1)],"typescript",t);let r=y.typescriptDefaults.getExtraLibs()[e];return r?h.editor.createModel(r.content,"typescript",t):null}_containsLibFile(e){for(let t of e)if(this.isLibFile(t))return!0;return!1}async fetchLibFilesIfNecessary(e){!this._containsLibFile(e)||await this._fetchLibFiles()}_fetchLibFiles(){return this._fetchLibFilesPromise||(this._fetchLibFilesPromise=this._worker().then((e=>e.getLibFiles())).then((e=>{this._hasFetchedLibFiles=!0,this._libFiles=e}))),this._fetchLibFilesPromise}},C=class extends v{constructor(e,t,i,r){super(r),this._libFiles=e,this._defaults=t,this._selector=i;let s=e=>{if(e.getLanguageId()!==i)return;let t,r=()=>{let{onlyVisible:t}=this._defaults.getDiagnosticsOptions();t?e.isAttachedToEditor()&&this._doValidate(e):this._doValidate(e)},s=e.onDidChangeContent((()=>{clearTimeout(t),t=window.setTimeout(r,500)})),n=e.onDidChangeAttached((()=>{let{onlyVisible:t}=this._defaults.getDiagnosticsOptions();t&&(e.isAttachedToEditor()?r():h.editor.setModelMarkers(e,this._selector,[]))}));this._listener[e.uri.toString()]={dispose(){s.dispose(),n.dispose(),clearTimeout(t)}},r()},n=e=>{h.editor.setModelMarkers(e,this._selector,[]);let t=e.uri.toString();this._listener[t]&&(this._listener[t].dispose(),delete this._listener[t])};this._disposables.push(h.editor.onDidCreateModel((e=>s(e)))),this._disposables.push(h.editor.onWillDisposeModel(n)),this._disposables.push(h.editor.onDidChangeModelLanguage((e=>{n(e.model),s(e.model)}))),this._disposables.push({dispose(){for(let e of h.editor.getModels())n(e)}});let a=()=>{for(let e of h.editor.getModels())n(e),s(e)};this._disposables.push(this._defaults.onDidChange(a)),this._disposables.push(this._defaults.onDidExtraLibsChange(a)),h.editor.getModels().forEach((e=>s(e)))}_disposables=[];_listener=Object.create(null);dispose(){this._disposables.forEach((e=>e&&e.dispose())),this._disposables=[]}async _doValidate(e){let t=await this._worker(e.uri);if(e.isDisposed())return;let i=[],{noSyntaxValidation:r,noSemanticValidation:s,noSuggestionDiagnostics:n}=this._defaults.getDiagnosticsOptions();r||i.push(t.getSyntacticDiagnostics(e.uri.toString())),s||i.push(t.getSemanticDiagnostics(e.uri.toString())),n||i.push(t.getSuggestionDiagnostics(e.uri.toString()));let a=await Promise.all(i);if(!a||e.isDisposed())return;let o=a.reduce(((e,t)=>t.concat(e)),[]).filter((e=>-1===(this._defaults.getDiagnosticsOptions().diagnosticCodesToIgnore||[]).indexOf(e.code))),l=o.map((e=>e.relatedInformation||[])).reduce(((e,t)=>t.concat(e)),[]).map((e=>e.file?h.Uri.parse(e.file.fileName):null));await this._libFiles.fetchLibFilesIfNecessary(l),!e.isDisposed()&&h.editor.setModelMarkers(e,this._selector,o.map((t=>this._convertDiagnostics(e,t))))}_convertDiagnostics(e,t){let i=t.start||0,r=t.length||1,{lineNumber:s,column:n}=e.getPositionAt(i),{lineNumber:a,column:o}=e.getPositionAt(i+r),l=[];return t.reportsUnnecessary&&l.push(h.MarkerTag.Unnecessary),t.reportsDeprecated&&l.push(h.MarkerTag.Deprecated),{severity:this._tsDiagnosticCategoryToMarkerSeverity(t.category),startLineNumber:s,startColumn:n,endLineNumber:a,endColumn:o,message:S(t.messageText,"\n"),code:t.code.toString(),tags:l,relatedInformation:this._convertRelatedInformation(e,t.relatedInformation)}}_convertRelatedInformation(e,t){if(!t)return[];let i=[];return t.forEach((t=>{let r=e;if(t.file&&(r=this._libFiles.getOrCreateModel(t.file.fileName)),!r)return;let s=t.start||0,n=t.length||1,{lineNumber:a,column:o}=r.getPositionAt(s),{lineNumber:l,column:d}=r.getPositionAt(s+n);i.push({resource:r.uri,startLineNumber:a,startColumn:o,endLineNumber:l,endColumn:d,message:S(t.messageText,"\n")})})),i}_tsDiagnosticCategoryToMarkerSeverity(e){switch(e){case 1:return h.MarkerSeverity.Error;case 3:return h.MarkerSeverity.Info;case 0:return h.MarkerSeverity.Warning;case 2:return h.MarkerSeverity.Hint}return h.MarkerSeverity.Info}},D=class extends v{get triggerCharacters(){return["."]}async provideCompletionItems(e,t,i,r){let s=e.getWordUntilPosition(t),n=new h.Range(t.lineNumber,s.startColumn,t.lineNumber,s.endColumn),a=e.uri,o=e.getOffsetAt(t),l=await this._worker(a);if(e.isDisposed())return;let d=await l.getCompletionsAtPosition(a.toString(),o);return!d||e.isDisposed()?void 0:{suggestions:d.entries.map((i=>{let r=n;if(i.replacementSpan){let t=e.getPositionAt(i.replacementSpan.start),s=e.getPositionAt(i.replacementSpan.start+i.replacementSpan.length);r=new h.Range(t.lineNumber,t.column,s.lineNumber,s.column)}let s=[];return-1!==i.kindModifiers?.indexOf("deprecated")&&s.push(h.languages.CompletionItemTag.Deprecated),{uri:a,position:t,offset:o,range:r,label:i.name,insertText:i.name,sortText:i.sortText,kind:D.convertKind(i.kind),tags:s}}))}}async resolveCompletionItem(e,t){let i=e,r=i.uri,s=i.position,n=i.offset,a=await(await this._worker(r)).getCompletionEntryDetails(r.toString(),n,i.label);return a?{uri:r,position:s,label:a.name,kind:D.convertKind(a.kind),detail:x(a.displayParts),documentation:{value:D.createDocumentationString(a)}}:i}static convertKind(e){switch(e){case N.primitiveType:case N.keyword:return h.languages.CompletionItemKind.Keyword;case N.variable:case N.localVariable:return h.languages.CompletionItemKind.Variable;case N.memberVariable:case N.memberGetAccessor:case N.memberSetAccessor:return h.languages.CompletionItemKind.Field;case N.function:case N.memberFunction:case N.constructSignature:case N.callSignature:case N.indexSignature:return h.languages.CompletionItemKind.Function;case N.enum:return h.languages.CompletionItemKind.Enum;case N.module:return h.languages.CompletionItemKind.Module;case N.class:return h.languages.CompletionItemKind.Class;case N.interface:return h.languages.CompletionItemKind.Interface;case N.warning:return h.languages.CompletionItemKind.File}return h.languages.CompletionItemKind.Property}static createDocumentationString(e){let t=x(e.documentation);if(e.tags)for(let i of e.tags)t+=`\n\n${A(i)}`;return t}};function A(e){let t=`*@${e.name}*`;if("param"===e.name&&e.text){let[i,...r]=e.text;t+=`\`${i.text}\``,r.length>0&&(t+=` — ${r.map((e=>e.text)).join(" ")}`)}else Array.isArray(e.text)?t+=` — ${e.text.map((e=>e.text)).join(" ")}`:e.text&&(t+=` — ${e.text}`);return t}var F=class extends v{signatureHelpTriggerCharacters=["(",","];static _toSignatureHelpTriggerReason(e){switch(e.triggerKind){case h.languages.SignatureHelpTriggerKind.TriggerCharacter:return e.triggerCharacter?e.isRetrigger?{kind:"retrigger",triggerCharacter:e.triggerCharacter}:{kind:"characterTyped",triggerCharacter:e.triggerCharacter}:{kind:"invoked"};case h.languages.SignatureHelpTriggerKind.ContentChange:return e.isRetrigger?{kind:"retrigger"}:{kind:"invoked"};case h.languages.SignatureHelpTriggerKind.Invoke:default:return{kind:"invoked"}}}async provideSignatureHelp(e,t,i,r){let s=e.uri,n=e.getOffsetAt(t),a=await this._worker(s);if(e.isDisposed())return;let o=await a.getSignatureHelpItems(s.toString(),n,{triggerReason:F._toSignatureHelpTriggerReason(r)});if(!o||e.isDisposed())return;let l={activeSignature:o.selectedItemIndex,activeParameter:o.argumentIndex,signatures:[]};return o.items.forEach((e=>{let t={label:"",parameters:[]};t.documentation={value:x(e.documentation)},t.label+=x(e.prefixDisplayParts),e.parameters.forEach(((i,r,s)=>{let n=x(i.displayParts),a={label:n,documentation:{value:x(i.documentation)}};t.label+=n,t.parameters.push(a),r<s.length-1&&(t.label+=x(e.separatorDisplayParts))})),t.label+=x(e.suffixDisplayParts),l.signatures.push(t)})),{value:l,dispose(){}}}},I=class extends v{async provideHover(e,t,i){let r=e.uri,s=e.getOffsetAt(t),n=await this._worker(r);if(e.isDisposed())return;let a=await n.getQuickInfoAtPosition(r.toString(),s);if(!a||e.isDisposed())return;let o=x(a.documentation),l=a.tags?a.tags.map((e=>A(e))).join("  \n\n"):"",d=x(a.displayParts);return{range:this._textSpanToRange(e,a.textSpan),contents:[{value:"```typescript\n"+d+"\n```\n"},{value:o+(l?"\n\n"+l:"")}]}}},L=class extends v{async provideDocumentHighlights(e,t,i){let r=e.uri,s=e.getOffsetAt(t),n=await this._worker(r);if(e.isDisposed())return;let a=await n.getOccurrencesAtPosition(r.toString(),s);return a&&!e.isDisposed()?a.map((t=>({range:this._textSpanToRange(e,t.textSpan),kind:t.isWriteAccess?h.languages.DocumentHighlightKind.Write:h.languages.DocumentHighlightKind.Text}))):void 0}},P=class extends v{constructor(e,t){super(t),this._libFiles=e}async provideDefinition(e,t,i){let r=e.uri,s=e.getOffsetAt(t),n=await this._worker(r);if(e.isDisposed())return;let a=await n.getDefinitionAtPosition(r.toString(),s);if(!a||e.isDisposed()||(await this._libFiles.fetchLibFilesIfNecessary(a.map((e=>h.Uri.parse(e.fileName)))),e.isDisposed()))return;let o=[];for(let e of a){let t=this._libFiles.getOrCreateModel(e.fileName);t&&o.push({uri:t.uri,range:this._textSpanToRange(t,e.textSpan)})}return o}},O=class extends v{constructor(e,t){super(t),this._libFiles=e}async provideReferences(e,t,i,r){let s=e.uri,n=e.getOffsetAt(t),a=await this._worker(s);if(e.isDisposed())return;let o=await a.getReferencesAtPosition(s.toString(),n);if(!o||e.isDisposed()||(await this._libFiles.fetchLibFilesIfNecessary(o.map((e=>h.Uri.parse(e.fileName)))),e.isDisposed()))return;let l=[];for(let e of o){let t=this._libFiles.getOrCreateModel(e.fileName);t&&l.push({uri:t.uri,range:this._textSpanToRange(t,e.textSpan)})}return l}},T=class extends v{async provideDocumentSymbols(e,t){let i=e.uri,r=await this._worker(i);if(e.isDisposed())return;let s=await r.getNavigationBarItems(i.toString());if(!s||e.isDisposed())return;let n=(t,i,r)=>{let s={name:i.text,detail:"",kind:M[i.kind]||h.languages.SymbolKind.Variable,range:this._textSpanToRange(e,i.spans[0]),selectionRange:this._textSpanToRange(e,i.spans[0]),tags:[]};if(r&&(s.containerName=r),i.childItems&&i.childItems.length>0)for(let e of i.childItems)n(t,e,s.name);t.push(s)},a=[];return s.forEach((e=>n(a,e))),a}},N=class{};m(N,"unknown",""),m(N,"keyword","keyword"),m(N,"script","script"),m(N,"module","module"),m(N,"class","class"),m(N,"interface","interface"),m(N,"type","type"),m(N,"enum","enum"),m(N,"variable","var"),m(N,"localVariable","local var"),m(N,"function","function"),m(N,"localFunction","local function"),m(N,"memberFunction","method"),m(N,"memberGetAccessor","getter"),m(N,"memberSetAccessor","setter"),m(N,"memberVariable","property"),m(N,"constructorImplementation","constructor"),m(N,"callSignature","call"),m(N,"indexSignature","index"),m(N,"constructSignature","construct"),m(N,"parameter","parameter"),m(N,"typeParameter","type parameter"),m(N,"primitiveType","primitive type"),m(N,"label","label"),m(N,"alias","alias"),m(N,"const","const"),m(N,"let","let"),m(N,"warning","warning");var M=Object.create(null);M[N.module]=h.languages.SymbolKind.Module,M[N.class]=h.languages.SymbolKind.Class,M[N.enum]=h.languages.SymbolKind.Enum,M[N.interface]=h.languages.SymbolKind.Interface,M[N.memberFunction]=h.languages.SymbolKind.Method,M[N.memberVariable]=h.languages.SymbolKind.Property,M[N.memberGetAccessor]=h.languages.SymbolKind.Property,M[N.memberSetAccessor]=h.languages.SymbolKind.Property,M[N.variable]=h.languages.SymbolKind.Variable,M[N.const]=h.languages.SymbolKind.Variable,M[N.localVariable]=h.languages.SymbolKind.Variable,M[N.variable]=h.languages.SymbolKind.Variable,M[N.function]=h.languages.SymbolKind.Function,M[N.localFunction]=h.languages.SymbolKind.Function;var K,R,E=class extends v{static _convertOptions(e){return{ConvertTabsToSpaces:e.insertSpaces,TabSize:e.tabSize,IndentSize:e.tabSize,IndentStyle:2,NewLineCharacter:"\n",InsertSpaceAfterCommaDelimiter:!0,InsertSpaceAfterSemicolonInForStatements:!0,InsertSpaceBeforeAndAfterBinaryOperators:!0,InsertSpaceAfterKeywordsInControlFlowStatements:!0,InsertSpaceAfterFunctionKeywordForAnonymousFunctions:!0,InsertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis:!1,InsertSpaceAfterOpeningAndBeforeClosingNonemptyBrackets:!1,InsertSpaceAfterOpeningAndBeforeClosingTemplateStringBraces:!1,PlaceOpenBraceOnNewLineForControlBlocks:!1,PlaceOpenBraceOnNewLineForFunctions:!1}}_convertTextChanges(e,t){return{text:t.newText,range:this._textSpanToRange(e,t.span)}}},H=class extends E{async provideDocumentRangeFormattingEdits(e,t,i,r){let s=e.uri,n=e.getOffsetAt({lineNumber:t.startLineNumber,column:t.startColumn}),a=e.getOffsetAt({lineNumber:t.endLineNumber,column:t.endColumn}),o=await this._worker(s);if(e.isDisposed())return;let l=await o.getFormattingEditsForRange(s.toString(),n,a,E._convertOptions(i));return l&&!e.isDisposed()?l.map((t=>this._convertTextChanges(e,t))):void 0}},W=class extends E{get autoFormatTriggerCharacters(){return[";","}","\n"]}async provideOnTypeFormattingEdits(e,t,i,r,s){let n=e.uri,a=e.getOffsetAt(t),o=await this._worker(n);if(e.isDisposed())return;let l=await o.getFormattingEditsAfterKeystroke(n.toString(),a,i,E._convertOptions(r));return l&&!e.isDisposed()?l.map((t=>this._convertTextChanges(e,t))):void 0}},V=class extends E{async provideCodeActions(e,t,i,r){let s=e.uri,n=e.getOffsetAt({lineNumber:t.startLineNumber,column:t.startColumn}),a=e.getOffsetAt({lineNumber:t.endLineNumber,column:t.endColumn}),o=E._convertOptions(e.getOptions()),l=i.markers.filter((e=>e.code)).map((e=>e.code)).map(Number),d=await this._worker(s);if(e.isDisposed())return;let u=await d.getCodeFixesAtPosition(s.toString(),n,a,l,o);return!u||e.isDisposed()?{actions:[],dispose:()=>{}}:{actions:u.filter((e=>0===e.changes.filter((e=>e.isNewFile)).length)).map((t=>this._tsCodeFixActionToMonacoCodeAction(e,i,t))),dispose:()=>{}}}_tsCodeFixActionToMonacoCodeAction(e,t,i){let r=[];for(let t of i.changes)for(let i of t.textChanges)r.push({resource:e.uri,edit:{range:this._textSpanToRange(e,i.span),text:i.newText}});return{title:i.description,edit:{edits:r},diagnostics:t.markers,kind:"quickfix"}}},j=class extends v{constructor(e,t){super(t),this._libFiles=e}async provideRenameEdits(e,t,i,r){let s=e.uri,n=s.toString(),a=e.getOffsetAt(t),o=await this._worker(s);if(e.isDisposed())return;let l=await o.getRenameInfo(n,a,{allowRenameOfImportPath:!1});if(!1===l.canRename)return{edits:[],rejectReason:l.localizedErrorMessage};if(void 0!==l.fileToRename)throw new Error("Renaming files is not supported.");let d=await o.findRenameLocations(n,a,!1,!1,!1);if(!d||e.isDisposed())return;let u=[];for(let e of d){let t=this._libFiles.getOrCreateModel(e.fileName);if(!t)throw new Error(`Unknown file ${e.fileName}.`);u.push({resource:t.uri,edit:{range:this._textSpanToRange(t,e.textSpan),text:i}})}return{edits:u}}},B=class extends v{async provideInlayHints(e,t,i){let r=e.uri,s=r.toString(),n=e.getOffsetAt({lineNumber:t.startLineNumber,column:t.startColumn}),a=e.getOffsetAt({lineNumber:t.endLineNumber,column:t.endColumn}),o=await this._worker(r);return e.isDisposed()?null:{hints:(await o.provideInlayHints(s,n,a)).map((t=>({...t,label:t.text,position:e.getPositionAt(t.position),kind:this._convertHintKind(t.kind)}))),dispose:()=>{}}}_convertHintKind(e){return"Parameter"===e?h.languages.InlayHintKind.Parameter:h.languages.InlayHintKind.Type}};function U(e){R=G(e,"typescript")}function $(e){K=G(e,"javascript")}function z(){return new Promise(((e,t)=>{if(!K)return t("JavaScript not registered!");e(K)}))}function q(){return new Promise(((e,t)=>{if(!R)return t("TypeScript not registered!");e(R)}))}function G(e,t){let i=new _(t,e),r=(...e)=>i.getLanguageServiceWorker(...e),s=new k(r);return h.languages.registerCompletionItemProvider(t,new D(r)),h.languages.registerSignatureHelpProvider(t,new F(r)),h.languages.registerHoverProvider(t,new I(r)),h.languages.registerDocumentHighlightProvider(t,new L(r)),h.languages.registerDefinitionProvider(t,new P(s,r)),h.languages.registerReferenceProvider(t,new O(s,r)),h.languages.registerDocumentSymbolProvider(t,new T(r)),h.languages.registerDocumentRangeFormattingEditProvider(t,new H(r)),h.languages.registerOnTypeFormattingEditProvider(t,new W(r)),h.languages.registerCodeActionProvider(t,new V(r)),h.languages.registerRenameProvider(t,new j(s,r)),h.languages.registerInlayHintsProvider(t,new B(r)),new C(s,e,t,r),r}return p(b)})()));