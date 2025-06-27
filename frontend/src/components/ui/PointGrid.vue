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
                <v-btn style="margin-left: 5px;" @click="registPointDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>신규 포인트 지급
                </v-btn>
                <v-dialog v-model="registPointDialog" width="500">
                    <RegistPoint
                        @closeDialog="registPointDialog = false"
                        @registPoint="registPoint"
                    ></RegistPoint>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="usePointDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 사용
                </v-btn>
                <v-dialog v-model="usePointDialog" width="500">
                    <UsePoint
                        @closeDialog="usePointDialog = false"
                        @usePoint="usePoint"
                    ></UsePoint>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="expirePointDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 소멸
                </v-btn>
                <v-dialog v-model="expirePointDialog" width="500">
                    <ExpirePoint
                        @closeDialog="expirePointDialog = false"
                        @expirePoint="expirePoint"
                    ></ExpirePoint>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Point</th>
                        <th>UserType</th>
                        <th>SubscriptionType</th>
                        <th>PointsDeadline</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Point">{{ val.point }}</td>
                            <td class="whitespace-nowrap" label="UserType">{{ val.userType }}</td>
                            <td class="whitespace-nowrap" label="SubscriptionType">{{ val.subscriptionType }}</td>
                            <td class="whitespace-nowrap" label="PointsDeadline">{{ val.pointsDeadline }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Point 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Point :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Point 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="UserId" v-model="selectedRow.userId" :editMode="true"/>
                            <Number label="Point" v-model="selectedRow.point" :editMode="true"/>
                            <String label="UserType" v-model="selectedRow.userType" :editMode="true"/>
                            <Date label="PointsDeadline" v-model="selectedRow.pointsDeadline" :editMode="true"/>
                            <SubscriptionType offline label="SubscriptionType" v-model="selectedRow.subscriptionType" :editMode="true"/>
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
    name: 'pointGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'points',
        registPointDialog: false,
        usePointDialog: false,
        expirePointDialog: false,
    }),
    watch: {
    },
    methods:{
        async registPoint(params){
            try{
                var path = "registPoint".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RegistPoint 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.registPointDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async usePoint(params){
            try{
                var path = "usePoint".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','UsePoint 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.usePointDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async expirePoint(params){
            try{
                var path = "expirePoint".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ExpirePoint 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.expirePointDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>