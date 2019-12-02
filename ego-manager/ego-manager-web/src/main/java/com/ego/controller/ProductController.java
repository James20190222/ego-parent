package com.ego.controller;

import com.ego.pojo.*;
import com.ego.result.FileResult;
import com.ego.service.*;
import com.ego.vo.GoodsCategoryVo;
import com.ego.result.BaseResult;
import com.ego.vo.SpecOrAttributeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理controller
 * Created by James on 2019/3/25 0025.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private GoodsCategoryServiceI goodsCategoryService;//商品类别service

    @Autowired
    private FileUploadServiceI fileUploadService;//文件service

    @Autowired
    private BrandServiceI brandService;//商品品牌service

    @Autowired
    private GoodsServiceI goodsService; //商品service

    @Autowired
    private GoodsImagesServiceI goodsImagesService;//商品相册service

    @Autowired
    private GoodsTypeServiceI goodsTypeService;//商品模型service

    @Autowired
    private GoodsSpecServiceI goodsSpecService;//商品规格service

    @Autowired
    private GoodsAttributeServiceI goodsAttributeService;//商品新增--商品模型(类型)service

    @Autowired
    private GoodsAttrServiceI goodsAttrService;

    /**
     *  商品列表--商品模型--新增或更新
     * @param goodsAttrId   主键id
     * @param goodsId       商品id
     * @param attrId        商品属性id
     * @param specId        商品规格id
     * @param value         规格或属性的值
     * @param flag          属性或规格标识
     * @return
     */
    @RequestMapping("/attr/saveOrUpdate")
    @ResponseBody
    public BaseResult attrSaveOrUpdate(Integer goodsAttrId,Integer goodsId,Integer attrId,
                                       Integer specId,String value,String flag){

        GoodsAttrWithBLOBs gaw = null;
        //判断主键是否存在
        if(null !=goodsAttrId && 0!=goodsAttrId){
            gaw = goodsAttrService.goodsAttrById(goodsAttrId);
            //修改规格
            if("spec".equals(flag)){
                gaw.setSpecId(specId);
                gaw.setSpecValue(value);
            }

            //修改属性
            if("attribute".equals(flag)){
                gaw.setAttrId(attrId);
                gaw.setAttrValue(value);
            }

            return goodsAttrService.goodsAttrUpdate(gaw);
        }


            //如果对象不存在,说明是新增行为
            gaw = new GoodsAttrWithBLOBs();
            gaw.setGoodsId(goodsId);
            //新增规格
            if("spec".equals(flag)){
                gaw.setSpecId(specId);
                gaw.setSpecValue(value);
            }
            //新增属性
            if("attribute".equals(flag)){
                gaw.setAttrId(attrId);
                gaw.setAttrValue(value);
            }
        return goodsAttrService.goodsAttrSave(gaw);

    }


    //根据属性id查询属性值
    @RequestMapping("/goodsAttributeById")
    @ResponseBody
    public SpecOrAttributeVo goodsAttributeById(Integer id){
        if(id==0){
            return new SpecOrAttributeVo();
        }
        GoodsAttribute attribute = goodsAttributeService.selectGoodsAttributeByAttrId(id);
        SpecOrAttributeVo savo =null;
        if(null!=attribute){
            savo = new SpecOrAttributeVo();
            savo.setId(attribute.getAttrId());
            savo.setValue(attribute.getAttrValues().split("\r\n"));
        }
        return savo;
    }

    //根据规格id查询规格值
    @RequestMapping("/goodsSpecById")
    @ResponseBody
    public SpecOrAttributeVo goodsSpecById(Integer id){
        if(id==0){
            return new SpecOrAttributeVo();
        }
        GoodsSpec spec = goodsSpecService.selectGoodsSpecById(id);
        SpecOrAttributeVo savo =null;
        if(null!=spec){
            savo = new SpecOrAttributeVo();
            savo.setId(spec.getSpecId());
            savo.setValue(spec.getSpecValue().split("\r\n"));
        }
        return savo;
    }

    //根据模型(类型)id查询属性
    @RequestMapping("/attributeListByTypeId")
    @ResponseBody
    public List<GoodsAttribute> attributeListByTypeId(Short typeId){
        return goodsAttributeService.selectGoodsAttributeListByTypeId(typeId);
    }


    //根据模型(类型)id查询规格
    @RequestMapping("/specListByTypeId")
    @ResponseBody
    public List<GoodsSpec> specListByTypeId(Short typeId){
        return goodsSpecService.selectGoodsByTypeId(typeId);
    }

    //商品属性---删除
    @RequestMapping(value = "/attribute/delete/{attrId}",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult attributeDelete(@PathVariable("attrId") Integer attrId ){
        return  goodsAttributeService.goodsAttributeDelete(attrId);
    }

    //商品属性--更新保存
    @RequestMapping("/attribute/update")
    @ResponseBody
    public BaseResult attributeUpdate(GoodsAttribute goodsAttribute){
        return  goodsAttributeService.goodsAttributeUpdate(goodsAttribute);
    }

    //商品属性---更新页面
    @RequestMapping(value = "/attribute/edit/{attrId}",method =RequestMethod.GET)
    public String attributeEdit(@PathVariable("attrId") Integer attrId,Model model){
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        model.addAttribute("goodsAttribute",goodsAttributeService.selectGoodsAttributeByAttrId(attrId));
        return "/product/attribute/attribute-edit";
    }

    //商品属性--新增保存
    @RequestMapping("/attribute/save")
    @ResponseBody
    public BaseResult attributeSave(GoodsAttribute goodsAttribute){
        return goodsAttributeService.goodsAttributeSave(goodsAttribute);
    }

    //商品属性---新增页面
    @RequestMapping(value = "/attribute/add/{typeId}",method = RequestMethod.GET)
    public String attributeAdd(@PathVariable("typeId") Short typeId, Model model){
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        model.addAttribute("typeId",typeId);
        return "product/attribute/attribute-add";
    }

    //商品属性---所有列表
    @RequestMapping(value = "/attribute/list/{typeId}",method = RequestMethod.GET)
    public String attributeList(@PathVariable("typeId") Short typeId,Model model){
        model.addAttribute("typeId",typeId);
        if(0==typeId){
            model.addAttribute("goodsAttributeList",goodsAttributeService.selectGoodsAttributeList());
        }else{
            model.addAttribute("goodsAttributeList",goodsAttributeService.selectGoodsAttributeListByTypeId(typeId));
        }

        return "product/attribute/attribute-list";
    }

    //商品规格--删除
    @RequestMapping(value = "/spec/delete/{specId}",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult specDelete(@PathVariable("specId") Integer specId){
        return goodsSpecService.deleteGoodsSpecById(specId);
    }

    //商品规格--更新页面--保存
    @RequestMapping("/spec/update")
    @ResponseBody
    public BaseResult specUpdate(GoodsSpec goodsSpec){
        return goodsSpecService.goodsSpecUpdate(goodsSpec);
    }

    //商品规格--更新页面
    @RequestMapping(value = "/spec/edit/{specId}",method = RequestMethod.GET)
    public String specEdit(Model model,@PathVariable("specId")  Integer specId){
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        model.addAttribute("goodsSpec",goodsSpecService.selectGoodsSpecById(specId));
        return "/product/spec/spec-edit";
    }

    //商品规格--新增保存
    @RequestMapping("/spec/save")
    @ResponseBody
    public BaseResult specSave(GoodsSpec goodsSpec){
        return goodsSpecService.goodsSpecSave(goodsSpec);
    }

    //商品规格--新增页面
    @RequestMapping(value = "/spec/add/{typeId}",method = RequestMethod.GET)
    public String specAdd(@PathVariable("typeId") Short typeId, Model model){
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        model.addAttribute("typeId",typeId);
        return "product/spec/spec-add";
    }

    //商品规格--列表
    @RequestMapping("/spec/list/{typeId}")
    public String specList(@PathVariable("typeId") Short typeId,Model model){
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        model.addAttribute("typeId",typeId);
        if(0==typeId){
            model.addAttribute("goodsSpecList",goodsSpecService.selectGoodsTypeList());
        }else{
            model.addAttribute("goodsSpecList",goodsSpecService.selectGoodsByTypeId(typeId));
        }
        return "product/spec/spec-list";
    }

    //商品模型--删除
    @RequestMapping(value = "/type/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult typeDelete(@PathVariable("id") Short id){
        return  goodsTypeService.goodsTypeDelete(id);
    }

    //商品模型--编辑
    @RequestMapping(value = "/type/edit/{id}",method = RequestMethod.GET)
    public String typeEdit(@PathVariable("id") Short id,Model model ){
        model.addAttribute("goodsType",goodsTypeService.selectGoodsTypeById(id));
        return "product/type/type-edit";
    }

    //商品模型--修改保存
    @RequestMapping("/type/update")
    @ResponseBody
    public BaseResult typeUpdate(GoodsType goodsType){
        return goodsTypeService.goodsTypeUpdate(goodsType);
    }

    //商品模型新增保存
    @RequestMapping("/type/save")
    @ResponseBody
    public BaseResult typeSave(GoodsType goodsType){
        return goodsTypeService.goodsTypeSave(goodsType);
    }

    //商品模型新增页面
    @RequestMapping("/type/add")
    public String typeAdd(){
        return "product/type/type-add";
    }

    //商品模型列表页面
    @RequestMapping("/type/list")
    public String typeList(Model model){
        List<GoodsType> goodsTypeList = goodsTypeService.selectGoodsTypeList();
        model.addAttribute("goodsTypeList",goodsTypeList);
        return "product/type/type-list";
    }


    //商品新增--相册保存
    @RequestMapping("/goodsImages/save")
    @ResponseBody
    public BaseResult goodsImagesSave(MultipartFile file,Integer goodsId){

        BaseResult result=null;
        try {
            //上传相册图片
            FileResult  fileResult = fileUploadService.fileUpload(file.getOriginalFilename(), file.getInputStream());
            if("success".equals(fileResult.getSuccess())){
                //保存商品相册对象
                GoodsImages goodsImages = new GoodsImages();
                goodsImages.setGoodsId(goodsId);
                goodsImages.setImageUrl(fileResult.getFileUrl());
                result = goodsImagesService.goodsImagesSave(goodsImages);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    //商品新增--保存
    @RequestMapping("/save")
    @ResponseBody
    public BaseResult productSave(Goods goods){
        return  goodsService.goodsSave(goods);
    }

    //商品列表
    @RequestMapping("/list")
    public String productList(Model model){
        //查询所有商品分类
        model.addAttribute("gcList",goodsCategoryService.selectCateListForGoodsList());
        //查询所有品牌
        model.addAttribute("brandList",brandService.selectBrandList());
        return "product/product-list";
    }

    //商品列表--分页查询
    @RequestMapping("/list/page")
    @ResponseBody
    public BaseResult productListPage(Goods goods,Integer pageNum,Integer pageSize){
        return goodsService.selectGoodsList(goods,pageNum,pageSize);
    }

    //商品列表--新增
    @RequestMapping("/add")
    public String productAdd(Model model){
        //查询商品一级分类
        model.addAttribute("gcList",goodsCategoryService.selectTopCategory());
        //查询品牌
        model.addAttribute("brandList",brandService.selectBrandList());
        //查询模型(类型)List
        model.addAttribute("goodsTypeList",goodsTypeService.selectGoodsTypeList());
        return "product/product-add";
    }

    //商品分类--编辑后保存
    @RequestMapping(value="/category/update" ,method = RequestMethod.POST)
    @ResponseBody
    public BaseResult categoryUpdate(GoodsCategoryVo goodsCategoryVo){
        GoodsCategory gc=new GoodsCategory();
        //拷贝属性
        BeanUtils.copyProperties(goodsCategoryVo,gc);
           //判断是否上传了新图片
        if(null!=goodsCategoryVo.getUpdateImage() && goodsCategoryVo.getUpdateImage().trim().length()>0){
            gc.setImage(goodsCategoryVo.getUpdateImage());
            //修改
            BaseResult result = goodsCategoryService.categoryUpdate(gc);
            //删除旧文件
            if(200==result.getCode()){
                fileUploadService.fileDelete(goodsCategoryVo.getImage());
            }
            return result;
        }
        //修改
        return goodsCategoryService.categoryUpdate(gc);

    }


    /*商品分类---编辑*/
    /*
    *  思路:
    *   1.构建编辑页面,拷贝新增页面
    *   2.根据主键查询商品分类信息,回显至页面
    *   3.回显级联菜单
    *       如果是一级菜单,进入页面只需要查询一级菜单
    *       如果是二级菜单,进入页面需要查询一级和二级菜单,回显一级菜单
    *       如果是三级菜单,进入页面需要查询一级和二级菜单,回显一级和二级菜单
    *   4.如果有图片回显图片,上传了新图片,删除旧图片
    *   5.保存
    * */
    @RequestMapping(value="/category/edit/{id}",method = RequestMethod.GET )
    public String categoryEdit(@PathVariable("id") Short id,Model model){
        //查询当前选中行的商品分类信息,并存放到视图中
        GoodsCategory gc = goodsCategoryService.selectCategoryById(id);
        model.addAttribute("gc",gc);
        //回显级联菜单
        //一级菜单必查
        model.addAttribute("gcList1", goodsCategoryService.selectTopCategory());
        //二级,并返回parentId
        if(2==gc.getLevel()){
            //查询二级菜单
            model.addAttribute("gcList2",goodsCategoryService.selectCategoryGetByParentId(gc.getParentId()));
            model.addAttribute("gcParentId1",gc.getParentId());
        }
        if(3==gc.getLevel()){
            //查询二级菜单
            model.addAttribute("gcList2",goodsCategoryService.selectCategoryGetByParentId(goodsCategoryService.selectCategoryById(gc.getParentId()).getParentId()));
            model.addAttribute("gcParentId1",goodsCategoryService.selectCategoryById(gc.getParentId()).getParentId());
        }
        return "product/category/category-edit";
    }

    //商品分类删除
    @RequestMapping(value="/category/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult categoryDelete(@PathVariable("id") Short id){
        //根据id查询分类
        GoodsCategory gc = goodsCategoryService.selectCategoryById(id);
        if(null==gc){
            return BaseResult.error();
        }
        //判断是第几级分类
        //直接选择一级分类
        if(1==gc.getLevel()){
            //查询所有二级分类
            List<GoodsCategory> gcList2 = goodsCategoryService.selectCategoryGetByParentId(id);
            //循环查询所有分类
            if (null!=gcList2 && !gcList2.isEmpty()) {
                for(int i=0;i<gcList2.size();i++){
                    List<GoodsCategory> gcList3 = goodsCategoryService.selectCategoryGetByParentId(gcList2.get(i).getId());
                    if(null!=gcList3 && !gcList3.isEmpty()){
                        for(int j=0;j<gcList3.size();j++){
                            //如果image有值,删除ftpe文件服务器文件
                            fileDel(gcList3.get(j));
                        }
                        //获取三级分类ids数组
                        Short[] ids3 = getCategoryIds(gcList3);
                        //删除三级分类
                        goodsCategoryService.categoryBatchDelete(ids3);
                    }
                    //如果image有值,删除ftpe文件服务器文件
                    fileDel(gcList2.get(i));
                }
                Short[] ids2 = getCategoryIds(gcList2);
                //删除二级分类
                goodsCategoryService.categoryBatchDelete(ids2);
            }
            }

        //直接选择二级分类
        if(2==gc.getLevel()){
            //查询所有三级分类
            List<GoodsCategory> gcList3 = goodsCategoryService.selectCategoryGetByParentId(id);
            if(null!=gcList3 && !gcList3.isEmpty()){
                for(int j=0;j<gcList3.size();j++){
                    //如果image有值,删除ftpe文件服务器文件
                    fileDel(gcList3.get(j));
                }
                //获取三级分类ids数组
                Short[] ids3 = getCategoryIds(gcList3);
                //删除三级分类
                goodsCategoryService.categoryBatchDelete(ids3);
            }

        }
            BaseResult result = goodsCategoryService.categoryDelete(id);
            //如果image有值,删除ftpe文件服务器文件
            fileDel(gc);
        return result ;
        }

    //获取主键数组
    private Short[] getCategoryIds(List<GoodsCategory> list){
        Short []ids=new Short[list.size()];
        for(int i=0;i<list.size();i++){
            ids[i]=list.get(i).getId();
        }
        return ids;
    }

    /*图片删除*/
    private void fileDel(GoodsCategory goodsCategory){
        if(null!=goodsCategory.getImage() && goodsCategory.getImage().length()>0){
            fileUploadService.fileDelete(goodsCategory.getImage());
        }
    }

    //商品分类--新增
    @RequestMapping("/category/save")
    @ResponseBody
    public BaseResult categorySave(GoodsCategory goodsCategory){
       return goodsCategoryService.categorySave(goodsCategory);
    }

    /*
    *
    *  商品分类-新增分类-根据父ID查询子分类
    * */
    @RequestMapping("/category/byParentId")
    @ResponseBody
    public List<GoodsCategory>  categoryByParentId(short parentId){
        return goodsCategoryService.selectCategoryGetByParentId(parentId);
    }

    /**
     * 商品分类--列表页
     * @return
     */
    @RequestMapping("category/list")
    public String categoryList(Model model){
        //查询所有分类
        model.addAttribute("gcList",goodsCategoryService.selectCategoryListFroViewNormal());
        return "product/category/category-list";
    }

    /**
     * 商品分类--新增
     * @return
     */
    @RequestMapping("category/add")
    public String categoryAdd(Model model){
        model.addAttribute("gclist",goodsCategoryService.selectTopCategory());
        return "product/category/category-add";
    }



}
