<template>
  <Modal v-model="curValue" :title="title" :loading="true">
    <Form
      ref="form"
      :model="form"
      label-position="right"
      :label-width="150"
      :rules="rules"
    >
      <FormItem label="角色" prop="userRoles">
        <Select
          multiple
          title="角色授权"
          v-model="cur_roles"
          style="width: 250px"
        >
          <Option v-for="n in roleList" :value="n.code" :key="n.code">
            {{ n.name }}
          </Option>
        </Select>
      </FormItem>
    </Form>
    <div slot="footer">
      <Button type="primary" @click="hdlSubmit('form')">确认 </Button>
      <Button style="margin-left: 8px" @click="hdlCancel">返回</Button>
    </div>
  </Modal>
</template>

<script>
import { grantUserRoles } from "@/api";
const _config = {
  title: "角色授权",
  success_evt: "on-user-grant-role",
  submit: grantUserRoles
};
export default {
  name: "user-grant",
  props: {
    value: Boolean,
    roleList: {
      type: Array,
      default: () => {
        return [];
      }
    }
  },
  computed: {
    title() {
      return _config.title;
    }
  },
  data() {
    return {
      curValue: false,
      form: {
        userRoles: []
      },
      cur_roles: [],
      rules: {
        userRoles: [
          {
            required: true,
            type: "array",
            message: "角色不能为空",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    setData(data) {
      this.cur_roles = data.userRoles;
      this.form.userAccount = data.userAccount;
      this.form.userName = data.userName;
    },

    hdlSubmit(name) {
      this.$refs[name].validate(valid => {
        if (valid) {
          _config.submit(this.form).then(() => {
            this.curValue = false;
            this.$emit(_config.success_evt, this.form);
          });
        }
      });
    },
    hdlCancel() {
      this.curValue = false;
      this.$emit("on-cancel");
    },
    reset() {
      this.form = {
        userRoles: [],
        userAccount: "",
        userName: ""
      };
    }
  },
  watch: {
    value: {
      handler(newValue) {
        this.curValue = newValue;
      },
      immediate: true
    },
    curValue(newValue) {
      this.$emit("input", newValue);
      !newValue && this.reset();
    },
    cur_roles(newValue) {
      this.form.userRoles = this.roleList
        .filter(n => {
          return newValue.includes(n.code);
        })
        .map(n => {
          return { roleCode: n.code, roleName: n.name };
        });
    }
  }
};
</script>
