import{r as e,h as t}from"./p-ee0b9025.js";import{S as r}from"./p-c74b54ba.js";let s=class{constructor(t){e(this,t)}componentWillLoad(){this.currentValue=this.propertyModel.expressions[this.propertyDescriptor.defaultSyntax||r.Literal]||void 0}getEditorHeight(e){return"Large"===(e.editorHeight||"Default")?{propertyEditor:"20em",textArea:6}:{propertyEditor:"15em",textArea:3}}onChange(e){this.propertyModel.expressions.Literal=this.currentValue=e.currentTarget.value}onDefaultSyntaxValueChanged(e){this.currentValue=e.detail}render(){const e=this.propertyDescriptor,r=this.propertyModel,o=e.name,a=e.options||{},s=this.getEditorHeight(a),i=a.context,l=o,n=o;let p=this.currentValue;if(null==p){const e=this.propertyDescriptor.defaultValue;p=e?e.toString():void 0}return t("elsa-property-editor",{activityModel:this.activityModel,propertyDescriptor:e,propertyModel:r,onDefaultSyntaxValueChanged:e=>this.onDefaultSyntaxValueChanged(e),"editor-height":s.propertyEditor,context:i},t("textarea",{id:l,name:n,value:p,onChange:e=>this.onChange(e),class:"focus:elsa-ring-blue-500 focus:elsa-border-blue-500 elsa-block elsa-w-full elsa-min-w-0 elsa-rounded-md sm:elsa-text-sm elsa-border-gray-300",rows:s.textArea}))}};export{s as elsa_multi_line_property};