function t(e,t,r,n){return new(r||(r=Promise))((function(i,o){function s(e){try{c(n.next(e))}catch(e){o(e)}}function a(e){try{c(n.throw(e))}catch(e){o(e)}}function c(e){var t;e.done?i(e.value):(t=e.value,t instanceof r?t:new r((function(e){e(t)}))).then(s,a)}c((n=n.apply(e,t||[])).next())}))}function e(e,t){var r,n,i,o,s={label:0,sent:function(){if(1&i[0])throw i[1];return i[1]},trys:[],ops:[]};return o={next:a(0),throw:a(1),return:a(2)},"function"==typeof Symbol&&(o[Symbol.iterator]=function(){return this}),o;function a(o){return function(a){return function(o){if(r)throw new TypeError("Generator is already executing.");for(;s;)try{if(r=1,n&&(i=2&o[0]?n.return:o[0]?n.throw||((i=n.return)&&i.call(n),0):n.next)&&!(i=i.call(n,o[1])).done)return i;switch(n=0,i&&(o=[2&o[0],i.value]),o[0]){case 0:case 1:i=o;break;case 4:return s.label++,{value:o[1],done:!1};case 5:s.label++,n=o[1],o=[0];continue;case 7:o=s.ops.pop(),s.trys.pop();continue;default:if(!((i=(i=s.trys).length>0&&i[i.length-1])||6!==o[0]&&2!==o[0])){s=0;continue}if(3===o[0]&&(!i||o[1]>i[0]&&o[1]<i[3])){s.label=o[1];break}if(6===o[0]&&s.label<i[1]){s.label=i[1],i=o;break}if(i&&s.label<i[2]){s.label=i[2],s.ops.push(o);break}i[2]&&s.ops.pop(),s.trys.pop();continue}o=t.call(e,s)}catch(e){o=[6,e],n=0}finally{r=i=0}if(5&o[0])throw o[1];return{value:o[0]?o[1]:void 0,done:!0}}([o,a])}}}var n=new Error("request for lock canceled"),r=function(){function r(e,t){if(void 0===t&&(t=n),this._maxConcurrency=e,this._cancelError=t,this._queue=[],this._waiters=[],e<=0)throw new Error("semaphore must be initialized to a positive value");this._value=e}return r.prototype.acquire=function(){var e=this,t=this.isLocked(),r=new Promise((function(t,r){return e._queue.push({resolve:t,reject:r})}));return t||this._dispatch(),r},r.prototype.runExclusive=function(r){return t(this,void 0,void 0,(function(){var t,n,i;return e(this,(function(e){switch(e.label){case 0:return[4,this.acquire()];case 1:t=e.sent(),n=t[0],i=t[1],e.label=2;case 2:return e.trys.push([2,,4,5]),[4,r(n)];case 3:return[2,e.sent()];case 4:return i(),[7];case 5:return[2]}}))}))},r.prototype.waitForUnlock=function(){return t(this,void 0,void 0,(function(){var t=this;return e(this,(function(){return this.isLocked()?[2,new Promise((function(e){return t._waiters.push({resolve:e})}))]:[2,Promise.resolve()]}))}))},r.prototype.isLocked=function(){return this._value<=0},r.prototype.release=function(){if(this._maxConcurrency>1)throw new Error("this method is unavailable on semaphores with concurrency > 1; use the scoped release returned by acquire instead");if(this._currentReleaser){var e=this._currentReleaser;this._currentReleaser=void 0,e()}},r.prototype.cancel=function(){var e=this;this._queue.forEach((function(t){return t.reject(e._cancelError)})),this._queue=[]},r.prototype._dispatch=function(){var e=this,t=this._queue.shift();if(t){var r=!1;this._currentReleaser=function(){r||(r=!0,e._value++,e._resolveWaiters(),e._dispatch())},t.resolve([this._value--,this._currentReleaser])}},r.prototype._resolveWaiters=function(){this._waiters.forEach((function(e){return e.resolve()})),this._waiters=[]},r}(),i=function(){function n(e){this._semaphore=new r(1,e)}return n.prototype.acquire=function(){return t(this,void 0,void 0,(function(){return e(this,(function(e){switch(e.label){case 0:return[4,this._semaphore.acquire()];case 1:return[2,e.sent()[1]]}}))}))},n.prototype.runExclusive=function(e){return this._semaphore.runExclusive((function(){return e()}))},n.prototype.isLocked=function(){return this._semaphore.isLocked()},n.prototype.waitForUnlock=function(){return this._semaphore.waitForUnlock()},n.prototype.release=function(){this._semaphore.release()},n.prototype.cancel=function(){return this._semaphore.cancel()},n}();const s=window,o=s.require;var c=[];let u;const a=new i;async function f(e){return await a.runExclusive((async()=>{if(u)return s.monaco;const t=document.location.origin,r=e.startsWith("http")?e:`${t}/${e}`;o.config({paths:{vs:`${r}/vs`}}),s.MonacoEnvironment={getWorkerUrl:()=>n};let n=URL.createObjectURL(new Blob([`\n\tself.MonacoEnvironment = {\n\t\tbaseUrl: '${r}'\n\t};\n\timportScripts('${r}/vs/base/worker/workerMain.js');\n`],{type:"text/javascript"}));return new Promise((e=>{o(["vs/editor/editor.main"],(()=>{var t;u=!0,(t=s.monaco).languages.register({id:"liquid"}),t.languages.registerCompletionItemProvider("liquid",{provideCompletionItems:()=>{const e=[],r=["assign","capture","endcapture","increment","decrement","if","else","elsif","endif","for","endfor","break","continue","limit","offset","range","reversed","cols","case","endcase","when","block","endblock","true","false","in","unless","endunless","cycle","tablerow","endtablerow","contains","startswith","endswith","comment","endcomment","raw","endraw","editable","endentitylist","endentityview","endinclude","endmarker","entitylist","entityview","forloop","image","include","marker","outputcache","plugin","style","text","widget","abs","append","at_least","at_most","capitalize","ceil","compact","concat","date","default","divided_by","downcase","escape","escape_once","first","floor","join","last","lstrip","map","minus","modulo","newline_to_br","plus","prepend","remove","remove_first","replace","replace_first","reverse","round","rstrip","size","slice","sort","sort_natural","split","strip","strip_html","strip_newlines","times","truncate","truncatewords","uniq","upcase","url_decode","url_encode"];for(let n=0;n<r.length;n++)e.push({label:r[n],kind:t.languages.CompletionItemKind.Keyword});return{suggestions:e}}}),function(e){e.languages.registerCompletionItemProvider("sql",{triggerCharacters:["@"],provideCompletionItems:(t,r)=>{t.getWordUntilPosition(r);const n=[];for(const t of c)n.push({label:`${t.variableName}: ${t.type}`,kind:e.languages.CompletionItemKind.Variable,insertText:t.variableName});return{suggestions:n}}})}(s.monaco),e(s.monaco)}))}))}))}export{c as E,f as i};