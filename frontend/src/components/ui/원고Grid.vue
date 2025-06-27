<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="registManuscriptDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>원고 등록
                </v-btn>
                <v-dialog v-model="registManuscriptDialog" width="500">
                    <RegistManuscript
                        @closeDialog="registManuscriptDialog = false"
                        @registManuscript="registManuscript"
                    ></RegistManuscript>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="requestPublishDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 요청 
                </v-btn>
                <v-dialog v-model="requestPublishDialog" width="500">
                    <RequestPublish
                        @closeDialog="requestPublishDialog = false"
                        @requestPublish="requestPublish"
                    ></RequestPublish>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="editManuscriptDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>원고 편집
                </v-btn>
                <v-dialog v-model="editManuscriptDialog" width="500">
                    <EditManuscript
                        @closeDialog="editManuscriptDialog = false"
                        @editManuscript="editManuscript"
                    ></EditManuscript>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="deleteManuscriptDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>원고 삭제 
                </v-btn>
                <v-dialog v-model="deleteManuscriptDialog" width="500">
                    <DeleteManuscript
                        @closeDialog="deleteManuscriptDialog = false"
                        @deleteManuscript="deleteManuscript"
                    ></DeleteManuscript>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="saveManuscriptDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>원고 저장
                </v-btn>
                <v-dialog v-model="saveManuscriptDialog" width="500">
                    <SaveManuscript
                        @closeDialog="saveManuscriptDialog = false"
                        @saveManuscript="saveManuscript"
                    ></SaveManuscript>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Date</th>
                        <th>AuthorName</th>
                        <th>Contents</th>
                        <th>Status</th>
                        <th>Type</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Title">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="Date">{{ val.date }}</td>
                            <td class="whitespace-nowrap" label="AuthorName">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="Contents">{{ val.contents }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="Type">{{ val.type }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">원고 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <원고 :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">원고 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="Title" v-model="selectedRow.title" :editMode="true"/>
                            <String label="Date" v-model="selectedRow.date" :editMode="true"/>
                            <String label="AuthorName" v-model="selectedRow.authorName" :editMode="true"/>
                            <String label="Contents" v-model="selectedRow.contents" :editMode="true"/>
                            <String label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <String label="Type" v-model="selectedRow.type" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: '원고Grid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: '원고',
        registManuscriptDialog: false,
        requestPublishDialog: false,
        editManuscriptDialog: false,
        deleteManuscriptDialog: false,
        saveManuscriptDialog: false,
    }),
    watch: {
    },
    methods:{
        async registManuscript(params){
            try{
                var path = "registManuscript".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RegistManuscript 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.registManuscriptDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestPublish(params){
            try{
                var path = "requestPublish".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestPublish 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestPublishDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async editManuscript(params){
            try{
                var path = "editManuscript".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','EditManuscript 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.editManuscriptDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deleteManuscript(params){
            try{
                var path = "deleteManuscript".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeleteManuscript 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deleteManuscriptDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async saveManuscript(params){
            try{
                var path = "saveManuscript".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','SaveManuscript 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.saveManuscriptDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>