import{r as e,h as s,H as t}from"./p-ee0b9025.js";import{l as a}from"./p-6137089a.js";import"./p-c74b54ba.js";import{a as i}from"./p-ccd51ea4.js";import"./p-971980b1.js";import"./p-82db2ff5.js";import"./p-949334ec.js";import{T as l}from"./p-821a7518.js";import"./p-e0c1fede.js";import"./p-f1ec68ec.js";import"./p-a3b5bd35.js";import"./p-80de33dc.js";import"./p-93cac3a6.js";import"./p-d88cb309.js";import"./p-83f217d4.js";const r={en:{default:{Name:"Name",Untitled:"Untitled",Id:"Id",Version:"Latest Version",PublishedVersion:"Published Version",Status:"Status",Published:"Published",Draft:"Draft",Properties:"{{name}} Properties"}},"zh-CN":{default:{Name:"名称",Untitled:"无题",Id:"Id",Version:"最新版本",PublishedVersion:"发布版本",Status:"状态",Published:"已发布",Draft:"草稿",Properties:"{{name}} 属性"}},"nl-NL":{default:{Name:"Naam",Untitled:"Untitled",Id:"Id",Version:"Laatste Versie",PublishedVersion:"Gepubliceerde Versie",Status:"Status",Published:"Published",Draft:"Draft",Properties:"{{name}} Properties"}},"fa-IR":{default:{Name:"عنوان",Untitled:"بی نام",Id:"شناسه",Version:"جدیدترین ویرایش",PublishedVersion:"ویرایش منتشر شده",Status:"وضعیت",Published:"منتشر شده",Draft:"پیش نویس",Properties:"{{name}} ویژگی های"}},"de-DE":{default:{Name:"Name",Untitled:"Unbenannt",Id:"Id",Version:"Neuste Version",PublishedVersion:"Veröffentlichte Version",Status:"Status",Published:"Veröffentlicht",Draft:"Entwurf",Properties:"{{name}} Eigenschaften"}}};let d=class{constructor(s){e(this,s)}async workflowIdChangedHandler(e){await this.loadWorkflowBlueprint(e),await this.loadPublishedVersion()}async componentWillLoad(){this.i18next=await a(this.culture,r),await this.loadWorkflowBlueprint(),await this.loadPublishedVersion()}render(){const e=(e,s)=>this.i18next.t(e,s),{workflowBlueprint:a}=this,i=a.name||this.i18next.t("Untitled"),{isPublished:l}=a;return s(t,null,s("dl",{class:"elsa-border-b elsa-border-gray-200 elsa-divide-y elsa-divide-gray-200"},s("div",{class:"elsa-py-3 elsa-flex elsa-justify-between elsa-text-sm elsa-font-medium"},s("dt",{class:"elsa-text-gray-500"},e("Name")),s("dd",{class:"elsa-text-gray-900"},i)),s("div",{class:"elsa-py-3 elsa-flex elsa-justify-between elsa-text-sm elsa-font-medium"},s("dt",{class:"elsa-text-gray-500"},e("Id")),s("dd",{class:"elsa-text-gray-900 elsa-break-all"},a.id||"-")),s("div",{class:"elsa-py-3 elsa-flex elsa-justify-between elsa-text-sm elsa-font-medium"},s("dt",{class:"elsa-text-gray-500"},e("Version")),s("dd",{class:"elsa-text-gray-900"},a.version)),s("div",{class:"elsa-py-3 elsa-flex elsa-justify-between elsa-text-sm elsa-font-medium"},s("dt",{class:"elsa-text-gray-500"},e("PublishedVersion")),s("dd",{class:"elsa-text-gray-900"},this.publishedVersion||"-")),s("div",{class:"elsa-py-3 elsa-flex elsa-justify-between elsa-text-sm elsa-font-medium"},s("dt",{class:"elsa-text-gray-500"},e("Status")),s("dd",{class:l?"elsa-text-green-600":"elsa-text-yellow-700"},e(l?"Published":"Draft")))))}createClient(){return i(this.serverUrl)}async loadPublishedVersion(){const e=await this.createClient(),{workflowBlueprint:s}=this;if(s.isPublished){const t=await e.workflowDefinitionsApi.getMany([s.id],{isPublished:!0}),a=s.isPublished?s:t.find((e=>e.definitionId==s.id));a&&(this.publishedVersion=a.version)}else this.publishedVersion=0}async loadWorkflowBlueprint(e=this.workflowId){const s=await this.createClient();this.workflowBlueprint=await s.workflowRegistryApi.get(e,{isLatest:!0})}static get watchers(){return{workflowId:["workflowIdChangedHandler"]}}};l.injectProps(d,["serverUrl","culture"]);export{d as elsa_workflow_blueprint_properties_panel};